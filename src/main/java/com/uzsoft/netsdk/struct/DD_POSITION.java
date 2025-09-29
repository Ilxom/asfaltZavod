package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class DD_POSITION extends Structure {
	public DD_POSITION(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public DD_POSITION() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends DD_POSITION implements Structure.ByReference {
	}

	public static class ByValue extends DD_POSITION implements Structure.ByValue {
	}

	public short  x; 
	public short  y; 
	

	@Override
	protected List<String> getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("x");
		Field.add("y");
		return Field;
	}
}
