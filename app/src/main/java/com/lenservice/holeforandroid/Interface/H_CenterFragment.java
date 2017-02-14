package com.lenservice.holeforandroid.Interface;


import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lenservice.holeforandroid.R;

/**
 * Created by len on 17/2/14.
 */

public class H_CenterFragment extends Fragment implements View.OnClickListener{
    private ImageView siderImageView;
    private RelativeLayout siderL;
    private LinearLayout Occlusionll;
    //SCREEN
    private int SCREEN_WIDTH;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_center, null);
    }

    @Override
    public void onResume() {
        super.onResume();
        initBaseViews();
    }

    private void initBaseViews() {
        WindowManager manager = this.getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        Occlusionll = (LinearLayout) this.getView().findViewById(R.id.Occlusionll);
        siderL = (RelativeLayout) this.getActivity().findViewById(R.id.home_soiderRL);
       siderImageView = (ImageView) this.getView().findViewById(R.id.btn_ic_nav_menu);
       siderImageView.setOnClickListener(this);
        Occlusionll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ic_nav_menu:
                Log.i("H_CenterFragment","<<<<<<<<<<<<<<<<< sider");
                showSider();
                Occlusionll.setVisibility(View.VISIBLE);
                break;
            case R.id.Occlusionll:
                Log.i("H_CenterFragment","<<<<<<<<<<<<<<<<< sider");
                closeSider();
                Occlusionll.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void  showSider(){
        float s = siderL.getTranslationX();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(siderL, "translationX", 0f, s + (int)(SCREEN_WIDTH*0.87));
        objectAnimator.setDuration(400).start();
    }
    public void  closeSider(){
        float s = siderL.getTranslationX();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(siderL, "translationX", 0f, s - (int)(SCREEN_WIDTH*0.87));
        objectAnimator.setDuration(400).start();
    }
}
