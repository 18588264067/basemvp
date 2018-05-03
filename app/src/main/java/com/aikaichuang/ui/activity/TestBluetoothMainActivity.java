package com.aikaichuang.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aikaichuang.R;
import com.aikaichuang.ui.widget.popwindow.PromptButton;
import com.aikaichuang.ui.widget.popwindow.PromptDialog;
import com.inuker.bluetooth.library.BluetoothClient;
import com.inuker.bluetooth.library.connect.listener.BluetoothStateListener;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.response.SearchResponse;
import com.inuker.bluetooth.library.utils.BluetoothLog;

import java.util.ArrayList;
import java.util.List;

public class TestBluetoothMainActivity extends AppCompatActivity {

    private TextView context;

    private Button button;

    private List<SearchResult> mDevices;

    BluetoothClient client;

    PromptDialog promptDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_bluetooth_main);

        mDevices = new ArrayList<SearchResult>();
        promptDialog = new PromptDialog(this);

        context = findViewById(R.id.context);
        button = findViewById(R.id.button);

        client = new BluetoothClient(this);

        client.registerBluetoothStateListener(new BluetoothStateListener() {
            @Override
            public void onBluetoothStateChanged(boolean openOrClosed) {
                BluetoothLog.v(String.format("onBluetoothStateChanged %b", openOrClosed));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showLoading("请稍后...");
                searchDevice();
            }
        });
    }

    private void searchDevice() {
        SearchRequest request = new SearchRequest.Builder()
                .searchBluetoothLeDevice(5000, 1).build();

        client.search(request, mSearchResponse);
    }

    private final SearchResponse mSearchResponse = new SearchResponse() {
        @Override
        public void onSearchStarted() {
            mDevices.clear();
        }

        @Override
        public void onDeviceFounded(SearchResult device) {
//            BluetoothLog.w("MainActivity.onDeviceFounded " + device.device.getAddress());
            if (!mDevices.contains(device)) {
                if (device.getName() == null ||
                        device.getName().equals("NULL")) {

                } else {
                    mDevices.add(device);
                }
//                Beacon beacon = new Beacon(device.scanRecord);
//                BluetoothLog.v(String.format("beacon for %s\n%s", device.getAddress(), beacon.toString()));

//                BeaconItem beaconItem = null;
//                BeaconParser beaconParser = new BeaconParser(beaconItem);
//                int firstByte = beaconParser.readByte(); // 读取第1个字节
//                int secondByte = beaconParser.readByte(); // 读取第2个字节
//                int productId = beaconParser.readShort(); // 读取第3,4个字节
//                boolean bit1 = beaconParser.getBit(firstByte, 0); // 获取第1字节的第1bit
//                boolean bit2 = beaconParser.getBit(firstByte, 1); // 获取第1字节的第2bit
//                beaconParser.setPosition(0); // 将读取起点设置到第1字节处
            }


        }

        @Override
        public void onSearchStopped() {
            BluetoothLog.w("MainActivity.onSearchStopped");
//            promptDialog.dismiss();
            if (mDevices.size() > 0) {
                PromptButton cancle = new PromptButton("取消", null);
                cancle.setTextColor(Color.parseColor("#0076ff"));
                cancle.setTextSize(12);
                PromptButton[] buttons = new PromptButton[mDevices.size() + 1];

                buttons[0] = cancle;

                for (int i = 0; i < mDevices.size(); i++) {
                    PromptButton item = new PromptButton(mDevices.get(i).getName(), null);
                    buttons[i + 1] = item;
                }


                promptDialog.showAlertSheet("", true, buttons);
            }
        }

        @Override
        public void onSearchCanceled() {
            BluetoothLog.w("MainActivity.onSearchCanceled");
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        client.stopSearch();
    }
}
