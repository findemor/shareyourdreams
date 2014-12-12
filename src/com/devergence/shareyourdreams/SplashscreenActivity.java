package com.devergence.shareyourdreams;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;

public class SplashscreenActivity extends CustomActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);      
        
    	start();
    	}

    	private void start() {
    		long time = 2 * 1000;
    		Timer timer = new Timer(true);

    		timer.schedule(new FinishTask(), time);
    	}

    	private class FinishTask extends TimerTask {

    		@Override
    		public void run() {
    			Intent activity = new Intent((SplashscreenActivity.this), MainActivity.class);
    			startActivity(activity);
    			SplashscreenActivity.this.finish();
    		}

    	}
    
}
