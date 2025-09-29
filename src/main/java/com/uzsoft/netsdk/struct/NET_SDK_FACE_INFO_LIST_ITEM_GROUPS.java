package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_INFO_LIST_ITEM_GROUPS extends Structure {
	public NET_SDK_FACE_INFO_LIST_ITEM_GROUPS(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_INFO_LIST_ITEM_GROUPS() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_INFO_LIST_ITEM_GROUPS implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_INFO_LIST_ITEM_GROUPS implements Structure.ByValue {
	}

	public int groupId;
	public byte[] guid = new byte[48]; 
	public DD_TIME_EX validStartTime = new DD_TIME_EX();
	public DD_TIME_EX validEndTime = new DD_TIME_EX();

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
