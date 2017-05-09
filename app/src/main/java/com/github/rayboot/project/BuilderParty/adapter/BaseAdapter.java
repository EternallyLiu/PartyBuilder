package com.github.rayboot.project.BuilderParty.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.rayboot.project.BuilderParty.adapter.cell.BaseCell;
import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liupei on 2017/5/4.
 */

public class BaseAdapter<T extends BaseCell> extends RecyclerView.Adapter<BaseHolder> {
    public ArrayList<T> cells;

    public BaseAdapter(ArrayList<T> cells) {
        this.cells = cells;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (int i = 0; i < cells.size(); i++) {
            if (viewType == cells.get(i).getItemType()) {
                return cells.get(i).OncreateViewHolder(parent,viewType);
            }
        }
        throw new RuntimeException("错误的布局类型！");
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        cells.get(position).OnBindData(holder, position);
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    @Override
    public int getItemViewType(int position) {
        return cells.get(position).getItemType();
    }

    public void add(T cell) {
        add(cells.size(),cell);
    }

    public void add(int index, T cell) {
        cells.add(index, cell);
        notifyItemChanged(index);
    }

    public void addAll(List<T> list) {
        cells.addAll(list);
        notifyItemRangeChanged(cells.size() - list.size(),list.size());
    }

    public void remove(T cell) {
       remove(cells.indexOf(cell));
    }

    public void remove(int index) {
        cells.remove(index);
        notifyItemRemoved(index);
    }

    public void remove(int start, int count) {
        if (start + count >= cells.size() || start < 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            cells.remove(start + i);
        }
        notifyItemRangeChanged(start, count);
    }

    public void clear() {
        cells.clear();
        notifyDataSetChanged();
    }
}
