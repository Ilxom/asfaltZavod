package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_SMART_VFD_CONFIG extends Structure {
	public DD_SMART_VFD_CONFIG(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_SMART_VFD_CONFIG() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_SMART_VFD_CONFIG implements Structure.ByReference {
	}

	public static class ByValue extends DD_SMART_VFD_CONFIG implements Structure.ByValue {
	}

	public int iSize;					   //本结构体长度
	public byte  enableFaceDetect;        //是否开启人脸检测
	public byte  enableSaveFacePicture;   //是否保存人脸图片
	public short enableSaveSourcePicture; //是否保存人脸检测源图片
	public int   holdTime;                //持续时间
	public DD_POSITION    startPoint =  new DD_POSITION();              //矩形的左上点坐标信息
	public DD_POSITION    endPoint = new DD_POSITION();                //矩形的右下点坐标信息
	public int   pushModeType;            //抓拍模式，0：自动模式，不会重复抓拍， 1：以固定时间间隔进行抓拍的模式
	public int   intervalTime;            //抓拍的间隔周期，单位秒，仅在抓拍模式为1的情况下有效
	

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
