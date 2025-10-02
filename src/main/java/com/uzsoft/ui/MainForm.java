package com.uzsoft.ui;

import com.uzsoft.dto.ClientDto;
import com.uzsoft.dto.SimpleTO;
import com.uzsoft.dto.WeightTO;
import com.uzsoft.module.LoginModule;
import com.uzsoft.module.RealPlayModule;
import com.uzsoft.netsdk.lib.NetSDKLib;
import com.uzsoft.utils.ComPort;
import com.uzsoft.utils.Res;
import com.uzsoft.utils.Utils;
import jssc.SerialPort;
import jssc.SerialPortEvent;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.uzsoft.utils.UIUtil.*;

public class MainForm extends BaseForm {
    public static List<String> clients = new ArrayList<>();
    public static List<String> products = new ArrayList<>();

    private JPanel mainPanel;
    private JLabel weightLabel;
    private JLabel currentDateTime;
    private JComboBox<String> productName;
    private JComboBox<String> receiver;
    private JTextField sender;
    private JTextField carDriver, operator;
    private JComboBox<String> direction;
    private JTable reportTable;
    private JPanel videoPanel;
    private JTextField carNumberLabel;
    private JTextField carModelLabel;
    private SerialPort serialPort;
    private Integer weightId = null;
    private Integer sumWeight;
    private String comPortName;
    private Integer comPortSpeed;
    private String camera1UserName, camera1Password;
    private String camera2UserName, camera2Password;
    private String camera1IPAddress, camera2IPAddress;
    private Integer camera1Port, camera2Port;

    private static final List<NetSDKLib.LLong> playHandles = new ArrayList<>();
    private boolean camera1IsEnabled = false, camera2IsEnabled = false;
    private int cameraCount = 0;

    public MainForm() {
        super(new String[]{"№", Res.string().getDirection(), Res.string().getCarNumber(), Res.string().getCarModel(), Res.string().getProductName(),
                Res.string().getGross(), Res.string().getTare(), Res.string().getNet(), Res.string().getSender(),
                Res.string().getReceiver(), Res.string().getCarDriver(), Res.string().getOperator(), Res.string().getTime()});
    }

    @Override
    protected void initialize() {
        sumWeight = 0;
        GridBagLayout gridBagLayout = new GridBagLayout();
        getSettings();
        setTitle(Res.string().getElectronWeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        initMainPanel(gridBagLayout);
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(1200, 1000));
        setMinimumSize(new Dimension(1200, 1000));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        initializeVideoPanel(gridBagLayout);
        initializeReportTable(gridBagLayout);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (camera1IsEnabled || camera2IsEnabled) {
                    playHandles.forEach(RealPlayModule::stopRealPlay);
                }
            }
        });
    }

    private void getSettings() {
        try {
            String sql = "SELECT * FROM settings order by id";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if ("CAMERA1_ENABLED".equals(rs.getString("settingKey"))) {
                    camera1IsEnabled = rs.getBoolean("settingValue");
                    if (camera1IsEnabled) {
                        cameraCount++;
                    }
                } else if ("CAMERA1_IP_ADDRESS".equals(rs.getString("settingKey"))) {
                    camera1IPAddress = rs.getString("settingValue");
                } else if ("CAMERA1_PORT".equals(rs.getString("settingKey"))) {
                    camera1Port = rs.getInt("settingValue");
                } else if ("CAMERA1_USERNAME".equals(rs.getString("settingKey"))) {
                    camera1UserName = rs.getString("settingValue");
                } else if ("CAMERA1_PASSWORD".equals(rs.getString("settingKey"))) {
                    camera1Password = rs.getString("settingValue");
                } else if ("CAMERA2_ENABLED".equals(rs.getString("settingKey"))) {
                    camera2IsEnabled = rs.getBoolean("settingValue");
                    if (camera2IsEnabled) {
                        cameraCount++;
                    }
                } else if ("CAMERA2_IP_ADDRESS".equals(rs.getString("settingKey"))) {
                    camera2IPAddress = rs.getString("settingValue");
                } else if ("CAMERA2_PORT".equals(rs.getString("settingKey"))) {
                    camera2Port = rs.getInt("settingValue");
                } else if ("CAMERA2_USERNAME".equals(rs.getString("settingKey"))) {
                    camera2UserName = rs.getString("settingValue");
                } else if ("CAMERA2_PASSWORD".equals(rs.getString("settingKey"))) {
                    camera2Password = rs.getString("settingValue");
                } else if ("COM_PORT_NAME".equals(rs.getString("settingKey"))) {
                    comPortName = rs.getString("settingValue");
                } else if ("COM_PORT_SPEED".equals(rs.getString("settingKey"))) {
                    comPortSpeed = rs.getInt("settingValue");
                } else if ("COM_PORT_ENABLED".equals(rs.getString("settingKey"))) {
                    if (rs.getBoolean("settingValue")) {
                        try {
                            ComPort main = new ComPort(comPortName, comPortSpeed);
                            serialPort = main.getSerialPort();
                            serialPort.addEventListener(this::serialEvent);
                            System.out.println(comPortName + " Started successfully");
                        } catch (Exception var8) {
                            var8.printStackTrace();
                        }
                    }
                } else if ("REPORT_FOLDER".equals(rs.getString("settingKey"))) {
                    Utils.reportFolder = rs.getString("settingValue");
                } else if ("APPLICATION_FOLDER".equals(rs.getString("settingKey"))) {
                    Utils.applicationFolder = rs.getString("settingValue");
                }
            }
            Utils.closeConnection();
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    private void initMainPanel(GridBagLayout gridBagLayout) {
        int y = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = y;
        gbc.gridx = 0;
        gbc.insets = new Insets(2,2,2,2);

        mainPanel = new JPanel(gridBagLayout);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getScaleIndicator(), 0, y, SwingConstants.LEFT, false, null);
        weightLabel = createLabel(mainPanel, gridBagLayout, gbc, "0", 30, 1, y++, SwingConstants.CENTER, true, "weightLabel");

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getDirection(), 0, y, SwingConstants.LEFT, false, null);
        direction = createCombobox(mainPanel, gridBagLayout, gbc, new String[]{"ТАРА","БРУТТО"}, 1, y++, "direction");

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getCarNumber(), 0, y, SwingConstants.LEFT, false, null);
        carNumberLabel = createTextBox(mainPanel, gridBagLayout, gbc, 1, y++, "carNumberLabel");
        carNumberLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getCarModel(), 0, y, SwingConstants.LEFT, false, null);
        carModelLabel = createTextBox(mainPanel, gridBagLayout, gbc, 1, y++, "carModelLabel");
        carModelLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getProductName(), 0, y, SwingConstants.LEFT, false, null);
        productName = createCombobox(mainPanel, gridBagLayout, gbc, products.toArray(new String[]{}), 1, y++, "productName");
        fetchProducts();

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getSender(), 0, y, SwingConstants.LEFT, false, null);
        sender = createTextBox(mainPanel, gridBagLayout, gbc, 1, y++, "sender");

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getReceiver(), 0, y, SwingConstants.LEFT, false, null);
        receiver = createCombobox(mainPanel, gridBagLayout, gbc, clients.toArray(new String[]{}), 1, y++, "receiver");
        fetchClients();

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getCarDriver(), 0, y, SwingConstants.LEFT, false, null);
        carDriver = createTextBox(mainPanel, gridBagLayout, gbc, 1, y++, "carDriver");

        createLabel(mainPanel, gridBagLayout, gbc, Res.string().getOperator(), 0, y, SwingConstants.LEFT, false, null);
        operator = createTextBox(mainPanel, gridBagLayout, gbc, 1, y++, "operator");

        currentDateTime = new JLabel();
        currentDateTime.setFont(new Font("times", Font.BOLD, 16));
        currentDateTime.setPreferredSize(new Dimension(200, 40));
        currentDateTime.setMinimumSize(new Dimension(200, 40));
        createWidget(mainPanel, gridBagLayout, gbc, currentDateTime, 0, y);

        int interval = 1000;
        new Timer(interval, (e) -> {
            if (currentDateTime != null) {
                currentDateTime.setText(Utils.fullDateFormat.format(new Date()));
            }
        }).start();

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton clearButton = new JButton(Res.string().getClear());
        clearButton.addActionListener((e) -> {
            clearFields();
        });
        buttonsPanel.add(clearButton);

        JButton saveButton = new JButton(Res.string().getSave());
        saveButton.addActionListener((e) -> {
            saveData();
        });
        buttonsPanel.add(saveButton);

        JButton reportButton = new JButton(Res.string().getReport());
        reportButton.addActionListener((e) -> {
            new ReportForm();
        });
        buttonsPanel.add(reportButton);

        if ("admin".equals(Utils.userName)) {
            JButton settingsButton = new JButton(Res.string().getSettings());
            settingsButton.addActionListener((e) -> {
                new SettingsForm(this);
            });
            buttonsPanel.add(settingsButton);
        }

        gbc.gridy = y;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(buttonsPanel, gbc);
        mainPanel.add(buttonsPanel);
    }

    private void initializeReportTable(GridBagLayout gridBagLayout) {
        reportTable = new JTable();
        reportTable.setMinimumSize(new Dimension(600, 200));
        reportTable.setPreferredSize(new Dimension(600, 200));
        reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        reportTable.setCellSelectionEnabled(false);
        reportTable.setColumnSelectionAllowed(false);
        reportTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = reportTable.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    if (reportTable.getModel().getValueAt(row, 0) != null) {
                        weightId = (Integer) reportTable.getModel().getValueAt(row, 0);
                    }
                    carNumberLabel.setText((String) reportTable.getModel().getValueAt(row, 2));
                    carModelLabel.setText((String) reportTable.getModel().getValueAt(row, 3));
                    productName.setSelectedItem(reportTable.getModel().getValueAt(row, 4));
                    sender.setText((String) reportTable.getModel().getValueAt(row, 8));
                    receiver.setSelectedItem(reportTable.getModel().getValueAt(row, 9));
                    carDriver.setText((String) reportTable.getModel().getValueAt(row, 10));
                    operator.setText((String) reportTable.getModel().getValueAt(row, 11));

                    if ("ТАРА".equals(reportTable.getModel().getValueAt(row, 1))) {
                        direction.setSelectedItem("БРУТТО");
                    } else if ("БРУТТО".equals(reportTable.getModel().getValueAt(row, 1))) {
                        direction.setSelectedItem("ТАРА");
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(reportTable,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMinimumSize(new Dimension(1200, 200));
        scrollPane.setPreferredSize(new Dimension(1200, 200));

        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.gridwidth = cameraCount > 0 ? 3 : 2;
        gbc.gridheight = 2;
        gridBagLayout.setConstraints(scrollPane, gbc);
        mainPanel.add(scrollPane);
        getData();
    }

    @Override
    public void getData() {
        try {
            //"№", "Тури", "Автомобил рақами", "Автомобил модели", "Махсулот номи", "Юборувчи", "Қабул қилувчи", "Оператор", "Вақти"
            String sql = "SELECT id,weighingType,carNumber,carModel,productName,sender,receiver,carDriver,operator,net,tare," +
                    "tareDate, gross, grossDate FROM weight " +
                    "WHERE net=0 ORDER BY id DESC ";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<WeightTO> weightList = Utils.convertSQLResultSetToObject(rs, WeightTO.class);
            reportTable.setModel(new WeightTableModel(this, weightList));
            Utils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeVideoPanel(GridBagLayout gridBagLayout) {
        if (cameraCount > 0) {
            GridLayout gbc8 = new GridLayout(cameraCount, 2);
            gbc8.setHgap(10);
            gbc8.setVgap(10);
            videoPanel = new JPanel(gbc8);
            videoPanel.setMinimumSize(new Dimension(533, 400));
            videoPanel.setPreferredSize(new Dimension(533, 400));

            gbc.gridy = 0;
            gbc.gridx = 2;
            gbc.gridheight = 9;
            gridBagLayout.setConstraints(videoPanel, gbc);
            mainPanel.add(videoPanel);

            if (camera1IsEnabled) {
                initializeCamera(camera1IPAddress, camera1Port, camera1UserName, camera1Password);
            }
            if (camera2IsEnabled) {
                initializeCamera(camera2IPAddress, camera2Port, camera2UserName, camera2Password);
            }
        }
    }

    private void initializeCamera(String ipAddress, int port, String userName, String password) {
        LoginModule loginModule = new LoginModule();
        NetSDKLib.LLong loginHandle = loginModule.login(ipAddress, port, userName, password);
        if (loginHandle.longValue() >= 1) {
            NetSDKLib.LLong playHandle = null;
            RealPlayWindow playWindow = new RealPlayWindow(loginHandle);
            videoPanel.add(playWindow);

            playHandle = RealPlayModule.startRealPlay(loginHandle, 0, 0, playWindow);
            if (playHandle.longValue() != 0) {
                playWindow.setHandles(loginHandle);
                playHandles.add(playHandle);
            } else {
                JOptionPane.showMessageDialog(null, Res.string().getCameraError(), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, Res.string().getCameraError(), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fetchClients() {
        try {
            String sql = "SELECT * FROM client ORDER BY clientName ";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<ClientDto> weightList = Utils.convertSQLResultSetToObject(rs, ClientDto.class);
            clients = weightList.stream().map(ClientDto::getClientName).collect(Collectors.toList());
            Utils.closeConnection();
            receiver.setModel(new DefaultComboBoxModel<>(clients.toArray(new String[]{})));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchProducts() {
        try {
            String sql = "SELECT * FROM products ORDER BY name";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<SimpleTO> weightList = Utils.convertSQLResultSetToObject(rs, SimpleTO.class);
            products = weightList.stream().map(SimpleTO::getName).collect(Collectors.toList());
            Utils.closeConnection();
            productName.setModel(new DefaultComboBoxModel<>(products.toArray(new String[]{})));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        carNumberLabel.setText("");
        carModelLabel.setText("");
        sender.setText("");
        carDriver.setText("");
        weightId = null;
        sumWeight = 0;
    }

    private void saveData() {
        try {
            if (carNumberLabel.getText() != null && !Objects.equals(carNumberLabel.getText(), "")) {
                sumWeight = Integer.parseInt(weightLabel.getText());
                Statement statement = Utils.getStatement();

                String sql = "", weighingType = (String) direction.getSelectedItem();
                if (weightId == null) {
                    if ("ТАРА".equals(weighingType)) {
                        sql = "tare, tareDate, ";
                    } else {
                        sql = "gross, grossDate, ";
                    }
                    statement.executeUpdate("INSERT INTO weight(" + sql + "weighingType, carNumber, carModel, productName, " +
                            "sender, receiver, carDriver, operator) VALUES(" + sumWeight + ", '" + Utils.formatDate2(new Date()) + "', '" +
                            weighingType + "', '" + carNumberLabel.getText() + "', '" + carModelLabel.getText() + "', '" +
                            Objects.requireNonNull(productName.getSelectedItem()) + "', '" +
                            sender.getText() + "', '" + Objects.requireNonNull(receiver.getSelectedItem()) + "', '" + carDriver.getText() + "', '" + operator.getText() + "')");
                } else {
                    if ("ТАРА".equals(weighingType)) {
                        sql = "tare = " + sumWeight + ", net = gross - " + sumWeight + ", tareDate=";
                    } else if (Objects.equals(direction.getSelectedItem(), "БРУТТО")) {
                        sql = "gross = " + sumWeight + ", net = " + sumWeight + " - tare, grossDate=";
                    }
                    statement.executeUpdate("UPDATE weight set " + sql + "'" +
                            Utils.formatDate2(new Date()) + "', weighingType='" + weighingType + "' WHERE id=" + weightId);
                }
                weightId = null;
                clearFields();
                JOptionPane.showMessageDialog(null, Res.localize("DATA_SAVED"), Res.localize("WARNING"), JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "Автомобил рақамини киритинг", "Хатолик", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            getData();
        }
    }

    private String getInt() {
        int i = (new Random()).nextInt();
        if (i < 0) {
            i = Math.abs(i);
        }

        if (i > 99999) {
            String s = String.valueOf(i);
            return s.substring(0, 5);
        } else {
            return String.valueOf(i);
        }
    }

    private synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.isRXCHAR() && oEvent.getEventValue() > 0) {
            try {
                byte[] bytes = serialPort.readBytes();
                if (bytes != null) {
                    String inputLine = new String(bytes, StandardCharsets.UTF_8);
                    if (!inputLine.trim().isEmpty()) {
                        Integer clearedString = clearString(inputLine);
                        weightLabel.setText(String.valueOf(clearedString));
                        sumWeight = clearedString;
                    }
                }
            } catch (Exception var4) {
                System.err.println(var4);
            }
        }

    }

    private Integer clearString(String inputLine) {
        inputLine = inputLine.replaceAll("\\+", "").substring(0, 7);
        System.out.println(inputLine);
        Pattern pattern = Pattern.compile("[-+]?([0-9]*\\.[0-9]+|[0-9]+)");
        Matcher m = pattern.matcher(inputLine);
        return m.find() ? Integer.parseInt(m.group()) : 0;
    }
}