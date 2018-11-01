package com.hdl.yzx;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hdl.elog.ELog;
import com.hdl.myhttputils.MyHttpUtils;
import com.hdl.myhttputils.bean.CommCallback;
import com.hdl.yzx.event.LoginEvent;
import com.hdl.yzx.result.YzxLoginResult;
import com.hdl.yzx.utils.SpUtils;
import com.yzxtcp.UCSManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import hdl.com.lib.runtimepermissions.HPermissions;
import hdl.com.lib.runtimepermissions.PermissionsResultAction;

/**
 * 登录到云之讯
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_phone)
    EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        SpUtils.getInstance().saveBooleanByKey("YZX_720P", true);
        /**
         * 获取授权
         */
        HPermissions.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied(String permission) {

            }
        });
    }

    /**
     * 登录
     *
     * @param view
     */
    public void onLogin(View view) {
        MyHttpUtils.build()
                .url("http://192.168.0.227:8080/appDevice/deviceLogin.do")
                .addParam("phone", etPhone.getText().toString().trim())
                .setJavaBean(YzxLoginResult.class)
                .onExecute(new CommCallback<YzxLoginResult>() {
                    @Override
                    public void onSucceed(YzxLoginResult result) {
                        ELog.e("result = " + result);
                        if ("000000".equals(result.getResp().getRespCode())) {
                            SpUtils.getInstance().saveToken(result.getResp().getClient().getLoginToken());
                            SpUtils.getInstance().saveStringByKey("clientNumber", result.getResp().getClient().getClientNumber());
                            SpUtils.getInstance().saveStringByKey("userId", result.getResp().getClient().getUserId());
                            EventBus.getDefault().post(new LoginEvent("开始登录了"));
                        }

                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        throwable.printStackTrace();
                        ELog.e("请求出错了");
                    }
                });
    }

    /**
     * 视频呼叫
     *
     * @param view
     */
    public void onCall(View view) {
        Intent intent = new Intent(this, VideoConverseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("userName", "对方的姓名");
        intent.putExtra("userId", etPhone.getText().toString());
        intent.putExtra("call_phone", etPhone.getText().toString());
        startActivity(intent);
    }

}
