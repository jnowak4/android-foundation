/*
 * Copyright (c) 2016. Core Logic
 */

package com.corelogic.di.modules;

import android.content.Context;


import com.corelogic.EspressoTestingApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created on 11/29/16.
 */
@Module
public class EspressoTestApplicationModule {

    private EspressoTestingApp app;

    public EspressoTestApplicationModule(EspressoTestingApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }



}
