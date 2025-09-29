package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_IVE_BASE_INFO extends Structure{
	public NET_SDK_IVE_BASE_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_BASE_INFO() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IVE_BASE_INFO implements Structure.ByReference {
	}
	public static class ByValue extends NET_SDK_IVE_BASE_INFO implements Structure.ByValue {
	}
     
    public long            i64SnapTime;               // 抓拍时间.
    public int             iSnapPicId;                // 抓拍ID.
    public int                 iSimilarity;               // 人脸比对相似度.(0-100)
    public int                 iPersonId;                 // 人员ID.
    public int                 iType;                     // 名单类型 0:陌生人 1:白名单 2:黑名单.
    public byte[] szName= new byte[128];               // 姓名.
	public int                 iMale;                     // 性别 1:male 0:female.
	public int                 iAge;                      // 年龄.
	public byte[] szIdentifyNum= new byte[128];        // 身份识别号.
	public byte[] szTel= new byte[64];                 // 电话.
	public byte[] szRes= new byte[128];                // reserve
	public int                 iSnapPicQuality;           // 抓拍人脸质量.
	public int                 iSnapPicAge;               // 抓拍人脸年龄.
	public int                 iSnapPicSex;               // 抓拍人脸性别.
	
	public byte                livingBody;                     // 是否是活体 1活体,0非活
	public byte                comparisonRes;                  // 比对结果 1成功,0失败
	
    public byte wearmask;                  // 是否戴口罩:0是未检测，1是未戴口罩 2是戴口罩
    public byte tempUnitsType;             // 温度单位 0摄氏度 1华氏度
	public int                 temperature;                    // 体温

	public byte[] keyID = new byte[36];                  //人脸库主键
	
	public byte[] szReserve = new byte[20];

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
