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
public class NET_DVR_IVE_POINT_T extends Structure {
	public NET_DVR_IVE_POINT_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_DVR_IVE_POINT_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_DVR_IVE_POINT_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_DVR_IVE_POINT_T implements Structure.ByValue {
	}
	
    public int X;
    public int Y;

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
