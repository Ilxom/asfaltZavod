package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_REC_FILE extends Structure {
	public NET_SDK_REC_FILE(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_REC_FILE() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_REC_FILE implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_REC_FILE implements Structure.ByValue {
	}

	public int dwChannel;
	public int bFileLocked;
	public DD_TIME startTime;
	public DD_TIME stopTime;
	public int dwRecType;
	public int dwPartition;
	public int dwFileIndex;

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
