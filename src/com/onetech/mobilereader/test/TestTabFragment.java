package com.onetech.mobilereader.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onetech.mobilereader.R;
import com.onetech.otcore.view.viewpager.TabHostFragmentBase;

public class TestTabFragment extends TabHostFragmentBase {
	private View mMainView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(mMainView==null){
			mMainView=inflater.inflate(R.layout.activity_test, container,false);
			initView();
			initListener();
		}
//		else{
//			if(mMainView.getParent()!=null){
//				((ViewGroup) mMainView.getParent()).removeView(mMainView);
//			}
//		}
		return mMainView;
	}
	private void initView(){
		
	}
	private void initListener(){
		
	}
}
