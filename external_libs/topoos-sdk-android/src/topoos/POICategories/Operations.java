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

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Operations.POISWarning;
import topoos.Exception.TopoosException;
import topoos.Objects.POICategory;
import android.content.Context;

/**
 * Operations related to POICategories management.
 *
 * @author topoos
 */
public class Operations {

	/** The Constant TYPE_CLOSED. */
	public static final String TYPE_CLOSED = POISWarning.TYPE_CLOSED;
	
	/** The Constant TYPE_DUPLICATED. */
	public static final String TYPE_DUPLICATED = POISWarning.TYPE_DUPLICATED;
	
	/** The Constant TYPE_WRONG_INDICATOR. */
	public static final String TYPE_WRONG_INDICATOR = POISWarning.TYPE_WRONG_INDICATOR;
	
	/** The Constant TYPE_WRONG_INFO. */
	public static final String TYPE_WRONG_INFO = POISWarning.TYPE_WRONG_INFO;

	/**
	 * Gets the list of POI categories.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @return List<POICategory>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POICategory> GetAll(
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.GetAll(accessTokenPregenerated);
	}

	/**
	 * Create a new category of POIs.
	 *
	 * @param accessTokenPregenerated (required) Access_token to root resources
	 * @param description (required) Category description
	 * @return POICategory
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POICategory Add(AccessTokenOAuth accessTokenPregenerated,
			String description) throws IOException, TopoosException {
		return Translator.Add(description, accessTokenPregenerated);
	}

	/**
	 * Updates the description of a category. The category must belong to the
	 * application.
	 *
	 * @param accessTokenPregenerated (required) Access_token to root resources
	 * @param categoryID (required) Category ID to modify
	 * @param description (required) Category description
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Update(AccessTokenOAuth accessTokenPregenerated,
			Integer categoryID, String description) throws IOException,
			TopoosException {
		return Translator.Update(categoryID, description, accessTokenPregenerated);
	}

	/**
	 * Deletes a POI category. The category will no longer appear as a result of
	 * queries, but the points of interest will remain associated with the
	 * deleted category if they were already above. The category must belong to
	 * the application.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param categoryID (required) Category ID to delete
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(AccessTokenOAuth accessTokenPregenerated,
			Integer categoryID) throws IOException, TopoosException {
		return Translator.Delete(categoryID, accessTokenPregenerated);
	}

	/**
	 * Gets the list of POI categories.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @return List<POICategory>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<POICategory> GetAll(Context context) throws IOException,
			TopoosException {
		return Translator.GetAll(context);
	}

	/**
	 * Create a new category of POIs.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param name (required) Category description
	 * @return POICategory
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static POICategory Add(Context context, String name)
			throws IOException, TopoosException {
		return Translator.Add(context, name);
	}


	/**
	 * Update.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param categoryID (required) Category ID to modify
	 * @param description (required) New description of category
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Update(Context context, Integer categoryID,
			String description) throws IOException, TopoosException {
		return Translator.Update(context, categoryID, description);
	}

	/**
	 * Deletes a POI category. The category will no longer appear as a result of
	 * queries, but the points of interest will remain associated with the
	 * deleted category if they were already above. The category must belong to
	 * the application.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param categoryID (required) Category ID to delete
	 * @return Boolean
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Boolean Delete(Context context, Integer categoryID)
			throws IOException, TopoosException {
		return Translator.Delete(context, categoryID);
	}

}
