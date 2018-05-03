package com.aikaichuang.util.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.aikaichuang.R;
import com.aikaichuang.ui.widget.popwindow.PromptButton;
import com.aikaichuang.ui.widget.popwindow.PromptButtonListener;
import com.aikaichuang.ui.widget.popwindow.PromptDialog;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

/**
 * Created by Scene Tang on 2018/4/26.
 */

public class PermissionChecker {

    private final Activity mContext;

    private PermissionCallBack callBack;

    String[] permissions;

    AlertDialog.Builder permissionDialog;

    private String PACKAGE_URL_SCHEME = "package:";

    public PermissionChecker(Activity context) {
        mContext = context;
    }


    public void checkPermissions(final PermissionCallBack callBack, String... permissions) {
        this.callBack = callBack;
        this.permissions = permissions;

        AndPermission.with(mContext)
                .permission(permissions)
                .rationale(new Rationale() {
                    @Override
                    public void showRationale(Context context, List<String> permissions, RequestExecutor executor) {
                    }
                })
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        callBack.success();
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        showMissingPermissionDialog(callBack, permissions);
                    }
                })
                .start();
    }

    // 显示缺失权限提示
    private void showMissingPermissionDialog(final PermissionCallBack callBack, List<String> permissions) {
        List<String> permissionNames = Permission.transformText(mContext, permissions);
        String message = mContext.getString(R.string.message_permission_rationale, TextUtils.join("\n", permissionNames));
        PromptDialog promptDialog = new PromptDialog(mContext);

        //按钮的定义，创建一个按钮的对象
        final PromptButton confirm = new PromptButton("去设置", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
                startAppSettings();
            }
        });
        //按钮的定义，创建一个按钮的对象
        final PromptButton cancelConfirm = new PromptButton("取消", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
                callBack.onCancel();
            }
        });

        confirm.setTextColor(Color.parseColor("#DAA520"));
        confirm.setFocusBacColor(Color.parseColor("#FAFAD2"));
        confirm.setDelyClick(true);//点击后，是否再对话框消失后响应按钮的监听事件
        confirm.setTextSize(12);
        cancelConfirm.setTextSize(12);
        promptDialog.showWarnAlert(message, cancelConfirm, confirm);
    }

    // 启动应用的设置
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + mContext.getPackageName()));
        mContext.startActivity(intent);
    }

}
