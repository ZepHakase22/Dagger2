package com.sensoriainc.dagger2tutorial.di.component;

import android.app.Application;

import com.sensoriainc.dagger2tutorial.DemoApplication;
import com.sensoriainc.dagger2tutorial.di.builder.ActivityBuilder;
import com.sensoriainc.dagger2tutorial.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by zep on 23/01/18.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class , ApplicationModule.class, ActivityBuilder.class} )
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        ApplicationComponent build();
        @BindsInstance Builder application(Application application);
    }
    void inject(DemoApplication demoApplication);

}
