package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_INFO_GROUP_ITEM extends Structure {
	public NET_SDK_FACE_INFO_GROUP_ITEM(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_INFO_GROUP_ITEM() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_INFO_GROUP_ITEM implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_INFO_GROUP_ITEM implements Structure.ByValue {
	}

	public byte[] guid = new byte[48];
	public byte[] name = new byte[64];
	public int property;
	public int groupId;
	public int enableAlarmSwitch;

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
