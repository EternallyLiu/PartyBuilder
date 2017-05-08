package com.github.rayboot.project.BuilderParty.adapter.cell;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;
import com.github.rayboot.project.BuilderParty.model.ContentModel;
import com.github.rayboot.project.R;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/5.
 */

public class HomeHorCell extends BaseCell {
    private ContentModel mData;
    private ArrayList<ContentModel> mList;

    private TextView home_hor_tv1;
    private TextView home_hor_tv2;
    private TextView home_hor_tv3;
    private TextView home_hor_tv4;
    private SimpleDraweeView home_hor_dv1;
    private SimpleDraweeView home_hor_dv2;
    private SimpleDraweeView home_hor_dv3;
    private SimpleDraweeView home_hor_dv4;
    private LinearLayout home_hor_ll1;
    private LinearLayout home_hor_ll2;
    private LinearLayout home_hor_ll3;
    private LinearLayout home_hor_ll4;
    private TextView home_hor_top_title;

    private ArrayList<TextView> mTvList;
    private ArrayList<DraweeView> mDvList;
    private ArrayList<LinearLayout> mLlList;


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

        home_hor_dv1 = holder.getDraweeView(R.id.home_hor_dv1);
        home_hor_dv2 = holder.getDraweeView(R.id.home_hor_dv2);
        home_hor_dv3 = holder.getDraweeView(R.id.home_hor_dv3);
        home_hor_dv4 = holder.getDraweeView(R.id.home_hor_dv4);

        home_hor_ll1 = holder.getLinearLayout(R.id.home_hor_ll1);
        home_hor_ll2 = holder.getLinearLayout(R.id.home_hor_ll2);
        home_hor_ll3 = holder.getLinearLayout(R.id.home_hor_ll3);
        home_hor_ll4 = holder.getLinearLayout(R.id.home_hor_ll4);

        home_hor_ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();
            }
        });

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

        mLlList = new ArrayList<>();
        mLlList.add(home_hor_ll1);
        mLlList.add(home_hor_ll2);
        mLlList.add(home_hor_ll3);
        mLlList.add(home_hor_ll4);

        for (int i = 0; i < mList.size(); i++) {
            mTvList.get(i).setText(mList.get(i).getContent_title());
            mDvList.get(i).setImageURI(Uri.parse(mList.get(i).getContent_icon()));
        }

        for (int j = 4; j > mList.size(); j--) {
            LinearLayout ll = mLlList.get(j - 1);
            ll.setVisibility(View.INVISIBLE);
            ll.setEnabled(false);
            ll.setFocusable(false);
        }

        home_hor_top_title.setText(mData.getContent_title());
    }

    @Override
    public int getItemType() {
        return mData.getContent_list_type();
    }
}
