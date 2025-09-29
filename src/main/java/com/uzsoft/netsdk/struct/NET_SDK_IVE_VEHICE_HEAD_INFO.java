package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖燕波
 * @create 2020/7/21
 * Description: 车牌识别
 */
public class NET_SDK_IVE_VEHICE_HEAD_INFO extends Structure {
	public NET_SDK_IVE_VEHICE_HEAD_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_VEHICE_HEAD_INFO() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IVE_VEHICE_HEAD_INFO implements Structure.ByReference {
	}
	public static class ByValue extends NET_SDK_IVE_VEHICE_HEAD_INFO implements Structure.ByValue {
	}
	
	public int begin_flag;       //开始标识，0x5a5a5a5a
	public int item_cnt;         /// NET_SDK_IVE_VEHICE_ITEM_INFO的个数
	public int plate_cnt;        /// 检测到车牌个数
	public long  relativeTime;     /// 检测源数据相对时间,相对时间
	public long  absoluteTime;     /// 检测源数据当前时间,绝对时间
	public int softwareVersion;  /// 软件版本号, 0xABCDEFGH,AB：厂家 CD：主版本 EFGH：子版本 厂商 1:欧姆龙 版本:V5.00
	public int softwareBuildDate;/// 软件生成日期,0xYYYYMMDD
	public int[] resver = new int[2];
	public int end_flag;         //结束标识，0xa5a5a5a5
	

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
