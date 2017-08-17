package com.corelogic;

import android.app.Application;

import com.corelogic.foundation.presentation.internal.di.components.ApplicationComponent;
import com.corelogic.foundation.presentation.internal.di.components.DaggerApplicationComponent;
import com.corelogic.foundation.presentation.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created on 8/17/17.
 */

public class FoundationApplication extends Application {

    protected static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        initializeInjector();
    }

    protected void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            throw new IllegalStateException("Cannot access the app component before the application has been created");
        }

        return applicationComponent;
    }
}
