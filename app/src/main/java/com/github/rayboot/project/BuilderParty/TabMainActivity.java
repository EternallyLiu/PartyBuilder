package com.github.rayboot.project.BuilderParty;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.rayboot.project.BuilderParty.adapter.HomePagerAdapter;
import com.github.rayboot.project.BuilderParty.base.BaseAppCompatActivity;
import com.github.rayboot.project.BuilderParty.fragment.BuilderPartyFragment;
import com.github.rayboot.project.BuilderParty.fragment.MakeBookFragment;
import com.github.rayboot.project.BuilderParty.fragment.MineFragment;
import com.github.rayboot.project.BuilderParty.view.MyViewPager;
import com.github.rayboot.project.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabMainActivity extends BaseAppCompatActivity implements View.OnClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.home_viewpager)
    MyViewPager homeViewpager;
    @Bind(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_tab_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setTitle("");

        initTabLayout();
    }

    private void initTabLayout() {
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new BuilderPartyFragment());
        mFragments.add(new MakeBookFragment());
        mFragments.add(new MineFragment());

        String[] mTitles = new String[]{"党建平台", "一键成书", "我的"};
        int[] mImages = new int[]{R.drawable.selector_partybuilder, R.drawable.selector_makebook, R.drawable.selector_mine};

        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(this, getSupportFragmentManager(), mFragments, mTitles, mImages);
        homeViewpager.setAdapter(homePagerAdapter);

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setupWithViewPager(homeViewpager);

        for (int i = 0; i < tablayout.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            tab.setCustomView(homePagerAdapter.getTabView(i));
            TextView tab_tv = (TextView) tab.getCustomView().findViewById(R.id.tab_tv);
            tab_tv.setTag(R.string.tag_index, i);
            tab_tv.setOnClickListener(this);
        }

        homeViewpager.setOffscreenPageLimit(3);
//        homeViewpager.setCurrentItem(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_tv:
                homeViewpager.setCurrentItem((int) v.getTag(R.string.tag_index));
                break;
        }
    }
}
