package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_SEARCH_IMAGE_ITEM extends Structure {
	public NET_SDK_SEARCH_IMAGE_ITEM(Pointer p,int offset) {
		super(p,ALIGN_NONE);
		useMemory(p,offset);
		read();
	}
	public NET_SDK_SEARCH_IMAGE_ITEM() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_SEARCH_IMAGE_ITEM implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_SEARCH_IMAGE_ITEM implements Structure.ByValue {
	}

	public DD_TIME recStartTime = new DD_TIME();
	public DD_TIME recEndTime = new DD_TIME();
	public int similarity; // 相似度
	public int faceFeatureId; // 通过人脸特征搜索时，和哪个特征匹配
	public NET_SDK_FACE_IMG_INFO_CH sfaceImg = new NET_SDK_FACE_IMG_INFO_CH(); // 通过人脸图片搜索时，和哪个图片匹配
	public byte[] resv = new byte[4];

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
