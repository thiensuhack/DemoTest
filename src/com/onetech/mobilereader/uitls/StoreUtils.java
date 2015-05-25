package com.onetech.mobilereader.uitls;

import android.content.Context;

import com.onetech.mobilereader.configs.DBConfig;
import com.onetech.otcore.db.store.SQLiteStore;
import com.onetech.otcore.db.store.SimpleStoreIF;

public final class StoreUtils {
	private StoreUtils(){
		
	}
	public static SimpleStoreIF getStoreAdapter(String name, Context context, int items){
		return SQLiteStore.getInstance(name, context, DBConfig.DBVERSION, items);
	}
}
