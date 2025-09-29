package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class REG_LOGIN_INFO extends Structure{
	public REG_LOGIN_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public REG_LOGIN_INFO() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends REG_LOGIN_INFO implements Structure.ByReference {
	}

	public static class ByValue extends REG_LOGIN_INFO implements Structure.ByValue {
	}

	public int deviceId;//注册设备id
	public byte[] m_szUserName = new byte[36];//注册设备用户名
	public byte[] m_szPasswd= new byte[36];//注册设备密码

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
