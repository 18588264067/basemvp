package com.aikaichuang.bluetooth;

/**
 * Created by Scene Tang on 2018/4/25.
 */

public interface BluetoothReader {

    void init(BluetoothInitCallBack callBack);

    void reader(BluetoothReaderCallBack callBack);

}
