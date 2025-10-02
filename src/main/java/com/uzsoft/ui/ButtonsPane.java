package com.uzsoft.ui;

import lombok.Getter;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPane extends JPanel {
    private final JButton wordButton, excelButton;
    private final JButton removeButton;
    @Getter
    private String state;

    public ButtonsPane() {
        setLayout(new GridBagLayout());

        wordButton = new JButton("Word");
        wordButton.setActionCommand("exportToWord");
        wordButton.setMinimumSize(new Dimension(60, 20));
        wordButton.setPreferredSize(new Dimension(60, 20));

        excelButton = new JButton("Excel");
        excelButton.setActionCommand("exportToExcel");
        excelButton.setMinimumSize(new Dimension(60, 20));
        excelButton.setPreferredSize(new Dimension(60, 20));

        removeButton = new JButton("Ўчириш");
        removeButton.setActionCommand("remove");
        removeButton.setMinimumSize(new Dimension(70, 20));
        removeButton.setPreferredSize(new Dimension(70, 20));

        this.add(this.wordButton);
        this.add(this.excelButton);
        this.add(this.removeButton);

        ActionListener listener = (e) -> {
            this.state = e.getActionCommand();
            System.out.println("State = " + this.state);
        };
        this.wordButton.addActionListener(listener);
        this.excelButton.addActionListener(listener);
        this.removeButton.addActionListener(listener);
    }

    public void addActionListener(ActionListener listener) {
        this.wordButton.addActionListener(listener);
        this.excelButton.addActionListener(listener);
        this.removeButton.addActionListener(listener);
    }
}