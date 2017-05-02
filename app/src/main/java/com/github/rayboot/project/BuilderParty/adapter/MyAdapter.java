package com.github.rayboot.project.BuilderParty.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rayboot.project.BuilderParty.TabMainActivity;
import com.github.rayboot.project.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liupei on 2017/5/2.
 */

public class MyAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> mFragments;
    private int[] mImages;
    private String[] mStrings;
    private Context mContext;


    private View mTabView;
    private TextView tab_tv;
    private ImageView tab_iv;

    public MyAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments, int[] images,String[] strings) {
        super(fm);
        this.mFragments = fragments;
        mImages = images;
        this.mContext = context;
        this.mStrings = strings;
    }



    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public View getTabView(int position) {
        mTabView = LayoutInflater.from(mContext).inflate(R.layout.tablayout_item, null);
        tab_tv = (TextView) mTabView.findViewById(R.id.tab_tv);
        tab_iv = (ImageView) mTabView.findViewById(R.id.tab_iv);

        tab_tv.setText(mStrings[position]);
        tab_iv.setImageDrawable(mContext.getResources().getDrawable(mImages[position]));
        return mTabView;
    }
}
