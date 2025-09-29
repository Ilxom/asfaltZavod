package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖燕波
 * @create 2020/6/8
 * @edit 2020/6/8
 * Description:
 */
public class NET_SDK_IVE_RECT_T extends Structure {
	public NET_SDK_IVE_RECT_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_RECT_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IVE_RECT_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IVE_RECT_T implements Structure.ByValue {
	}
	
	 public int X1;   // 左上角x坐标
     public int Y1;   // 左上角y坐标
     public int X2;   // 右下角x坐标
     public int Y2;   // 右下角y坐标

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
