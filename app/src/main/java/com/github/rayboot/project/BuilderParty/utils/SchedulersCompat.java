package com.github.rayboot.project.BuilderParty.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: Ray  Created on 2016/3/10.
 * email : sy0725work@gmail.com
 */
public class SchedulersCompat {

    private static final Observable.Transformer ioTransformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    public static <T>  Observable.Transformer<T,T> applyIoScheduler() {
        return (Observable.Transformer<T, T>) ioTransformer;
    }
}
