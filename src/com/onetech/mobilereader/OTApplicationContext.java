package com.onetech.mobilereader;

import android.content.Context;

public class OTApplicationContext {
	private String applicationName = "OTApplicationContext";
	public Context context = null;
	private static OTApplicationContext _instance;

	public static OTApplicationContext getInstance() {
		if (_instance == null) {
			_instance = new OTApplicationContext();
		}
		return _instance;
	}

	public static void setApplicationName(String appName) {
		getInstance().applicationName = appName;
	}

	public static String getApplicationName() {
		return getInstance().applicationName;
	}

	public static void setContext(Context context) {
		getInstance().context = context;
	}
	public static Context getContext(){
		return getInstance().context;
	}
}
