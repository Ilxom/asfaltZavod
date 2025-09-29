package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class IPC_FACE_INFO extends Structure{
	public IPC_FACE_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public IPC_FACE_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends IPC_FACE_INFO implements Structure.ByReference {
	}

	public static class ByValue extends IPC_FACE_INFO implements Structure.ByValue {
	}

	public String itemId;				//id   
    public String listType;//名单类型
    public String name;		//名称
    public String sex; //male   female
    public String age;
    public String identifyNumber;
    public String telephone;
    public String pictureData;//图片数据
	

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
