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

package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;


/**
 * The Class POICategoryCollectionResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class POICategoryCollectionResult extends APICallResult {

	/** The poi category collection. */
	private POICategoryCollection poiCategoryCollection = null;

	/**
	 * Instantiates a new pOI category collection result.
	 */
	public POICategoryCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category collection result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public POICategoryCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category collection result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param poiCategoryCollection
	 *            the poi category collection
	 */
	public POICategoryCollectionResult(String error, String result,
			POICategoryCollection poiCategoryCollection) {
		super(error, result);
		this.poiCategoryCollection = poiCategoryCollection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		Integer id = null;
		String description = null;
		Boolean isSystem = null;
		POICategory poiCategory = null;
		JSONObject jObject = null;
		if (APIUtils.getcorrectJSONARRAYstring(Result) != null) {
			ArrayList<POICategory> arraylist = new ArrayList<POICategory>();
			try {
				JSONArray jArray = (JSONArray) new JSONTokener(
						APIUtils.getcorrectJSONARRAYstring(Result)).nextValue();
				for (int i = 0; i < jArray.length(); i++) {
					jObject = jArray.getJSONObject(i);
					// Extracting content
					id = APIUtils.getIntegerorNull(jObject, "Id");
					description = APIUtils.getStringorNull(jObject,
							"Description");
					isSystem = jObject.getBoolean("is_system_category");
					poiCategory = new POICategory(id, description, isSystem);
					arraylist.add(poiCategory);
				}
				this.poiCategoryCollection = new POICategoryCollection(
						arraylist);
			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
	}

	/**
	 * Gets the poi category collection.
	 * 
	 * @return the poiCategoryCollection
	 */
	public POICategoryCollection getPoiCategoryCollection() {
		return poiCategoryCollection;
	}

	/**
	 * Sets the poi category collection.
	 * 
	 * @param poiCategoryCollection
	 *            the poiCategoryCollection to set
	 */
	public void setPoiCategoryCollection(
			POICategoryCollection poiCategoryCollection) {
		this.poiCategoryCollection = poiCategoryCollection;
	}

}
