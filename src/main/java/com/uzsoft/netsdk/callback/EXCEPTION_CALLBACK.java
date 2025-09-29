package com.uzsoft.netsdk.callback;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public interface EXCEPTION_CALLBACK extends Callback  {
	public void invoke(int dwType, NativeLong lUserID, NativeLong lHandle, Pointer pUser);
}
