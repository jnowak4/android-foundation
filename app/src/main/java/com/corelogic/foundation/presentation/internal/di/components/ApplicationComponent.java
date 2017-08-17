package com.corelogic.foundation.presentation.internal.di.components;

/**
 * Author: Seth Bourget
 * Date: 5/25/16
 */

import android.content.Context;


import com.corelogic.foundation.presentation.internal.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent
{
	Context context();

}
