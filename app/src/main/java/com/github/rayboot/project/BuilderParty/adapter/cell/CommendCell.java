package com.github.rayboot.project.BuilderParty.adapter.cell;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;
import com.github.rayboot.project.BuilderParty.model.BookCommendModel;
import com.github.rayboot.project.R;

import java.text.SimpleDateFormat;

/**
 * Created by liupei on 2017/5/9.
 */

public class CommendCell extends BaseCell implements View.OnClickListener{
    private BookCommendModel commendModel;
    private PopupWindow mPop;


    public CommendCell(Context context, BookCommendModel model) {
        this.mContext = context;
        this.commendModel = model;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public BaseHolder OncreateViewHolder(ViewGroup viewGroup, int itemType) {
        View itemView = inflater.inflate(R.layout.makebook_commendproduction, viewGroup, false);
        return new BaseHolder(itemView);
    }

    @Override
    public void OnBindData(BaseHolder baseHolder, int position) {
        baseHolder.getTextView(R.id.make_commend_tv_bookname).setText(commendModel.getBook_title());
        baseHolder.getTextView(R.id.make_commend_tv_bookeauthor).setText(commendModel.getBook_author());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        baseHolder.getTextView(R.id.make_commend_tv_booktime).setText("时间：" + formatter.format(commendModel.getBook_create_time()));
        baseHolder.getTextView(R.id.make_commend_tv_share).setOnClickListener(this);

        baseHolder.getDraweeView(R.id.make_commend_dv).setImageURI(Uri.parse(commendModel.getBook_cover()));

        View popupView = inflater.inflate(R.layout.popup_commend, null, false);
        // 创建PopupWindow对象
        mPop = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置点击窗口外popupWindow消失
        mPop.setBackgroundDrawable(new BitmapDrawable());
        mPop.setOutsideTouchable(true);
        //设置焦点可以被点击
        mPop.setFocusable(true);
        LinearLayout popup_ll = (LinearLayout) popupView.findViewById(R.id.popup_ll);
        popup_ll.setOnClickListener(this);
    }

    @Override
    public int getItemType() {
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.make_commend_tv_share:
                if (!mPop.isShowing()) {
                    mPop.showAsDropDown(v,200,20);
                }
                break;
            case R.id.popup_ll:
                Toast.makeText(mContext, "分享中...", Toast.LENGTH_SHORT).show();
                if (mPop.isShowing()) {
                    mPop.dismiss();
                }
                break;
        }
    }
}
