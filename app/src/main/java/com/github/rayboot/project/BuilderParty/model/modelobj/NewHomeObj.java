package com.github.rayboot.project.BuilderParty.model.modelobj;

import com.github.rayboot.project.BuilderParty.model.ContentModel;

/**
 * Created by liupei on 2017/5/3.
 */

public class NewHomeObj {
    private String title;
    private ContentModel content_list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContentModel getContent_list() {
        return content_list;
    }

    public void setContent_list(ContentModel content_list) {
        this.content_list = content_list;
    }
}
