package com.sensoriainc.dagger2tutorial.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.sensoriainc.dagger2tutorial.di.ApplicationContext;
import com.sensoriainc.dagger2tutorial.di.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zep on 23/01/18.
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs(Application application) {
        return application.getSharedPreferences("demo-prefs",Context.MODE_PRIVATE);
    }


}
