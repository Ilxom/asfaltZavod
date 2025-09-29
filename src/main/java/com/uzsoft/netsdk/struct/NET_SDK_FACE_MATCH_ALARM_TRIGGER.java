package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 目标组人脸比对报警联动信息
 */
public class NET_SDK_FACE_MATCH_ALARM_TRIGGER extends Structure {
    public NET_SDK_FACE_MATCH_ALARM_TRIGGER(Pointer p) {
        super(p,ALIGN_NONE);
        useMemory(p);
        read();
    }

    public NET_SDK_FACE_MATCH_ALARM_TRIGGER() {
        super(ALIGN_NONE);
    }

    public static class ByReference extends NET_SDK_FACE_MATCH_ALARM_TRIGGER implements Structure.ByReference {
    }

    public static class ByValue extends NET_SDK_FACE_MATCH_ALARM_TRIGGER implements Structure.ByValue {
    }

    public byte[] guid = new byte[48];// 联动抓图通道
    public int groupId;// 目标组ID
    public byte groupSwitch;// 启用
    public byte alarmOutSwitch;// 联动报警输出
    public byte[] alarmOut = new byte[16];// 联动报警输出默认最多16个
    public byte recSwitch;// 录像
    public int[] recCH = new int[128];// 联动录像通道
    public byte snapSwitch;// 抓图
    public int[] snapCH = new int[128];// 联动抓图通道
    public int popVideo;// 视频弹出
    public byte msgPushSwitch;
    public byte buzzerSwitch;
    public byte popMsgSwitch;
    public byte emailSwitch;

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
