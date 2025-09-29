package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖燕波
 * @create 2018/6/25
 * @edit 2020/4/20
 * Description: 
 */
public class NET_SDK_LOG extends Structure {

	public NET_SDK_LOG(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_LOG() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_LOG implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_LOG implements Structure.ByValue {
	}
	 public DD_TIME strLogTime;
     public int dwMajorType;
     public int dwMinorType;
	 public byte[] sNetUser = new byte[36];
     public int dwRemoteHostAddr;
     public byte[] sContent = new byte[512];


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
