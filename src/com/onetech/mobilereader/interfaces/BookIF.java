package com.onetech.mobilereader.interfaces;

import java.util.List;

import com.onetech.mobilereader.entity.BookEntity;


public interface BookIF{
	public List<BookEntity> getAll();
	public BookEntity getBookEntityById(long id);
}
