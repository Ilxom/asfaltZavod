package com.uzsoft.netsdk.callback;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 * Created by Administrator on 2018/7/16.
 */
public interface SUBSCRIBE_CALLBACK extends Callback {
    void invoke(NativeLong lUserID, int dwCommand, Pointer pBuf, int dwBufLen, Pointer pUser);
}
