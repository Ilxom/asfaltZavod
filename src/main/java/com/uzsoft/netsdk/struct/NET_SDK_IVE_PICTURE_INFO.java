package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_IVE_PICTURE_INFO extends Structure{
	public NET_SDK_IVE_PICTURE_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_PICTURE_INFO() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IVE_PICTURE_INFO implements Structure.ByReference {
	}
	public static class ByValue extends NET_SDK_IVE_PICTURE_INFO implements Structure.ByValue {
	}
     
	public int iWidth;                    // 图片宽.
    public int iHeight;                   // 图片高.
    public int iPicFormat;                // 图片格式.
    public int iPicSize;                  // 图片大小.

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
