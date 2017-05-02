package com.github.rayboot.project.BuilderParty.service;

/**
 * Created by liupei on 2017/5/2.
 */

public class ApiFactory {
    static Api api = null;

    public static Api getApi() {
        if (api == null) {
            api = new Api();
        }
        return api;
    }
}
