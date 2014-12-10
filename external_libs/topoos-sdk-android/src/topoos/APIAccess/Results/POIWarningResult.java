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
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;


/**
 * The Class POIWarningResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class POIWarningResult extends APICallResult {

	/** The poi warning. */
	POIWarning poiWarning = null;

	/**
	 * Instantiates a new pOI warning result.
	 */
	public POIWarningResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI warning result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public POIWarningResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI warning result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param poiWarning
	 *            the poi warning
	 */
	public POIWarningResult(String error, String result, POIWarning poiWarning) {
		super(error, result);
		this.poiWarning = poiWarning;
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
		Integer poi_id = null;
		String type = null;
		String user_id = null;
		Date timestamp = null;
		POIWarningData data = null;

		Integer id_warningdata = null;
		Double latitude = null;
		Double longitude = null;
		Double accuracy = null;
		Double vaccuracy = null;
		Double elevation = null;
		String name = null;
		String address = null;
		String cross_street = null;
		String city = null;
		String country = null;
		String postal_code = null;
		String phone = null;
		String twitter = null;
		String description = null;
		ArrayList<POICategory> categories = null;
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				id = APIUtils.getIntegerorNull(jObject, "id");
				poi_id = APIUtils.getIntegerorNull(jObject, "poi_id");
				type = APIUtils.getStringorNull(jObject, "type");
				user_id = APIUtils.getStringorNull(jObject, "user_id");
				timestamp = APIUtils.toDateString(APIUtils.getStringorNull(
						jObject, "timestamp"));
				JSONObject jObjectData = jObject.optJSONObject("data");
				if (jObjectData != null) {
					id_warningdata = APIUtils.getIntegerorNull(jObjectData,
							"id");
					latitude = APIUtils
							.getDoubleorNull(jObjectData, "latitude");
					longitude = APIUtils.getDoubleorNull(jObjectData,
							"longitude");
					elevation = APIUtils.getDoubleorNull(jObjectData,
							"elevation");
					name = APIUtils.getStringorNull(jObjectData, "name");
					accuracy = APIUtils
							.getDoubleorNull(jObjectData, "accuracy");
					vaccuracy = APIUtils.getDoubleorNull(jObjectData,
							"vaccuracy");
					address = APIUtils.getStringorNull(jObjectData, "address");
					cross_street = APIUtils.getStringorNull(jObjectData,
							"cross_street");
					city = APIUtils.getStringorNull(jObjectData, "city");
					country = APIUtils.getStringorNull(jObjectData, "country");
					postal_code = APIUtils.getStringorNull(jObjectData,
							"postal_code");
					phone = APIUtils.getStringorNull(jObjectData, "phone");
					twitter = APIUtils.getStringorNull(jObjectData, "twitter");
					description = APIUtils.getStringorNull(jObjectData,
							"description");
					categories = new ArrayList<POICategory>();
					JSONArray jArray = jObjectData.optJSONArray("categories");
					if (jArray != null) {
						for (int i = 0; i < jArray.length(); i++) {
							JSONObject job = jArray.getJSONObject(i);
							categories
									.add(new POICategory(
											APIUtils
											.getIntegerorNull(job,"Id"),
											APIUtils.getStringorNull(job,
													"Description"),
													APIUtils
													.getBooleanorNull(job,"is_system_category")));
						}
					}
					data = new POIWarningData(id_warningdata, latitude,
							longitude, accuracy, vaccuracy, elevation, name,
							address, cross_street, city, country, postal_code,
							phone, twitter, description, categories);
				}
				this.poiWarning = new POIWarning(id, poi_id, type, user_id,
						timestamp, data);
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
	 * Gets the poi warning.
	 * 
	 * @return the poiWarning
	 */
	public POIWarning getPoiWarning() {
		return poiWarning;
	}

	/**
	 * Sets the poi warning.
	 * 
	 * @param poiWarning
	 *            the poiWarning to set
	 */
	public void setPoiWarning(POIWarning poiWarning) {
		this.poiWarning = poiWarning;
	}

}
