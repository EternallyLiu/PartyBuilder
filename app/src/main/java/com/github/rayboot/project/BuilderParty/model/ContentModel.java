package com.github.rayboot.project.BuilderParty.model;

import com.github.rayboot.project.BuilderParty.model.modelobj.ImageModel;

import java.util.ArrayList;

/**
 * Created by liupei on 2017/5/3.
 */

public class ContentModel {
    private String content_source;
    private ArrayList<ContentModel> contents;
    private long content_id;
    private long content_topic_id;
    private int content_type;
    private int content_category;
    private String content_icon;
    private String content_title;
    private String content_subtitle;
    private String content_author;
    private long content_time;
    private String content_url;
    private String content_html;
    private ArrayList<ImageModel> content_images;
    private int content_collection;
    private int open;
    private String parent_id;
    private int content_appendix;
    private int content_list_type;
    private int read_status;
    private int report_status;
    private int read_time;

    public int getRead_status() {
        return read_status;
    }

    public void setRead_status(int read_status) {
        this.read_status = read_status;
    }

    public int getReport_status() {
        return report_status;
    }

    public void setReport_status(int report_status) {
        this.report_status = report_status;
    }

    public int getRead_time() {
        return read_time;
    }

    public void setRead_time(int read_time) {
        this.read_time = read_time;
    }

    public String getContent_source() {
        return content_source;
    }

    public void setContent_source(String content_source) {
        this.content_source = content_source;
    }

    public ArrayList<ContentModel> getContents() {
        return contents;
    }

    public void setContents(ArrayList<ContentModel> contents) {
        this.contents = contents;
    }

    public long getContent_id() {
        return content_id;
    }

    public void setContent_id(long content_id) {
        this.content_id = content_id;
    }

    public long getContent_topic_id() {
        return content_topic_id;
    }

    public void setContent_topic_id(long content_topic_id) {
        this.content_topic_id = content_topic_id;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public int getContent_category() {
        return content_category;
    }

    public void setContent_category(int content_category) {
        this.content_category = content_category;
    }

    public String getContent_icon() {
        return content_icon;
    }

    public void setContent_icon(String content_icon) {
        this.content_icon = content_icon;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getContent_subtitle() {
        return content_subtitle;
    }

    public void setContent_subtitle(String content_subtitle) {
        this.content_subtitle = content_subtitle;
    }

    public String getContent_author() {
        return content_author;
    }

    public void setContent_author(String content_author) {
        this.content_author = content_author;
    }

    public long getContent_time() {
        return content_time;
    }

    public void setContent_time(long content_time) {
        this.content_time = content_time;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getContent_html() {
        return content_html;
    }

    public void setContent_html(String content_html) {
        this.content_html = content_html;
    }

    public ArrayList<ImageModel> getContent_images() {
        return content_images;
    }

    public void setContent_images(ArrayList<ImageModel> content_images) {
        this.content_images = content_images;
    }

    public int getContent_collection() {
        return content_collection;
    }

    public void setContent_collection(int content_collection) {
        this.content_collection = content_collection;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public int getContent_appendix() {
        return content_appendix;
    }

    public void setContent_appendix(int content_appendix) {
        this.content_appendix = content_appendix;
    }

    public int getContent_list_type() {
        return content_list_type;
    }

    public void setContent_list_type(int content_list_type) {
        this.content_list_type = content_list_type;
    }
}

