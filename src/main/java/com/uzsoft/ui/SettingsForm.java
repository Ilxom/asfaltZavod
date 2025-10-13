package com.uzsoft.ui;

import com.uzsoft.Constants;
import com.uzsoft.utils.UIUtil;
import com.uzsoft.utils.Utils;
import jssc.SerialPortList;
import com.uzsoft.utils.Res;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SettingsForm extends JFrame implements Constants {
    private JComboBox<String> comListBox;
    private JButton saveCOMButton;
    private JPasswordField oldPassword;
    private JPasswordField repeatPassword;
    private JButton updatePasswordButton;
    private JPasswordField newPassword;
    private JTextField camera1IPAddress;
    private JTextField camera1Port;
    private JTextField camera1UserName;
    private JPasswordField camera1Password;
    private JTextField camera2IPAddress;
    private JTextField camera2Port;
    private JTextField camera2UserName;
    private JTextField clientName, productName;
    private JTextField carNumber, carModel;
    private JTextField comPortSpeed;
    private JPasswordField camera2Password;
    private JButton camera1SaveButton;
    private JButton camera2SaveButton;
    private JButton saveClientButton, saveProductButton;
    private JButton saveCarButton;
    GridBagLayout gridBagLayout = new GridBagLayout();

    private static final Font font12Bold = new Font("Arial", Font.BOLD, 12);
    private static final Font font14Bold = new Font("Arial", Font.BOLD, 14);

    public SettingsForm(MainForm mainForm) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel mainPanel = new JPanel(gridBagLayout);
        gbc.gridy = 0;

        JPanel comPanel = createCOMPanel();
        gbc.gridx = 0;
        gridBagLayout.setConstraints(comPanel, gbc);
        mainPanel.add(comPanel);

        JPanel userPanel = createUserPanel();
        gbc.gridx = 1;
        gridBagLayout.setConstraints(userPanel, gbc);
        mainPanel.add(userPanel);

        JPanel camera1Panel = createCameraPanel(Res.localize("CAMERA1"), "camera1");
        gbc.gridy = 1;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(camera1Panel, gbc);
        mainPanel.add(camera1Panel);

        JPanel camera2Panel = createCameraPanel(Res.localize("CAMERA2"), "camera2");
        gbc.gridx = 1;
        gridBagLayout.setConstraints(camera2Panel, gbc);
        mainPanel.add(camera2Panel);

        JPanel clientPanel = createClientPanel();
        gbc.gridy = 2;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(clientPanel, gbc);
        mainPanel.add(clientPanel);

        JPanel carsPanel = createCarsPanel();
        gbc.gridx = 1;
        gridBagLayout.setConstraints(carsPanel, gbc);
        mainPanel.add(carsPanel);

        JPanel productPanel = createProductPanel();
        gbc.gridy = 3;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(productPanel, gbc);
        mainPanel.add(productPanel);

        setTitle(Res.string().getSettings());
        setPreferredSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(1000, 700));
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        pack();

        comListBox.setModel(new DefaultComboBoxModel<>(SerialPortList.getPortNames()));

        try {
            String sql = "SELECT * FROM settings order by id";
            Statement stmt = Utils.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (COM_PORT.equals(rs.getString("settingKey"))) {
                    comListBox.setSelectedItem(rs.getString("settingValue"));
                }
            }
            Utils.closeConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        updatePasswordButton.addActionListener(e -> {
            try {
                String oldPass = String.valueOf(oldPassword.getPassword());
                String sql = "SELECT id,userName,password FROM users WHERE userName='" + Utils.userName + "' and password='" + oldPass + "'";
                Statement stmt = Utils.getStatement();
                ResultSet rs = stmt.executeQuery(sql);
                boolean res = rs.next();
                if (res) {
                    if (new String(newPassword.getPassword()).equals(new String(repeatPassword.getPassword()))) {
                        int updateCount = stmt.executeUpdate("update users set password='" + new String(newPassword.getPassword()) + "' where userName='" + Utils.userName + "'");
                        if (updateCount > 0) {
                            JOptionPane.showMessageDialog(null, "Фойдаланувчи пароли янгиланди", "Огохлантириш", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Фойдаланувчи паролини янгилашда хатолик", "Хатолик", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Янги паролни хато киритилди", "Хатолик", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Жорий парол хато киритилди", "Хатолик", JOptionPane.ERROR_MESSAGE);
                }
                Utils.closeConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        saveCOMButton.addActionListener(e -> {
            try {
                String comPort = (String) comListBox.getSelectedItem();
                int res1 = Utils.getStatement().executeUpdate("update settings set settingValue='" + comPort + "' WHERE settingKey='COM_PORT_NAME'");
                int res2 = Utils.getStatement().executeUpdate("update settings set settingValue='" + comPortSpeed.getText() + "' WHERE settingKey='COM_PORT_SPEED'");
                if (res1 > 0 || res2 > 0) {
                    JOptionPane.showMessageDialog(null, "COM порт созламаси сақланди", "Огохлантириш", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "COM порт созламасини сақлашда хатолик", "Хатолик", JOptionPane.ERROR_MESSAGE);
                }
                Utils.closeConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        camera1SaveButton.addActionListener(e -> {
            if (camera1IPAddress.getText() == null || camera1IPAddress.getText().length() < 11 || camera1IPAddress.getText().split("\\.").length < 4) {
                JOptionPane.showMessageDialog(null, "1-камера IP адреси хато киритилган", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (camera1Port.getText() == null || camera1Port.getText().length() < 4) {
                JOptionPane.showMessageDialog(null, "1-камера порти хато киритилган", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (camera1UserName.getText() == null || camera1UserName.getText().length() < 4) {
                JOptionPane.showMessageDialog(null, "1-камера логини хато киритилган", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (camera1Password.getPassword() == null || camera1Password.getPassword().length < 7) {
                JOptionPane.showMessageDialog(null, "1-камера пароли 7 та белгидан кам бўлмаслиги керак", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt = Utils.getStatement();
            try {
                stmt.executeUpdate("update settings set settingValue='" + camera1IPAddress.getText() + "' where settingKey='CAMERA1_IP_ADDRESS'");
                stmt.executeUpdate("update settings set settingValue='" + camera1Port.getText() + "' where settingKey='CAMERA1_PORT'");
                stmt.executeUpdate("update settings set settingValue='" + camera1UserName.getText() + "' where settingKey='CAMERA1_USERNAME'");
                stmt.executeUpdate("update settings set settingValue='" + camera1Password.getText() + "' where settingKey='CAMERA1_PASSWORD'");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                Utils.closeConnection();
                JOptionPane.showMessageDialog(null, "1-камера маълумотлари сақланди", "Огохлантириш", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        camera2SaveButton.addActionListener(e -> {
            if (camera2IPAddress.getText() == null || camera2IPAddress.getText().length() < 11 || camera2IPAddress.getText().split("\\.").length < 4) {
                JOptionPane.showMessageDialog(null, "2-камера IP адреси хато киритилган", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (camera2Port.getText() == null || camera2Port.getText().length() < 4) {
                JOptionPane.showMessageDialog(null, "2-камера порти хато киритилган", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (camera2UserName.getText() == null || camera2UserName.getText().length() < 4) {
                JOptionPane.showMessageDialog(null, "2-камера логини хато киритилган", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (camera2Password.getPassword() == null || camera2Password.getPassword().length < 7) {
                JOptionPane.showMessageDialog(null, "2-камера пароли 7 та белгидан кам бўлмаслиги керак", "Хатолик", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt = Utils.getStatement();
            try {
                stmt.executeUpdate("update settings set settingValue='" + camera2IPAddress.getText() + "' where settingKey='CAMERA2_IP_ADDRESS'");
                stmt.executeUpdate("update settings set settingValue='" + camera2Port.getText() + "' where settingKey='CAMERA2_PORT'");
                stmt.executeUpdate("update settings set settingValue='" + camera2UserName.getText() + "' where settingKey='CAMERA2_USERNAME'");
                stmt.executeUpdate("update settings set settingValue='" + camera2Password.getText() + "' where settingKey='CAMERA2_PASSWORD'");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                Utils.closeConnection();
                JOptionPane.showMessageDialog(null, "2-камера маълумотлари сақланди", "Огохлантириш", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        saveClientButton.addActionListener(e -> {
            if (clientName.getText() == null || clientName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, Res.localize("ENTER_CLIENT_NAME"), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt = Utils.getStatement();
            try {
                stmt.executeUpdate("insert into client(clientName, deleted) values('" + clientName.getText() + "', false)");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                Utils.closeConnection();
                mainForm.fetchClients();
                JOptionPane.showMessageDialog(null, Res.localize("CLIENT_DATA_SAVED"), Res.string().getError(), JOptionPane.INFORMATION_MESSAGE);
            }
        });

        saveProductButton.addActionListener(e -> {
            if (productName.getText() == null || productName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, Res.localize("ENTER_PRODUCT_NAME"), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt = Utils.getStatement();
            try {
                stmt.executeUpdate("insert into products(name) values('" + productName.getText() + "')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                Utils.closeConnection();
                mainForm.fetchProducts();
                JOptionPane.showMessageDialog(null, Res.localize("PRODUCT_DATA_SAVED"), Res.string().getError(), JOptionPane.INFORMATION_MESSAGE);
            }
        });

        saveCarButton.addActionListener(e -> {
            if (carNumber.getText() == null || carNumber.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, Res.localize("ENTER_CAR_NUMBER"), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (carModel.getText() == null || carModel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, Res.localize("ENTER_CAR_MODEL"), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt = Utils.getStatement();
            try {
                stmt.executeUpdate("insert into cars(carNumber, carModel) values('" + carNumber.getText() + "', '" + carModel.getText() + "')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                Utils.closeConnection();
                mainForm.fetchCars();
                JOptionPane.showMessageDialog(null, Res.localize("CAR_DATA_SAVED"), Res.string().getError(), JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private JPanel createCOMPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel(gridBagLayout);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Res.localize("COM_PORT")));
        panel.setPreferredSize(new Dimension(300, 200));

        // COM Port label
        JLabel comLabel = new JLabel("COM port:");
        comLabel.setFont(font12Bold);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(comLabel, gbc);
        panel.add(comLabel);

        // COM Port combo box
        comListBox = new JComboBox<>();
        comListBox.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(comListBox, gbc);
        panel.add(comListBox);

        // COM Port speed label
        JLabel comSpeedLabel = new JLabel(Res.localize("COM_PORT_SPEED"));
        comSpeedLabel.setFont(font12Bold);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(comSpeedLabel, gbc);
        panel.add(comSpeedLabel);

        comPortSpeed = new JTextField();
        comPortSpeed.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(comPortSpeed, gbc);
        panel.add(comPortSpeed);

        // Save COM button
        saveCOMButton = new JButton(Res.string().getSave());
        saveCOMButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 2;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(saveCOMButton, gbc);
        panel.add(saveCOMButton);

        return panel;
    }

    // User password configuration panel
    private JPanel createUserPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel(gridBagLayout);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Res.localize("USER")));
        panel.setPreferredSize(new Dimension(400, 200));

        gbc.gridy = 0;
        gbc.gridx = 0;
        // Old Password label
        JLabel oldPasswordLabel = new JLabel(Res.localize("CURRENT_PASSWORD"));
        oldPasswordLabel.setFont(font12Bold);
        gridBagLayout.setConstraints(oldPasswordLabel, gbc);
        panel.add(oldPasswordLabel);

        // Old Password field
        oldPassword = new JPasswordField();
        oldPassword.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(oldPassword, gbc);
        panel.add(oldPassword);

        // New Password label
        JLabel newPasswordLabel = new JLabel(Res.localize("NEW_PASSWORD"));
        newPasswordLabel.setFont(font12Bold);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(newPasswordLabel, gbc);
        panel.add(newPasswordLabel);

        // New Password field
        newPassword = new JPasswordField();
        newPassword.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(newPassword, gbc);
        panel.add(newPassword);

        // Repeat Password label
        JLabel repeatPasswordLabel = new JLabel(Res.localize("RETYPE_PASSWORD"));
        repeatPasswordLabel.setFont(font12Bold);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(repeatPasswordLabel, gbc);
        panel.add(repeatPasswordLabel);

        // Repeat Password field
        repeatPassword = new JPasswordField();
        repeatPassword.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(repeatPassword, gbc);
        panel.add(repeatPassword);

        // Save Password button
        panel.add(new Label(""));
        updatePasswordButton = new JButton(Res.string().getSave());
        updatePasswordButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 3;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(updatePasswordButton, gbc);
        panel.add(updatePasswordButton);

        return panel;
    }

    // Camera configuration panel (common for both cameras)
    private JPanel createCameraPanel(String title, String cameraPrefix) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel(gridBagLayout);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        panel.setPreferredSize(new Dimension(400, 250));

        // IP address label
        JLabel ipLabel = new JLabel(Res.string().getDeviceIp());
        gbc.gridy = 0;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(ipLabel, gbc);
        panel.add(ipLabel);

        // IP address field
        JTextField ipField = new JTextField();
        switch (cameraPrefix) {
            case "camera1":
                camera1IPAddress = ipField;
                break;
            case "camera2":
                camera2IPAddress = ipField;
                break;
        }
        gbc.gridx = 1;
        ipField.setPreferredSize(new Dimension(200, 30));
        gridBagLayout.setConstraints(ipField, gbc);
        panel.add(ipField);

        // Port label
        JLabel portLabel = new JLabel(Res.string().getPort());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(portLabel, gbc);
        panel.add(portLabel);

        // Port field
        JTextField portField = new JTextField();
        switch (cameraPrefix) {
            case "camera1":
                camera1Port = portField;
                break;
            case "camera2":
                camera2Port = portField;
                break;
        }
        portField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(portField, gbc);
        panel.add(portField);

        // Username label
        JLabel userLabel = new JLabel(Res.string().getUserName());
        gbc.gridy = 2;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(userLabel, gbc);
        panel.add(userLabel);

        // Username field
        JTextField userField = new JTextField();
        switch (cameraPrefix) {
            case "camera1":
                camera1UserName = userField;
                break;
            case "camera2":
                camera2UserName = userField;
                break;
        }
        userField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(userField, gbc);
        panel.add(userField);

        // Password label
        JLabel passwordLabel = new JLabel(Res.string().getPassword());
        gbc.gridy = 3;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(passwordLabel, gbc);
        panel.add(passwordLabel);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        switch (cameraPrefix) {
            case "camera1":
                camera1Password = passwordField;
                break;
            case "camera2":
                camera2Password = passwordField;
                break;
        }
        passwordField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(passwordField, gbc);
        panel.add(passwordField);

        // Save button
        JButton saveButton = new JButton(Res.string().getSave());
        saveButton.setFont(font14Bold);
        switch (cameraPrefix) {
            case "camera1":
                camera1SaveButton = saveButton;
                break;
            case "camera2":
                camera2SaveButton = saveButton;
                break;
        }
        gbc.gridy = 4;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(saveButton, gbc);
        panel.add(saveButton);

        return panel;
    }

    private JPanel createClientPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel(gridBagLayout);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Res.localize("CLIENTS")));
        panel.setPreferredSize(new Dimension(300, 100));

        JLabel comLabel = new JLabel(Res.localize("CLIENT_NAME"));
        comLabel.setFont(font12Bold);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(comLabel, gbc);
        panel.add(comLabel);

        clientName = new JTextField();
        clientName.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(clientName, gbc);
        panel.add(clientName);

        saveClientButton = new JButton(Res.string().getSave());
        saveClientButton.setFont(font14Bold);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(saveClientButton, gbc);
        panel.add(saveClientButton);

        return panel;
    }

    private JPanel createCarsPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel(gridBagLayout);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Res.localize("CARS")));
        panel.setPreferredSize(new Dimension(300, 130));

        UIUtil.createLabel(panel, gridBagLayout, gbc, Res.localize("CAR_NUMBER"), 0, 0, 100, 30, SwingConstants.LEFT, font12Bold, null);
        carNumber = UIUtil.createTextBox(panel, gridBagLayout, gbc, 1, 0, 200, 30, SwingConstants.LEFT, "carNumber");

        UIUtil.createLabel(panel, gridBagLayout, gbc, Res.localize("CAR_MODEL"), 0, 1, 100, 30, SwingConstants.LEFT, font12Bold, null);
        carModel = UIUtil.createTextBox(panel, gridBagLayout, gbc, 1, 1, 200, 30, SwingConstants.LEFT, "carModel");

        saveCarButton = new JButton(Res.string().getSave());
        saveCarButton.setFont(font14Bold);
        gbc.gridy = 2;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(saveCarButton, gbc);
        panel.add(saveCarButton);

        return panel;
    }

    private JPanel createProductPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel(gridBagLayout);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Res.localize("PRODUCTS")));
        panel.setPreferredSize(new Dimension(300, 100));

        JLabel productLabel = new JLabel(Res.localize("PRODUCT_NAME"));
        productLabel.setFont(font12Bold);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gridBagLayout.setConstraints(productLabel, gbc);
        panel.add(productLabel);

        productName = new JTextField();
        productName.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gridBagLayout.setConstraints(productName, gbc);
        panel.add(productName);

        saveProductButton = new JButton(Res.string().getSave());
        saveProductButton.setFont(font14Bold);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gridBagLayout.setConstraints(saveProductButton, gbc);
        panel.add(saveProductButton);

        return panel;
    }
}
