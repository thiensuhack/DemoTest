package com.onetech.mobilereader.interfaces;

import java.util.List;

import com.onetech.mobilereader.entity.BookEntity;

public interface UserBookDetailIF {
	public List<BookEntity> getListBookDetail(String requestUrl, List<Long> ids);
	public BookEntity getBookDetail(String requestUrl, long id);
}
