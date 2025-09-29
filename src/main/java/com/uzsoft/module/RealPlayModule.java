package com.uzsoft.module;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.uzsoft.netsdk.lib.NetSDKLib;
import com.uzsoft.netsdk.struct.LPNET_SDK_CLIENTINFO;

import java.awt.*;

public class RealPlayModule {

	public static NetSDKLib.LLong startRealPlay(NetSDKLib.LLong m_hLoginHandle, int channel, int stream, Panel realPlayWindow) {
		NetSDKLib.LLong playHandle = LoginModule.netsdk.CLIENT_RealPlayEx(m_hLoginHandle, channel, Native.getComponentPointer(realPlayWindow), stream);

		if(playHandle.longValue() == 0) {
			System.err.println("Failed to start real-time monitoring");
		} else {
			System.out.println("Success to start real play");
		}

		return playHandle;
	}

	public static void stopRealPlay(NetSDKLib.LLong playHandle) {
		if(playHandle.longValue() == 0) {
			return;
		}

		boolean bRet = LoginModule.netsdk.CLIENT_StopRealPlayEx(playHandle);
		if(bRet) {
			playHandle.setValue(0);
		}
	}
}
