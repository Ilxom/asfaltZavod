package com.uzsoft.ui;

import com.uzsoft.dto.WeightTO;
import com.uzsoft.utils.Res;
import com.uzsoft.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Slf4j
public class WeightTableModel extends AbstractTableModel {
    private final BaseForm form;
    private final List<WeightTO> data;

    public WeightTableModel(BaseForm form, List<WeightTO> data) {
        this.form = form;
        this.data = data;
    }

    public String getColumnName(int column) {
        return form.columnNames[column];
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class value = Object.class;
        value = switch (columnIndex) {
            case 0, 5, 6, 7 -> Integer.class;
            case 1, 2, 3, 4, 8, 9, 10, 11 -> String.class;
            default -> value;
        };

        return value;
    }

    public int getRowCount() {
        return this.data.size();
    }

    public int getColumnCount() {
        return form.getColumnNames().length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        WeightTO obj = this.data.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> obj.getId();
            case 1 -> obj.getWeighingType();
            case 2 -> obj.getCarNumber();
            case 3 -> obj.getCarModel();
            case 4 -> obj.getProductName();
            case 5 -> obj.getGross();
            case 6 -> obj.getTare();
            case 7 -> obj.getNet();
            case 8 -> obj.getSender();
            case 9 -> obj.getReceiver();
            case 10 -> obj.getCarDriver();
            case 11 -> obj.getOperator();
            case 12 -> Utils.formatDate3("ТАРА".equals(obj.getWeighingType()) ? obj.getTareDate() : obj.getGrossDate());
            default -> null;
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 12) {
            System.out.println(aValue);
            WeightTO value = this.data.get(rowIndex);
            if ("exportToWord".equals(aValue)) {
                log.info("Export to WORD");
                Utils.exportToWord(value.getId());
            } else if ("exportToExcel".equals(aValue)) {
                log.info("Export to Excel");
                Utils.exportToExcel(value.getId());
            } else if ("remove".equals(aValue)) {
                log.info("Remove row");
                this.remove(value);
            }

            this.fireTableCellUpdated(rowIndex, columnIndex);
        }

    }

    public void remove(WeightTO value) {
        int startIndex = this.data.indexOf(value);
        int dialog = JOptionPane.showConfirmDialog(null, String.format(Res.localize("REMOVE_DATA_QUESTION"), value.getId()), Res.localize("WARNING"), 2, 2);
        if (dialog == 0) {
            try {
                Statement statement = Utils.getStatement();
                int resultSet = statement.executeUpdate("update weight set deleted=true, deletedDate=now() where id=" + value.getId());
                if (resultSet > 0) {
                    JOptionPane.showMessageDialog(null, String.format(Res.localize("REMOVE_DATA_SUCCESS"), value.getId()), Res.localize("WARNING"), 1);
                    data.remove(value);
                    fireTableRowsInserted(startIndex, startIndex);
                    form.getData();
                } else {
                    JOptionPane.showMessageDialog(null, String.format(Res.localize("REMOVE_DATA_ERROR"), value.getId()), Res.localize("WARNING"), 2);
                }
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }

    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == getColumnCount() - 1;
    }
}
