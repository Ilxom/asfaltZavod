package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_ALARMINFO extends Structure {
	public NET_SDK_ALARMINFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_ALARMINFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_ALARMINFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_ALARMINFO implements Structure.ByValue {
	}

	public int		dwAlarmType;
	public int		dwSensorIn;		
	public int		dwChannel;		
	public int		dwDisk;	

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
