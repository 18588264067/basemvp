package com.aikaichuang.bluetooth;

import com.aikaichuang.model.entity.IdCard;

/**
 * Created by Scene Tang on 2018/4/25.
 */

public interface BluetoothReaderCallBack {

    void onSuccess(IdCard idCard);

    void onError(Error error);
}
