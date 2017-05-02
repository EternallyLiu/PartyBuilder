package com.github.rayboot.project.BuilderParty;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rayboot.project.BuilderParty.adapter.MyAdapter;
import com.github.rayboot.project.BuilderParty.base.BaseAppCompatActivity;
import com.github.rayboot.project.BuilderParty.fragment.BuilderPartyFragment;
import com.github.rayboot.project.BuilderParty.fragment.MakeBookFragment;
import com.github.rayboot.project.BuilderParty.fragment.MineFragment;
import com.github.rayboot.project.BuilderParty.service.Api;
import com.github.rayboot.project.BuilderParty.service.ApiFactory;
import com.github.rayboot.project.BuilderParty.service.ApiService;
import com.github.rayboot.project.BuilderParty.service.response.LoginResponse;
import com.github.rayboot.project.BuilderParty.utils.SchedulersCompat;
import com.github.rayboot.project.BuilderParty.view.MyViewPager;
import com.github.rayboot.project.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class TabMainActivity extends BaseAppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.home_viewpager)
    MyViewPager mViewPager;
    @Bind(R.id.tablayout)
    TabLayout mTabLayout;

    private ArrayList<Fragment> mFragments;
    private String[] mStrings;
    private int[] mImages;
    private MyAdapter mAdapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setTitle("");

        initTabLayout();
        setTabLayoutTabView();

        initLogin();
    }

//    private void initLogin() {
//        Api api = ApiFactory.getApi();
//        apiService = api.getApiService();
//        apiService.loginParty("18655117019", "111111")
//                .compose(SchedulersCompat.applyIoSchedulers())
//        .subscribe(LoginResponse -> {
//            LoginResponse.
//        }, throwable -> {
//            Toast.makeText(TabMainActivity.this, "登录接口出错", Toast.LENGTH_SHORT).show();
//        });
//    }

    private void setTabLayoutTabView() {
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(mAdapter.getTabView(i));
        }

        //设置默认显示党政建设,这时候需要更改图标标题颜色
        View builderPartyView = mAdapter.getTabView(0);
        ((TextView) builderPartyView.findViewById(R.id.tab_tv)).setTextColor(getResources().getColor(R.color.selector_tablayout));
        ((ImageView) builderPartyView.findViewById(R.id.tab_iv)).setImageDrawable(getResources().getDrawable(R.drawable.selector_partybuilder));
    }

    private void initTabLayout() {
        initFragment();
        initTabView();
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mAdapter = new MyAdapter(getSupportFragmentManager(), this, mFragments, mImages, mStrings);
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initTabView() {
        mStrings = new String[]{"党政建设", "一键成书", "我的"};
        mImages = new int[]{R.drawable.selector_partybuilder, R.drawable.selector_makebook, R.drawable.selector_mine};
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new BuilderPartyFragment());
        mFragments.add(new MakeBookFragment());
        mFragments.add(new MineFragment());
    }
}
