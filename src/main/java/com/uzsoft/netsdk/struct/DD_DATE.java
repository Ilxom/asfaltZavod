package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_DATE extends Structure {
	public DD_DATE(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_DATE() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_DATE implements Structure.ByReference {
	}

	public static class ByValue extends DD_DATE implements Structure.ByValue {
	}

	public byte mday;		//Day of month (1–31)
    public byte month;		//Month (1–12;)
    public short year;		//Year (current solar year)

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
