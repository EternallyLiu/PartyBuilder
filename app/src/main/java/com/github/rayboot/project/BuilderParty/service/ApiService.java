package com.github.rayboot.project.BuilderParty.service;

import com.github.rayboot.project.BuilderParty.model.modelobj.BooksCommendObj;
import com.github.rayboot.project.BuilderParty.model.modelobj.BooksStudyInfoObj;
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
    @GET("ccp/books?request_type=1")
    Observable<BaseResponse<BooksStudyInfoObj>> getStudyInfoBooks(@Header("token") String token,
                                                                  @Header("userid") long userid,
                                                                  @Header("platform") String platform,
                                                                  @Header("clientversion") String clientversion,
                                                                  @Query("current_page") int current_page,
                                                                  @Query("page_size") int page_size);

    /**
     * 一键成书 推荐作品接口
     */
    @GET("ccp/books?request_type=2")
    Observable<BaseResponse<BooksCommendObj>> getCommendBooks(@Header("token") String token,
                                                              @Header("userid") long userid,
                                                              @Header("platform") String platform,
                                                              @Header("clientversion") String clientversion,
                                                              @Query("current_page") int current_page,
                                                              @Query("page_size") int page_size);
}
