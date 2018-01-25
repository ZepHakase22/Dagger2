package com.sensoriainc.dagger2tutorial.di.module;

import android.app.Activity;

import dagger.Module;

/**
 * Created by zep on 24/01/18.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity=activity;
    }

}
