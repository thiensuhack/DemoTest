package com.onetech.mobilereader.uitls;

import org.json.JSONObject;

import com.onetech.mobilereader.http.ResultHttp;

public final class CommonUtils {
	private CommonUtils() {

	}

	public static ResultHttp getResultRequest(String data) {
		ResultHttp result = null;
		try {
			JSONObject jb = new JSONObject(data);
			if (jb != null) {
				result = new ResultHttp();
				result.error_code = jb.getInt("error_code");
				result.error_msg = jb.getString("error_msg");
				result.data = jb.get("data");
			}
		} catch (Exception e) {
		}
		return result;
	}
}
