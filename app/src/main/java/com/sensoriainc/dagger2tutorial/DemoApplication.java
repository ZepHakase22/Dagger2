package com.sensoriainc.dagger2tutorial;

import android.app.Application;
import android.content.Context;

import com.sensoriainc.dagger2tutorial.di.component.ApplicationComponent;
import com.sensoriainc.dagger2tutorial.di.component.DaggerApplicationComponent;
import com.sensoriainc.dagger2tutorial.di.module.ApplicationModule;

/**
 * Created by zep on 23/01/18.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                                .builder()
                                .applicationModule(new ApplicationModule(this))
                                .build();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }

}
