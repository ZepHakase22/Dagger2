package com.sensoriainc.dagger2tutorial.di.component;

import android.content.Context;

import com.sensoriainc.dagger2tutorial.DemoApplication;
import com.sensoriainc.dagger2tutorial.data.DBHelper;
import com.sensoriainc.dagger2tutorial.data.DataManager;
import com.sensoriainc.dagger2tutorial.data.SharedPrefsHelper;
import com.sensoriainc.dagger2tutorial.di.ApplicationContext;
import com.sensoriainc.dagger2tutorial.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zep on 23/01/18.
 */
@Singleton
@Component(modules =ApplicationModule.class)
public interface ApplicationComponent {
    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    DataManager getDataManager();

    DBHelper getDbHelper();

    SharedPrefsHelper getSharedPrefsHelper();
}
