package cc.quicklogin.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import cc.quicklogin.sdk.open.AuthUIConfig;
import cc.quicklogin.sdk.open.PrivacyClickListener;


public class LoginAuthUIHelper {

    public static AuthUIConfig getPortraitActivity(final Context context) {
        AuthUIConfig.Builder builder = new AuthUIConfig.Builder();

        builder.setStatusBarLight(true)
                .setNavigationBarColor(R.color.blue)
                .setBackgroundColor(R.color.blue)
                .setBackgroundImgDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_dialog_bg))
                .setNavText("QuickLogin")
                .setNavColor(R.color.blue)
                .setNavTextColor(R.color.blue)
                .setNavBackImgDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_close))
                .setNavBackOffset(14, 14, null, null)

//                .setLoginClicker(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                        builder.setTitle("123");
////                        builder.setCancelable(false);
//                        AlertDialog alertDialog = builder.create();
//                        alertDialog.show();
//                    }
//                }, true)
                .setLogoOffset(null, 10, null, null)

                .setNumberOffset(null, 116, null, null)
//                .setNumberColor(R.color.white)

                .setSloganOffset(null, 152, null, null)
                .setSloganPaintFlags(Paint.UNDERLINE_TEXT_FLAG)

                .setLogBtnWidth(250)
                .setLogBtnOffset(null, 184, null, null)
                .setLogBtnBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_login))

                .setSwitchOffset(null, 246, null, null)
                .setSwitchHidden(false)
//                .setSwitchOffsetY(10)
//                .setSwitchOffsetBottomY(10)
//                .setSwitchOffsetX(10)
//                .setSwitchOffsetRightX(10)

                .setToastDuration(Toast.LENGTH_LONG)
//                .setToastGravity(Gravity.CENTER, 0, 0)
//                .setToastMargin(0F, 0F)
                .setUncheckToastText("请先同意条款")
                .setCheckboxChecked(true)

                .setPrivacyGravityLeft(true)
                .setAppPrivacyOne("Bitlib", "https://bitlib.cc/service.html")
                .setAppPrivacyColor(R.color.privacy_base_color, R.color.colorAccent)
                .setPrivacyOffset(16, 16, 16, 6)
                .setPrivacyDecorator("登录即同意", "和", "、", "");


        //其他方式登录
        TextView wechat = new TextView(context);
        wechat.setText("使用微信登录");
        RelativeLayout.LayoutParams wechatLP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        wechatLP.setMargins(0, convertDpToPixels(context, 276), 0, 0);
        wechatLP.addRule(RelativeLayout.CENTER_HORIZONTAL);
        wechat.setLayoutParams(wechatLP);

        builder.addCustomView(wechat, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "onclick", Toast.LENGTH_SHORT).show();
            }
        });

//        ProgressBar progressBar = new ProgressBar(context);
//        progressBar.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        progressBar.setBackgroundColor(context.getResources().getColor(R.color.black));
//        builder.setLoadingView(progressBar);

//        RelativeLayout relativeLayout = new RelativeLayout(context);
//        builder.setLoadingView(relativeLayout);

        builder.setCheckboxDrawable("quick_login_check");
        builder.setSwitchClicker(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "switch", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setAppPrivacyTwoClicker(new PrivacyClickListener() {
            @Override
            public void onClick(View v, String url) {
                // 展示协议页面
            }
        });

        builder.setOperatorPrivacyClicker(new PrivacyClickListener() {
            @Override
            public void onClick(View v, String url) {
                // 展示协议页面
            }
        }, false);

        return builder.create();
    }

    public static AuthUIConfig getPortraitDialog(final Context context) {
        AuthUIConfig.Builder builder = new AuthUIConfig.Builder();
        WindowManager manager = ((Activity) context).getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int dialogWidth = (int) (outMetrics.widthPixels * 0.8);
        int dialogHeight = (int) (outMetrics.heightPixels * 0.7);

        builder.setShowDialog(true)

                .setDialogSize(dialogWidth, dialogHeight)
//                .setDialogDimAmount(0.3f)

                .setStatusBarLight(true)
//                .setBackgroundColor(R.color.red)
                .setBackgroundImgDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_dialog_bg))
//                .setStatusBarColor(R.color.translucent)
                .setNavText("QuickLogin")
                .setNavBackImgDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_close))
//                .setNavBackWidh(32)
//                .setNavBackHeight(32)
                .setNavBackOffset(null, 12, 12, null)
                .setNavHidden(true)

//                .setLogoHeight(96)
                .setLogoOffset(null, 10, null, null)

                .setNumberOffset(null, 116, null, null)
//                .setNumberColor(R.color.white)

                .setSloganOffset(null, 152, null, null)

                .setLogBtnWidth(250)
                .setLogBtnOffset(null, 184, null, null)
                .setLogBtnBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_login))

                .setSwitchOffset(null, 246, null, null)
                .setSwitchHidden(false)
//                .setSwitchOffsetY(10)
//                .setSwitchOffsetBottomY(10)
//                .setSwitchOffsetX(10)
//                .setSwitchOffsetRightX(10)

                .setCheckboxChecked(true)

                .setAppPrivacyOne("Bitlib", "https://bitlib.cc/service.html")
                .setPrivacyOffset(16, 16, 16, 6)
                .setPrivacyDecorator("登录即同意", "和", "、", "");


        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        progressBar.setBackgroundColor(context.getResources().getColor(R.color.black));
        builder.setLoadingView(progressBar);


        builder.setCheckboxDrawable("quick_login_check");
        builder.setSwitchClicker(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "switch", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public static AuthUIConfig getLandscapeActivity(final Context context) {
        AuthUIConfig.Builder builder = new AuthUIConfig.Builder();
        WindowManager manager = ((Activity) context).getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int dialogWidth = (int) (outMetrics.widthPixels * 0.8);
        int dialogHeight = (int) (outMetrics.heightPixels * 0.7);

        builder.setStatusBarLight(true)
                .setBackgroundColor(R.color.red)
                .setBackgroundImgDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_dialog_bg))
//                .setStatusBarColor(R.color.translucent)
                .setNavText("QuickLogin")
//                .setNavBackImgDrawable(getDrawable(R.drawable.quick_login_close))
//                .setNavBackWidh(32)
//                .setNavBackHeight(32)
                .setNavBackOffset(14, 14, null, null)
                .setNavHidden(false)

//                .setLogoHeight(96)
                .setLogoOffset(null, 10, null, null)

                .setNumberOffset(null, 80, null, null)
//                .setNumberColor(R.color.white)

                .setSloganOffset(null, 116, null, null)

                .setLogBtnWidth(250)
                .setLogBtnOffset(null, 146, null, null)
                .setLogBtnBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_login))

                .setSwitchOffset(null, 200, null, null)
                .setSwitchHidden(false)
//                .setSwitchOffsetY(10)
//                .setSwitchOffsetBottomY(10)
//                .setSwitchOffsetX(10)
//                .setSwitchOffsetRightX(10)

                .setAppPrivacyOne("Bitlib", "https://bitlib.cc/service.html")
                .setPrivacyOffset(16, 16, 16, 6)
                .setPrivacyDecorator("登录即同意", "和", "、", "");


        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        progressBar.setBackgroundColor(context.getResources().getColor(R.color.black));
        builder.setLoadingView(progressBar);


        builder.setCheckboxDrawable("quick_login_check");
        builder.setSwitchClicker(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "switch", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public static AuthUIConfig getLandscapeDialog(final Context context) {
        AuthUIConfig.Builder builder = new AuthUIConfig.Builder();
        WindowManager manager = ((Activity) context).getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int dialogWidth = (int) (outMetrics.widthPixels * 0.8);
        int dialogHeight = (int) (outMetrics.heightPixels * 0.7);

        builder.setShowDialog(true)

                .setDialogSize(dialogHeight, dialogWidth)

                .setStatusBarLight(true)
                .setBackgroundColor(R.color.red)
                .setBackgroundImgDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_dialog_bg))
//                .setStatusBarColor(R.color.translucent)
                .setNavText("QuickLogin")
//                .setNavBackImgDrawable(getDrawable(R.drawable.quick_login_close))
//                .setNavBackWidh(32)
//                .setNavBackHeight(32)
                .setNavBackOffset(null, 12, 12, null)
                .setNavHidden(true)

//                .setLogoHeight(96)
                .setLogoOffset(null, 10, null, null)

                .setNumberOffset(null, 86, null, null)
//                .setNumberColor(R.color.white)

                .setSloganOffset(null, 122, null, null)

                .setLogBtnWidth(250)
                .setLogBtnOffset(null, 154, null, null)
                .setLogBtnBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.quick_login_login))

                .setSwitchOffset(null, 216, null, null)
                .setSwitchHidden(false)
//                .setSwitchOffsetY(10)
//                .setSwitchOffsetBottomY(10)
//                .setSwitchOffsetX(10)
//                .setSwitchOffsetRightX(10)

                .setAppPrivacyOne("Bitlib", "https://bitlib.cc/service.html")
                .setPrivacyOffset(16, 16, 16, 6)
                .setPrivacyDecorator("登录即同意", "和", "、", "");


        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        progressBar.setBackgroundColor(context.getResources().getColor(R.color.black));
        builder.setLoadingView(progressBar);


        builder.setCheckboxDrawable("quick_login_check");
        builder.setSwitchClicker(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "switch", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    /**
     * dp转px
     *
     * @param context Context
     * @param dp      dp
     * @return px
     */
    public static int convertDpToPixels(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
