package com.onetech.mobilereader.uitls;

import java.io.File;

public final class FilesUtils {
	private FilesUtils(){
		
	}
	public static String getExtension(File f) {
        try {
        	String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                ext = s.substring(i + 1).toLowerCase();
            }
            return ext;
		} catch (Exception e) {
		}
        return null;
    }
}
