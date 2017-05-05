package com.github.rayboot.project.BuilderParty.model.modelobj;

/**
 * Created by liupei on 2017/5/4.
 */

public class ImageModel{
    private String image_url;
    private int image_width;
    private int image_height;
    private int image_orientation;
    private String image_remark;
    private String image_content;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getImage_width() {
        return image_width;
    }

    public void setImage_width(int image_width) {
        this.image_width = image_width;
    }

    public int getImage_height() {
        return image_height;
    }

    public void setImage_height(int image_height) {
        this.image_height = image_height;
    }

    public int getImage_orientation() {
        return image_orientation;
    }

    public void setImage_orientation(int image_orientation) {
        this.image_orientation = image_orientation;
    }

    public String getImage_remark() {
        return image_remark;
    }

    public void setImage_remark(String image_remark) {
        this.image_remark = image_remark;
    }

    public String getImage_content() {
        return image_content;
    }

    public void setImage_content(String image_content) {
        this.image_content = image_content;
    }
}
