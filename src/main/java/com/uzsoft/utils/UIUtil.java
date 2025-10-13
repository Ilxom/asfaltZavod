package com.uzsoft.utils;

import javax.swing.*;
import java.awt.*;

public class UIUtil {

    private static final Font font40Bold = new Font("times", Font.BOLD, 40);

    public static void createWidget(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, JComponent component, int x, int y) {
        gbc.gridy = y;
        gbc.gridx = x;
        component.setMinimumSize(new Dimension(100, 40));
        component.setPreferredSize(new Dimension(200, 40));
        component.setMaximumSize(new Dimension(200, 40));
        gridBagLayout.setConstraints(component, gbc);
        mainPanel.add(component);
    }

    public static void createWidget(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, JComponent component, int x, int y,
                                    int width, int height) {
        gbc.gridy = y;
        gbc.gridx = x;
        component.setPreferredSize(new Dimension(width, height));
        gridBagLayout.setConstraints(component, gbc);
        mainPanel.add(component);
    }

    public static JLabel createLabel(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, String labelText,
                               int x, int y, int horizontalAlignment, boolean useBoldFont, String componentName) {
        return createLabel(mainPanel, gridBagLayout, gbc, labelText, 14, x, y, horizontalAlignment, useBoldFont, componentName);
    }

    public static JLabel createLabel(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, String labelText,
                               int labelFontSize, int x, int y, int horizontalAlignment, boolean useBoldFont, String componentName) {
        JLabel label = new JLabel(labelText);
        label.setName(componentName);
        label.setHorizontalTextPosition(horizontalAlignment);
        label.setMinimumSize(new Dimension(200, 40));
        label.setPreferredSize(new Dimension(200, 40));
        label.setMaximumSize(new Dimension(200, 40));
        if (useBoldFont) {
            label.setFont(font40Bold);
        } else {
            label.setFont(new Font("times", Font.BOLD, labelFontSize));
        }
        createWidget(mainPanel, gridBagLayout, gbc, label, x, y);
        return label;
    }

    public static JLabel createLabel(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, String labelText,
                               int x, int y, int width, int height, int horizontalAlignment, Font font, String componentName) {
        JLabel label = new JLabel(labelText);
        label.setName(componentName);
        label.setFont(font);
        createWidget(mainPanel, gridBagLayout, gbc, label, x, y, width, height);
        return label;
    }

    public static JTextField createTextBox(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, int x, int y, String componentName) {
        JTextField textField = new JTextField();
        textField.setName(componentName);
        createWidget(mainPanel, gridBagLayout, gbc, textField, x, y);
        return textField;
    }

    public static JTextField createTextBox(JPanel mainPanel, GridBagLayout gridBagLayout, GridBagConstraints gbc, int x, int y,
                                           int width, int height, int horizontalAlignment, String componentName) {
        JTextField textField = new JTextField();
        textField.setName(componentName);
        createWidget(mainPanel, gridBagLayout, gbc, textField, x, y, width, height);
        return textField;
    }

    public static JComboBox<String> createCombobox(JPanel mainPanel, GridBagLayout layout, GridBagConstraints gbc, String[] items, int x, int y, String componentName) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setName(componentName);
        createWidget(mainPanel, layout, gbc, comboBox, x, y);
        return comboBox;
    }
}
