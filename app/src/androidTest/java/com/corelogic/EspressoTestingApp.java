package com.corelogic;

/**
 * Created on 8/17/17.
 */

public class EspressoTestingApp extends FoundationApplication {
    @Override
    public void onCreate() {
        initializeInjector();
        super.onCreate();
    }

    @Override
    protected void initializeInjector() {
//        this.applicationComponent = DaggerHomeChatEspressoTestApplicationComponent.builder()
//                .homeChatEspressoTestApplicationModule(new EspressoTestApplicationModule(this))
//                .build();
    }

//    public static EspressoTestApplicationComponent getApplicationComponent() {
//        return (EspressoTestApplicationComponent)applicationComponent;
//    }
}
