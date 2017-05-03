package com.github.rayboot.project.BuilderParty.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rayboot.project.BuilderParty.service.Api;
import com.github.rayboot.project.BuilderParty.service.ApiFactory;
import com.github.rayboot.project.BuilderParty.service.ApiService;
import com.github.rayboot.project.BuilderParty.utils.SchedulersCompat;
import com.github.rayboot.project.R;

public class BuilderPartyFragment extends Fragment {
    private ApiService apiService;
    private Api api;

    public BuilderPartyFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initRecyclerViewData();
    }

//    private void initRecyclerViewData() {
//        api = ApiFactory.getApi();
//        apiService = api.getApiService();
//        apiService.getHomeContent(getActivity())
//                .compose(SchedulersCompat.applyIoScheduler())
//                .subscribe(newHomeObjBaseResponse -> {
//                    newHomeObjBaseResponse.getData().getContent_list();
//                },throwable -> {
//                    Log.e(TAG, throwable.getLocalizedMessage());
//                });
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_builder_party, container, false);
    }

}
