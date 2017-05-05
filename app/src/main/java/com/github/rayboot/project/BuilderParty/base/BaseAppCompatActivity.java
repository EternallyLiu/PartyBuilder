package com.github.rayboot.project.BuilderParty.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.github.rayboot.project.BuilderParty.application.App;
import com.github.rayboot.project.BuilderParty.global.Global;
import com.github.rayboot.project.BuilderParty.service.Api;
import com.github.rayboot.project.BuilderParty.service.ApiFactory;
import com.github.rayboot.project.BuilderParty.service.ApiService;
import com.github.rayboot.project.BuilderParty.service.body.LoginRequset;
import com.github.rayboot.project.BuilderParty.utils.SchedulersCompat;
import com.umeng.analytics.MobclickAgent;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author rayboot
 * @from 14/11/3 14:04
 * @TODO
 */
public class BaseAppCompatActivity extends AppCompatActivity {
    public LayoutInflater mInflater;
    private CompositeSubscription mCompositeSubscription;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = new Api().getApiService();
        mInflater = LayoutInflater.from(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        return this.mCompositeSubscription;
    }

    public void addSubscription(Subscription s) {
        getCompositeSubscription().add(s);
    }
}
