/*
 * Copyright (c) 2016. Core Logic
 */

package com.corelogic.di.components;

import android.content.Context;


import com.corelogic.di.modules.EspressoTestApplicationModule;
import com.corelogic.foundation.presentation.internal.di.components.ApplicationComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 11/29/16.
 */
@Singleton
@Component(modules = EspressoTestApplicationModule.class)
public interface EspressoTestApplicationComponent extends ApplicationComponent {
    Context context();


}
