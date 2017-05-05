package com.github.rayboot.project.BuilderParty.application;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.rayboot.project.BuilderParty.service.Api;
import com.github.rayboot.project.BuilderParty.service.ApiFactory;
import com.github.rayboot.project.BuilderParty.service.ApiService;
import com.github.rayboot.project.BuilderParty.service.body.LoginRequset;
import com.github.rayboot.project.BuilderParty.utils.SchedulersCompat;

/**
 * Created by liupei on 2017/5/4.
 */

public class App extends Application {
    public static long userid;
    public static String token;

    private Api api;
    private ApiService apiService;

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        initLogin();
    }

    private void initLogin() {
        api = ApiFactory.getApi();
        apiService = api.getApiService();
        apiService.loginParty(new LoginRequset("18655117019","111111"))
                .compose(SchedulersCompat.applyIoScheduler())
                .subscribe(baseResponse ->{
                    token = baseResponse.getData().getUser_model().getToken();
                    userid = baseResponse.getData().getUser_model().getUser_id();
                },throwable -> {
                    Log.d(TAG, throwable.getLocalizedMessage());
                });
    }
}
