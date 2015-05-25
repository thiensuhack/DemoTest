package com.onetech.mobilereader.configs;

public class DBConfig {
	public static int DBVERSION = 1;

	public static final class Cache {
		
		public static final String BOOK_TABLE = "Book";
		public static final int BOOK_TABLE_SIZE = 100;
		
		public static final String BOOK_DETAIL_TABLE = "BookDetail";
		public static final int BOOK_DETAIL_TABLE_SIZE = 500;

		public static final String COMMON_TABLE= "Common";
		public static final int COMMON_TABLE_SIZE = 100;
		
		public static final String LIST_CATEGORY_CACHE_KEY = "categorycachekey";
	}
	
}
