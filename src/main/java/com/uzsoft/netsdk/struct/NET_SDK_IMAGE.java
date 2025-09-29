package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖燕波
 * @create 2018/6/25
 * @edit 2020/4/20
 * Description: 
 */
public class NET_SDK_IMAGE extends Structure {

	public NET_SDK_IMAGE(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IMAGE() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IMAGE implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IMAGE implements Structure.ByValue {
	}
	public int dwChannel; 
    public int dwImageType; //0:alarm;1:manual 
    public  DD_TIME_EX captureTime;
    public int totalNum;
    public byte[]	resv = new byte[8];


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
