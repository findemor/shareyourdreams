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
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * The Class Translator.
 */
class Translator {
	
	/** The method. */
	private static String method = "GET";
	
	/** The format. */
	private static String format = "json";
	
	/** The version. */
	private static Integer version = topoos.Constants.APIVERSION;

	/**
	 * Gets the.
	 *
	 * @param POISID the poisid
	 * @param type the type
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> Get(Integer[] POISID, String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		List<POIDataWarning> pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			String strPOIID = "";
			if (POISID != null) {
				for (int i = 0; i < POISID.length; i++) {
					if (i < POISID.length - 1) {
						strPOIID = strPOIID + POISID[i] + ",";
					} else {
						strPOIID = strPOIID + POISID[i];
					}
				}
			}
			POISWarning pOISWarning = new POISWarning("Get", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					strPOIID, type);
			POIWarningCollectionResult pOIWarningCollectionResult = new POIWarningCollectionResult();
			APICaller.ExecuteOperation(pOISWarning, pOIWarningCollectionResult);
			pOIWarning = pOIWarningCollectionResult.getPOIDataWarnings();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	/**
	 * Gets the all.
	 *
	 * @param type the type
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> GetAll(String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		List<POIDataWarning> pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarning pOISWarning = new POISWarning("GetAll", method, format,
					version, accessTokenPregenerated.getAccessToken(), null,
					type);
			POIWarningCollectionResult pOIWarningCollectionResult = new POIWarningCollectionResult();
			APICaller.ExecuteOperation(pOISWarning, pOIWarningCollectionResult);
			pOIWarning = pOIWarningCollectionResult.getPOIDataWarnings();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	/**
	 * Adds the closed.
	 *
	 * @param POI_ID the poi id
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddClosed(Integer POI_ID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddClosed",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_CLOSED);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	/**
	 * Adds the duplicated.
	 *
	 * @param POI_ID the poi id
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddDuplicated(Integer POI_ID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("GetAll",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_DUPLICATED);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	/**
	 * Adds the wrong indicator.
	 *
	 * @param POI_ID the poi id
	 * @param lat the lat
	 * @param lng the lng
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongIndicator(Integer POI_ID, Double lat,
			Double lng, Double accuracy, Double vaccuracy, Double elevation,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd(
					"AddWrongIndicator", method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_WRONG_INDICATOR, lat, lng, accuracy,
					vaccuracy, elevation);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	/**
	 * Adds the wrong info.
	 *
	 * @param POI_ID the poi id
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
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongInfo(Integer POI_ID, String name,
			Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			String strcategories = "";
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					if (i < categories.length - 1) {
						strcategories = strcategories + categories[i] + ",";
					} else {
						strcategories = strcategories + categories[i];
					}
				}
			}
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddWrongInfo",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_WRONG_INFO,
					!strcategories.equals("") ? strcategories : null, name,
					desc, address, cross_street, city, country, postal_code,
					phone, twitter);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	/**
	 * Delete.
	 *
	 * @param POISID the poisid
	 * @param type the type
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(Integer[] POISID, String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Boolean delete = null;
		if (accessTokenPregenerated.isValid()) {
			String strPOIID = "";
			if (POISID != null) {
				for (int i = 0; i < POISID.length; i++) {
					if (i < POISID.length - 1) {
						strPOIID = strPOIID + POISID[i] + ",";
					} else {
						strPOIID = strPOIID + POISID[i];
					}
				}
			}
			POISWarningDelete pOISWarningDelete = new POISWarningDelete(
					"Delete", method, format, version,
					accessTokenPregenerated.getAccessToken(),
					!strPOIID.equals("") ? strPOIID : null, type);
			GenericResult genenicResult = new GenericResult();
			APICaller.ExecuteOperation(pOISWarningDelete, genenicResult);
			delete = genenicResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	/**
	 * Delete all.
	 *
	 * @param type the type
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean DeleteAll(String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Boolean delete = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningDelete pOISWarningDelete = new POISWarningDelete(
					"DeleteAll", method, format, version,
					accessTokenPregenerated.getAccessToken(), null, type);
			GenericResult genenicResult = new GenericResult();
			APICaller.ExecuteOperation(pOISWarningDelete, genenicResult);
			delete = genenicResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	/**
	 * Gets the.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @param type the type
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> Get(Context context, Integer[] POIID,
			String type) throws IOException, TopoosException {
		return Get(POIID, type, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Gets the all.
	 *
	 * @param context the context
	 * @param type the type
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POIDataWarning> GetAll(Context context, String type)
			throws IOException, TopoosException {
		return GetAll(type, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Adds the closed.
	 *
	 * @param context the context
	 * @param POI_ID the poi id
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddClosed(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		return AddClosed(POI_ID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Adds the duplicated.
	 *
	 * @param context the context
	 * @param POI_ID the poi id
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddDuplicated(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		return AddDuplicated(POI_ID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Adds the wrong indicator.
	 *
	 * @param context the context
	 * @param POI_ID the poi id
	 * @param lat the lat
	 * @param lng the lng
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongIndicator(Context context, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) throws IOException, TopoosException {
		return AddWrongIndicator(POI_ID, lat, lng, accuracy, vaccuracy,
				elevation, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Adds the wrong info.
	 *
	 * @param context the context
	 * @param POI_ID the poi id
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
	 * @return the pOI warning
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POIWarning AddWrongInfo(Context context, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return AddWrongInfo(POI_ID, name, categories, desc, address,
				cross_street, city, country, postal_code, phone, twitter,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Delete.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @param type the type
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(Context context, Integer[] POIID, String type)
			throws IOException, TopoosException {
		return Delete(POIID, type, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Delete all.
	 *
	 * @param context the context
	 * @param type the type
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean DeleteAll(Context context, String type)
			throws IOException, TopoosException {
		return DeleteAll(type, AccessTokenOAuth.GetAccessToken(context));
	}
}
