package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_TLV_BUFFER_DESC extends Structure{
	public NET_SDK_TLV_BUFFER_DESC(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_TLV_BUFFER_DESC() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_TLV_BUFFER_DESC implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_TLV_BUFFER_DESC implements Structure.ByValue {
	}

	public byte ucID;                        //1B,数据ID,由应用方定义
	public byte ucVersion;        //1B,数据版本,由应用方定义
	public short usNumber;        //2B,单位数量,最多65535
	public int dwSize;            //4B,单个信息大小, 总长度=usNumber*dwSize

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
