package com.github.rayboot.project.BuilderParty.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rayboot.project.BuilderParty.adapter.BaseAdapter;
import com.github.rayboot.project.BuilderParty.adapter.cell.BaseCell;
import com.github.rayboot.project.BuilderParty.adapter.cell.StudyInfoCell;
import com.github.rayboot.project.BuilderParty.application.App;
import com.github.rayboot.project.BuilderParty.model.BookModel;
import com.github.rayboot.project.BuilderParty.utils.SchedulersCompat;
import com.github.rayboot.project.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MakeBookFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.makebook_tv_left)
    TextView makebookTvLeft;
    @Bind(R.id.makebook_tv_center)
    TextView makebookTvCenter;
    @Bind(R.id.makebook_tv_right)
    TextView makebookTvRight;
    @Bind(R.id.makebook_search)
    TextView makebookSearch;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.makebook_recycler)
    RecyclerView makebookRecycler;

    private boolean isStudyInfo = false;//设置一个变量来判断是否处在学习资料界面，避免重复加载
    private TextView CurrentTv;//设置该变量记录刚才点击的是哪个tab

    private final static int TYPE_STYDYINFO = 1;
    private final static int TYPE_COMMENDPRODUCTION = 2;
    private final static int TYPE_MINEPRODUCTION = 3;

    private ArrayList<BookModel> mStudyInfoList;
    private List<BaseCell> mCells = new ArrayList<>();
    private BaseAdapter<BaseCell> adapter;

    public MakeBookFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_book, container, false);
        ButterKnife.bind(this, view);
        makebookTvLeft.setSelected(true);
        makebookTvLeft.setOnClickListener(this);
        makebookTvCenter.setOnClickListener(this);
        makebookTvRight.setOnClickListener(this);
        getDataFromService(TYPE_STYDYINFO);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.makebook_tv_left:
                if (!isStudyInfo) {
                    if (mCells != null) {
                        mCells.clear();
                    }
                    getDataFromService(TYPE_STYDYINFO);
                    makebookTvLeft.setSelected(true);
                }
                break;
            case R.id.makebook_tv_center:
                if (mCells != null) {
                    mCells.clear();
                }
                getDataFromService(TYPE_COMMENDPRODUCTION);
                makebookTvCenter.setSelected(true);
                break;
            case R.id.makebook_tv_right:
                if (mCells != null) {
                    mCells.clear();
                }
                getDataFromService(TYPE_MINEPRODUCTION);
                makebookTvRight.setSelected(true);
                break;
        }
    }

    private void getDataFromService(int type) {
        switch (type) {
            case TYPE_STYDYINFO:
                apiService.getStudyInfo(App.token, App.userid, "Android", "1.0.0", 1, 1, 10)
                        .compose(SchedulersCompat.applyIoScheduler())
                        .subscribe(booksResponse -> {
                            mStudyInfoList = booksResponse.getData().getBook_list();
                            initDataAdapter(TYPE_STYDYINFO);
                        }, throwable -> {
                            //打印错误日志
                            Log.e(getClass().getSimpleName(), throwable.getLocalizedMessage());
                        });
                break;
            case TYPE_COMMENDPRODUCTION:
                break;
            case TYPE_MINEPRODUCTION:
                break;
        }

    }

    private void initDataAdapter(int type) {
        switch (type) {
            case TYPE_STYDYINFO:
                for (int i = 0; i < mStudyInfoList.size(); i++) {
                    StudyInfoCell cell = new StudyInfoCell(getActivity(), mStudyInfoList.get(i));
                    mCells.add(cell);
                }
                break;
            case TYPE_COMMENDPRODUCTION:
                break;
            case TYPE_MINEPRODUCTION:
                break;
        }

        adapter = new BaseAdapter<>((ArrayList<BaseCell>) mCells);
        makebookRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        makebookRecycler.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
