package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class intStruct extends Structure {
	public intStruct(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public intStruct() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends intStruct implements Structure.ByReference {
	}

	public static class ByValue extends intStruct implements Structure.ByValue {
	}
	public int intValue; 

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
