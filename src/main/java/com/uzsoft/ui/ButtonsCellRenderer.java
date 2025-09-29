package com.uzsoft.ui;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonsCellRenderer extends DefaultTableCellRenderer {
    private final ButtonsPane buttonsPane = new ButtonsPane();

    public ButtonsCellRenderer() {
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            this.buttonsPane.setBackground(table.getSelectionBackground());
        } else {
            this.buttonsPane.setBackground(table.getBackground());
        }

        return this.buttonsPane;
    }
}
