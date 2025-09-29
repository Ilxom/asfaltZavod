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
public class NET_SDK_IMAGE_INFO extends Structure {

	public NET_SDK_IMAGE_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IMAGE_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_IMAGE_INFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IMAGE_INFO implements Structure.ByValue {
	}
	public int imageSize; 
    public int imageMode;//0:jpg;1:png;2:bmp 
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
