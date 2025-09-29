package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_ALARM_STATUS_INFO extends Structure {
	public DD_ALARM_STATUS_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_ALARM_STATUS_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_ALARM_STATUS_INFO implements Structure.ByReference {
	}

	public static class ByValue extends DD_ALARM_STATUS_INFO implements Structure.ByValue {
	}

	public int iSize;					//the length of this struct
    public int chanl;	//报警通道，跟通道无关的报警是-1， 跟通道相关的是通道，io之类的报警是个数
    public int alarmType;	//refer to  NET_SDK_N9000_ALARM_TYPE in ErrorCodeAndConst.java

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
