package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 目标组人脸比对报警联动信息
 */
public class NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_INFO extends Structure {
    public NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_INFO(Pointer p) {
        super(p,ALIGN_NONE);
        useMemory(p);
        read();
    }

    public NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_INFO() {
        super(ALIGN_NONE);
    }

    public static class ByReference extends NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_INFO implements Structure.ByReference {
    }

    public static class ByValue extends NET_SDK_IVE_FACE_MATCH_QUERY_ALBUM_INFO implements Structure.ByValue {
    }
    public int				iPageNum;				   // 页码(从0开始).
    public int				iPageSize;				   // 每页条目数.(范围1-10)
    public boolean             bUseKeyFilter;             // 使用键值过滤删除.
    public int              iKey;                      // 键值.
    public boolean bUseNameFilter;            // 使用姓名过滤查询.
    public byte[]           szName = new byte[128];                    // 姓名.
    public boolean bUseTypeFilter;            // 使用黑白名单过滤查询.
    public int              iType;                     // 名单类型 0:陌生人 1:白名单 2:黑名单.
    public boolean bUseSexFilter;             // 使用性别过滤查询.
    public int              iMale;                     // 性别 1:male 0:female.
    public boolean bUseIdentify;              // 使用ID匹配.
    public byte[]           szIdentifyNum = new byte[128];   

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
