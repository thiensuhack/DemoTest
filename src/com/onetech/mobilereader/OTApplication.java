package com.onetech.mobilereader;

import android.app.Application;

public class OTApplication extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		OTApplicationContext.setContext(getApplicationContext());
	}
}
