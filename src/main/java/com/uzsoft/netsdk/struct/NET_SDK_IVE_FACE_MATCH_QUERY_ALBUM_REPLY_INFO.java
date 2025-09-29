package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 目标组人脸比对报警联动信息
 */
public class NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_REPLY_INFO extends Structure {
    public NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_REPLY_INFO(Pointer p) {
        super(p,ALIGN_NONE);
        useMemory(p);
        read();
    }

    public NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_REPLY_INFO() {
        super(ALIGN_NONE);
    }

    public static class ByReference extends NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_REPLY_INFO implements Structure.ByReference {
    }

    public static class ByValue extends NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_REPLY_INFO implements Structure.ByValue {
    }
    public int              				iKey;      // 键值.
    public NET_SDK_IVE_FACE_MATCH_ADD_ALBUM_INFO stBaseInfo;// 基本信息.

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
