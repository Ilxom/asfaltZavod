package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_IMAGE_EFFECT_T extends Structure{
	public NET_SDK_IMAGE_EFFECT_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IMAGE_EFFECT_T() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IMAGE_EFFECT_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_IMAGE_EFFECT_T implements Structure.ByValue {
	}
	public int          minValue;             // the minimum value
    public int          maxValue;             // the maximum value
    public int          curValue;             // the current value
    public int          defaultValue;             // the default value


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
