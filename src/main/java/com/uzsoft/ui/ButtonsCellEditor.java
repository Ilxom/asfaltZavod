package com.uzsoft.ui;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;

public class ButtonsCellEditor extends AbstractCellEditor implements TableCellEditor {
    private final ButtonsPane buttonsPane = new ButtonsPane();

    public ButtonsCellEditor() {
        this.buttonsPane.addActionListener((e) -> {
            SwingUtilities.invokeLater(this::stopCellEditing);
        });
    }

    public Object getCellEditorValue() {
        return this.buttonsPane.getState();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            this.buttonsPane.setBackground(table.getSelectionBackground());
        } else {
            this.buttonsPane.setBackground(table.getBackground());
        }

        return this.buttonsPane;
    }
}
