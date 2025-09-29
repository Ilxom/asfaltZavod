package com.uzsoft.module;

import com.sun.jna.Callback;
import com.uzsoft.netsdk.lib.NetSDKLib;

public class LoginModule {

	public static NetSDKLib netsdk 		= NetSDKLib.NETSDK_INSTANCE;
	private NetSDKLib.NET_DEVICEINFO_Ex m_stDeviceInfo = new NetSDKLib.NET_DEVICEINFO_Ex();
	private NetSDKLib.LLong m_hLoginHandle = new NetSDKLib.LLong(0);
	private static boolean bInit    = false;
	private static boolean bLogopen = false;

	public NetSDKLib.LLong init() {
		return init(m_hLoginHandle, null, null);
	}

	public NetSDKLib.LLong init(NetSDKLib.LLong m_hLoginHandle, Callback cbDisConnect, NetSDKLib.fHaveReConnect haveReConnect) {
		this.m_hLoginHandle = m_hLoginHandle;
		bInit = netsdk.CLIENT_Init(cbDisConnect, null);
		if(!bInit) {
			System.out.println("Initialize SDK failed");
			return new NetSDKLib.LLong(0);
		}

		netsdk.CLIENT_SetAutoReconnect(haveReConnect, null);
		netsdk.CLIENT_SetConnectTime(5000, 1);
		netsdk.CLIENT_SetGDPREnable(true);

		NetSDKLib.NET_PARAM netParam = new NetSDKLib.NET_PARAM();
		netParam.nConnectTime = 10000;
		netParam.nGetConnInfoTime = 3000;
		netsdk.CLIENT_SetNetworkParam(netParam);

		return m_hLoginHandle;
	}

	public void cleanup() {
		if(bLogopen) {
			netsdk.CLIENT_LogClose();
		}

		if(bInit) {
			netsdk.CLIENT_Cleanup();
		}
	}

	public NetSDKLib.LLong login(String m_strIp, int m_nPort, String m_strUser, String m_strPassword) {
		init();

		//--------------------------------------------------------------------------------------------------------------
		NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY pstInParam=new NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY();
		pstInParam.nPort=m_nPort;
		pstInParam.szIP=m_strIp.getBytes();
		pstInParam.szPassword=m_strPassword.getBytes();
		pstInParam.szUserName=m_strUser.getBytes();

		NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY pstOutParam=new NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY();
		pstOutParam.stuDeviceInfo=m_stDeviceInfo;
		m_hLoginHandle=netsdk.CLIENT_LoginWithHighLevelSecurity(pstInParam, pstOutParam);
		if(m_hLoginHandle.longValue() == 0) {
			System.err.printf("Login Device Port Failed.");
		} else {
			System.out.println("Login Success [ " + m_strIp + " ]");
		}

		return m_hLoginHandle;
	}

	public boolean logout() {
		if(m_hLoginHandle.longValue() == 0) {
			return false;
		}

		boolean bRet = netsdk.CLIENT_Logout(m_hLoginHandle);
		if(bRet) {
			m_hLoginHandle.setValue(0);
		}

		return bRet;
	}
}
