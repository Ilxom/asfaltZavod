package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LPNET_SDK_DEVICEINFO extends Structure {
	public LPNET_SDK_DEVICEINFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public LPNET_SDK_DEVICEINFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends LPNET_SDK_DEVICEINFO implements Structure.ByReference {
	}

	public static class ByValue extends LPNET_SDK_DEVICEINFO implements Structure.ByValue {
	}

	public byte localVideoInputNum; // 本地视频输入通道数目
	public byte audioInputNum; // 音频输入通道数目
	public byte sensorInputNum; // 传感器输入通道数目
	public byte sensorOutputNum; // 继电器输出数目
	public int displayResolutionMask; // 监视器可选择的分辨率
	public byte videoOuputNum; // 视频输出数目（及支持回放最大通道数）
	public byte netVideoOutputNum; // 网络回放最大通道数目
	public byte netVideoInputNum; // 数字信号接入通道数目
	public byte IVSNum; // 智能分析通道数目
	public byte presetNumOneCH; // 每个通道预置点数目
	public byte cruiseNumOneCH; // 每个通道巡航线数目
	public byte presetNumOneCruise; // 每个巡航线的预置点数目
	public byte trackNumOneCH; // 每个通道轨迹数目
	public byte userNum; // 用户数目
	public byte netClientNum; // 最多客户端数目
	public byte netFirstStreamNum; // 主码流传输的通道最大数目，即同时可以有几个客户端查看主码流
	public byte deviceType; // NET_SDK_DEVICE_TYPE
	public byte doblueStream; // 是否有提供双码流
	public byte audioStream; // 是否有提供音频流
	public byte talkAudio; // 是否有对讲功能: 1表示有对讲功能;0表示没有
	public byte bPasswordCheck; // 操作是否要输入密码
	public byte defBrightness; // 缺省亮度
	public byte defContrast; // 缺省对比度
	public byte defSaturation; // 缺省饱和度
	public byte defHue; // 缺省色调
	public short videoInputNum; // 视频输入通道数目（本地加网络）
	public short deviceID; // 设备ID号
	public int videoFormat; // 系统当前制式
	// 假如是FUNC_REMOTE_UPGRADE对应的功能，那么第FUNC_REMOTE_UPGRADE个比特为1，否则为零。
	public int[] function = new int[8]; // 功能描述
	public int deviceIP; // 设备网络地址
	public byte[] deviceMAC = new byte[6]; // 设备物理地址
	public short devicePort; // 设备端口
	public int buildDate; // 创建日期:year<<16 + month<<8 + mday
	public int buildTime; // 创建时间:hour<<16 + min<<8 + sec
	public byte[] deviceName = new byte[36]; // 设备名称
	public byte[] firmwareVersion = new byte[36];// 固件版本
	public byte[] kernelVersion = new byte[64]; // 内核版本
	public byte[] hardwareVersion = new byte[36]; // 硬件版本
	public byte[] MCUVersion = new byte[36]; // 单片机版本
	public byte[] firmwareVersionEx = new byte[64]; // 固件版本扩展，主要针对新产品
	public int softwareVer;			//IPC software version
	public byte[] szSN = new byte[32]; // SN
	public byte[] deviceProduct = new byte[28]; // 设备型号

	@Override
	protected List<String> getFieldOrder() {
		List<Field> flist = getFieldList();
		List<String> list = new ArrayList<>(flist.size());
		for (Field f : flist) {
		    list.add(f.getName());
		}
		return list;
	}
}
