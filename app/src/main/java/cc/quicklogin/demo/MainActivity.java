package cc.quicklogin.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import cc.quicklogin.sdk.LoginHelper;
import cc.quicklogin.sdk.open.TokenInfo;
import cc.quicklogin.sdk.open.TokenListener;

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

                final LoginHelper loginHelper = LoginHelper.getInstance(getApplicationContext(), "bf49d4a3f4ff7e0aefe1efe97c57729d");
                loginHelper.setDebug();
                loginHelper.getToken(new TokenListener() {
                    @Override
                    public void onTokenSuccess(final TokenInfo tokenInfo) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                resp.setText("resultCode:" + tokenInfo.getResultCode() + ",msg:" + tokenInfo.getMsg() + ",operatorType:" + tokenInfo.getOperatorType() + ",accessCode:" + tokenInfo.getAccessCode() + ",traceId:" + tokenInfo.getTraceId() + ",mobile:" + tokenInfo.getMobile() + "\n 耗时：" + ((System.currentTimeMillis() - startTime)) + "毫秒");

                            }
                        });
                        System.out.println(tokenInfo.toString());
                        loginHelper.destroy();
                    }

                    @Override
                    public void onTokenFail(final TokenInfo tokenInfo) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                resp.setText("code=" + tokenInfo.getResultCode() + ",msg=" + tokenInfo.getMsg());
                            }
                        });
                        System.out.println(tokenInfo.toString());
                    }
                }, 5000);

            }
        });
    }
}
