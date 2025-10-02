package com.uzsoft.ui;

import com.uzsoft.Constants;
import com.uzsoft.utils.Res;
import com.uzsoft.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.uzsoft.utils.UIUtil.*;

@Slf4j
public class LoginForm extends JFrame {
    private final JPanel mainPanel = new JPanel();
    private final JTextField loginBox;
    private final JPasswordField passwordBox;
    private JButton loginButton = null;
    private final JPanel loginPanel;
    private Image mainImage;
    private final JComboBox<String> languageBox;

    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    LoginForm() {
        String[] languages = new String[]{"Ўзбек", "Русский", "English"};
        Res.switchLanguage(Res.LanguageType.Russian);

        mainPanel.setSize(500, 400);
        mainPanel.setLayout(gridBagLayout);

        GridLayout gbc8 = new GridLayout(4, 2);
        gbc8.setHgap(10);
        loginPanel = new JPanel();
        loginPanel.setLayout(gbc8);
        loginPanel.setSize(300, 200);
        loginPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        loginPanel.setBackground(Color.WHITE);

        JLabel loginLabel = createLabel(loginPanel, gridBagLayout, gbc, Res.string().getUserName(), 0, 0, SwingConstants.LEFT, false, null);
        loginBox = createTextBox(loginPanel, gridBagLayout, gbc, 1, 0, "loginBox");

        JLabel passwordLabel = createLabel(loginPanel, gridBagLayout, gbc, Res.string().getPassword(), 0, 1, SwingConstants.LEFT, false, null);
        passwordBox = new JPasswordField();
        createWidget(loginPanel, gridBagLayout, gbc, passwordBox, 1, 1);

        JLabel languageLabel = createLabel(loginPanel, gridBagLayout, gbc, Res.string().getLanguage(), 0, 2, SwingConstants.LEFT, false, null);

        languageBox = new JComboBox<>(languages);
        languageBox.addItemListener(arg0 -> {
            Res.LanguageType type = languageBox.getSelectedIndex() == 0 ? Res.LanguageType.Uzbek : languageBox.getSelectedIndex() == 1 ? Res.LanguageType.Russian : Res.LanguageType.English;
            Res.switchLanguage(type);

            loginLabel.setText(Res.string().getUserName());
            passwordLabel.setText(Res.string().getPassword());
            languageLabel.setText(Res.string().getLanguage());
            loginButton.setText(Res.string().getLogin());
            setTitle(Res.string().getElectronWeight());
        });

        createWidget(loginPanel, gridBagLayout, gbc, languageBox, 1, 2);

        createLabel(loginPanel, gridBagLayout, gbc, "", 0, 3, SwingConstants.LEFT, false, null);
        loginButton = new JButton(Res.string().getLogin());
        createWidget(loginPanel, gridBagLayout, gbc, loginButton, 1, 3);

        mainPanel.add(loginPanel);

        languageBox.setSelectedItem("Русский");
        setTitle(Res.string().getElectronWeight());
        setPreferredSize(new Dimension(600, 430));
        setMinimumSize(new Dimension(600, 430));
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        pack();

        drawBackground();

        passwordBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });

        loginButton.addActionListener(e -> {
            loginToSystem();
        });
    }

    private void drawBackground() {
        try {
            mainImage = ImageIO.read(new File(Constants.applicationFolder + "/back.jpg"));
            if (mainPanel != null && mainImage != null) {
                mainPanel.getGraphics().drawImage(mainImage, 0, 0, null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginToSystem() {
        String login = loginBox.getText();
        if (login == null || login.isEmpty() || passwordBox.getPassword() == null || passwordBox.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, Res.localize("INVALID_CREDENTIALS"), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                log.info("Login to the system");
                String password = String.valueOf(passwordBox.getPassword());
                String sql = "SELECT id,userName,password,userFullName FROM users WHERE userName='" + login + "' and password='" + password + "'";
                Statement stmt = Utils.getStatement();
                ResultSet rs = stmt.executeQuery(sql);
                boolean res = rs.next();
                if (res) {
                    Utils.userName = login;
                    Utils.userFullName = rs.getString("userFullName");
                    new MainForm();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, Res.localize("INVALID_CREDENTIALS"), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
                }
                Utils.closeConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        int width = getWidth();
        int height = getHeight();

        if (width > 0 && height > 0) {
            if (mainImage != null) {
                mainImage = mainImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                mainPanel.getGraphics().drawImage(mainImage, 0, 0, null);
                loginPanel.repaint();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}
