package com.github.rayboot.project.BuilderParty.adapter.holder;

import android.sax.RootElement;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.DraweeView;

/**
 * Created by liupei on 2017/5/4.
 */

public class BaseHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views;
    private View itemView;

    public BaseHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    public <V extends View> V getView(int resId) {
        View view = views.get(resId);
        if (view == null) {
            view = itemView.findViewById(resId);
        }
        return (V) view;
    }

    public TextView getTextView(int resId) {
        return getView(resId);
    }

    public ImageView getImageView(int resId) {
        return getView(resId);
    }

    public Button getButton(int resId) {
        return getView(resId);
    }

    public DraweeView getDraweeView(int resId) {
        return getView(resId);
    }
}
