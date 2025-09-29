package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 人脸比对报警
 * @author Administrator
 *
 */
public class NET_SDK_FACE_MATCH_ALARM extends Structure {
	public NET_SDK_FACE_MATCH_ALARM(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}

	public NET_SDK_FACE_MATCH_ALARM() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_FACE_MATCH_ALARM implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_FACE_MATCH_ALARM implements Structure.ByValue {
	}

	public int similarity; // 对比相似度
	public int[] enableCH = new int[128]; //开启的通道。 通道下标1开始 
	public NET_SDK_FACE_MATCH_CHAN_GROUP[] FaceMatchChanGroup = (NET_SDK_FACE_MATCH_CHAN_GROUP[])new NET_SDK_FACE_MATCH_CHAN_GROUP().toArray(128);
	public int faceFeatureGroupsNum; //目标组联动信息个数
	public Pointer sFaceMatchAlarmTrigger; // NET_SDK_FACE_MATCH_ALARM_TRIGGER* 目标组联动信息。 
 
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
