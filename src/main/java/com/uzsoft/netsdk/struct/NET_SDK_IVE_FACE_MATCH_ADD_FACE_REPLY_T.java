package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_IVE_FACE_MATCH_ADD_FACE_REPLY_T extends Structure {
    public NET_SDK_IVE_FACE_MATCH_ADD_FACE_REPLY_T(Pointer p) {
        super(p,ALIGN_NONE);
        useMemory(p);
        read();
    }

    public NET_SDK_IVE_FACE_MATCH_ADD_FACE_REPLY_T() {
        super(ALIGN_NONE);
    }

    public static class ByReference extends NET_SDK_IVE_FACE_MATCH_ADD_FACE_REPLY_T implements Structure.ByReference {
    }

    public static class ByValue extends NET_SDK_IVE_FACE_MATCH_ADD_FACE_REPLY_T implements Structure.ByValue {
    }
    public int             dwResult;
    public int                 iPersonId;              
    public byte[]               szRes = new byte[32];


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
