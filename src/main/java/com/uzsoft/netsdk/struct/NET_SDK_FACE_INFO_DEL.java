package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_INFO_DEL extends Structure {
	public NET_SDK_FACE_INFO_DEL(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_INFO_DEL() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_INFO_DEL implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_INFO_DEL implements Structure.ByValue {
	}

	public int faceInfoListItemId;
	public int[] groupsId = new int[16];

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
