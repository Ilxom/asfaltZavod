package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class NET_SDK_ST_SFACEIMGDATA extends Structure {
	public NET_SDK_ST_SFACEIMGDATA(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_ST_SFACEIMGDATA() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_ST_SFACEIMGDATA implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_ST_SFACEIMGDATA implements Structure.ByValue {
	}

	public int                imgWidth;//
	public int                imgHeight;//
	public int                imgLen;//
	public Pointer imgData;//

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

