package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_CH_CRUISE extends Structure {
	public DD_CH_CRUISE(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_CH_CRUISE() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_CH_CRUISE implements Structure.ByReference {
	}

	public static class ByValue extends DD_CH_CRUISE implements Structure.ByValue {
	}

	public int channel;
    public int cruiseIndex;
    public byte[] cruiseName = new byte[64];


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
