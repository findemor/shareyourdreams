package com.devergence.shareyourdreams;

import java.util.List;
import java.util.Random;
import com.devergence.shareyourdreams.map.CircleOverlay;
import com.devergence.shareyourdreams.map.DreamOverlay;
import com.devergence.shareyourdreams.map.Utils;
import com.devergence.shareyourdreams.topoos.AccessInterface;
import com.devergence.shareyourdreams.topoos.GlobalDreamCounters;
import com.devergence.shareyourdreams.topoos.POICategories;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import topoos.Objects.POI;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import android.content.Context;
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
	private MapView mMapView;
	private MapController mMapController;

	private Location m_DeviceLocation = null;
	private Handler m_Handler = new Handler(new ResultMessageCallback());

	private List<POI> m_pois = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// hide titlebar of application must be before setting the layout
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_map);

		// Get view references
		mMapView = (MapView) findViewById(R.id.mapview);
		mMapController = mMapView.getController();

		// Get Location Manager references
		mLocationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);

		// Get last cached device location
		String locationProvider = LocationManager.NETWORK_PROVIDER;
		Location lastKnownLocation = mLocationManager
				.getLastKnownLocation(locationProvider);

		if (lastKnownLocation != null) {
			// Center map
			mMapController.setZoom(20); // Fixed Zoom Level
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
		GeoPoint geoPoint = new GeoPoint((int) (loc.getLatitude() * 1000000),
				(int) (loc.getLongitude() * 1000000));

		Utils.BoundingCoordinates(geoPoint, AccessInterface.SEARCH_RADIUS_METERS, mMapView);

		mMapController.animateTo(geoPoint);

		Thread thread = new Thread(new LoadDreamWorker());
		thread.start();
	}

	/**
	 * Draw Dreams before loading
	 */
	private void drawDreams() {
		mMapView.getOverlays().clear();

		mMapView.getOverlays().add(
				new CircleOverlay(this, m_DeviceLocation.getLatitude(),
						m_DeviceLocation.getLongitude(),
						AccessInterface.SEARCH_RADIUS_METERS));

		if (m_pois != null) {
			for (POI p : m_pois) {
				// 1 - create marker
				
				
				
				Drawable drawable = getRandomMarker(AccessInterface.IsDream(p.getCategories()) ? POICategories.DREAM : POICategories.NIGHTMARE);
				
				DreamOverlay itemizedoverlay = new DreamOverlay(drawable, this);
				// 2 - geolocalize marker
				GeoPoint geoPoint = new GeoPoint(
						(int) (p.getLatitude() * 1000000),
						(int) (p.getLongitude() * 1000000));
				OverlayItem overlayitem = new OverlayItem(
						geoPoint,
						AccessInterface.IsDream(p.getCategories()) ? getString(R.string.dream)
								: getString(R.string.nightmare),
						p.getDescription());
				// 3 - Add marker to map
				itemizedoverlay.addOverlay(overlayitem);
				mMapView.getOverlays().add(itemizedoverlay);
			}
		}

		mMapView.postInvalidate();
	}
	
	/**
	 * get fun in the markers :)
	 * @param type
	 * @return
	 */
	private Drawable getRandomMarker(int type)
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
