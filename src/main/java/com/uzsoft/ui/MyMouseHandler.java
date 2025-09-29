package com.uzsoft.ui;

//import com.uzsoft.camera.ZoomWindow;

import com.uzsoft.module.RealPlayModule;
import com.uzsoft.netsdk.lib.NetSDKLib;
import com.uzsoft.utils.Res;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseHandler implements MouseListener {
    private final NetSDKLib.LLong loginHandle;

    public MyMouseHandler(NetSDKLib.LLong loginHandle) {
        this.loginHandle = loginHandle;
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
        NetSDKLib.LLong playHandle = new NetSDKLib.LLong(0);
        RealPlayWindow playWindow = new RealPlayWindow(playHandle);
        new ZoomWindow(playWindow);
        playHandle = RealPlayModule.startRealPlay(loginHandle, 0, 0, playWindow);
        if (playHandle.longValue() == 0) {
            JOptionPane.showMessageDialog(null, Res.string().getCameraError(), Res.string().getError(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
