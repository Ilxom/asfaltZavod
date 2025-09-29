package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DD_TIME extends Structure {
	public DD_TIME(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_TIME() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_TIME implements Structure.ByReference {
	}

	public static class ByValue extends DD_TIME implements Structure.ByValue {
	}

	public byte second; // Seconds after minute (0–59)
	public byte minute; // Minutes after hour (0–59)
	public byte hour; // Hours since midnight (0–23)
	public byte wday; // Day of week (0–6; Sunday = 0)
	public byte mday; // Day of month (1–31)
	public byte month; // Month (0–11; January = 0)
	public short year; // Year (current year minus 1900)
	public int nTotalseconds; // 总秒数
	public int nMicrosecond; // 微秒

	public String toString() {
        return (year + 1900) + "/" + (month + 1) + "/" + mday + " " + hour + ":" + minute + ":" + second;
    }
	//用于列表中显示
    public String toStringTime()
    {
        return  String.format("%02d/%02d/%02d %02d:%02d:%02d", (year + 1900), (month + 1), mday, 
        		hour, minute, second);
    }
  //存储文件名使用
    public String toStringTitle()
   {
       return  String.format("Time_%02d%02d%02d_%02d%02d%02d", (year + 1900), (month + 1), mday, 
    		   hour, minute, second);
   }
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
