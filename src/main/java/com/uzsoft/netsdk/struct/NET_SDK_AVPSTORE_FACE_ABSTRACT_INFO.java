package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_AVPSTORE_FACE_ABSTRACT_INFO extends Structure{
	public NET_SDK_AVPSTORE_FACE_ABSTRACT_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_AVPSTORE_FACE_ABSTRACT_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_AVPSTORE_FACE_ABSTRACT_INFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_AVPSTORE_FACE_ABSTRACT_INFO implements Structure.ByValue {
	}

	public byte[] szName = new byte[32];                                    //名称
	public int dwBirth;                    //出生日期,如19991234
	public byte[] szNativePlace = new byte[16];             //籍贯
	public byte[] szNote= new byte[16];                  //备注
	public byte byPicNum;                    //图片数量，最大5张
	public byte byTypeCredential;            //证件类型
	public byte bySex;                       //性别 0 male      1 female
	public byte byGroupCount;                //所属组ID
	public byte[] byGroupID = new byte[4];
	
	public byte[] TimeCycle = new byte[32];//对应C++中的联合体
	
	public byte[] szCredential = new byte[32];              //证件号码, '\0' 结束     具有唯一性
	public byte[] byPhoneNum = new byte[16];            //手机号码
	public byte[] byIDParam = new byte[16];             /////具有唯一性
	

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
