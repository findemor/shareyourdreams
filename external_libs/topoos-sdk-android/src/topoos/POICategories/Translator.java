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

package topoos.POICategories;

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
 *
 * @author topoos
 */
class Translator {

	/** The method. */
	private static String method = "GET";
	
	/** The format. */
	private static String format = "json";
	
	/** The version. */
	private static Integer version = topoos.Constants.APIVERSION;

	/**
	 * Gets the all.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POICategory> GetAll(
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		List<POICategory> GetAll = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategories pOISCategories = new POISCategories("GetAll",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), true);
			POICategoryCollectionResult pOICategoryCollectionResult = new POICategoryCollectionResult();
			APICaller.ExecuteOperation(pOISCategories,
					pOICategoryCollectionResult);
			GetAll = pOICategoryCollectionResult.getPoiCategoryCollection()
					.getCategories();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return GetAll;
	}

	/**
	 * Adds the.
	 *
	 * @param description the description
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the pOI category
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POICategory Add(String description,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POICategory pOICategory = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesAdd pOISCategoriesAdd = new POISCategoriesAdd("Add",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), description);
			POICategoryResult pOICategoryResult = new POICategoryResult();
			APICaller.ExecuteOperation(pOISCategoriesAdd, pOICategoryResult);
			pOICategory = pOICategoryResult.getPoiCategory();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOICategory;
	}

	/**
	 * Update.
	 *
	 * @param categoryID the category id
	 * @param description the description
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Update(Integer categoryID, String description,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POICategory pOICategory = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesUpdate pOISCategoriesUpdate = new POISCategoriesUpdate(
					"Update", method, format, version,
					accessTokenPregenerated.getAccessToken(), description,categoryID);
			POICategoryResult pOICategoryResult = new POICategoryResult();
			APICaller.ExecuteOperation(pOISCategoriesUpdate, pOICategoryResult);
			pOICategory = pOICategoryResult.getPoiCategory();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOICategory != null;
	}

	/**
	 * Delete.
	 *
	 * @param categoryID the category id
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(Integer categoryID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean delete = false;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesDelete pOISCategoriesDelete = new POISCategoriesDelete(
					"Delete", method, format, version,
					accessTokenPregenerated.getAccessToken(), categoryID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(pOISCategoriesDelete, genericResult);
			delete = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	/**
	 * Gets the all.
	 *
	 * @param context the context
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POICategory> GetAll(Context context) throws IOException,
			TopoosException {
		return GetAll(AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Adds the.
	 *
	 * @param context the context
	 * @param name the name
	 * @return the pOI category
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POICategory Add(Context context, String name)
			throws IOException, TopoosException {
		return Add(name, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Update.
	 *
	 * @param context the context
	 * @param categoryID the category id
	 * @param description the description
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Update(Context context, Integer categoryID,
			String description) throws IOException, TopoosException {
		return Update(categoryID, description, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Delete.
	 *
	 * @param context the context
	 * @param categoryID the category id
	 * @return the boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(Context context, Integer categoryID)
			throws IOException, TopoosException {
		return Delete(categoryID, AccessTokenOAuth.GetAccessToken(context));
	}

}
