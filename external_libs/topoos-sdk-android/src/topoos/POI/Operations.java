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

package topoos.POI;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.POI;
import android.content.Context;

/**
 * 
 * @author topoos
 * 
 * Operations related to point of interest(POI) management
 * 
 */
public class Operations {

	/**
	 * Add a new point of interest (POI).Fields like address, cross_street,
	 * city, country, and postalCode not specified, it will attempt to
	 * automatically generate
	 * 
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param geocode Try to geocode the specified lat and lng, to fill unspecified attributes. Default value: false
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param desc
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Add(AccessTokenOAuth accessTokenPregenerated,
			String name, Double lat, Double lng, Boolean geocode, Integer[] categories,
			Double accuracy, Double vaccuracy, Double elevation, String desc,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.Add(name, lat, lng, geocode, categories, accuracy, vaccuracy,
				elevation, desc, address, cross_street, city, country,
				postal_code, phone, twitter, accessTokenPregenerated);
	}

	/**
	 * Gets information from a point of interest
	 * 
	 * @param POIID
	 *            (required) point of interest identifier
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Get(AccessTokenOAuth accessTokenPregenerated, Integer POIID
			) throws IOException,
			TopoosException {
		return Translator.Get(POIID, accessTokenPregenerated);
	}

	/**
	 * Gets a collection of points of interest near a location
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position
	 * @param radius
	 *            (required) search radius in meters
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param total (optional) number of pois
	 * 
	 * @return List<POI>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POI> GetNear(AccessTokenOAuth accessTokenPregenerated,
			Double lat, Double lng, Integer radius, Integer[] categories, Integer total)
			throws IOException, TopoosException {
		return Translator.GetNear(lat, lng, radius, categories,total,
				accessTokenPregenerated);
	}

	/**
	 * Gets a collection of collection of points filtering by various criteria
	 * 
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param POIS
	 *            (optional) list of identifiers of POI you want to retrieve,
	 *            separated by commas
	 * @param city
	 *            (optional) gets the POI in the city specified
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param q
	 *            (optional) gets the POI whose name or description matched the
	 *            pattern
	 * @param total (optional) number of pois
	 * 
	 * @return List<POI>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POI> GetWhere(AccessTokenOAuth accessTokenPregenerated,
			Integer[] categories, Integer[] POIS, String city, String country,
			String postal_code, String q, Integer total) throws IOException, TopoosException {
		return Translator.GetWhere(categories, POIS, city, country,
				postal_code, q,total, accessTokenPregenerated);
	}

	/**
	 * Upgrade the point of interest with the new information provided. If you
	 * want to erase a parameter must be included in the call, but without
	 * providing a value (null).
	 * 
	 * @param POIID
	 *            (Can not be null) POI identifier we want to update
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param desc
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Update(AccessTokenOAuth accessTokenPregenerated,
			Integer POIID, String name, Double lat, Double lng, Boolean geocode,
			Integer[] categories, Double accuracy, Double vaccuracy,
			Double elevation, String desc, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter) throws IOException, TopoosException {
		return Translator.Update(POIID, name, lat, lng, geocode, categories, accuracy,
				vaccuracy, elevation, desc, address, cross_street, city,
				country, postal_code, phone, twitter, accessTokenPregenerated);
	}

	/**
	 * Deletes a point of interest
	 * 
	 * @param POIID
	 *            (Can not be null) POI identifier we want to update
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Delete(AccessTokenOAuth accessTokenPregenerated, Integer POIID
			) throws IOException,
			TopoosException {
		return Translator.Delete(POIID, accessTokenPregenerated);
	}

	/**
	 * Add a new point of interest (POI).Fields like address, cross_street,
	 * city, country, and postalCode not specified, it will attempt to
	 * automatically generate
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param desc
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Add(Context context, String name, Double lat, Double lng,
			Boolean geocode, Integer[] categories, Double accuracy, Double vaccuracy,
			Double elevation, String desc, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter) throws IOException, TopoosException {
		return Translator.Add(context, name, lat, lng, geocode, categories, accuracy,
				vaccuracy, elevation, desc, address, cross_street, city,
				country, postal_code, phone, twitter);
	}

	/**
	 * Gets information from a point of interest
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POIID
	 *            (required) point of interest identifier
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Get(Context context, Integer POIID) throws IOException,
			TopoosException {
		return Translator.Get(context, POIID);
	}

	/**
	 * Gets a collection of points of interest near a location
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position
	 * @param radius
	 *            (required) search radius in meters
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs.
	 * @param total (optional) number of pois
	 * 
	 * @return List<POI>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POI> GetNear(Context context, Double lat, Double lng,
			Integer radius, Integer[] categories, Integer total) throws IOException,
			TopoosException {
		return Translator.GetNear(context, lat, lng, radius, categories,total);

	}

	/**
	 * Gets a collection of collection of points filtering by various criteria
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param POIS
	 *            (optional) list of identifiers of POI you want to retrieve,
	 *            separated by commas
	 * @param city
	 *            (optional) gets the POI in the city specified
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param q
	 *            (optional) gets the POI whose name or description matched the
	 *            pattern
	 * @param total (optional) number of pois
	 * @return List<Poi>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POI> GetWhere(Context context, Integer[] categories,
			Integer[] POIS, String city, String country, String postal_code,
			String q, Integer total) throws IOException, TopoosException {
		return Translator.GetWhere(context, categories, POIS, city, country,
				postal_code, q, total);
	}

	/**
	 * * Upgrade the point of interest with the new information provided. If you
	 * want to erase a parameter must be included in the call, but without
	 * providing a value (null).
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POIID
	 *            (Can not be null) POI identifier we want to update
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param desc
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Update(Context context, Integer POIID, String name,
			Double lat, Double lng, Boolean geocode, Integer[] categories, Double accuracy,
			Double vaccuracy, Double elevation, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.Update(context, POIID, name, lat, lng, geocode, categories,
				accuracy, vaccuracy, elevation, desc, address, cross_street,
				city, country, postal_code, phone, twitter);
	}

	/**
	 * Deletes a point of interest
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POIID
	 *            (Can not be null) POI identifier we want to update
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Delete(Context context, Integer POIID)
			throws IOException, TopoosException {
		return Translator.Delete(context, POIID);
	}

}
