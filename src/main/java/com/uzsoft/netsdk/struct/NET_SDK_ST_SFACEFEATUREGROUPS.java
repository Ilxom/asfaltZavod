package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class NET_SDK_ST_SFACEFEATUREGROUPS extends Structure {
	public NET_SDK_ST_SFACEFEATUREGROUPS(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_ST_SFACEFEATUREGROUPS() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_ST_SFACEFEATUREGROUPS implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_ST_SFACEFEATUREGROUPS implements Structure.ByValue {
	}

	 public int	groupsId;				//GROUP Id

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





