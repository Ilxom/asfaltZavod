package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PTZ_3D_POINT_INFO extends Structure{
	public PTZ_3D_POINT_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public PTZ_3D_POINT_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends PTZ_3D_POINT_INFO implements Structure.ByReference {
	}

	public static class ByValue extends PTZ_3D_POINT_INFO implements Structure.ByValue {
	}

	public int selBeginX;		//鼠标拖选方框起始点的x坐标（相对于当前窗口左上角）
    public int selBeginY;		//鼠标拖选方框结束点的y坐标（相对于当前窗口左上角）
    public int selEndX;		//鼠标拖选方框结束点的x坐标（相对于当前窗口左上角）
    public int selEndY;		//鼠标拖选方框结束点的y坐标（相对于当前窗口左上角）
    public int displayWidth;	//图像显示区域宽度
    public int displayHeight; 	//图像显示区域高度
    public int[] reserve = new int[2]; //保留

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
