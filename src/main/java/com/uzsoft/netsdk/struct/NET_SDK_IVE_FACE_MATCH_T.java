package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 * @create 2018/6/25
 * Description: 人脸比对
 */
public class NET_SDK_IVE_FACE_MATCH_T extends Structure {
	public NET_SDK_IVE_FACE_MATCH_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_FACE_MATCH_T() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IVE_FACE_MATCH_T implements Structure.ByReference {
	}
	public static class ByValue extends NET_SDK_IVE_FACE_MATCH_T implements Structure.ByValue {
	}
    public DD_TIME_EX frameTime;   //帧时间
    public int dwRealFaceID;  //抓拍人脸ID
    public int dwGrpID;       //特征组ID
    public int dwLibFaceID;   //特征库人脸ID
    public int dwSimilar;     //相似度
    public byte[] byName = new byte[32]; //姓名
    public int Channel;         //通道ID
//    public byte[] szCredential = new byte[64]; //证件号码, '\0' 结束,具有唯一性
//    public byte[] serialNumber = new byte[32]; //序列号
    public int imgLen;      //人脸数据长度
//    public int BackLen;      //人脸数据长度

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
