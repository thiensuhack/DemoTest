package com.onetech.mobilereader.objects;

public class DeviceInfo {
	private String device_id;
	private String device_type;
	private String imei;
	private String serial_number;
	private String app_id;
	private String app_version;
	private String hash_key;
	private String debug;
	private String token_id;
	
	public DeviceInfo(){
		device_id="";
		device_type="";
		imei="";
		serial_number="";
		app_id="";
		app_version="";
		hash_key="";
		debug="";
		token_id="";
	
	}
	public String getDevice_Id() {
		return device_id;
	}
	public void setDevice_Id(String device_id) {
		this.device_id = device_id;
	}
	
	public String getUserAgent() {
		return System.getProperty("http.agent") + ";mobilereader";
	}
	
	
	public String getDevice_Type() {
		return device_type;
	}
	public void setDevice_Type(String device_type) {
		this.device_type = device_type;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getSerial_Number() {
		return serial_number;
	}
	public void setSerial_Number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getApp_Id() {
		return app_id;
	}
	public void setApp_Id(String app_id) {
		this.app_id = app_id;
	}
	public String getApp_Version() {
		return app_version;
	}
	public void setApp_Version(String app_version) {
		this.app_version = app_version;
	}
	public String getHash_Key() {
		return hash_key;
	}
	public void setHash_Key(String hash_key) {
		this.hash_key = hash_key;
	}
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	public String getToken_Id() {
		return token_id;
	}
	public void setToken_Id(String token_id) {
		this.token_id = token_id;
	}
}
