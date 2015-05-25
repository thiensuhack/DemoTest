package com.onetech.mobilereader.interfaces;

import java.util.List;

import com.onetech.mobilereader.entity.CategoryEntity;
import com.onetech.mobilereader.entity.UserEntity;

public interface CommonIF {
	// User store utils
	public UserEntity getUserInfo(long id);
	
	// Category store utils
	public List<CategoryEntity> getAllCategory();
}
