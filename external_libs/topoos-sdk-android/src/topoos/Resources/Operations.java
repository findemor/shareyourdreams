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

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.GeocodingData;
import topoos.Objects.Location;
import android.content.Context;

/**
 * 
 * @author topoos
 * 
 */
public class Operations {
	
	public static final String DATA_TRACK= topoos.APIAccess.Operations.ExportLayerTrack.DATA_TRACK;
	public static final String TYPE_LAYER= topoos.APIAccess.Operations.ExportLayerTrack.TYPE_LAYER;
	public static final String EXPORT_FORMAT_KML=topoos.APIAccess.Operations.ExportLayerTrack.EXPORT_FORMAT_KML;
	public static final String EXPORT_FORMAT_JSON=topoos.APIAccess.Operations.ExportLayerTrack.EXPORT_FORMAT_JSON;
	
	/**
	 * 
	 * @param resolution
	 * @param latCenter
	 * @param lngCenter
	 * @param radius
	 * @param accessTokenPregenerated
	 * @return List<Location>
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<Location> GetCircle(AccessTokenOAuth accessTokenPregenerated, Integer resolution,
			Double latCenter, Double lngCenter, Double radius
			) throws IOException, TopoosException {
		return Translator.GetCircle(resolution, latCenter, lngCenter, radius,
				accessTokenPregenerated);
	}

	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param accessTokenPregenerated
	 * @return List<GeocodingData>
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<GeocodingData> GetGeocode(AccessTokenOAuth accessTokenPregenerated, Double lat, Double lng) throws IOException, TopoosException {
		return Translator.GetGeocode(lat, lng, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param resourceID
	 * @param type
	 * @param format
	 * @param apiKey 
	 * @return Track
	 * @throws TopoosException 
	 * @throws IOException 
	 */
	public static String GetTrackExported(Integer resourceID, String type,
			String format, String apiKey) throws IOException, TopoosException {
		return Translator.GetTrackExported(resourceID, type, format, apiKey);
	}


	/**
	 * 
	 * @param context
	 * @param resolution
	 * @param latCenter
	 * @param lngCenter
	 * @param radius
	 * @return List<Location>
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<Location> GetCircle(Context context, Integer resolution,
			Double latCenter, Double lngCenter, Double radius) throws IOException, TopoosException {
		return Translator.GetCircle(context, resolution, latCenter, lngCenter,
				radius);

	}

	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @return List<GeocodingData>
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<GeocodingData> GetGeocode(Context context, Double lat,
			Double lng) throws IOException, TopoosException {
		return Translator.GetGeocode(context, lat, lng);
	}
}
