package com.onetech.mobilereader.models;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onetech.mobilereader.OTApplicationContext;
import com.onetech.mobilereader.configs.AppConfig.UrlRequest;
import com.onetech.mobilereader.configs.DBConfig.Cache;
import com.onetech.mobilereader.entity.CategoryEntity;
import com.onetech.mobilereader.http.OTHttpRequest;
import com.onetech.mobilereader.http.ResultHttp;
import com.onetech.mobilereader.interfaces.CommonIF;
import com.onetech.mobilereader.uitls.CommonUtils;
import com.onetech.mobilereader.uitls.StoreUtils;
import com.onetech.otcore.db.store.SimpleStoreIF;

public class CommonModel extends BaseModel implements CommonIF {

	private static CommonIF _instance;
	private static final Lock createLock = new ReentrantLock();

	private static final int STORE_EXPIRE = 3 * 24 * 60 * 60; // 3 day

	public static CommonIF getInstance() {
		if (_instance == null) {
			createLock.lock();
			_instance = new CommonModel();
			createLock.unlock();
		}
		return _instance;
	}

	private CommonModel() {

	}

	@Override
	SimpleStoreIF getStoreAdapter() {
		return StoreUtils.getStoreAdapter(Cache.COMMON_TABLE,
				OTApplicationContext.getContext(), Cache.COMMON_TABLE_SIZE);
	}

	@Override
	void setStore(String key, String value) {
		this.getStoreAdapter().put(key, value, STORE_EXPIRE);
	}

	@Override
	void setStore(String key, String value, int expiredTime) {
		this.getStoreAdapter().put(key, value, expiredTime);
	}

	@Override
	public List<CategoryEntity> getAllCategory() {
		List<CategoryEntity> result = new ArrayList<CategoryEntity>();
		String cateString = this.getStoreAdapter().get(
				Cache.LIST_CATEGORY_CACHE_KEY);
		if (cateString != null && cateString.length() > 0) {
			result = convertJsonStringToListCategory(cateString);
		} else {

		}
		return null;
	}

	private List<CategoryEntity> getAllCategoryFromServer() {
		List<CategoryEntity> result = null;
		try {
			String data = OTHttpRequest.getInstance().getStringFromServer(
					UrlRequest.GET_ALL_CATEGORY, null);
			if (data != null && data.length() > 0) {
				ResultHttp resultHttp = CommonUtils.getResultRequest(data);
				if (resultHttp != null && resultHttp.error_code == 0) {
					JSONArray jArr = (JSONArray) resultHttp.data;
					if (jArr != null && jArr.length() > 0) {
						result = new ArrayList<CategoryEntity>();
						CategoryEntity tmp = null;
						int arrSize = jArr.length();
						for (int i = 0; i < arrSize; i++) {
							JSONObject jb = jArr.getJSONObject(i);
							tmp = convertJsonStringToListCategory(jb);
							if (tmp != null) {
								result.add(tmp);
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
		return result;
	}

	private CategoryEntity convertJsonStringToListCategory(JSONObject jb) {
		CategoryEntity result = null;
		try {
			result = new CategoryEntity();
			result.setId(jb.getLong("id"));
			result.setName(jb.getString("name"));
			result.setShortDescription(jb.optString("shortDescription", ""));
			result.setDescription(jb.optString("description", ""));
			result.setDateCreated(jb.optString("dateCreated", ""));
		} catch (JSONException e) {
		}
		return result;
	}

	private List<CategoryEntity> convertJsonStringToListCategory(String json) {
		if (json == null || json.equals("")) {
			return null;
		}
		List<CategoryEntity> result = new ArrayList<CategoryEntity>();
		Gson gs = new Gson();
		Type typeClass = new TypeToken<List<CategoryEntity>>() {
		}.getType();
		result = gs.fromJson(json, typeClass);
		return result;
	}
}
