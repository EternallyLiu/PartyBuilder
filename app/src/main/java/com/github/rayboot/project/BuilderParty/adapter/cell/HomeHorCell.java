package com.github.rayboot.project.BuilderParty.adapter.cell;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.DraweeView;
import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;
import com.github.rayboot.project.BuilderParty.model.ContentModel;
import com.github.rayboot.project.R;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/5.
 */

public class HomeHorCell extends BaseCell {
    private ContentModel mData;
    private final LayoutInflater inflater;
    private ArrayList<ContentModel> mList;

    private TextView home_hor_tv1;
    private TextView home_hor_tv2;
    private TextView home_hor_tv3;
    private TextView home_hor_tv4;
    private DraweeView home_hor_dv1;
    private DraweeView home_hor_dv2;
    private DraweeView home_hor_dv3;
    private DraweeView home_hor_dv4;
    private TextView home_hor_top_title;

    private ArrayList<TextView> mTvList;
    private ArrayList<DraweeView> mDvList;

    public HomeHorCell(Context context, ContentModel data) {
        this.mContext = context;
        this.mData = data;
        inflater = LayoutInflater.from(mContext);
        mList = mData.getContents();
    }


    @Override
    public BaseHolder OncreateViewHolder(ViewGroup viewGroup, int itemType) {
        View itemView = inflater.inflate(R.layout.home_recycler_hor, viewGroup, false);
        return new BaseHolder(itemView);
    }

    @Override
    public void OnBindData(BaseHolder holder, int position) {
        home_hor_tv1 = holder.getTextView(R.id.home_hor_tv1);
        home_hor_tv2 = holder.getTextView(R.id.home_hor_tv2);
        home_hor_tv3 = holder.getTextView(R.id.home_hor_tv3);
        home_hor_tv4 = holder.getTextView(R.id.home_hor_tv4);

        home_hor_dv1 = holder.getView(R.id.home_hor_dv1);
        home_hor_dv2 = holder.getView(R.id.home_hor_dv2);
        home_hor_dv3 = holder.getView(R.id.home_hor_dv3);
        home_hor_dv4 = holder.getView(R.id.home_hor_dv4);

        home_hor_top_title = holder.getTextView(R.id.builderparty_tv);

        mTvList = new ArrayList<>();
        mTvList.add(home_hor_tv1);
        mTvList.add(home_hor_tv2);
        mTvList.add(home_hor_tv3);
        mTvList.add(home_hor_tv4);

        mDvList = new ArrayList<>();
        mDvList.add(home_hor_dv1);
        mDvList.add(home_hor_dv2);
        mDvList.add(home_hor_dv3);
        mDvList.add(home_hor_dv4);

        for (int i = 0; i < mList.size(); i++) {
            mTvList.get(i).setText(mList.get(i).getContent_title());
            mDvList.get(i).setImageURI(Uri.parse(mList.get(i).getContent_icon()));
        }

        home_hor_top_title.setText(mData.getContent_title());
    }

    @Override
    public int getItemType() {
        return mData.getContent_list_type();
    }
}
