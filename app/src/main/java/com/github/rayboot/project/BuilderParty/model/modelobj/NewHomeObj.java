package com.github.rayboot.project.BuilderParty.model.modelobj;

import com.github.rayboot.project.BuilderParty.model.ContentModel;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/3.
 */

public class NewHomeObj {
    private String title;
    private ArrayList<ContentModel> content_list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ContentModel> getContent_list() {
        return content_list;
    }

    public void setContent_list(ArrayList<ContentModel> content_list) {
        this.content_list = content_list;
    }
}
