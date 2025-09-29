package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖燕波
 * @create 2020/6/9
 * @edit 2020/6/9
 * Description:
 */
public class NET_SDK_IVE_PERIMETER_T extends Structure {
	public NET_SDK_IVE_PERIMETER_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_PERIMETER_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IVE_PERIMETER_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IVE_PERIMETER_T implements Structure.ByValue {
	}
	
	public int          count;             // 个数
	public NET_SDK_IVE_PER_INFO_T[]   perInfo = new NET_SDK_IVE_PER_INFO_T[32];       // 区域入侵分析结果信息

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
