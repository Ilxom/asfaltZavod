package com.uzsoft.ui;

import javax.swing.*;
import java.awt.*;

public class ZoomWindow extends JFrame {

    public ZoomWindow(RealPlayWindow window) {
        setPreferredSize(new Dimension(1200, 710));
        setMinimumSize(new Dimension(1200, 710));
        setContentPane(window);
        setDefaultLookAndFeelDecorated(true);
        setVisible(true);
        pack();
    }
}
