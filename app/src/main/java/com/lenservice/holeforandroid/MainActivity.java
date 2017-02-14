package com.lenservice.holeforandroid;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lenservice.holeforandroid.Interface.H_CenterFragment;
import com.lenservice.holeforandroid.Interface.H_SiderFragment;

public class MainActivity extends Activity {

    //pro
    private H_SiderFragment siderFragment;
    private H_CenterFragment centerFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    //SCREEN
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;

    //layout
    private RelativeLayout siderLayout;
    private RelativeLayout centerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        SCREEN_HEIGHT = outMetrics.heightPixels;
        initFragment();
    }

    private void initFragment() {
        fragmentManager = this.getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        siderFragment = new H_SiderFragment();
        centerFragment = new H_CenterFragment();

        siderLayout = (RelativeLayout) this.findViewById(R.id.home_soiderRL);
        centerLayout = (RelativeLayout) this.findViewById(R.id.home_centerRL);

        //重新设置frame
        RelativeLayout.LayoutParams leftF = new RelativeLayout.LayoutParams(SCREEN_WIDTH, SCREEN_HEIGHT);
        leftF.topMargin = 0;
        leftF.leftMargin = -SCREEN_WIDTH;
        RelativeLayout.LayoutParams centerF = new RelativeLayout.LayoutParams(SCREEN_WIDTH, SCREEN_HEIGHT);
        centerF.topMargin = 0;
        siderLayout.setLayoutParams(leftF);
        centerLayout.setLayoutParams(centerF);

        centerLayout.setEnabled(false);
        centerLayout.setFocusable(false);

        //添加到事务
        transaction.replace(R.id.home_soiderRL, siderFragment, "sider");
        transaction.replace(R.id.home_centerRL, centerFragment, "center");
        // 提交
        transaction.commit();
    }


}
