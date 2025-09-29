package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 * @create 2018/6/25
 * Description: 人脸检测
 */
public class NET_DVR_IVE_VFD_RESULT_HEAD_T extends Structure {
	public NET_DVR_IVE_VFD_RESULT_HEAD_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_DVR_IVE_VFD_RESULT_HEAD_T() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_DVR_IVE_VFD_RESULT_HEAD_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_DVR_IVE_VFD_RESULT_HEAD_T implements Structure.ByValue {
	}
	
    public long time;            //检测源数据当前时间 /* 微秒级 */
    public long relativeTime;    //检测源数据相对时间 /* 微秒级 */
    public int detectDataLen;   //检测源数据长度
    public int softwareVersion; //软件版本号, 0xABCDEFGH,AB：厂家 CD：主版本 EFGH：子版本 厂商 1:欧姆龙 版本:V5.00
    public int softwareBuildDate;//软件生成日期,0xYYYYMMDD
    public int faceCnt;         //人脸的个数，最大40个
    public int[] faceDataLen = new int[40]; //每个人脸的长度

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
