package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_IPC_DEVICE_INFO extends Structure {

	public NET_SDK_IPC_DEVICE_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IPC_DEVICE_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IPC_DEVICE_INFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IPC_DEVICE_INFO implements Structure.ByValue {
	}
	public int deviceID;				
    public short channel;				
    public short status;					
    public byte[] szEtherName = new byte[16];		
    public byte[] szServer = new byte[64];		
    public short	nPort;					
    public short	nHttpPort;				
    public short	nCtrlPort;				
    public byte[] szID = new byte[64];			
    public byte[] username = new byte[36];				
    public int manufacturerId;			
    public byte[] manufacturerName = new byte[36];		
    public byte[] productModel = new byte[36];				
    public byte	bUseDefaultCfg;			
    public byte	bPOEDevice;				
    public byte[] resv = new byte[2];	


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
