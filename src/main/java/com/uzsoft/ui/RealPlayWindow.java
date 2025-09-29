package com.uzsoft.ui;

import com.uzsoft.netsdk.lib.NetSDKLib;

import java.awt.*;

public class RealPlayWindow extends Panel {

    public RealPlayWindow(NetSDKLib.LLong loginHandle) {
        super();
        setMinimumSize(new Dimension(533, 400));
        setPreferredSize(new Dimension(533, 400));
    }

    public void setHandles(NetSDKLib.LLong loginHandle) {
        addMouseListener(new MyMouseHandler(loginHandle));
    }
}
