package com.uzsoft.ui;

import com.uzsoft.Constants;
import com.uzsoft.dto.CarTO;
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
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.uzsoft.utils.UIUtil.*;

@Slf4j
public class MainForm extends BaseForm {
    public static List<String> clients = new ArrayList<>();
    public static List<String> products = new ArrayList<>();
    public static List<String> cars = new ArrayList<>();

    private JPanel mainPanel;
    private JLabel weightLabel;
    private JTextField weightBox;
    private JLabel currentDateTime;
    private JComboBox<String> productName;
    private JComboBox<String> receiver;
    private JTextField sender;
    private JTextField carDriver, operator;
    private JComboBox<String> direction;
    private JTable reportTable;
    private JPanel videoPanel;
    private JComboBox<String> carNumberBox;
    private JTextField carModelBox;
    private SerialPort serialPort;
    private Integer weightId = null;
    private Float sumWeight;
    private String comPortName;
    private String eWeight;
    private Integer comPortSpeed;
    private String weightDeviceType;
    private String camera1UserName, camera1Password;
    private String camera2UserName, camera2Password;
    private String camera1IPAddress, camera2IPAddress;
    private Integer camera1Port, camera2Port;
    private static NetSDKLib.LLong playHandle = null;

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
        sumWeight = 0f;
        GridLayout gridBagLayout = new GridLayout();
        getSettings();
        setTitle(Res.string().getElectronWeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        initMainPanel();
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(1200, 900));
        setMinimumSize(new Dimension(1200, 900));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
//        initializeVideoPanel(gridBagLayout);
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
                } else if ("WEIGHT_DEVICE_TYPE".equals(rs.getString("settingKey"))) {
                    weightDeviceType = rs.getString("settingValue");
                    Utils.weightDeviceType = weightDeviceType;
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
                        } catch (Exception e) {
                            log.error(Arrays.toString(e.getStackTrace()));
                        }
                    }
                } else if ("REPORT_FOLDER".equals(rs.getString("settingKey"))) {
                    Utils.reportFolder = rs.getString("settingValue");
                    if (Files.notExists(Paths.get(Utils.reportFolder))) {
                        Files.createDirectory(Paths.get(Utils.reportFolder));
                    }
                } else if ("APPLICATION_FOLDER".equals(rs.getString("settingKey"))) {
                    Utils.applicationFolder = rs.getString("settingValue");
                } else if ("TEST_MODE".equals(rs.getString("settingKey"))) {
                    Utils.testMode = rs.getBoolean("settingValue");
                }
            }
            Utils.closeConnection();
        } catch (SQLException | IOException var9) {
            throw new RuntimeException(var9);
        }
    }

    private void initMainPanel() {
        GridLayout gridBagLayout = new GridLayout(10, 2, 2, 2);
        gridBagLayout.setHgap(10);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel componentsPanel = new JPanel(gridBagLayout);
        componentsPanel.setPreferredSize(new Dimension(1100, 400));
        componentsPanel.setMinimumSize(new Dimension(1100, 400));
        componentsPanel.setMaximumSize(new Dimension(1100, 400));

        createLabel(componentsPanel, gridBagLayout, Res.string().getScaleIndicator(), 1, 1, SwingConstants.LEFT, false, null);
        if (Utils.testMode) {
            weightBox = createTextBox(componentsPanel, gridBagLayout, 2, 1, "weightBox");
        } else {
            weightLabel = createLabel(componentsPanel, gridBagLayout, "0", 30, 2, 1, SwingConstants.CENTER, true, "weightLabel");
        }

        createLabel(componentsPanel, gridBagLayout, Res.string().getDirection(), 1, 2, SwingConstants.LEFT, false, null);
        direction = createCombobox(componentsPanel, gridBagLayout, new String[]{"ТАРА","БРУТТО"}, 2, 2, "direction");

        createLabel(componentsPanel, gridBagLayout, Res.string().getCarNumber(), 1, 3, SwingConstants.LEFT, false, null);
        carNumberBox = createCombobox(componentsPanel, gridBagLayout, new String[]{}, 2, 3, "carNumberLabel");
        carNumberBox.setBorder(new BevelBorder(BevelBorder.RAISED));
        fetchCars();
        carNumberBox.addItemListener(itemEvent -> {
            try {
                Statement stmt = Utils.getStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cars where carNumber='" + itemEvent.getItem().toString() + "'");
                List<CarTO> carList = Utils.convertSQLResultSetToObject(rs, CarTO.class);
                carModelBox.setText(carList.get(0).getCarModel());
                Utils.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        createLabel(componentsPanel, gridBagLayout, Res.string().getCarModel(), 1, 4, SwingConstants.LEFT, false, null);
        carModelBox = createTextBox(componentsPanel, gridBagLayout, 2, 4, "carModelLabel");
        carModelBox.setBorder(new BevelBorder(BevelBorder.RAISED));
        carModelBox.setEnabled(false);

        createLabel(componentsPanel, gridBagLayout, Res.string().getProductName(), 1, 5, SwingConstants.LEFT, false, null);
        productName = createCombobox(componentsPanel, gridBagLayout, products.toArray(new String[]{}), 2, 5, "productName");
        fetchProducts();

        createLabel(componentsPanel, gridBagLayout, Res.string().getSender(), 1, 6, SwingConstants.LEFT, false, null);
        sender = createTextBox(componentsPanel, gridBagLayout, 2, 6, "sender");

        createLabel(componentsPanel, gridBagLayout, Res.string().getReceiver(), 1, 7, SwingConstants.LEFT, false, null);
        receiver = createCombobox(componentsPanel, gridBagLayout, clients.toArray(new String[]{}), 2, 7, "receiver");
        fetchClients();

        createLabel(componentsPanel, gridBagLayout, Res.string().getCarDriver(), 1, 8, SwingConstants.LEFT, false, null);
        carDriver = createTextBox(componentsPanel, gridBagLayout, 2, 8, "carDriver");

        createLabel(componentsPanel, gridBagLayout, Res.string().getOperator(), 1, 9, SwingConstants.LEFT, false, null);
        operator = createTextBox(componentsPanel, gridBagLayout, 2, 9, "operator");

        currentDateTime = new JLabel();
        currentDateTime.setFont(new Font("times", Font.BOLD, 16));
        currentDateTime.setPreferredSize(new Dimension(200, 40));
        currentDateTime.setMinimumSize(new Dimension(200, 40));
        createWidget(componentsPanel, gridBagLayout, currentDateTime, 1, 10);

        int interval = 1000;
        new Timer(interval, (e) -> {
            if (currentDateTime != null) {
                currentDateTime.setText(Utils.fullDateFormat.format(new Date()));
            }
        }).start();

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.setSize(new Dimension(1200, 50));

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

        BoxLayout gridBagLayout2 = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
//        mainPanel.setLayout(gridBagLayout2);
        mainPanel.add(componentsPanel);
        mainPanel.add(buttonsPanel);
    }

    private void initializeReportTable(GridLayout gridBagLayout) {
        reportTable = new JTable();
        reportTable.setMinimumSize(new Dimension(1200, 400));
        reportTable.setPreferredSize(new Dimension(1200, 400));
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
                    carNumberBox.setSelectedItem(reportTable.getModel().getValueAt(row, 2));
                    carModelBox.setText((String) reportTable.getModel().getValueAt(row, 3));
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
        scrollPane.setMinimumSize(new Dimension(1200, 400));
        scrollPane.setPreferredSize(new Dimension(1200, 400));

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
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    private void initializeVideoPanel(GridLayout gridBagLayout) {
        if (cameraCount > 0) {
            GridLayout gbc8 = new GridLayout(cameraCount, 2);
            gbc8.setHgap(10);
            gbc8.setVgap(10);
            videoPanel = new JPanel(gbc8);
            videoPanel.setMinimumSize(new Dimension(533, 400));
            videoPanel.setPreferredSize(new Dimension(533, 400));

//            gridBagLayout.setConstraints(videoPanel);
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

    private void localCapturePicture(String picFileName) {
        boolean pictureEx = LoginModule.netsdk.CLIENT_CapturePictureEx(playHandle, Constants.applicationFolder + "/files/images/" + picFileName, NetSDKLib.NET_CAPTURE_FORMATS.NET_CAPTURE_JPEG);
        if (!pictureEx) {
            System.err.println("CLIENT_CapturePicture Failed!");
        } else {
            System.out.println("CLIENT_CapturePicture success");
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
            log.error(Arrays.toString(e.getStackTrace()));
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
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    public void fetchCars() {
        try {
            String sql = "SELECT * FROM cars ORDER BY id";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<CarTO> weightList = Utils.convertSQLResultSetToObject(rs, CarTO.class);
            cars = weightList.stream().map(CarTO::getCarNumber).collect(Collectors.toList());
            Utils.closeConnection();
            carNumberBox.setModel(new DefaultComboBoxModel<>(cars.toArray(new String[]{})));
        } catch (SQLException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    private void clearFields() {
        carNumberBox.setSelectedItem("");
        carModelBox.setText("");
        sender.setText("");
        carDriver.setText("");
        weightId = null;
        sumWeight = 0f;
    }

    private void saveData() {
        try {
            if (carNumberBox.getSelectedItem() != null && !Objects.equals(carNumberBox.getSelectedItem(), "")) {
                sumWeight = Float.parseFloat(Utils.testMode ? weightBox.getText() : weightLabel.getText());
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
                            weighingType + "', '" + carNumberBox.getSelectedItem() + "', '" + carModelBox.getText() + "', '" +
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
                    localCapturePicture(weightId + ".jpg");
                }
                weightId = null;
                clearFields();
                JOptionPane.showMessageDialog(null, Res.localize("DATA_SAVED"), Res.localize("WARNING"), JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "Автомобил рақамини киритинг", "Хатолик", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            log.error(Arrays.toString(e.getStackTrace()));
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
        if (oEvent.isRXCHAR()) {
            try {
                if ("KELI_XK3118".equals(Utils.weightDeviceType)) {
                    String bytes = serialPort.readString();
                    eWeight = eWeight + bytes;
                    if ("=".equals(bytes)) {
                        eWeight = "";
                    } else if (")".equals(bytes)) {
                        System.out.println("TOTAL WEIGHT: " + eWeight);
                        Float clearedString = clearString(eWeight);
                        weightLabel.setText(clearedString.toString());
                        sumWeight = clearedString;
                        eWeight = "";
                    }
                }
            } catch (Exception e) {
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private Float clearString(String inputLine) {
        inputLine = inputLine.replaceAll("\r", "").replaceAll("\n", "")
                .replaceAll("=", "").replaceAll("\\(", "")
                .replaceAll("\\)", "").replaceAll("kg", "");
        return Float.parseFloat(inputLine);
    }
}