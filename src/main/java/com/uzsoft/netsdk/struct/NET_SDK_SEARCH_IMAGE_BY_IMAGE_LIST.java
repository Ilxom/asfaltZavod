package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_SEARCH_IMAGE_BY_IMAGE_LIST extends Structure {
	public NET_SDK_SEARCH_IMAGE_BY_IMAGE_LIST(Pointer p,int offset) {
		super(p,ALIGN_NONE);
		useMemory(p,offset);
		read();
	}
	public NET_SDK_SEARCH_IMAGE_BY_IMAGE_LIST() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_SEARCH_IMAGE_BY_IMAGE_LIST implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_SEARCH_IMAGE_BY_IMAGE_LIST implements Structure.ByValue {
	}

	public int bEnd;//为1表述搜图个数已结束， 0表示后面还有
	public int listNum;
	public Pointer pSearchImageItem;//NET_SDK_SEARCH_IMAGE_ITEM *

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
