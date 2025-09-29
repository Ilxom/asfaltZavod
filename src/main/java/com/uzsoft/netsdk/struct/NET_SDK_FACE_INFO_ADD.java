package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_INFO_ADD extends Structure {
	public NET_SDK_FACE_INFO_ADD(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_INFO_ADD() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_INFO_ADD implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_INFO_ADD implements Structure.ByValue {
	}

	public NET_SDK_FACE_INFO_LIST_ITEM sFaceInfoItem = new NET_SDK_FACE_INFO_LIST_ITEM();
	public int imgNum;
	public NET_SDK_FACE_IMG_INFO_CH[] sFaceImgInfo=(NET_SDK_FACE_IMG_INFO_CH[])new NET_SDK_FACE_IMG_INFO_CH[5];//最大5张
	public int haveImgData;//0、1
	public int imgWidth;//haveImgData ==1 有效
	public int imgHeight;//haveImgData ==1 有效
	public int imgLen;//haveImgData ==1 有效
	public Pointer imgData;//haveImgData ==1 有效   char*

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
