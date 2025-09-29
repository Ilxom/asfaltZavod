package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_DEV_SUPPORT extends Structure{
	public NET_SDK_DEV_SUPPORT(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_DEV_SUPPORT() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_DEV_SUPPORT implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_DEV_SUPPORT implements Structure.ByValue {
	}
	public int	support ;
	//public int	supportThermometry ;				//支持口罩跟体温
	//public int	supportVfd;				//人脸检测
	//public int	supportVfdMatch;				//人脸比对
	//public int	supportresv;					//待填入
	public int[]	resv = new int[15];				//暂时未用上

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
