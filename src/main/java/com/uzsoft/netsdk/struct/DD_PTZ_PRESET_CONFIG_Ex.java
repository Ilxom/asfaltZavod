package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_PTZ_PRESET_CONFIG_Ex extends Structure {
	public DD_PTZ_PRESET_CONFIG_Ex(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_PTZ_PRESET_CONFIG_Ex() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_PTZ_PRESET_CONFIG_Ex implements Structure.ByReference {
	}

	public static class ByValue extends DD_PTZ_PRESET_CONFIG_Ex implements Structure.ByValue {
	}
	public int channel;
    public int presetIndex;
    public byte[] presetName = new byte[64];
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
