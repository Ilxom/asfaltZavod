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
public class NET_SDK_IVE_TRIP_INFO_T extends Structure {
	public NET_SDK_IVE_TRIP_INFO_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_TRIP_INFO_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IVE_TRIP_INFO_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IVE_TRIP_INFO_T implements Structure.ByValue {
	}
	
	public int         eventId;            // 事件ID
	public int         status;             // 报警状态,0:none 1:start 2:end 3:procedure
	public int         targetId;           // 目标ID
	public NET_SDK_IVE_LINE_T      line;               // 绊线规则信息
	public NET_SDK_IVE_RECT_T      rect;               // 目标矩形框

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
