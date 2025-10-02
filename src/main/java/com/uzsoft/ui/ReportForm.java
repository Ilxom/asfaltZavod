package com.uzsoft.ui;

import com.uzsoft.dto.WeightTO;
import com.uzsoft.utils.Res;
import com.uzsoft.utils.Utils;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ReportForm extends BaseForm {
    private JTable reportTable;
    private JPanel mainPanel;
    private JPanel topToolBox;
    private String startDate;
    private String endDate;
    private JDatePickerImpl datePicker1;
    private JDatePickerImpl datePicker2;

    public ReportForm() {
        super(new String[]{"№", Res.string().getDirection(), Res.string().getCarNumber(), Res.string().getCarModel(), Res.string().getProductName(),
                Res.string().getGross(), Res.string().getTare(), Res.string().getNet(), Res.string().getSender(),
                Res.string().getReceiver(), Res.string().getCarDriver(), Res.string().getOperator(), Res.string().getTime(), Res.string().getAction()});
    }

    @Override
    protected void initialize() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(2, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        createTopToolBox();
        createReportPanel();
        setTitle(Res.string().getReport());
        setPreferredSize(new Dimension(1200, 1000));
        setMinimumSize(new Dimension(1200, 1000));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setContentPane(mainPanel);
        pack();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException ignored) {
        }

        Properties properties = new Properties();
        properties.setProperty("text.today", Res.localize("TODAY"));
        properties.setProperty("text.month", Res.localize("MONTH"));
        properties.setProperty("text.year", Res.localize("YEAR"));
        properties.setProperty("text.clear", Res.localize("CLEAR"));

        JDatePanelImpl datePanel1 = new JDatePanelImpl(new UtilDateModel(new Date()), properties);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateComponentFormatter());

        JDatePanelImpl datePanel2 = new JDatePanelImpl(new UtilDateModel(new Date()), properties);
        datePicker2 = new JDatePickerImpl(datePanel2, new DateComponentFormatter());

        gbc.fill = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        if ("uz".equals(Res.getBundle().getLocale().getLanguage())) {
            this.topToolBox.add(this.datePicker1, gbc);
            gbc.gridx = 1;
            this.topToolBox.add(new Label(Res.localize("FROM")), gbc);
            gbc.gridx = 2;
            this.topToolBox.add(this.datePicker2, gbc);
            gbc.gridx = 3;
            this.topToolBox.add(new Label(Res.localize("TO")), gbc);
        } else {
            this.topToolBox.add(new Label(Res.localize("FROM")), gbc);
            gbc.gridx = 1;
            this.topToolBox.add(this.datePicker1, gbc);
            gbc.gridx = 2;
            this.topToolBox.add(new Label(Res.localize("TO")), gbc);
            gbc.gridx = 3;
            this.topToolBox.add(this.datePicker2, gbc);
        }
        Button okButton = getButton();
        gbc.gridx = 4;
        this.topToolBox.add(okButton, gbc);
        Button excelButton = new Button("Excel");
        excelButton.addActionListener((ActionEvent e) -> {
            Date startDate = (Date)datePicker1.getModel().getValue();
            startDate = Utils.getDayStart(startDate);
            this.startDate = Utils.formatDate2(startDate);
            Date endDate = (Date)this.datePicker2.getModel().getValue();
            endDate = Utils.getDayEnd(endDate);
            this.endDate = Utils.formatDate2(endDate);
            Utils.exportToExcel(this.startDate, this.endDate, columnNames);
        });
        gbc.gridx = 5;
        this.topToolBox.add(excelButton, gbc);

        showData();
    }

    private void createTopToolBox() {
        topToolBox = new JPanel();
        topToolBox.setPreferredSize(new Dimension(300, 30));
        topToolBox.setLayout(new GridBagLayout());

        mainPanel. add(topToolBox, BorderLayout. NORTH);
    }

    private void createReportPanel() {
        reportTable = new JTable();
        JScrollPane reportPanel = new JScrollPane(reportTable);
        reportPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        mainPanel.add(reportPanel, BorderLayout.CENTER);
    }

    private Button getButton() {
        Button okButton = new Button("OK");
        okButton.addActionListener((e) -> {
            showData();
        });
        return okButton;
    }

    public void showData() {
        prepareDates();
        getReportData();
    }

    private void prepareDates() {
        Date startDate1 = (Date)this.datePicker1.getModel().getValue();
        startDate1 = Utils.getDayStart(startDate1);
        this.startDate = Utils.formatDate2(startDate1);
        Date endDate1 = (Date)this.datePicker2.getModel().getValue();
        endDate1 = Utils.getDayEnd(endDate1);
        this.endDate = Utils.formatDate2(endDate1);
    }

    public void getReportData() {
        int lastColumn = getColumnNames().length - 1;
        getData();
        this.reportTable.setCellSelectionEnabled(true);
        this.reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.reportTable.setRowHeight(30);
        this.reportTable.getColumnModel().getColumn(lastColumn).setCellRenderer(new ButtonsCellRenderer());
        this.reportTable.getColumnModel().getColumn(lastColumn).setCellEditor(new ButtonsCellEditor());
        this.reportTable.getColumnModel().getColumn(lastColumn).setPreferredWidth(220);
        this.reportTable.getColumnModel().getColumn(lastColumn).setMaxWidth(220);
    }

    @Override
    public void getData() {
        try {
            String sql = "SELECT id,weighingType,carNumber,carModel,productName,sender,receiver,carDriver,operator," +
                    "gross,grossDate, tare,tareDate, net FROM weight WHERE deleted=false ";
            if (isNotEmpty(this.startDate) && isNotEmpty(this.endDate)) {
                sql = sql + " and ((grossDate between '" + this.startDate + "' and '" + this.endDate + "') or (tareDate between '" + this.startDate + "' and '" + this.endDate + "')) ";
            }

            sql = sql + " ORDER BY id DESC ";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<WeightTO> weightList = Utils.convertSQLResultSetToObject(rs, WeightTO.class);
            reportTable.setModel(new WeightTableModel(this, weightList));

            Utils.closeConnection();
        } catch (SQLException var7) {
            throw new RuntimeException(var7);
        }
    }

    private static boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

}
