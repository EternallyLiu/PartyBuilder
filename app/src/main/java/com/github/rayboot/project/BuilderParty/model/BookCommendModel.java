package com.github.rayboot.project.BuilderParty.model;

/**
 * Created by liupei on 2017/5/9.
 */

public class BookCommendModel{
    private int book_status;
    private String book_summary;
    private String book_title;
    private String book_author;
    private String extra;
    private long book_id;
    private long book_create_time;
    private String book_cover;
    private int book_total_page;
    private int book_type;

    public int getBook_status() {
        return book_status;
    }

    public void setBook_status(int book_status) {
        this.book_status = book_status;
    }

    public String getBook_summary() {
        return book_summary;
    }

    public void setBook_summary(String book_summary) {
        this.book_summary = book_summary;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getBook_create_time() {
        return book_create_time;
    }

    public void setBook_create_time(long book_create_time) {
        this.book_create_time = book_create_time;
    }

    public String getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public int getBook_total_page() {
        return book_total_page;
    }

    public void setBook_total_page(int book_total_page) {
        this.book_total_page = book_total_page;
    }

    public int getBook_type() {
        return book_type;
    }

    public void setBook_type(int book_type) {
        this.book_type = book_type;
    }
}
