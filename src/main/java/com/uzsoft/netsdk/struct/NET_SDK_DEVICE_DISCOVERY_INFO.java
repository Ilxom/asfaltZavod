package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_DEVICE_DISCOVERY_INFO extends Structure{
	public NET_SDK_DEVICE_DISCOVERY_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_DEVICE_DISCOVERY_INFO() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_DEVICE_DISCOVERY_INFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_DEVICE_DISCOVERY_INFO implements Structure.ByValue {
	}
	public int deviceType;//0:NET_SDK_DVR 1:NET_SDK_DVS 2:NET_SDK_IPCAMERA 3:NET_SDK_NVR 4: NET_SDK_SUPERDVR 5:NET_SDK_DECODER
    public byte[] productType = new byte[16];
    public byte[] strIP= new byte[16];
    public byte[] strNetMask= new byte[16];
    public byte[] strGateWay= new byte[16];
    public byte[] byMac= new byte[8];
    public short netPort;
    public short httpPort;
    public int softVer;
    public int softBuildDate;
    public byte ucIPMode;			//0 静态IP 1 dhcp
    public byte[] dwSecondIP= new byte[16];
    public byte[] dwSecondMask= new byte[16];

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
