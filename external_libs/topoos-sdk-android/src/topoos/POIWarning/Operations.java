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

package topoos.POIWarning;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.Operations.POISWarningAdd;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * Operations related to POI Warnings management.
 * 
 * @author topoos
 * 
 */
public class Operations {

	/** The Constant TYPE_CLOSED. */
	public static final String TYPE_CLOSED = POISWarningAdd.TYPE_CLOSED;
	
	/** The Constant TYPE_DUPLICATED. */
	public static final String TYPE_DUPLICATED = POISWarningAdd.TYPE_DUPLICATED;
	
	/** The Constant TYPE_WRONG_INDICATOR. */
	public static final String TYPE_WRONG_INDICATOR = POISWarningAdd.TYPE_WRONG_INDICATOR;
	
	/** The Constant TYPE_WRONG_INFO. */
	public static final String TYPE_WRONG_INFO = POISWarningAdd.TYPE_WRONG_INFO;

	/**
	 * Gets the list of error messages related to a point of interest.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param POISID (optional) List of identifier whose warnings POI want to
	 * retrieve.
	 * @param type (optional) List of type whose warnings POI want to retrieve.
	 * @return List<POIDataWarning>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> Get(
			AccessTokenOAuth accessTokenPregenerated, Integer[] POISID,
			String type) throws IOException, TopoosException {
		return Translator.Get(POISID, type, accessTokenPregenerated);
	}

	/**
	 * Gets the list of all error messages related to a type.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param type (required) Type of warning (TYPE_CLOSED, TYPE_DUPLICATED,
	 * TYPE_WRONG_INDICATOR, TYPE_WRONG_INFO)
	 * @return List<POIDataWarning>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> GetAll(
			AccessTokenOAuth accessTokenPregenerated, String type)
			throws IOException, TopoosException {
		return Translator.GetAll(type, accessTokenPregenerated);
	}

	/**
	 * Adds the closed.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddClosed(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddClosed(POI_ID, accessTokenPregenerated);
	}

	/**
	 * Adds the duplicated.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddDuplicated(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddDuplicated(POI_ID, accessTokenPregenerated);
	}

	/**
	 * Adds the wrong indicator.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @param lat the lat
	 * @param lng the lng
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongIndicator(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) throws IOException, TopoosException {
		return Translator.AddWrongIndicator(POI_ID, lat, lng, accuracy,
				vaccuracy, elevation, accessTokenPregenerated);
	}

	/**
	 * Adds the wrong info.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @param name the name
	 * @param categories the categories
	 * @param desc the desc
	 * @param address the address
	 * @param cross_street the cross_street
	 * @param city the city
	 * @param country the country
	 * @param postal_code the postal_code
	 * @param phone the phone
	 * @param twitter the twitter
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongInfo(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.AddWrongInfo(POI_ID, name, categories, desc, address,
				cross_street, city, country, postal_code, phone, twitter,
				accessTokenPregenerated);
	}

	/**
	 * Delete.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param POISID the poisid
	 * @param type the type
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(AccessTokenOAuth accessTokenPregenerated,
			Integer[] POISID, String type) throws IOException, TopoosException {
		return Translator.Delete(POISID, type, accessTokenPregenerated);
	}

	/**
	 * Delete all.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param type the type
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean DeleteAll(AccessTokenOAuth accessTokenPregenerated,
			String type) throws IOException, TopoosException {
		return Translator.DeleteAll(type, accessTokenPregenerated);
	}

	/**
	 * Gets the.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param POIID (optional) List of identifier whose warnings POI want to
	 * retrieve.
	 * @param type (optional) List of type whose warnings POI want to retrieve.
	 * @return List<POIDataWarning>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> Get(Context context, Integer[] POIID,
			String type) throws IOException, TopoosException {
		return Translator.Get(context, POIID, type);
	}

	/**
	 * Gets the all.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param type (required) Type of warning (TYPE_CLOSED, TYPE_DUPLICATED,
	 * TYPE_WRONG_INDICATOR, TYPE_WRONG_INFO)
	 * @return List<POIDataWarning>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> GetAll(Context context, String type)
			throws IOException, TopoosException {
		return Translator.GetAll(context, type);
	}

	/**
	 * Adds the closed.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddClosed(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddClosed(context, POI_ID);
	}

	/**
	 * Adds the duplicated.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddDuplicated(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddDuplicated(context, POI_ID);
	}

	/**
	 * Adds the wrong indicator.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @param lat the lat
	 * @param lng the lng
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongIndicator(Context context, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) throws IOException, TopoosException {
		return Translator.AddWrongIndicator(context, POI_ID, lat, lng,
				accuracy, vaccuracy, elevation);
	}

	/**
	 * Adds the wrong info.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param POI_ID (required) POI ID that we assign this warning.
	 * @param name the name
	 * @param categories the categories
	 * @param desc the desc
	 * @param address the address
	 * @param cross_street the cross_street
	 * @param city the city
	 * @param country the country
	 * @param postal_code the postal_code
	 * @param phone the phone
	 * @param twitter the twitter
	 * @return POIWarning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongInfo(Context context, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.AddWrongInfo(context, POI_ID, name, categories, desc,
				address, cross_street, city, country, postal_code, phone,
				twitter);
	}

	/**
	 * Delete.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param POIID the poiid
	 * @param type the type
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(Context context, Integer[] POIID, String type)
			throws IOException, TopoosException {
		return Translator.Delete(context, POIID, type);
	}

	/**
	 * Delete all.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param type the type
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean DeleteAll(Context context, String type)
			throws IOException, TopoosException {
		return Translator.DeleteAll(context, type);
	}

}
