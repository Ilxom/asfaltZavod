package com.uzsoft.netsdk.callback;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface TALK_DATA_CALLBACK extends Callback  {
	public void invoke(int lVoiceComHandle, Pointer pRecvDataBuffer, int dwBufSize, byte byAudioFlag, Pointer pUser);
}
