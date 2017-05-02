package com.github.rayboot.project.BuilderParty.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: Ray  Created on 2016/3/10.
 * email : sy0725work@gmail.com
 */
public class SchedulersCompat {

    private static final Observable.Transformer computationTransformer =
            new Observable.Transformer() {
                @Override
                public Object call(Object observable) {
                    return ((Observable) observable).subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread());
                }
            };
}
