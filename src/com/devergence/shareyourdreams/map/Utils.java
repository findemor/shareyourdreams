package com.devergence.shareyourdreams.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.devergence.shareyourdreams.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class Utils {

	/**
	 * Adjust Level Zoom
	 * 
	 * @param gp
	 * @param distance meters
	 */
	public static void BoundingCoordinates(Activity act, Location loc, double distance, final GoogleMap mMapView) {

		double MIN_LAT = -90;
		double MAX_LAT = 90;
		double MIN_LON = -180;
		double MAX_LON = 180;
		
		int radius = 6370997;

		if (radius < 0d || distance < 0d)
			throw new IllegalArgumentException();

		// angular distance in radians on a great circle
		double radDist = distance / radius;

		double radLat = Math.toRadians(loc.getLatitude()); 
		double radLon = Math.toRadians(loc.getLongitude());

		double minLat = radLat - radDist;
		double maxLat = radLat + radDist;

		double minLon, maxLon;
		if (minLat > MIN_LAT && maxLat < MAX_LAT) {
			double deltaLon = Math.asin(Math.sin(radDist) / Math.cos(radLat));
			minLon = radLon - deltaLon;

			if (minLon < MIN_LON)
				minLon += 2d * Math.PI;

			maxLon = radLon + deltaLon;

			if (maxLon > MAX_LON)
				maxLon -= 2d * Math.PI;
		} else {
			// a pole is within the distance
			minLat = Math.max(minLat, MIN_LAT);
			maxLat = Math.min(maxLat, MAX_LAT);
			minLon = MIN_LON;
			maxLon = MAX_LON;
		}

		minLat = Math.toDegrees(minLat);
		minLon = Math.toDegrees(minLon);
		maxLat = Math.toDegrees(maxLat);
		maxLon = Math.toDegrees(maxLon);

		LatLng southwest = new LatLng(minLat, minLon);
		LatLng northeast = new LatLng(maxLat, maxLon);
		final LatLngBounds bounds = new LatLngBounds(southwest, northeast);
		mMapView.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 10));
		
		
		
	}
}
