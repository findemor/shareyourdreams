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
 * The Class POIWarningCollectionResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class POIWarningCollectionResult extends APICallResult {

	/** The POI data warnings. */
	private ArrayList<POIDataWarning> POIDataWarnings = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		if (APIUtils.getcorrectJSONARRAYstring(Result) != null) {
			try {
				JSONArray jArray = (JSONArray) new JSONTokener(
						APIUtils.getcorrectJSONARRAYstring(Result)).nextValue();
				// Extracting content
				this.POIDataWarnings = new ArrayList<POIDataWarning>();
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject jPOI = jArray.getJSONObject(i).getJSONObject(
							"current");
					ArrayList<POICategory> categories = new ArrayList<POICategory>();
					JSONArray jArrayCategories = jPOI
							.getJSONArray("categories");
					for (int j = 0; j < jArrayCategories.length(); j++) {
						categories
								.add(new POICategory(
										APIUtils.getIntegerorNull(
												jArrayCategories
														.getJSONObject(j), "Id"),
										APIUtils.getStringorNull(
												jArrayCategories
														.getJSONObject(j),
												"Description"),
										APIUtils.getBooleanorNull(
												jArrayCategories
														.getJSONObject(j),
												"is_system_category")));
					}
					POIWarningCount warningcount = new POIWarningCount(
							APIUtils.getIntegerorNull(
									jPOI.getJSONObject("warnings"), "closed"),
							APIUtils.getIntegerorNull(
									jPOI.getJSONObject("warnings"),
									"duplicated"),
							APIUtils.getIntegerorNull(
									jPOI.getJSONObject("warnings"),
									"wrongIndicator"),
							APIUtils.getIntegerorNull(
									jPOI.getJSONObject("warnings"), "wrongInfo"));
					// POI
					POI poi = new POI(
							jPOI.getInt("id"),
							APIUtils.getStringorNull(jPOI, "name"),
							APIUtils.getStringorNull(jPOI, "description"),
							APIUtils.getDoubleorNull(jPOI, "latitude"),
							APIUtils.getDoubleorNull(jPOI, "longitude"),
							APIUtils.getDoubleorNull(jPOI, "elevation"),
							APIUtils.getDoubleorNull(jPOI, "accuracy"),
							APIUtils.getDoubleorNull(jPOI, "vaccuracy"),
							APIUtils.toDateString(jPOI
									.getString("registertime")),
							categories,
							APIUtils.getStringorNull(jPOI, "address"),
							APIUtils.getStringorNull(jPOI, "crossStreet"),
							APIUtils.getStringorNull(jPOI, "city"),
							APIUtils.getStringorNull(jPOI, "country"),
							APIUtils.getStringorNull(jPOI, "postalCode"),
							APIUtils.getStringorNull(jPOI, "phone"),
							APIUtils.getStringorNull(jPOI, "twitter"),
							APIUtils.toDateString(APIUtils.getStringorNull(jPOI,"lastUpdate")),
							warningcount);
					JSONArray jArrayWarnings = jArray.getJSONObject(i)
							.getJSONArray("warnings");
					// ArrayList<POIWarning>
					ArrayList<POIWarning> arrayPOIWarnings = new ArrayList<POIWarning>();
					for (int j = 0; j < jArrayWarnings.length(); j++) {
						JSONObject jPOIwarning = jArrayWarnings
								.getJSONObject(j);
						POIWarningData poiWarningData = null;
						if (jPOIwarning.optJSONObject("data") != null) {
							JSONArray jPOIwarningCategories = jPOIwarning
									.getJSONObject("data").getJSONArray(
											"categories");
							ArrayList<POICategory> arrayCategories = new ArrayList<POICategory>();
							for (int z = 0; z < jPOIwarningCategories.length(); z++) {
								arrayCategories.add(new POICategory(APIUtils
										.getIntegerorNull(jPOIwarningCategories
												.getJSONObject(z), "Id"),
										APIUtils.getStringorNull(
												jPOIwarningCategories
														.getJSONObject(z),
												"Description"),
										APIUtils.getBooleanorNull(
												jPOIwarningCategories
														.getJSONObject(z),
												"is_system_category")));
							}
							poiWarningData = new POIWarningData(
									APIUtils.getIntegerorNull(
											jPOIwarning.optJSONObject("data"),
											"id"), APIUtils.getDoubleorNull(
											jPOIwarning.optJSONObject("data"),
											"latitude"),
									APIUtils.getDoubleorNull(
											jPOIwarning.optJSONObject("data"),
											"longitude"),
									APIUtils.getDoubleorNull(
											jPOIwarning.optJSONObject("data"),
											"accuracy"),
									APIUtils.getDoubleorNull(
											jPOIwarning.optJSONObject("data"),
											"vaccuracy"),
									APIUtils.getDoubleorNull(
											jPOIwarning.optJSONObject("data"),
											"elevation"),
									APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"name"), APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"address"),
									APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"cross_street"),
									APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"city"), APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"country"),
									APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"postal_code"),
									APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"phone"), APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"twitter"),
									APIUtils.getStringorNull(
											jPOIwarning.optJSONObject("data"),
											"description"), arrayCategories);
						}

						POIWarning poiwarning = new POIWarning(
								APIUtils.getIntegerorNull(jPOIwarning, "id"),
								APIUtils.getIntegerorNull(jPOIwarning, "poi_id"),
								APIUtils.getStringorNull(jPOIwarning, "type"),
								APIUtils.getStringorNull(jPOIwarning, "user_id"),
								APIUtils.toDateString(jPOIwarning
										.getString("timestamp")),
								poiWarningData);
						arrayPOIWarnings.add(poiwarning);
					}
					POIDataWarnings.add(new POIDataWarning(poi,
							arrayPOIWarnings));
				}

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
	 * Gets the pOI data warnings.
	 * 
	 * @return the pOIDataWarnings
	 */
	public ArrayList<POIDataWarning> getPOIDataWarnings() {
		return POIDataWarnings;
	}

	/**
	 * Sets the pOI data warnings.
	 * 
	 * @param pOIDataWarnings
	 *            the pOIDataWarnings to set
	 */
	public void setPOIDataWarnings(ArrayList<POIDataWarning> pOIDataWarnings) {
		POIDataWarnings = pOIDataWarnings;
	}

}
