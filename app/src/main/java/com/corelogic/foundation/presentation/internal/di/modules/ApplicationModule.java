package com.corelogic.foundation.presentation.internal.di.modules;

import android.content.Context;

import com.corelogic.FoundationApplication;
import com.corelogic.foundation.data.net.HttpService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Seth Bourget
 * Date: 5/25/16
 */
@Module
public class ApplicationModule
{
	private FoundationApplication app;

	public ApplicationModule(FoundationApplication app)
	{
		this.app = app;
	}

	@Provides
	@Singleton
	public Context provideApplicationContext() {
		return app;
	}

	@Provides
	@Singleton
	public HttpService provideHttpService() {
		return new HttpService();
	}
}
