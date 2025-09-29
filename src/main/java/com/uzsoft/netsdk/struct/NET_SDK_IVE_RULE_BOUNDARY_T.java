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
public class NET_SDK_IVE_RULE_BOUNDARY_T extends Structure {
	public NET_SDK_IVE_RULE_BOUNDARY_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_RULE_BOUNDARY_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IVE_RULE_BOUNDARY_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IVE_RULE_BOUNDARY_T implements Structure.ByValue {
	}
	
	public int      pointNum;              // 区域包含点的个数（0或3到8）
	public    NET_SDK_IVE_POINT_T[] point = new NET_SDK_IVE_POINT_T  [32];             // 点的坐标信息

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
