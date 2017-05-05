package com.github.rayboot.project.BuilderParty.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class HomePagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;
    private Context mContext;
    private int[] mImages;


    public HomePagerAdapter(Context context, FragmentManager fm, ArrayList<Fragment> fragments, String[] titles, int[] images) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
        this.mContext = context;
        this.mImages = images;
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
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.tablayout_item, null);
        TextView tab_tv = (TextView) tabView.findViewById(R.id.tab_tv);
        tab_tv.setText(mTitles[position]);

        Drawable drawable = mContext.getDrawable(mImages[position]);
        drawable.setBounds(0, 0, drawable.getMinimumWidth()/2, drawable.getMinimumHeight()/2);
        tab_tv.setCompoundDrawables(null, drawable, null, null);
        return tabView;
    }

}
