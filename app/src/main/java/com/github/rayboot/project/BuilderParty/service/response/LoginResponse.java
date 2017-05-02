package com.github.rayboot.project.BuilderParty.service.response;

import com.github.rayboot.project.BuilderParty.model.UserModel;

/**
 * Created by liupei on 2017/5/2.
 */

public class LoginResponse {
    public UserModel userModel;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
