package com.uzsoft.netsdk.callback;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

public interface BACKUP_DATA_CALLBACK extends Callback  {
	public void invoke(NativeLong lFileHandle, int dataType, Pointer pBuffer, int dataLen, Pointer pUser);
}
