package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_IVE_CDD_INFO_T extends Structure{
	public NET_SDK_IVE_CDD_INFO_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_CDD_INFO_T() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IVE_CDD_INFO_T implements Structure.ByReference {
	}
	public static class ByValue extends NET_SDK_IVE_CDD_INFO_T implements Structure.ByValue {
	}
    
    public int                 iRatio;                         // 人群密度等级 0-无效；1-人少；2-人多；3-人很多
    public NET_SDK_IVE_RECT_T              rect;                           // 目标矩形框

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
