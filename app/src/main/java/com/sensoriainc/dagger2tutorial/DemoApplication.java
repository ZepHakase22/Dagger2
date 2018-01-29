package com.sensoriainc.dagger2tutorial;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.sensoriainc.dagger2tutorial.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by zep on 23/01/18.
 */

public class DemoApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

}
