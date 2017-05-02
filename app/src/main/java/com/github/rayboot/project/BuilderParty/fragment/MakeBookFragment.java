package com.github.rayboot.project.BuilderParty.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rayboot.project.R;

public class MakeBookFragment extends Fragment {


    public MakeBookFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_make_book, container, false);
    }

}
