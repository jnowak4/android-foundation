/*
 * Copyright (c) 2016. Core Logic
 */

package com.corelogic;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created on 11/29/16.
 */

public class MockTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException,
                                                                                                IllegalAccessException,
                                                                                                ClassNotFoundException {
        return super.newApplication(cl, EspressoTestingApp.class.getName(), context);
    }

}
