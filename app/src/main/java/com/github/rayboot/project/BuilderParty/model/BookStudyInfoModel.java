package com.github.rayboot.project.BuilderParty.model;

/**
 * Created by liupei on 2017/5/8.
 */

public class BookStudyInfoModel {
    private long content_time;
    private String content_title;
    private String content_id;
    private String content_icon;
    private int content_type;

    public long getContent_time() {
        return content_time;
    }

    public void setContent_time(long content_time) {
        this.content_time = content_time;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getContent_icon() {
        return content_icon;
    }

    public void setContent_icon(String content_icon) {
        this.content_icon = content_icon;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }
}
