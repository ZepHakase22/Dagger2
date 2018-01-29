package com.sensoriainc.dagger2tutorial.di.builder;

import com.sensoriainc.dagger2tutorial.MainActivity;
import com.sensoriainc.dagger2tutorial.di.module.ActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by zep on 29/01/18.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = ActivityModule.class)
    abstract MainActivity bindMainActivity();

}
