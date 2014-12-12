package com.devergence.shareyourdreams;

import java.util.List;
import java.util.Random;

import com.devergence.shareyourdreams.map.Utils;
import com.devergence.shareyourdreams.topoos.AccessInterface;
import com.devergence.shareyourdreams.topoos.GlobalDreamCounters;
import com.devergence.shareyourdreams.topoos.POICategories;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import topoos.Objects.POI;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MapActivity extends CustomMapActivity {

	private static final int WORKER_MSG_OK = 1;
	private static final int WORKER_MSG_ERROR = -1;
	private static final int WORKER_MSG_GLOBAL_OK = 2;
	private static final int WORKER_MSG_GLOBAL_ERROR = -2;

	private LocationManager mLocationManager;

	private Location m_DeviceLocation = null;
	private Handler m_Handler = new Handler(new ResultMessageCallback());
	private GoogleMap mapa;
	private List<POI> m_pois = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// hide titlebar of application must be before setting the layout
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_map);

		// Get view references
		mapa = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
		
		mapa.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
		    @Override
		    public void onMapLoaded() {
		    	configureMap();
		    }
		});
	}
	
	private void configureMap()
	{

		// Get Location Manager references
		mLocationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);

		// Get last cached device location
		String locationProvider = LocationManager.NETWORK_PROVIDER;
		Location lastKnownLocation = null;
		if (mLocationManager.isProviderEnabled(locationProvider))
		{
			lastKnownLocation = mLocationManager
				.getLastKnownLocation(locationProvider);
		} else 
		{
			// Center map
			lastKnownLocation = new Location("NoProvider");
			lastKnownLocation.setLatitude(0);
			lastKnownLocation.setLongitude(0);
		} 
		
		if (lastKnownLocation != null) {
			// Center map
			mapa.animateCamera( CameraUpdateFactory.zoomTo( 20.0f ) );   
			centerLocationAndLoadDreams(lastKnownLocation);
			m_DeviceLocation = lastKnownLocation;
		} else {
			// Comenzamos a atender actualizaciones en las posiciones
			CustomLocationListener customLocationListener = new CustomLocationListener();

			mLocationManager.requestLocationUpdates(
					LocationManager.NETWORK_PROVIDER, 2000, // minTime
					0, // minDistance
					customLocationListener);
		}

		// Load global counters
		Thread thread = new Thread(new LoadGlobalDreamsCountersWorker());
		thread.start();
	}

	/**
	 * Center map on location
	 * 
	 * @param loc
	 */
	private void centerLocationAndLoadDreams(Location loc) {
		
		//mapa.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(loc.getLatitude(), loc.getLongitude())));
		Utils.BoundingCoordinates(this, loc, AccessInterface.SEARCH_RADIUS_METERS, mapa);

		Thread thread = new Thread(new LoadDreamWorker());
		thread.start();
	}

	/**
	 * Draw Dreams before loading
	 */
	private void drawDreams() {
		mapa.clear();

		CircleOptions radius = new CircleOptions()
	     .center(new LatLng(m_DeviceLocation.getLatitude(), m_DeviceLocation.getLongitude()))
	     .radius(AccessInterface.SEARCH_RADIUS_METERS)
	     .strokeColor(getResources().getColor(R.color.radius_border))
	     .fillColor(getResources().getColor(R.color.radius_solid));
		
		mapa.addCircle(radius);
		
		if (m_pois != null) {
			for (POI p : m_pois) {
				// 1 - create marker
				
				int resource = getRandomMarkerResource(AccessInterface.IsDream(p.getCategories()) ? POICategories.DREAM : POICategories.NIGHTMARE);
				BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(resource);
				
				// 2 - set marker properties
				
				MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(p.getLatitude(), p.getLongitude()))
	                     .title(AccessInterface.IsDream(p.getCategories()) ? getString(R.string.dream) : getString(R.string.nightmare))
	                     .snippet(p.getDescription())
	                     .icon(icon);
				
				// 3 - Add marker to map
				mapa.addMarker(markerOptions);
			}
		}

	}
	

	/**
	 * get fun in the markers :)
	 * @param type
	 * @return
	 */
	private int getRandomMarkerResource(int type)
	{
		int drawable = 0;
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3);
		
		
		if (type == POICategories.DREAM)
		{
			if (randomInt == 0)
			{
				drawable = R.drawable.mapa_sue1;
			}else if (randomInt == 2)
			{
				drawable = R.drawable.mapa_sue3;
			}else
			{
				drawable = R.drawable.mapa_sue2;
			}
		}else if (type == POICategories.NIGHTMARE)
		{
			if (randomInt == 0)
			{
				drawable = R.drawable.mapa_pes1;
			}else if (randomInt == 2)
			{
				drawable = R.drawable.mapa_pes3;
			}else
			{
				drawable = R.drawable.mapa_pes2;
			}
		}
		
		return drawable;
	}
	
	/**
	 * get fun in the markers :)
	 * @param type
	 * @return
	 */
	private Drawable getRandomMarkerDrawable(int type)
	{
		Drawable drawable = null;
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3);
		
		
		if (type == POICategories.DREAM)
		{
			if (randomInt == 0)
			{
				drawable = this.getResources().getDrawable(R.drawable.mapa_sue1);
			}else if (randomInt == 2)
			{
				drawable = this.getResources().getDrawable(R.drawable.mapa_sue3);
			}else
			{
				drawable = this.getResources().getDrawable(R.drawable.mapa_sue2);
			}
		}else if (type == POICategories.NIGHTMARE)
		{
			if (randomInt == 0)
			{
				drawable = this.getResources().getDrawable(R.drawable.mapa_pes1);
			}else if (randomInt == 2)
			{
				drawable = this.getResources().getDrawable(R.drawable.mapa_pes3);
			}else
			{
				drawable = this.getResources().getDrawable(R.drawable.mapa_pes2);
			}
		}
		
		return drawable;
	}

	private class ResultMessageCallback implements Callback {

		public boolean handleMessage(Message arg0) {

			switch (arg0.what) {
			case WORKER_MSG_ERROR:
				Toast.makeText(MapActivity.this,
						getString(R.string.connection_error), Toast.LENGTH_LONG)
						.show();
				break;
			case WORKER_MSG_OK:
				drawDreams();
				break;
			case WORKER_MSG_GLOBAL_ERROR:
				Toast.makeText(MapActivity.this,
						getString(R.string.connection_error), Toast.LENGTH_LONG)
						.show();
				break;
			case WORKER_MSG_GLOBAL_OK:
				refreshCounters((GlobalDreamCounters) arg0.obj);
				break;
			}

			return true; // lo marcamos como procesado
		}
	}

	/**
	 * Refresh global counters
	 * @param obj
	 */
	private void refreshCounters(GlobalDreamCounters obj) {

		try {
			//Animate
			Animation slidedown = AnimationUtils.loadAnimation(MapActivity.this,
					R.anim.slidedown);
			slidedown.reset();
			findViewById(R.id.header).setVisibility(LinearLayout.VISIBLE);
			findViewById(R.id.header).startAnimation(slidedown);

			
			// refresh counters
			int counterDream = obj.getDreamGlobalCounter();
			int counterNightmare = obj.getNightmareGlobalCounter();

			TextView txCounterDream = (TextView) findViewById(R.id.counter_dreams);
			TextView txCounterNightmare = (TextView) findViewById(R.id.counter_nightmares);

			txCounterDream.setText(getString(R.string.counter_global_dreams)
					.replace("{0}", Integer.toString(counterDream)));
			txCounterNightmare.setText(getString(
					R.string.counter_global_nightmares).replace("{0}",
					Integer.toString(counterNightmare)));
		} catch (Exception ex) {
			//
		}
	}

	/**
	 * Custom Location Listener implementation
	 * 
	 */
	private class CustomLocationListener implements LocationListener {

		public void onLocationChanged(Location argLocation) {
			m_DeviceLocation = argLocation;
			centerLocationAndLoadDreams(argLocation);
			mLocationManager.removeUpdates(this); // We need only one aproximate
													// location
		}

		public void onProviderDisabled(String provider) {
		}

		public void onProviderEnabled(String provider) {
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}

	/**
	 * Load Dreams in background
	 * 
	 */
	private class LoadDreamWorker implements Runnable {

		public void run() {

			int mensajeDevuelto = WORKER_MSG_OK;

			try {
				m_pois = AccessInterface.GetUserDreamsNear(MapActivity.this,
						m_DeviceLocation);

			} catch (Exception e) {
				mensajeDevuelto = WORKER_MSG_ERROR;
				Log.e("Upload", e.getMessage());
			}

			m_Handler.sendEmptyMessage(mensajeDevuelto);
		}
	}

	/**
	 * Load Global Dreams Counters in background
	 * 
	 */
	private class LoadGlobalDreamsCountersWorker implements Runnable {

		public void run() {

			Message msg = new Message();

			try {
				GlobalDreamCounters g = AccessInterface
						.GetGlobalDreamCounters(MapActivity.this);

				if (g == null) {
					msg.what = WORKER_MSG_GLOBAL_ERROR;
				} else {
					msg.what = WORKER_MSG_GLOBAL_OK;
					msg.obj = g;
				}

			} catch (Exception e) {
				msg.what = WORKER_MSG_GLOBAL_ERROR;
				Log.e("LoadGlobal", e.getMessage());
			}

			m_Handler.sendMessage(msg);
		}
	}




}
