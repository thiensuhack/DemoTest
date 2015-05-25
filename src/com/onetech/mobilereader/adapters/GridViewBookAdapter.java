package com.onetech.mobilereader.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onetech.mobilereader.R;
import com.onetech.mobilereader.entity.BookEntity;


public class GridViewBookAdapter extends OTBaseAdapter<BookEntity> {
	private class ViewHolder{
		public TextView title;
		public TextView author;
		public ImageView imageCover;
	}
	public GridViewBookAdapter(Activity _activity){
		activity = _activity;
		mListData = new ArrayList<BookEntity>();
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		initImageLoader();
	}
	@Override
	public long getItemId(int position) {
		if(mListData != null && mListData.size()>position){
			return mListData.get(position).getId();
		}
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item_directory_row, parent,false);
			viewHolder = new ViewHolder();
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
}
