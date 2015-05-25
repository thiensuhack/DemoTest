package com.onetech.mobilereader.test;

import android.app.Fragment;

import com.onetech.mobilereader.R;
import com.onetech.otcore.view.viewpager.TabHostActivityBase;
import com.onetech.otcore.view.viewpager.TabHostFragmentBase;

public class TestTabHostActivity extends TabHostActivityBase {
	private Fragment mTabHostFragment;
	@Override
	public TabHostFragmentBase getTabFragment(int position) {
		switch (position) {
		case 0:
			mTabHostFragment= TestTabFragment.instantiate(getApplicationContext(), TestTabFragment.class.getName());
			break;
		case 1:
			mTabHostFragment= TestTabFragment.instantiate(getApplicationContext(), TestTabFragment.class.getName());
			break;
		case 2:
			mTabHostFragment= TestTabFragment.instantiate(getApplicationContext(), TestTabFragment.class.getName());
			break;
		case 3:
			mTabHostFragment= TestTabFragment.instantiate(getApplicationContext(), TestTabFragment.class.getName());
			break;
		default:
			break;
		}
		return (TabHostFragmentBase)mTabHostFragment;
	}

	@Override
	protected void initTabs() {
		String[] titleTabItems = this.getResources().getStringArray(
				R.array.title_tab_item);
		for (String title : titleTabItems) {
			addTab(title);
		}
	}

}
