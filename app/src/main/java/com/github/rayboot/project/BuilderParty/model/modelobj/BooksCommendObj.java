package com.github.rayboot.project.BuilderParty.model.modelobj;

import com.github.rayboot.project.BuilderParty.model.BookCommendModel;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/9.
 */

public class BooksCommendObj {
    private long total_time;
    private int rank;
    private int total_page;
    private int total_count;
    private int current_page;
    private ArrayList<BookCommendModel> data_list;

    public long getTotal_time() {
        return total_time;
    }

    public void setTotal_time(long total_time) {
        this.total_time = total_time;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public ArrayList<BookCommendModel> getData_list() {
        return data_list;
    }

    public void setData_list(ArrayList<BookCommendModel> data_list) {
        this.data_list = data_list;
    }
}
