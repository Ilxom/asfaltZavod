package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_REC_EVENT extends Structure {
	public NET_SDK_REC_EVENT(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_REC_EVENT() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_REC_EVENT implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_REC_EVENT implements Structure.ByValue {
	}

	public int dwChannel;//channel
    public DD_TIME startTime;//start time
    public DD_TIME stopTime;//stop time
    public int dwRecType;//record type 0：no record type;1:manual;2:schedual;4:motion detect record 8:sensor alarm record;16:behaviour analysis alarm record

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
