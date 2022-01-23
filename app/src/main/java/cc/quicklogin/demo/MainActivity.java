package cc.quicklogin.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import cc.quicklogin.sdk.LoginHelper;
import cc.quicklogin.sdk.open.LoginInfo;
import cc.quicklogin.sdk.open.LoginResultListener;

public class MainActivity extends AppCompatActivity {

    private Button preLogin, getTokenImplicit, getTokenDialog, getTokenFull;
    private TextView resp;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preLogin = findViewById(R.id.pre_login);
        getTokenImplicit = findViewById(R.id.get_token_implicit);
        getTokenDialog = findViewById(R.id.get_token_dialog);
        getTokenFull = findViewById(R.id.get_token_full);
        loading = findViewById(R.id.loading);
        resp = findViewById(R.id.resp);

//                混淆配置：
//                # 移动
//                -keep class com.cmic.** {*; }
//                # 电信
//                -keep class cn.com.chinatelecom.account.** {*; }
//                # 一键登录
//                -keep class cc.quicklogin.** {*; }
        LoginHelper.init(getApplicationContext(), "c08eabb172cd4f61be07b7d361cf9fc7");
        preLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                final long startTime = System.currentTimeMillis();
                LoginHelper.getInstance().setDebug();
                LoginHelper.getInstance().preLogin(new LoginResultListener() {
                    @Override
                    public void onComplete(LoginInfo loginInfo) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loading.setVisibility(View.INVISIBLE);
                                resp.setText("resultCode:" + loginInfo.getResultCode()
                                        + ",msg:" + loginInfo.getMsg()
                                        + ",operatorType:" + loginInfo.getOperatorType()
                                        + ",mobile:" + loginInfo.getMobile()
                                        + ",expiredTime:" + loginInfo.getExpiredTime() + "秒"
                                        + "\n 耗时：" + ((System.currentTimeMillis() - startTime)) + "毫秒");
                            }
                        });
                        System.out.println(loginInfo.toString());
                    }
                }, 5000);
            }
        });
        getTokenImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                final long startTime = System.currentTimeMillis();
                LoginHelper.getInstance().setDebug();
                LoginHelper.getInstance().getAccessCode(new LoginResultListener() {
                    @Override
                    public void onComplete(LoginInfo loginInfo) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loading.setVisibility(View.INVISIBLE);
                                resp.setText("resultCode:" + loginInfo.getResultCode()
                                        + ",msg:" + loginInfo.getMsg()
                                        + ",operatorType:" + loginInfo.getOperatorType()
                                        + ",accessCode:" + loginInfo.getAccessCode()
                                        + ",traceId:" + loginInfo.getTraceId()
                                        + ",mobile:" + loginInfo.getMobile()
                                        + ",authCode:" + loginInfo.getAuthCode()
                                        + ",expiredTime:" + loginInfo.getExpiredTime() + "秒"
                                        + "\n 耗时：" + ((System.currentTimeMillis() - startTime)) + "毫秒");
                            }
                        });
                        System.out.println(loginInfo.toString());
                    }
                }, 5000);
            }
        });
        getTokenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                final long startTime = System.currentTimeMillis();
                LoginHelper.getInstance().setDebug();
                LoginHelper.getInstance().getAccessCode(new LoginResultListener() {
                    @Override
                    public void onComplete(LoginInfo loginInfo) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loading.setVisibility(View.INVISIBLE);
                                resp.setText("resultCode:" + loginInfo.getResultCode()
                                        + ",msg:" + loginInfo.getMsg()
                                        + ",operatorType:" + loginInfo.getOperatorType()
                                        + ",accessCode:" + loginInfo.getAccessCode()
                                        + ",traceId:" + loginInfo.getTraceId()
                                        + ",mobile:" + loginInfo.getMobile()
                                        + ",authCode:" + loginInfo.getAuthCode()
                                        + ",expiredTime:" + loginInfo.getExpiredTime() + "秒"
                                        + "\n 耗时：" + ((System.currentTimeMillis() - startTime)) + "毫秒");
                                LoginHelper.getInstance().finishAuthActivity();
                            }
                        });
                        System.out.println(loginInfo.toString());
                    }
                }, 5000, LoginAuthUIHelper.getPortraitDialog(MainActivity.this));
            }
        });
        getTokenFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                final long startTime = System.currentTimeMillis();
                LoginHelper.getInstance().setDebug();
                LoginHelper.getInstance().getAccessCode(new LoginResultListener() {
                    @Override
                    public void onComplete(LoginInfo loginInfo) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loading.setVisibility(View.INVISIBLE);
                                resp.setText("resultCode:" + loginInfo.getResultCode()
                                        + ",msg:" + loginInfo.getMsg()
                                        + ",operatorType:" + loginInfo.getOperatorType()
                                        + ",accessCode:" + loginInfo.getAccessCode()
                                        + ",traceId:" + loginInfo.getTraceId()
                                        + ",mobile:" + loginInfo.getMobile()
                                        + ",authCode:" + loginInfo.getAuthCode()
                                        + ",expiredTime:" + loginInfo.getExpiredTime() + "秒"
                                        + "\n 耗时：" + ((System.currentTimeMillis() - startTime)) + "毫秒");
                                LoginHelper.getInstance().finishAuthActivity();
                            }
                        });
                        System.out.println(loginInfo.toString());
                    }
                }, 5000, LoginAuthUIHelper.getPortraitActivity(MainActivity.this));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (LoginHelper.getInstance() != null) {
            LoginHelper.getInstance().destroy();
        }
    }

//    public void showProgressDialogLP(String message) {
//        dialog_lp = ProgressDialog.show(this, null, message, true, false);
//    }
//
//    public void removeProgressDialogLP() {
//        if (dialog_lp != null && dialog_lp.isShowing()) {
//            dialog_lp.dismiss();
//            dialog_lp.onDetachedFromWindow();
//            dialog_lp = null;
//        }
//    }
}
