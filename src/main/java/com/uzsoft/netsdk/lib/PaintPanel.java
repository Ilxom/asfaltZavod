package com.uzsoft.netsdk.lib;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private Image image;
	
	public PaintPanel() {
		super();
		setOpaque(true); //非透明
		setLayout(null);
		setBackground(Color.GRAY);
		setForeground(new Color(0, 0, 0));
	}

    protected void paintComponent(Graphics g) {
		if(image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
		super.paintComponent(g);
	}	
}
