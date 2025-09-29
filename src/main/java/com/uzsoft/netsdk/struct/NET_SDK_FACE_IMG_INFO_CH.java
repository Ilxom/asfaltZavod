package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_IMG_INFO_CH extends Structure {
	public NET_SDK_FACE_IMG_INFO_CH(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_IMG_INFO_CH() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_IMG_INFO_CH implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_IMG_INFO_CH implements Structure.ByValue {
	}

	public DD_TIME_EX frameTime = new DD_TIME_EX();
	public int snapImgId;//抓拍图片id
	public int targetImgId;//目标图片id
	public int chl;
	public byte   isPanorama;//0表示抓拍图片，1表示全景图
	public byte[] resv = new byte[7]; // 保留


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
