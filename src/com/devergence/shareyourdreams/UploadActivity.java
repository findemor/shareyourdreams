package com.devergence.shareyourdreams;

import java.util.Date;
import com.devergence.shareyourdreams.internal.Dream;
import com.devergence.shareyourdreams.internal.PersistenceSQL;
import com.devergence.shareyourdreams.topoos.AccessInterface;
import com.devergence.shareyourdreams.topoos.POICategories;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class UploadActivity extends CustomActivity {
	
	private static final int WORKER_MSG_OK = 1;
	private static final int WORKER_MSG_ERROR = -1;

	private int m_POIRegistrationType;
	private String m_Description;
	private Location m_DeviceLocation = null;

	private LocationManager mLocationManager;
	private Handler m_Handler = new Handler(new ResultMessageCallback());
	private ProgressDialog m_ProgressDialog = null;
	
	private TextView mLbCounterCharactersLeft;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        m_POIRegistrationType = getIntent().getExtras().getInt("type");
        
        //LocationManager reference and Get the last cached device location
        mLocationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        
        m_DeviceLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (m_DeviceLocation == null)
        {
        	m_DeviceLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        	
        CustomLocationListener customLocationListener = new CustomLocationListener();
        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 0, customLocationListener);
        
        configureLayout();
    }
    
    
    public void onRegister(View v)
    {
    	m_Description = ((EditText)findViewById(R.id.dream_description_text)).getText().toString();
    	
    	m_ProgressDialog = ProgressDialog.show(this, getString(R.string.upload_wait_title), getString(R.string.upload_wait_desc));
    	Thread thread = new Thread(new UploadDreamWorker());
		thread.start();
    }
    

	private class ResultMessageCallback implements Callback {

		public boolean handleMessage(Message arg0) {
			m_ProgressDialog.dismiss();
			
			switch(arg0.what)
			{
			case WORKER_MSG_ERROR:
				Toast.makeText(UploadActivity.this, getString(R.string.connection_error), Toast.LENGTH_LONG).show();
				break;
			case WORKER_MSG_OK:
				(UploadActivity.this).finish();
				break;
			}
			
			return true; //lo marcamos como procesado
		}
	}
	
	
	/**
	 * Get location updates
	 *
	 */
	private class CustomLocationListener implements LocationListener{

		  public void onLocationChanged(Location argLocation) {
			  m_DeviceLocation = argLocation;
			  checkRegisterButtonStatus();
			  mLocationManager.removeUpdates(this);
		  }

		  public void onProviderDisabled(String provider) {}

		  public void onProviderEnabled(String provider) {}

		  public void onStatusChanged(String provider,
		    int status, Bundle extras) {}
	 }
	
	
    
    /**
     * Layout components preparation
     */
    private void configureLayout()
    {
        ImageButton ibd = (ImageButton)findViewById(R.id.button_register_dream);
        ImageButton ibn = (ImageButton)findViewById(R.id.button_register_nightmare);
        
        ibd.setVisibility(m_POIRegistrationType == POICategories.DREAM ? ImageButton.VISIBLE : ImageButton.GONE);
        ibn.setVisibility(m_POIRegistrationType == POICategories.NIGHTMARE ? ImageButton.VISIBLE : ImageButton.GONE);
        ibd.setEnabled(false);
        ibn.setEnabled(false);
        
        
        EditText descriptionText = (EditText)findViewById(R.id.dream_description_text);
        
        descriptionText.setHint(m_POIRegistrationType == POICategories.DREAM ? getString(R.string.dream_description) : getString(R.string.nightmare_description));
        
        descriptionText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(300) });

        mLbCounterCharactersLeft = (TextView) findViewById(R.id.lbCounterCharactersLeft);
        
		// Events
        descriptionText.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
					//int left = updateCharactersLeft(s.toString());
					//mLbCounterCharactersLeft.setText(Integer.toString(left));	
				
				if (mLbCounterCharactersLeft != null) {
					int left = updateCharactersLeft(s.toString());
					mLbCounterCharactersLeft.setText(Integer.toString(left));
				}
				
				checkRegisterButtonStatus();
			}
		
			public void beforeTextChanged(CharSequence s, int start,
					int count, int after) {
			}
		
			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
			}
		});
    }
    

	private int updateCharactersLeft(String currentText) {
		int restantes = 300;
		if (currentText != null) {
			restantes = restantes - currentText.length();
		}
		return restantes;
	}
    
    /**
     * Change the status enabled/disabled for the register button when we have the mandatory info
     */
    private void checkRegisterButtonStatus()
    {
    	EditText descriptionText = (EditText)findViewById(R.id.dream_description_text);
    	
    	boolean enabled = descriptionText.getText().length() > 0 && m_DeviceLocation != null;
    	
    	ImageButton ibd = (ImageButton)findViewById(R.id.button_register_dream);
        ImageButton ibn = (ImageButton)findViewById(R.id.button_register_nightmare);
        
        ibd.setEnabled(enabled);
        ibn.setEnabled(enabled);
        
    }
    
    
    /**
	 * Upload the dreams and update other related items (as counters and database)
	 *
	 */
	private class UploadDreamWorker implements Runnable {
		
		public void run(){
			
			int mensajeDevuelto = WORKER_MSG_OK;
			
			try {
				
				int newPOIid = AccessInterface.RegisterDream(UploadActivity.this, m_POIRegistrationType, m_Description, m_DeviceLocation);
				
				Dream newDream = new Dream(newPOIid, m_POIRegistrationType, m_Description, new Date());
				
				PersistenceSQL.insertDream(UploadActivity.this, newDream);
				
			} catch (Exception e) {
				mensajeDevuelto = WORKER_MSG_ERROR;
				Log.e("Upload", e.getMessage());
			}
			
			//devolvemos un mensaje al hilo principal
			m_Handler.sendEmptyMessage(mensajeDevuelto);
		}
	}
    
}
