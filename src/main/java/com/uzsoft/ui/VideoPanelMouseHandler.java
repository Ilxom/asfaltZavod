package com.uzsoft.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class VideoPanelMouseHandler implements MouseListener {

    private final File weightFolder;
    private final String cameraIPAddress;

    public VideoPanelMouseHandler(File weightFolder, String cameraIPAddress) {
        this.weightFolder = weightFolder;
        this.cameraIPAddress = cameraIPAddress;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        zoomInImage();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void zoomInImage() {
        /*String strFileName = weightFolder.getAbsolutePath() + "/" + UUID.randomUUID() + ".jpg";
        HttpUtil.GetSnapshot(Constants.protocol + cameraIPAddress + "/GetSnapshot", strFileName);
        try {
            Panel imagePanel = new Panel();
            Image image= ImageIO.read(new File(strFileName));
            image = image.getScaledInstance(new Float(670 * 1.78f).intValue(), 670, Image.SCALE_SMOOTH);
            ImageIcon imageicon=new ImageIcon(image);
            JLabel label=new JLabel(imageicon);
            imagePanel.add(label);
            new ZoomWindow(imagePanel);
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
}
