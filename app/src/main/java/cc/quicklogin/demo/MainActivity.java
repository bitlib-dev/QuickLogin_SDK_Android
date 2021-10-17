package cc.quicklogin.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import cc.quicklogin.sdk.LoginHelper;
import cc.quicklogin.sdk.open.InitResultListener;
import cc.quicklogin.sdk.open.LoginInfo;
import cc.quicklogin.sdk.open.LoginResultListener;

public class MainActivity extends AppCompatActivity {

    private Button getToken;
    private TextView resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToken = findViewById(R.id.get_token);
        resp = findViewById(R.id.resp);

        getToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long startTime = System.currentTimeMillis();

                LoginHelper.init(getApplicationContext(), "bf49d4a3f4ff7e0aefe1efe97c57729d", new InitResultListener() {
                    @Override
                    public void onComplete(boolean result, String msg) {
                        if (result) {
                            LoginHelper.getInstance().setDebug();
                            LoginHelper.getInstance().getAccessCode(new LoginResultListener() {
                                @Override
                                public void onComplete(LoginInfo loginInfo) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            resp.setText("resultCode:" + loginInfo.getResultCode() + ",msg:" + loginInfo.getMsg() + ",operatorType:" + loginInfo.getOperatorType() + ",accessCode:" + loginInfo.getAccessCode() + ",traceId:" + loginInfo.getTraceId() + ",mobile:" + loginInfo.getMobile() + ",authCode:" + loginInfo.getAuthCode() + "\n 耗时：" + ((System.currentTimeMillis() - startTime)) + "毫秒");
                                        }
                                    });
                                    System.out.println(loginInfo.toString());
                                }
                            }, 5000);
                        } else {
                            System.out.println("失败原因：" + msg);
                        }

                    }
                });


            }
        });
    }
}
