package com.github.rayboot.project.BuilderParty.model;

/**
 * Created by liupei on 2017/5/2.
 */

public class UserModel {
    public long user_id;
    public String user_name;
    public String user_avatar;
    public String phone;
    public String company;
    public long company_id;
    public String position;
    public long branch_id;
    public String branch_name;
    public String party_position;
    public boolean custom_password;
    public String token;
    public Integer unread;
    public Integer collect_count;
    public boolean is_admin;
    public int rank;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getParty_position() {
        return party_position;
    }

    public void setParty_position(String party_position) {
        this.party_position = party_position;
    }

    public boolean isCustom_password() {
        return custom_password;
    }

    public void setCustom_password(boolean custom_password) {
        this.custom_password = custom_password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUnread() {
        return unread;
    }

    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public Integer getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(Integer collect_count) {
        this.collect_count = collect_count;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
