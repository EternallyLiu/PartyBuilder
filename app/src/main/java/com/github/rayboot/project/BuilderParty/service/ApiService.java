package com.github.rayboot.project.BuilderParty.service;

import com.github.rayboot.project.BuilderParty.service.response.LoginResponse;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liupei on 2017/5/2.
 */

public interface ApiService {

    /**
     * 登录接口
     */
    @POST("login")
    Observable<LoginResponse> loginParty(@Query("phone") String phone,
                                         @Query("password") String password);

}
