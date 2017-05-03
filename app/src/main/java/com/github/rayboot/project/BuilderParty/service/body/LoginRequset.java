package com.github.rayboot.project.BuilderParty.service.body;

import android.util.Base64;

/**
 * Created by liupei on 2017/5/3.
 */

public class LoginRequset {
    private String phone;
    private String password;
    private String verify_code;

    public LoginRequset(String phone, String password) {
        this.phone = phone;
        this.password = Base64.encodeToString(password.getBytes(), Base64.DEFAULT);;
    }

    public LoginRequset(String phone, String password, String verify_code) {
        this.phone = phone;
        this.password = Base64.encodeToString(password.getBytes(), Base64.DEFAULT);;
        this.verify_code = verify_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}
