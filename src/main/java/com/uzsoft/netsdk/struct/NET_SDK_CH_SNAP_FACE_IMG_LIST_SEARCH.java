package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_CH_SNAP_FACE_IMG_LIST_SEARCH extends Structure {
	public NET_SDK_CH_SNAP_FACE_IMG_LIST_SEARCH(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_CH_SNAP_FACE_IMG_LIST_SEARCH() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_CH_SNAP_FACE_IMG_LIST_SEARCH implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_CH_SNAP_FACE_IMG_LIST_SEARCH implements Structure.ByValue {
	}

	public int dwChannel;//抓图通道
	public DD_TIME startTime; //时间
	public DD_TIME endTime; //时间
    public int pageIndex;//第几页
    public int pageSize;//每页数
	public byte[] resv = new byte[8]; // 保留


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
