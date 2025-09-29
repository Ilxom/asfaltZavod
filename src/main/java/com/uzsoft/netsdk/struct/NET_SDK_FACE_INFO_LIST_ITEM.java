package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class NET_SDK_FACE_INFO_LIST_ITEM extends Structure {
	public NET_SDK_FACE_INFO_LIST_ITEM(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_INFO_LIST_ITEM() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_INFO_LIST_ITEM implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_INFO_LIST_ITEM implements Structure.ByValue {
	}

	public int itemId;				//id
    public byte[] name = new byte[64];		//
    public int sex; //0:male 1:female
    public int birthday;//eg:19900707
    public byte[] nativePlace = new byte[64];
    public int certificateType; //0:idCard
    public byte[] certificateNum =new byte[20];		//重庆中冉64，其他20
    public byte[] mobile = new byte[20];		//
    public byte[] number = new byte[20];		//
    public int faceImgCount;
    public NET_SDK_FACE_INFO_LIST_ITEM_GROUPS[] groups = (NET_SDK_FACE_INFO_LIST_ITEM_GROUPS[])new NET_SDK_FACE_INFO_LIST_ITEM_GROUPS().toArray(16);
    
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
