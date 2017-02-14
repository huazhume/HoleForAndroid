package com.lenservice.holeforandroid.Interface;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.lenservice.holeforandroid.R;

/**
 * Created by len on 17/2/14.
 */

public class H_SiderFragment extends Fragment implements View.OnClickListener{
    private RelativeLayout mainRelativeLayout;
    //SCREEN
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sider, null);
    }

    @Override
    public void onResume() {
        super.onResume();
        WindowManager manager = this.getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        SCREEN_HEIGHT = outMetrics.heightPixels;
        mainRelativeLayout = (RelativeLayout) this.getView().findViewById(R.id.siderMainRelativeLayout);
        ListView listView = new ListView(this.getActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)(SCREEN_WIDTH * 0.87),SCREEN_HEIGHT);
        mainRelativeLayout.addView(listView,layoutParams);

//        LinearLayout linearLayout = new LinearLayout(this.getActivity());
//        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int)(SCREEN_WIDTH * 0.13)*2,SCREEN_HEIGHT);
//        layoutParams2.leftMargin = (int)(SCREEN_WIDTH * 0.87);
//        mainRelativeLayout.addView(linearLayout,layoutParams2);
//        linearLayout.setBackgroundColor(Color.RED);
//        listView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void onClick(View v) {

    }
}
