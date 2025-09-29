package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_DEVICE_FUNC_IPC extends Structure {
	public NET_SDK_DEVICE_FUNC_IPC(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_DEVICE_FUNC_IPC() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_DEVICE_FUNC_IPC implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_DEVICE_FUNC_IPC implements Structure.ByValue {
	}

	public byte intelist_enable;          // 表示该结构体是否包含智能能力集列表(后面31位)，1表示支持, 0表示不支持
	public byte intelist_Perimeter;       // 是否支持区域入侵, 1表示支持, 0表示不支持
	public byte intelist_Tripwire;        // 是否支持绊线侦测, 1表示支持, 0表示不支持
	public byte intelist_Osc;             // 是否支持物品看护, 1表示支持, 0表示不支持
	public byte intelist_Avd;             // 是否支持异常侦测, 1表示支持, 0表示不支持
	public byte intelist_Cpc;             // 是否支持人流量统计, 1表示支持, 0表示不支持
	public byte intelist_Cdd;             // 是否支持人群密度检测, 1表示支持, 0表示不支持
	public byte intelist_Ipd;             // 是否支持人员入侵侦测, 1表示支持, 0表示不支持
	public byte intelist_Vfd;             // 是否支持人脸抓拍, 1表示支持, 0表示不支持
	public byte intelist_Vfd_Match;       // 是否支持人脸比对, 1表示支持, 0表示不支持
	public byte intelist_Vehice;          // 是否支持车牌检测, 1表示支持, 0表示不支持
	public byte intelist_AoiEntry;        // 是否支持进入区域, 1表示支持, 0表示不支持
	public byte intelist_AoiLeave;        // 是否支持离开区域, 1表示支持, 0表示不支持
	public byte intelist_PassLineCount;   // 是否支持过线统计, 1表示支持, 0表示不支持
	public byte intelist_Vfd_Detect;      // 是否支持人脸侦测, 1表示支持, 0表示不支持
	public byte intelist_Traffic;         // 是否支持流量统计, 1表示支持, 0表示不支持
	public byte[] intelist_reserver = new byte[16];       // 预留智能功能
	public int[] resvFunction = new int[7];			//预留功能描述


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

