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
public class NET_SDK_DISK_INFO extends Structure {

	public NET_SDK_DISK_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_DISK_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_DISK_INFO implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_DISK_INFO implements Structure.ByValue {
	}
	public int		diskIndex;			//磁盘编号
    public short diskStatus;			//磁盘状态，0:正常,1:未格式化,2:正在格式化,3:异常
    public short diskProperty;		//磁盘状态，0:可读写,1:只读,2:冗余
    public int		diskTotalSpace;		//磁盘总空间，单位MB
    public int		diskFreeSpace;		//磁盘剩余空间，单位MB


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
