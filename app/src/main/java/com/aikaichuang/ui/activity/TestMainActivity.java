package com.aikaichuang.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aikaichuang.R;
import com.aikaichuang.ui.widget.popwindow.OnAdClickListener;
import com.aikaichuang.ui.widget.popwindow.PromptButton;
import com.aikaichuang.ui.widget.popwindow.PromptButtonListener;
import com.aikaichuang.ui.widget.popwindow.PromptDialog;


/**
 * github:limxing
 */
public class TestMainActivity extends AppCompatActivity {

    private PromptDialog promptDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);

        //创建对象
        promptDialog = new PromptDialog(this);
        //设置自定义属性
        promptDialog.getDefaultBuilder()
                .touchAble(true)
                .round(3)
                .loadingDuration(3000)
                .textSize(12);


        findViewById(R.id.main_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showWarn("注意");
            }
        });

        findViewById(R.id.main_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                main_failview.setMode(FailView.MODE_REFRESH);
                promptDialog.showLoading("正在登录");
            }
        });
        findViewById(R.id.main_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showSuccess("登陆成功");
            }
        });
        findViewById(R.id.main_fail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showError("登录失败");
            }
        });

        //按钮的定义，创建一个按钮的对象
        final PromptButton confirm = new PromptButton("确定", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
                Toast.makeText(TestMainActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        //按钮的定义，创建一个按钮的对象
        final PromptButton cancelConfirm = new PromptButton("取消", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
                Toast.makeText(TestMainActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        confirm.setTextColor(Color.parseColor("#DAA520"));
        confirm.setFocusBacColor(Color.parseColor("#FAFAD2"));
        confirm.setDelyClick(true);//点击后，是否再对话框消失后响应按钮的监听事件
        confirm.setTextSize(12);
        cancelConfirm.setTextSize(12);
        findViewById(R.id.main_warn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showWarnAlert("你确定要退出登录？", cancelConfirm, confirm);
            }
        });

        findViewById(R.id.main_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showInfo("成功了");
            }
        });

        findViewById(R.id.main_system).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可创建android效果的底部Sheet选择，默认IOS效果，sheetCellPad=0为Android效果的Sheet
//                promptDialog.getAlertDefaultBuilder().sheetCellPad(0).round(0);
                //设置按钮的特点，颜色大小什么的，具体看PromptButton的成员变量
                PromptButton cancle = new PromptButton("取消", null);
                cancle.setTextColor(Color.parseColor("#0076ff"));
                cancle.setTextSize(12);
                //设置显示的文字大小及颜色
//                promptDialog.getAlertDefaultBuilder().textSize(12).textColor(Color.GRAY);
                //默认两个按钮为Alert对话框，大于三个按钮的为底部SHeet形式展现
                promptDialog.showAlertSheet("", true, cancle,
                        new PromptButton("选项1", null), new PromptButton("选项2", null),
                        new PromptButton("选项3", null), new PromptButton("选项4", null));

            }
        });
        findViewById(R.id.main_customer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.showCustom(R.mipmap.ic_launcher, "自定义图标的");
            }
        });
//        u0_a280   8011  2923  1474704 209280 SyS_epoll_ 0000000000 S me.leefeng.beida

        findViewById(R.id.main_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptDialog.getDefaultBuilder().backAlpha(150);
                promptDialog.showAd(true, new OnAdClickListener() {
                    @Override
                    public void onAdClick() {
                        Toast.makeText(TestMainActivity.this,"点击了广告",Toast.LENGTH_SHORT).show();
                    }
                }).setImageResource(R.drawable.test);
            }
        });

    }

    /**
     * 根据需要处理返回键，这里主要针对Alert和Sheet的对话框的返回处理
     */
    @Override
    public void onBackPressed() {
        if (promptDialog.onBackPressed())
            super.onBackPressed();
    }
}
