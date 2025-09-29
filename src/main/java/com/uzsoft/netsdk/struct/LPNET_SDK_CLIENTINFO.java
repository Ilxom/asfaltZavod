package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LPNET_SDK_CLIENTINFO extends Structure {
	public LPNET_SDK_CLIENTINFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public LPNET_SDK_CLIENTINFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends LPNET_SDK_CLIENTINFO implements Structure.ByReference {
	}

	public static class ByValue extends LPNET_SDK_CLIENTINFO implements Structure.ByValue {
	}

	public int lChannel;
	public int streamType;
	public Pointer hPlayWnd;
	public int bNoDecode; //0:decode，1：not decode only for windows os，default is 0

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
