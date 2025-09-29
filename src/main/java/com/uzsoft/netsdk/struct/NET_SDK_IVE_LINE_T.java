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
public class NET_SDK_IVE_LINE_T extends Structure {
	public NET_SDK_IVE_LINE_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_LINE_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IVE_LINE_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IVE_LINE_T implements Structure.ByValue {
	}
	
	public int X1;   // 起点x坐标
    public int Y1;   // 起点y坐标
    public int X2;   // 终点x坐标
    public int Y2;   // 终点y坐标

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
