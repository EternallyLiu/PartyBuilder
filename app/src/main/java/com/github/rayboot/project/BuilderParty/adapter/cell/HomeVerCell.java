package com.github.rayboot.project.BuilderParty.adapter.cell;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;
import com.github.rayboot.project.BuilderParty.model.ContentModel;
import com.github.rayboot.project.R;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/5.
 */

public class HomeVerCell extends BaseCell{
    public ContentModel contentModel;
    public ArrayList<ContentModel> mData;

    private TextView home_ver_tv1;
    private TextView home_ver_tv2;
    private TextView home_ver_tv3;
    private TextView home_ver_top_title;

    private ArrayList<TextView> mTvList;
    private ArrayList<View> mLines;
    private View line1;
    private View line2;

    public HomeVerCell(Context context,ContentModel contentModel) {
        this.contentModel = contentModel;
        this.mContext = context;
        mData = contentModel.getContents();
        inflater = LayoutInflater.from(mContext);
        mTvList = new ArrayList<>();
        mLines = new ArrayList<>();
    }

    @Override
    public BaseHolder OncreateViewHolder(ViewGroup viewGroup, int itemType) {
        View itemView = inflater.inflate(R.layout.home_recycler_ver, viewGroup, false);
        return new BaseHolder(itemView);
    }

    @Override
    public void OnBindData(BaseHolder baseHolder, int position) {
        home_ver_tv1 = baseHolder.getTextView(R.id.home_ver_tv1);
        home_ver_tv2 = baseHolder.getTextView(R.id.home_ver_tv2);
        home_ver_tv3 = baseHolder.getTextView(R.id.home_ver_tv3);

        line1 = baseHolder.getView(R.id.home_ver_line1);
        line2 = baseHolder.getView(R.id.home_ver_line2);

        home_ver_top_title = baseHolder.getTextView(R.id.builderparty_tv);

        mLines.add(line1);
        mLines.add(line2);

        mTvList.add(home_ver_tv1);
        mTvList.add(home_ver_tv2);
        mTvList.add(home_ver_tv3);

        for (int i = 0; i < mData.size(); i++) {
            if (i == 3) {
                break;
            }
            String title = mData.get(i).getContent_title();
            mTvList.get(i).setText(title);
        }

        //隐藏掉无用的组件
        if (mData.size() < 3) {
            for (int j = 3; j > mData.size(); j--) {
                mTvList.get(j - 1).setVisibility(View.GONE);
                if (j != 3) {
                    mLines.get(j - 1).setVisibility(View.GONE);
                    if (j == 2) {
                        mLines.get(0).setVisibility(View.GONE);
                    }
                }
            }
        }

        home_ver_top_title.setText(contentModel.getContent_title());
    }

    @Override
    public int getItemType() {
        return contentModel.getContent_list_type();
    }
}
