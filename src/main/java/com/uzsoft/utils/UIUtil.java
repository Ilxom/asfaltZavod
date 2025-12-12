package com.uzsoft.utils;

import javax.swing.*;
import java.awt.*;

public class UIUtil {

    private static final Font font40Bold = new Font("times", Font.BOLD, 40);

    public static void createWidget(JPanel mainPanel, GridLayout gridBagLayout, JComponent component, int x, int y) {
//        gridBagLayout.setRows(y);
//        gridBagLayout.setColumns(x);
        component.setMinimumSize(new Dimension(100, 40));
        component.setPreferredSize(new Dimension(200, 40));
        component.setMaximumSize(new Dimension(200, 40));
        mainPanel.add(component);
    }

    public static void createWidget(JPanel mainPanel, GridLayout gridBagLayout, JComponent component, int x, int y,
                                    int width, int height) {
//        gridBagLayout.setRows(y);
//        gridBagLayout.setColumns(x);
        component.setPreferredSize(new Dimension(width, height));
//        gridBagLayout.setConstraints(component, gbc);
        mainPanel.add(component);
    }

    public static JLabel createLabel(JPanel mainPanel, GridLayout gridBagLayout, String labelText,
                               int x, int y, int horizontalAlignment, boolean useBoldFont, String componentName) {
        return createLabel(mainPanel, gridBagLayout, labelText, 14, x, y, horizontalAlignment, useBoldFont, componentName);
    }

    public static JLabel createLabel(JPanel mainPanel, GridLayout gridBagLayout, String labelText,
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
        createWidget(mainPanel, gridBagLayout, label, x, y);
        return label;
    }

    public static void createLabel(JPanel mainPanel, GridLayout gridBagLayout, String labelText,
                                   int x, int y, int width, int height, Font font, String componentName) {
        JLabel label = new JLabel(labelText);
        label.setName(componentName);
        label.setFont(font);
        createWidget(mainPanel, gridBagLayout, label, x, y, width, height);
    }

    public static JTextField createTextBox(JPanel mainPanel, GridLayout gridBagLayout, int x, int y, String componentName) {
        JTextField textField = new JTextField();
        textField.setName(componentName);
        textField.setFont(new Font("times", Font.BOLD, 16));
        createWidget(mainPanel, gridBagLayout, textField, x, y);
        return textField;
    }

    public static JTextField createTextBox(JPanel mainPanel, GridLayout gridBagLayout, int x, int y,
                                           int width, int height, String componentName) {
        JTextField textField = new JTextField();
        textField.setName(componentName);
        createWidget(mainPanel, gridBagLayout, textField, x, y, width, height);
        return textField;
    }

    public static JComboBox<String> createCombobox(JPanel mainPanel, GridLayout layout, String[] items, int x, int y, String componentName) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setName(componentName);
        createWidget(mainPanel, layout, comboBox, x, y);
        return comboBox;
    }
}
