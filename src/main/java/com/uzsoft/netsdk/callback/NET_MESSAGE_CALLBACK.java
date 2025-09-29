package com.uzsoft.netsdk.callback;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public interface NET_MESSAGE_CALLBACK extends Callback  {
	public boolean invoke(NativeLong lCommand, NativeLong lUserID, Pointer pBuf, int dwBufLen, Pointer pUser);
}
