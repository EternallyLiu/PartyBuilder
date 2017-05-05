package com.github.rayboot.project.BuilderParty.adapter.cell;

import android.content.Context;
import android.view.ViewGroup;

import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;

/**
 * Created by liupei on 2017/5/4.
 */

public abstract class BaseCell {
    public Context mContext;

    //子类cell实现该方法来加载自己的布局
    public abstract BaseHolder OncreateViewHolder(ViewGroup viewGroup,int itemType);

    //向子类cell的view上绑定数据
    public abstract void OnBindData(BaseHolder baseHolder,int position);

    //获取子类cell的类型
    public abstract int getItemType();

    //选择实现该方法，用于释放资源
    public void releaseResouce() {}
}
