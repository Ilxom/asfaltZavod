package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_CH_DEVICE_STATUS extends Structure {
	public NET_SDK_CH_DEVICE_STATUS(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_CH_DEVICE_STATUS() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_CH_DEVICE_STATUS implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_CH_DEVICE_STATUS implements Structure.ByValue {
	}

	public short channel; // 通道(从0开始)
	public short status; // 连接状态（0:offline，videoloss. 1: online,signal）
	public int chlType; // E_DIGITAL_CHL_TYPE,数字通道 E_ANALOG_CHL_TYPE,模拟通道
	public byte[] name = new byte[132];
	public byte[] resv = new byte[32]; // 暂时未用上

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
