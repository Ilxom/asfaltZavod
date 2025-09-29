package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FACE_MATCH_CHAN_GROUP extends Structure {
	public NET_SDK_FACE_MATCH_CHAN_GROUP(Pointer p) {
		super(p, ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FACE_MATCH_CHAN_GROUP() {
        super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_MATCH_CHAN_GROUP implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_MATCH_CHAN_GROUP implements Structure.ByValue {
	}

	public int  faceFeatureGroupsNum; //通道拥有的目标组个数
//	public Pointer pfaceFeatureGroupIDs;  //通道拥有的目标组ID列表
	public int[] faceFeatureGroupIDs = new int[16];  //通道拥有的目标组ID列表
	

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
