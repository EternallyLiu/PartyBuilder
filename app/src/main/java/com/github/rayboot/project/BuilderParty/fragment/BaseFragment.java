package com.github.rayboot.project.BuilderParty.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.rayboot.project.BuilderParty.service.Api;
import com.github.rayboot.project.BuilderParty.service.ApiService;

/**
 * Created by liupei on 2017/5/4.
 */

public class BaseFragment extends Fragment {
    public ApiService apiService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        apiService = new Api().getApiService();
        super.onCreate(savedInstanceState);
    }
}
