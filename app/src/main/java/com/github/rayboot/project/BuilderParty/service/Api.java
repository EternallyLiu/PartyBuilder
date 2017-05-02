package com.github.rayboot.project.BuilderParty.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liupei on 2017/5/2.
 */

public class Api{
    final ApiService apiService;

    public Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://stg2.v5time.net/ccp/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
