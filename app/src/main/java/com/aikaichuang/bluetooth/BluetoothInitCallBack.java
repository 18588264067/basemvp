package com.aikaichuang.bluetooth;

/**
 * Created by Scene Tang on 2018/4/25.
 */

public interface BluetoothInitCallBack {

    boolean onSuccess();

    void onError(Error error);
}
