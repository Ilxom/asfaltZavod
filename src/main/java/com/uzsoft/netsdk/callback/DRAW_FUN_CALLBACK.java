package com.uzsoft.netsdk.callback;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public interface DRAW_FUN_CALLBACK extends Callback  {
	public void invoke(NativeLong lLiveHandle, Pointer hDC, Pointer pUser);
}
