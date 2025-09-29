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
 * Description: 人脸检测
 */
public class NET_DVR_IVE_VFD_RESULT_DATA_INFO_T extends Structure {

	public NET_DVR_IVE_VFD_RESULT_DATA_INFO_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_DVR_IVE_VFD_RESULT_DATA_INFO_T() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_DVR_IVE_VFD_RESULT_DATA_INFO_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_DVR_IVE_VFD_RESULT_DATA_INFO_T implements Structure.ByValue {
	}
    public int type;  ///<: 0, JPG; 1, YUV
    public int status; ///<:0, INVALID; 1, VALID; 2, SAVED
    public int width;
    public int height;
    public int dataLen;

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
