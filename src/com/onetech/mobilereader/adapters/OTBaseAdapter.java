package com.onetech.mobilereader.adapters;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.onetech.mobilereader.R;
import com.onetech.mobilereader.entity.BookEntity;

public abstract class OTBaseAdapter<T> extends BaseAdapter {
	protected Activity activity;
	protected LayoutInflater inflater = null;
	protected DisplayImageOptions options;
	protected List<T> mListData;
	
	protected void updateListData(List<T> _listData){
		mListData.clear();
		mListData.addAll(_listData);
		notifyDataSetChanged();
	}
	
	protected void insetListData(List<T> _listData){
		mListData.addAll(_listData);
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		if(mListData==null){
			return 0;
		}
		return mListData.size();
	}

	@Override
	public Object getItem(int position) {
		if(mListData != null && mListData.size()>position){
			return mListData.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		return null;
	}
	protected void initImageLoader() {
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.not_found_icon)
				.showImageForEmptyUri(R.drawable.not_found_icon)
				.showImageOnFail(R.drawable.not_found_icon)
				.resetViewBeforeLoading(true).cacheOnDisk(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
				.cacheInMemory(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
				.displayer(new FadeInBitmapDisplayer(300)).handler(new Handler()).build();
	}

	protected void initImageLoader(int imageLoadingResId,int emptyImageResId,
			int failedLoadedImageResId) {
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(imageLoadingResId)
				.showImageForEmptyUri(emptyImageResId)
				.showImageOnFail(failedLoadedImageResId)
				.resetViewBeforeLoading(true).cacheOnDisk(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
				.cacheInMemory(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
				.displayer(new FadeInBitmapDisplayer(300)).handler(new Handler()).build();
	}
}
