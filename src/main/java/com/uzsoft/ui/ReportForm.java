package com.uzsoft.ui;

import com.uzsoft.dto.WeightTO;
import com.uzsoft.utils.Utils;
import com.uzsoft.utils.Res;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ReportForm extends BaseForm {
    private JTable reportTable;
    private JPanel mainPanel;
    private JPanel topToolBox;
    private String startDate;
    private String endDate;
    private SimpleDateFormat dateFormat4;
    private JDatePickerImpl datePicker1;
    private JDatePickerImpl datePicker2;

    public ReportForm() {
        super(new String[]{"№", Res.string().getDirection(), Res.string().getCarNumber(), Res.string().getCarModel(), Res.string().getProductName(),
                Res.string().getGross(), Res.string().getTare(), Res.string().getNet(), Res.string().getSender(),
                Res.string().getReceiver(), Res.string().getOperator(), Res.string().getTime(), Res.string().getAction()});
    }

    @Override
    protected void initialize() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(2, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        createTopToolBox();
        createReportPanel();
        this.dateFormat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        setTitle(Res.string().getReport());
        setPreferredSize(new Dimension(900, 600));
        setMinimumSize(new Dimension(900, 600));
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
        this.datePicker1 = new JDatePickerImpl(datePanel1, new DateComponentFormatter());

        JDatePanelImpl datePanel2 = new JDatePanelImpl(new UtilDateModel(new Date()), properties);
        this.datePicker2 = new JDatePickerImpl(datePanel2, new DateComponentFormatter());

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
            exportToExcel();
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
        String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        Object[][] data = {
                {"Row 1, Col 1", "Row 1, Col 2", "Row 1, Col 3"},
                {"Row 2, Col 1", "Row 2, Col 2", "Row 2, Col 3"},
        };

        reportTable = new JTable(data, columnNames);
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

    private void showData() {
        prepareDates();
        getReportData();
    }

    private void prepareDates() {
        Date startDate1 = (Date)this.datePicker1.getModel().getValue();
        startDate1 = Utils.getDayStart(startDate1);
        this.startDate = this.dateFormat4.format(startDate1);
        Date endDate1 = (Date)this.datePicker2.getModel().getValue();
        endDate1 = Utils.getDayEnd(endDate1);
        this.endDate = this.dateFormat4.format(endDate1);
    }

    public void getReportData() {
        getData();
        this.reportTable.setCellSelectionEnabled(true);
        this.reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.reportTable.setRowHeight(30);
        this.reportTable.getColumnModel().getColumn(12).setCellRenderer(new ButtonsCellRenderer());
        this.reportTable.getColumnModel().getColumn(12).setCellEditor(new ButtonsCellEditor());
        this.reportTable.getColumnModel().getColumn(12).setPreferredWidth(220);
        this.reportTable.getColumnModel().getColumn(12).setMaxWidth(220);
    }

    @Override
    public void getData() {
        try {
            String sql = "SELECT id,weighingType,carNumber,carModel,productName,sender,receiver,operator," +
                    "gross,grossDate, tare,tareDate, net FROM weight WHERE deleted=false ";
            if (isNotEmpty(this.startDate) && isNotEmpty(this.endDate)) {
                sql = sql + " and ((grossDate between '" + this.startDate + "' and '" + this.endDate + "') or (tareDate between '" + this.startDate + "' and '" + this.endDate + "')) ";
            }

            sql = sql + " ORDER BY id DESC ";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<WeightTO> weightList = Utils.convertSQLResultSetToObject(rs, WeightTO.class);
            this.reportTable.setModel(new WeightTableModel(this, weightList));

            Utils.closeConnection();
        } catch (SQLException var7) {
            throw new RuntimeException(var7);
        }
    }

    private static boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    public void exportToExcel() {
        Date startDate = (Date)datePicker1.getModel().getValue();
        startDate = Utils.getDayStart(startDate);
        this.startDate = this.dateFormat4.format(startDate);
        Date endDate = (Date)this.datePicker2.getModel().getValue();
        endDate = Utils.getDayEnd(endDate);
        this.endDate = this.dateFormat4.format(endDate);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setBorderRight(BorderStyle.THIN);
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short)15);
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        style.setFont(font);
        int index = 0;

        String sql;
        for (String s : columnNames) {
            sql = s;
            XSSFCell cell = row.createCell(index++);
            cell.setCellValue(sql);
            cell.setCellStyle(style);
        }

        sheet.setColumnWidth(0, 2560);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 3840);
        sheet.setColumnWidth(6, 3840);
        sheet.setColumnWidth(7, 3840);
        sheet.setColumnWidth(8, 7200);
        sheet.setColumnWidth(9, 7200);
        sheet.setColumnWidth(10, 7200);
        sheet.setColumnWidth(11, 7200);
        sheet.setColumnWidth(12, 5000);

        try {
            int gross = 0, tare = 0, net = 0;
            sql = "SELECT id,weighingType,carNumber,carModel,productName,sender,receiver,carDriver,operator,gross,grossDate,tare,tareDate,net FROM weight where deleted=false ";
            if (isNotEmpty(this.startDate) && isNotEmpty(this.endDate)) {
                sql = sql + " and ((grossDate between '" + this.startDate + "' and '" + this.endDate + "') or (tareDate between '" + this.startDate + "' and '" + this.endDate + "')) ";
            }

            sql = sql + " ORDER BY id DESC ";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);

            XSSFCell cell;
            while(rs.next()) {
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                cell = row.createCell(0);
                cell.setCellValue(rs.getInt("id"));
                cell.setCellStyle(style2);

                cell = row.createCell(1);
                cell.setCellValue(rs.getString("weighingType"));
                cell.setCellStyle(style2);

                cell = row.createCell(2);
                cell.setCellValue(rs.getString("carNumber"));
                cell.setCellStyle(style2);

                cell = row.createCell(3);
                cell.setCellValue(rs.getString("carModel"));
                cell.setCellStyle(style2);

                cell = row.createCell(4);
                cell.setCellValue(rs.getString("productName"));
                cell.setCellStyle(style2);

                cell = row.createCell(5);
                cell.setCellValue(rs.getInt("gross"));
                cell.setCellStyle(style2);
                gross = gross + rs.getInt("gross");

                cell = row.createCell(6);
                cell.setCellValue(rs.getInt("tare"));
                cell.setCellStyle(style2);
                tare = tare + rs.getInt("tare");

                cell = row.createCell(7);
                cell.setCellValue(rs.getInt("net"));
                cell.setCellStyle(style2);
                net = net + rs.getInt("net");

                cell = row.createCell(8);
                cell.setCellValue(rs.getString("sender"));
                cell.setCellStyle(style2);

                cell = row.createCell(9);
                cell.setCellValue(rs.getString("receiver"));
                cell.setCellStyle(style2);

                cell = row.createCell(10);
                cell.setCellValue(rs.getString("carDriver"));
                cell.setCellStyle(style2);

                cell = row.createCell(11);
                cell.setCellValue(rs.getString("operator"));
                cell.setCellStyle(style2);

                cell = row.createCell(12);
                cell.setCellValue(Utils.formatDate3(rs.getTimestamp("ТАРА".equals(rs.getString("weighingType")) ? "tareDate" : "grossDate")));
                cell.setCellStyle(style2);
            }

            row = sheet.createRow(sheet.getLastRowNum() + 1);
            cell = row.createCell(0);
            cell.setCellValue("Жами:");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue(gross);
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue(tare);
            cell.setCellStyle(style);
            cell = row.createCell(7);
            cell.setCellValue(net);
            cell.setCellStyle(style);
            Utils.closeConnection();
            if (Files.notExists(Paths.get(Utils.reportFolder))) {
                Files.createDirectory(Paths.get(Utils.reportFolder));
            }

            String fileName = Utils.reportFolder + Utils.dateFormat1.format(new Date()) + ".xlsx";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            JOptionPane.showMessageDialog(null, Res.localize("REPORT_EXPORTED_TO_EXCEL"), Res.localize("WARNING"), JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException | SQLException var19) {
            var19.printStackTrace();
        }
    }
}
