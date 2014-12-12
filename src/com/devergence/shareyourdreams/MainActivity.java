package com.devergence.shareyourdreams;

import com.devergence.shareyourdreams.topoos.POICategories;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends CustomActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //The first time we must manually create the necessary POIs categories, and get the IDs for use in the whole app
        /*
        try {
			com.devergence.shareyourdreams.topoos.AccessInterface.PreregisterApplicationNeccessaryItems(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
        */
        //Now the application cloud context is ready
        
    }
    
    public void onRegisterDream(View v)
    {
    	Intent activity = new Intent(this, UploadActivity.class);
    	activity.putExtra("type", POICategories.DREAM);
		this.startActivity(activity);
    }
    
    public void onRegisterNightmare(View v)
    {
    	Intent activity = new Intent(this, UploadActivity.class);
    	activity.putExtra("type", POICategories.NIGHTMARE);
		this.startActivity(activity);
    }
    
    public void onViewMap(View v)
    {
    	Intent activity = new Intent(this, MapActivity.class);
		this.startActivity(activity);
    }
    
    public void onViewDatabase(View v)
    {
    	Intent activity = new Intent(this, DatabaseActivity.class);
		this.startActivity(activity);
    }
    

    public void onViewSpell(View v)
    {
    	Intent activity = new Intent(this, SpellActivity.class);
		this.startActivity(activity);
    }
    
}
