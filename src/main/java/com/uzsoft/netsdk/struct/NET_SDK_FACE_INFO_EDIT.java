package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_INFO_EDIT extends Structure {
	public NET_SDK_FACE_INFO_EDIT(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_INFO_EDIT() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_INFO_EDIT implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_INFO_EDIT implements Structure.ByValue {
	}

	public int[] delFaceImgs = new int[5];
	public NET_SDK_FACE_INFO_ADD sFaceInfoItem;

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
