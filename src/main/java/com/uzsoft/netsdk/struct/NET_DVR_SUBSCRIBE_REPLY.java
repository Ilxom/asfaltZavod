package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_DVR_SUBSCRIBE_REPLY extends Structure{
	public NET_DVR_SUBSCRIBE_REPLY(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_DVR_SUBSCRIBE_REPLY() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_DVR_SUBSCRIBE_REPLY implements Structure.ByReference {
	}

	public static class ByValue extends NET_DVR_SUBSCRIBE_REPLY implements Structure.ByValue {
	}

	public byte[] serverAddress = new byte[256];	// 订阅标识 后期的续订和退订使用	
    public long currentTime;// 当前时间
    public long terminationTime;// 终止时间
    public byte[] resv = new byte[64];	// 后期扩展用

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
