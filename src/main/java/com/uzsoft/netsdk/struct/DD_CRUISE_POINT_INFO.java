package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_CRUISE_POINT_INFO extends Structure {
	public DD_CRUISE_POINT_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_CRUISE_POINT_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_CRUISE_POINT_INFO implements Structure.ByReference {
	}

	public static class ByValue extends DD_CRUISE_POINT_INFO implements Structure.ByValue {
	}

	public int presetIndex;
    public int dwellSpeed;
    public int dwellTime;

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
