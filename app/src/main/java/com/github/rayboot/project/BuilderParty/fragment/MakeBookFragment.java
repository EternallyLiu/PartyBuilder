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
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.github.rayboot.project.BuilderParty.adapter.BaseAdapter;
import com.github.rayboot.project.BuilderParty.adapter.cell.BaseCell;
import com.github.rayboot.project.BuilderParty.adapter.cell.CommendCell;
import com.github.rayboot.project.BuilderParty.adapter.cell.StudyInfoCell;
import com.github.rayboot.project.BuilderParty.application.App;
import com.github.rayboot.project.BuilderParty.model.BookCommendModel;
import com.github.rayboot.project.BuilderParty.model.BookStudyInfoModel;
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
    @Bind(R.id.make_commend_tv_empty)
    TextView makebookTvEmpty;
    @Bind(R.id.makebook_refresh)
    MaterialRefreshLayout makebookRefreshLayout;

    private boolean isStudyInfo = false;//设置一个变量来判断是否处在学习资料界面，避免重复加载
    private TextView CurrentTv;//设置该变量记录刚才点击的是哪个tab
    private int CurrentType = 1;//加载更多的时候判断是哪个页面加载更多
    private int CurrentPage = 1;
    private int scrollPosition = 0;//记录recyvlerView需要滚动到的指定位置

    private final static int TYPE_STYDYINFO = 1;
    private final static int TYPE_COMMENDPRODUCTION = 2;
    private final static int TYPE_MINEPRODUCTION = 3;

    private ArrayList<BookStudyInfoModel> mStudyInfoList;
    private ArrayList<BookCommendModel> mCommendList;
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
        getDataFromService(TYPE_STYDYINFO, 1, 2, false, false);

        makebookRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getDataFromService(CurrentType, 1, 2, false, true);
                materialRefreshLayout.finishRefresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                getDataFromService(CurrentType, ++CurrentPage, 2, true, false);
                materialRefreshLayout.finishRefreshLoadMore();
            }
        });
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
                    CurrentPage = 1;
                    makebookTvLeft.setSelected(true);
                    if (CurrentTv != null && CurrentTv != makebookTvLeft) {
                        CurrentTv.setSelected(false);
                        getDataFromService(TYPE_STYDYINFO, CurrentPage, 2, false, false);
                        CurrentTv = makebookTvLeft;
                    }
                }
                CurrentType = 1;
                break;
            case R.id.makebook_tv_center:
                if (mCells != null) {
                    mCells.clear();
                }
                CurrentPage = 1;
                makebookTvCenter.setSelected(true);
                if (CurrentTv != null && CurrentTv != makebookTvCenter) {
                    CurrentTv.setSelected(false);
                    CurrentTv = makebookTvCenter;
                    getDataFromService(TYPE_COMMENDPRODUCTION, CurrentPage, 2, false, false);
                }
                CurrentType = 2;
                break;
            case R.id.makebook_tv_right:
                if (mCells != null) {
                    mCells.clear();
                }
                CurrentPage = 1;
                makebookTvRight.setSelected(true);
                if (CurrentTv != null && CurrentTv != makebookTvRight) {
                    CurrentTv.setSelected(false);
                    CurrentTv = makebookTvRight;
                    getDataFromService(TYPE_MINEPRODUCTION, CurrentPage, 2, false, false);
                }
                CurrentType = 3;
                break;
        }
    }

    private void getDataFromService(int type, int currentPage, int PageSize, boolean isLoadmore, boolean isPullRefresh) {
        switch (type) {
            case TYPE_STYDYINFO:
                apiService.getStudyInfoBooks(App.token, App.userid, "Android", "1.0.0", currentPage, PageSize)
                        .compose(SchedulersCompat.applyIoScheduler())
                        .subscribe(booksResponse -> {
                            mStudyInfoList = booksResponse.getData().getBook_list();
                            initDataAdapter(TYPE_STYDYINFO, currentPage, isLoadmore, isPullRefresh);
                        }, throwable -> {
                            //打印错误日志
                            Log.e(getClass().getSimpleName(), throwable.getLocalizedMessage());
                        });
                break;
            case TYPE_COMMENDPRODUCTION:
                apiService.getCommendBooks(App.token, App.userid, "Android", "1.0.0", CurrentPage, PageSize)
                        .compose(SchedulersCompat.applyIoScheduler())
                        .subscribe(booksResponse -> {
                            mCommendList = booksResponse.getData().getData_list();
                            initDataAdapter(TYPE_COMMENDPRODUCTION, currentPage, isLoadmore, isPullRefresh);
                        }, throwable -> {
                            //打印错误日志
                            Log.e(getClass().getSimpleName(), throwable.getLocalizedMessage());
                        });
                break;
            case TYPE_MINEPRODUCTION:
                initDataAdapter(TYPE_MINEPRODUCTION, currentPage, isLoadmore, isPullRefresh);
                break;
        }
    }

    private void initDataAdapter(int type, int currentPage, boolean isLoadMore, boolean isPullRefresh) {
        if (isPullRefresh) {
            mCells.clear();//如果是下拉刷新则先清空一遍数据
        }

        if (adapter != null) {
            scrollPosition = adapter.cells.size() - 1;
        }
        switch (type) {
            case TYPE_STYDYINFO:
                for (int i = 0; i < mStudyInfoList.size(); i++) {
                    StudyInfoCell cell = new StudyInfoCell(getActivity(), mStudyInfoList.get(i));
                    mCells.add(cell);
                }
                CurrentTv = makebookTvLeft;
                break;
            case TYPE_COMMENDPRODUCTION:
                for (int i = 0; i < mCommendList.size(); i++) {
                    CommendCell cell = new CommendCell(getActivity(), mCommendList.get(i));
                    mCells.add(cell);
                }
                CurrentTv = makebookTvCenter;
                break;
            case TYPE_MINEPRODUCTION:
                CurrentTv = makebookTvRight;
                break;
        }

        CurrentPage = currentPage;

        if (!(isLoadMore == true && adapter.cells.size() != 0)) {
            if (mCells.size() == 0 || mCells == null) {
                makebookTvEmpty.setVisibility(View.VISIBLE);
                if (adapter != null) {
                    adapter.clear();
                }
                return;
            }
        }

        adapter = new BaseAdapter<>((ArrayList<BaseCell>) mCells);
        makebookRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        makebookRecycler.setAdapter(adapter);
        makebookRecycler.scrollToPosition(scrollPosition);//滚动到本次加载的第一个item
        makebookTvEmpty.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
