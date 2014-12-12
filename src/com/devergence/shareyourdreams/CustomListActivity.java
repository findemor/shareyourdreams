package com.devergence.shareyourdreams;

import com.devergence.shareyourdreams.topoos.AccessInterface;
import com.google.analytics.tracking.android.EasyTracker;

import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class CustomListActivity extends ListActivity {

	@Override
	protected void onStart() {
		super.onStart();
		EasyTracker.getInstance().activityStart(this); // Add this method.
		
		AccessInterface.initializeTopoosSession(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		EasyTracker.getInstance().activityStop(this); // Add this method.
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_about:
			Intent activity = new Intent(this, AboutActivity.class);
			this.startActivity(activity);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
