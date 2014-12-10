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

import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;


/**
 * The Class POICategoryResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class POICategoryResult extends APICallResult {

	/** The poi category. */
	private POICategory poiCategory = null;

	/**
	 * Instantiates a new pOI category result.
	 */
	public POICategoryResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public POICategoryResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param poiCategory
	 *            the poi category
	 */
	public POICategoryResult(String error, String result,
			POICategory poiCategory) {
		super(error, result);
		this.poiCategory = poiCategory;
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
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				id = APIUtils.getIntegerorNull(jObject, "Id");

				description = APIUtils.getStringorNull(jObject, "Description");
				isSystem = jObject.getBoolean("is_system_category");
				this.poiCategory = new POICategory(id, description, isSystem);
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
	 * Gets the poi category.
	 * 
	 * @return the poiCategory
	 */
	public POICategory getPoiCategory() {
		return poiCategory;
	}

	/**
	 * Sets the poi category.
	 * 
	 * @param poiCategory
	 *            the poiCategory to set
	 */
	public void setPoiCategory(POICategory poiCategory) {
		this.poiCategory = poiCategory;
	}

}