package com.devergence.shareyourdreams.map;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class Utils {

	/**
	 * Adjust Level Zoom
	 * 
	 * @param gp
	 * @param distance meters
	 */
	public static void BoundingCoordinates(GeoPoint gp, double distance, MapView mMapView) {

		double MIN_LAT = -90;
		double MAX_LAT = 90;
		double MIN_LON = -180;
		double MAX_LON = 180;
		
		int radius = 6370997;

		if (radius < 0d || distance < 0d)
			throw new IllegalArgumentException();

		// angular distance in radians on a great circle
		double radDist = distance / radius;

		double radLat = Math.toRadians(gp.getLatitudeE6() / 1e6); // here is
																	// your
																	// single
																	// point
																	// latitude
																	// gp.getLatitude
		double radLon = Math.toRadians(gp.getLongitudeE6() / 1e6); // here is
																	// your
																	// single
																	// point
																	// longitude
																	// gp.getlongitude

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

		// GeoPoint minGeo = new GeoPoint((int)(minLat*1e6),(int)(minLon*1e6));
		// GeoPoint maxGeo = new GeoPoint((int)(maxLat*1e6),(int)(maxLon*1e6));

		final MapController controller = mMapView.getController();
		controller.zoomToSpan((int) (Math.abs(minLat - maxLat) * 1000000),
				(int) (Math.abs(minLon - maxLon) * 1000000));
	}
}
