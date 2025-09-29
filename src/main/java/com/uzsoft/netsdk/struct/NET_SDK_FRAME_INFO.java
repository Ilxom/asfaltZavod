package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_FRAME_INFO extends Structure {
	public NET_SDK_FRAME_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_FRAME_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FRAME_INFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FRAME_INFO implements Structure.ByValue {
	}

	public int deviceID;
	public int channel;
	public int frameType; // 参考DD_FRAME_TYPE
	public int length;
	public int keyFrame; // 0：非关键帧 1：关键帧
	public int width;
	public int height;
	public int frameIndex;
	public int frameAttrib;// 参考DD_FRAME_ATTRIB
	public int streamID;
	public long time; // 从1970年1月1日0点0分0秒开始的绝对时间，单位微秒
	public long relativeTime;// 相对时间，单位微秒

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
