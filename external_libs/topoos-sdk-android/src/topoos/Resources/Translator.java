/**
 * Copyright 2014-present topoos
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package topoos.Resources;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * 
 * @author topoos
 *
 */
class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	public static	List<Location> GetCircle (Integer resolution,Double latCenter,Double lngCenter,Double radius, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		List<Location> list = null;
		if (accessTokenPregenerated.isValid()) {
			ResourcesGet_polygon Get_polygon = new ResourcesGet_polygon("GetCircle", method, format,
					version, accessTokenPregenerated.getAccessToken(), ResourcesGet_polygon.SHAPE_CIRCLE,resolution,
					latCenter, lngCenter, radius);		
			
			PolygonResult polygonResult = new PolygonResult();
			APICaller.ExecuteOperation(Get_polygon, polygonResult);
			list = polygonResult.getPolygon();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return list;
	}

	public static	List<GeocodingData> GetGeocode (Double lat, Double lng, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		List<GeocodingData> Geocoding = null;
		if (accessTokenPregenerated.isValid()) {
			ResourcesGeocode resourcesGeocode = new ResourcesGeocode("GetGeocode", method, format,
					version, accessTokenPregenerated.getAccessToken(), lat,
					lng);
			GeocodingResult geocodingResult = new GeocodingResult();
			APICaller.ExecuteOperation(resourcesGeocode, geocodingResult);
			Geocoding = geocodingResult.getGeocoding();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return Geocoding;
	}
	
	public static String GetTrackExported(Integer resourceID, String type,
			String format, String apiKey) throws IOException, TopoosException{

		
		Resource resourceTrack=new Resource("GetTrackExported", method, format,
				version, type, apiKey, resourceID);
		TrackResourceExportedResult trackResourceExportedResult =new TrackResourceExportedResult();
		APICaller.ExecuteOperation(resourceTrack, trackResourceExportedResult);

		return trackResourceExportedResult.getTrackresource();
	}
	
	
	public static	List<Location> GetCircle (Context context, Integer resolution,Double latCenter,Double lngCenter,Double radius) throws IOException, TopoosException{
		return GetCircle(resolution, latCenter, lngCenter, radius, AccessTokenOAuth.GetAccessToken(context));
	
	}

	public static	List<GeocodingData> GetGeocode (Context context, Double lat, Double lng) throws IOException, TopoosException{
		return GetGeocode(lat, lng, AccessTokenOAuth.GetAccessToken(context));
	}
	
	
	
}
