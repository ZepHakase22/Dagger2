package com.sensoriainc.dagger2tutorial.di.component;

import com.sensoriainc.dagger2tutorial.MainActivity;
import com.sensoriainc.dagger2tutorial.di.PerActivity;
import com.sensoriainc.dagger2tutorial.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by zep on 24/01/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules =ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
