package com.github.rayboot.project.BuilderParty.model.modelobj;

import com.github.rayboot.project.BuilderParty.model.BookStudyInfoModel;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/8.
 */

public class BooksStudyInfoObj {
    private int current_page;
    private int total_page;
    private int total_count;

    private ArrayList<BookStudyInfoModel> data_list;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public ArrayList<BookStudyInfoModel> getBook_list() {
        return data_list;
    }

    public void setBook_list(ArrayList<BookStudyInfoModel> book_list) {
        this.data_list = book_list;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
}
