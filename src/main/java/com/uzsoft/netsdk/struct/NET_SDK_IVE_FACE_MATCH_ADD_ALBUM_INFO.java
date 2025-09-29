package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 目标组人脸比对报警联动信息
 */
public class NET_SDK_IVE_FACE_MATCH_ADD_ALBUM_INFO extends Structure {
    public NET_SDK_IVE_FACE_MATCH_ADD_ALBUM_INFO(Pointer p) {
        super(p,ALIGN_NONE);
        useMemory(p);
        read();
    }

    public NET_SDK_IVE_FACE_MATCH_ADD_ALBUM_INFO() {
        super(ALIGN_NONE);
    }

    public static class ByReference extends NET_SDK_IVE_FACE_MATCH_ADD_ALBUM_INFO implements Structure.ByReference {
    }

    public static class ByValue extends NET_SDK_IVE_FACE_MATCH_ADD_ALBUM_INFO implements Structure.ByValue {
    }
    public int                 iType;                     // 名单类型 0:陌生人 1:白名单 2:黑名单.
    public byte[]              szName = new byte[128];               // 姓名.
    public int                 iMale;                     // 性别 1:male 0:female.
    public int                 iAge;                      // 年龄.
    public byte[]              szIdentifyNum = new byte[128];        // 身份识别号.
    public byte[]              szTel = new byte[64];                 // 电话.
    public int                 iWidth;                    // 图片宽.
    public int                 iHeight;                   // 图片高.
    public int                 iPicFormat;                // 图片格式.
    public int                 iPicSize;                  // 图片大小.
    public byte[]              szRes = new byte[128];                // reserve

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
