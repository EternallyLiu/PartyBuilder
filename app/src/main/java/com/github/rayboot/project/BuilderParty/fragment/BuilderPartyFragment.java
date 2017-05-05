package com.github.rayboot.project.BuilderParty.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rayboot.project.BuilderParty.adapter.BuilderPartyAdapter;
import com.github.rayboot.project.BuilderParty.adapter.cell.BaseCell;
import com.github.rayboot.project.BuilderParty.adapter.cell.HomeHorCell;
import com.github.rayboot.project.BuilderParty.adapter.cell.HomeVerCell;
import com.github.rayboot.project.BuilderParty.application.App;
import com.github.rayboot.project.BuilderParty.model.ContentModel;
import com.github.rayboot.project.BuilderParty.utils.SchedulersCompat;
import com.github.rayboot.project.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BuilderPartyFragment extends BaseFragment {
    @Bind(R.id.builder_recycler)
    RecyclerView builderRecycler;

    private List<BaseCell> cells = new ArrayList<>();
    private BuilderPartyAdapter adapter;

    public BuilderPartyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_builder_party, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        //注意异步框架的执行顺序
        apiService.getHomeContent(App.token, App.userid, "Android", "1.0.0")
                .compose(SchedulersCompat.applyIoScheduler())
                .subscribe(newHomeObjBaseResponse -> {
                    ArrayList<ContentModel> homeModelList = newHomeObjBaseResponse.getData().getContent_list();
                    initCells(homeModelList);
                    adapter = new BuilderPartyAdapter((ArrayList) cells);
                    builderRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                    builderRecycler.setAdapter(adapter);
                }, throwable -> {
                    Log.d(this.getClass().getSimpleName(), throwable.getLocalizedMessage());
                });
    }

    private void initCells(ArrayList<ContentModel> homeModelList) {
        for (int i = 0; i < homeModelList.size(); i++) {
            switch (homeModelList.get(i).getContent_list_type()) {
                case 0:
                    HomeVerCell vercell = new HomeVerCell(getActivity(), homeModelList.get(i));
                    cells.add(vercell);
                    break;
                case 1:
                    HomeHorCell horcell = new HomeHorCell(getActivity(), homeModelList.get(i));
                    cells.add(horcell);
                    break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
