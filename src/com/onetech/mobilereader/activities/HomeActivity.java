package com.onetech.mobilereader.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.onetech.mobilereader.R;
import com.onetech.mobilereader.configs.AppConfig.BUNDLE_KEY;
import com.onetech.mobilereader.dialogs.DirectoryDialog;
import com.onetech.mobilereader.dialogs.DirectoryDialog.ResultDirectorySelected;
import com.onetech.mobilereader.fragments.NavigationDrawerFragment;


public class HomeActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    
    
    
	
	private ProgressDialog mProgressDialog = null;
	private DirectoryDialog mDirectoryDialog=null;
	private ResultDirectorySelected mResultDirectory=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        initView();
		initListener();
		initProgress(null);
//		String json = "{\"id\": 12984305795,\"name\": \"John\",\"shortDescription\": \"hello John\",\"description\": \"hello John baby\"}";
//		BookEntity book = JSONUtils.convertJsonStringToBookDetail(json);
//		Log.e("CONVERT DATA", book.toString());
    }
    private void initView(){
    	
		mResultDirectory=new ResultDirectorySelected() {
			@Override
			public void onChooseDirectory(String dir) {
				//Toast.makeText(getApplicationContext(), dir, Toast.LENGTH_LONG).show();
				Intent intent=new Intent(HomeActivity.this,ReaderActivity.class);
				intent.putExtra(BUNDLE_KEY.EBOOK_FILE, dir);
				startActivity(intent);				
			}
		};
	}
	
	private void initListener(){
		
	}
	protected void initProgress(String message) {
		mProgressDialog = new ProgressDialog(HomeActivity.this);
		if (message != null) {
			mProgressDialog.setMessage(message);
		} else {
			mProgressDialog.setMessage(getString(R.string.common_waitting_message));
		}
	}
	public void showSelectFileDialog(){
		mDirectoryDialog=new DirectoryDialog(HomeActivity.this, mResultDirectory, null);
	}
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.reader, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_reader, container, false);
            
            Button mBtnOpenDirectory = null;
            mBtnOpenDirectory=(Button) rootView.findViewById(R.id.openDirectoryBtn);
            mBtnOpenDirectory.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					((HomeActivity)getActivity()).showSelectFileDialog();
				}
			});
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((HomeActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
