package com.github.rayboot.project.BuilderParty.service;

import com.github.rayboot.project.BuilderParty.model.modelobj.BooksObj;
import com.github.rayboot.project.BuilderParty.model.modelobj.LoginDataObj;
import com.github.rayboot.project.BuilderParty.model.modelobj.NewHomeObj;
import com.github.rayboot.project.BuilderParty.service.body.LoginRequset;
import com.github.rayboot.project.BuilderParty.service.response.BaseResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
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
    @POST("ccp/login")
    Observable<BaseResponse<LoginDataObj>> loginParty(@Body LoginRequset loginbody);

    /**
     * 主页面数据接口
     */
    @GET("ccp/newhome")
    Observable<BaseResponse<NewHomeObj>> getHomeContent(@Header("token") String token,
                                                        @Header("userid") long userid,
                                                        @Header("platform") String platform,
                                                        @Header("clientversion") String clientversion);

    /**
     * 一键成书 学习资料接口
     */
    @GET("ccp/books")
    Observable<BaseResponse<BooksObj>> getStudyInfo(@Header("token") String token,
                                                    @Header("userid") long userid,
                                                    @Header("platform") String platform,
                                                    @Header("clientversion") String clientversion,
                                                    @Query("request_type") int request_type,
                                                    @Query("current_page") int current_page,
                                                    @Query("page_size") int page_size);
}
