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
public class NET_SDK_IVE_PASSLINECOUNT_T extends Structure {
	public NET_SDK_IVE_PASSLINECOUNT_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_PASSLINECOUNT_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IVE_PASSLINECOUNT_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IVE_PASSLINECOUNT_T implements Structure.ByValue {
	}
	
	public int          enterCarCount; //进入车辆数
    public int            enterPersonCount;//进入人数
    public int            enterBikeCount;//进入自行车数
    public int            leaveCarCount; //离开车辆数，如果单向计数，此字段值为0
    public int            leavePersonCount;//离开人数，如果单向计数，此字段值为0
    public int            leaveBikeCount;//离开自行车数，如果单向计数，此字段值为0
    public int            existCarCount;//留存车辆数，如果单向计数，此字段值为0
    public int            existPersonCount;//留存人数，如果单向计数，此字段值为0
    public int 						existBikeCount;//留存自行车数，如果单向计数，此字段值为0
    public int          count;         //分析结果个数
    public NET_SDK_IVE_PASSLINECOUNT_INFO_T[]  passLineInfo = new NET_SDK_IVE_PASSLINECOUNT_INFO_T[32];      // 绊线分析结果信息

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
