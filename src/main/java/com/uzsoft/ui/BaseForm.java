package com.uzsoft.ui;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.*;


@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public abstract class BaseForm extends JFrame {

    protected String[] columnNames;
    protected GridBagConstraints gbc;

    public BaseForm(String[] columnNames) throws HeadlessException {
        this.columnNames = columnNames;
        this.gbc = new GridBagConstraints();
        initialize();
    }

    protected abstract void initialize();

    protected abstract void getData();

}
