package com.onetech.mobilereader.models;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.onetech.mobilereader.OTApplicationContext;
import com.onetech.mobilereader.configs.DBConfig.Cache;
import com.onetech.mobilereader.entity.BookEntity;
import com.onetech.mobilereader.interfaces.BookIF;
import com.onetech.mobilereader.uitls.StoreUtils;
import com.onetech.otcore.db.store.SimpleStoreIF;


public class BookModel extends BaseModel implements BookIF {
	
	private static BookIF _instance;
	private static final Lock createLock = new ReentrantLock();
	
	private static final int STORE_EXPIRE = 3*24*60*60; //3 day
	
	public static BookIF getInstance(){
		if(_instance==null){
			createLock.lock();
			_instance = new BookModel();
			createLock.unlock();
		}
		return _instance;
	}
	private BookModel(){
		
	}
	@Override
	SimpleStoreIF getStoreAdapter() {
		return StoreUtils.getStoreAdapter(Cache.BOOK_TABLE, OTApplicationContext.getContext(), Cache.BOOK_TABLE_SIZE);
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
	public List<BookEntity> getAll() {
		
		return null;
	}
	@Override
	public BookEntity getBookEntityById(long id) {
		
		return null;
	}
	
	
}
