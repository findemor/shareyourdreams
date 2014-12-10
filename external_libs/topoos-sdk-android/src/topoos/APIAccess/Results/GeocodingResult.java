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
 * @see APICallResult
 * @author topoos
 *
 */
public class GeocodingResult extends APICallResult{

	ArrayList<GeocodingData> geocoding=null;
	
	
	
	/**
	 * 
	 */
	public GeocodingResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param error
	 * @param result
	 */
	public GeocodingResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param error
	 * @param result
	 * @param geocoding
	 */
	public GeocodingResult(String error, String result,
			ArrayList<GeocodingData> geocoding) {
		super(error, result);
		this.geocoding = geocoding;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		if (APIUtils.getcorrectJSONARRAYstring(Result) != null) {
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(APIUtils.getcorrectJSONARRAYstring(Result))
					.nextValue();
			// Extracting content
			this.geocoding=new ArrayList<GeocodingData>();
			for(int i=0;i<jArray.length();i++){
				JSONObject jObject=jArray.getJSONObject(i);
				JSONObject jObjectAddress=jObject.optJSONObject("address");
				JSONObject jObjectLocation=jObject.optJSONObject("location");
				JSONObject jObjectBounds=jObject.optJSONObject("bounds");
				JSONObject jObjectSouthwest=null;
				JSONObject jObjectNortheast=null;
				if(jObjectBounds!=null){
					jObjectSouthwest=jObjectBounds.optJSONObject("southwest");
					jObjectNortheast=jObjectBounds.optJSONObject("northeast");
				}
				if(jObjectAddress!=null||jObjectLocation!=null|| jObjectSouthwest!=null||jObjectNortheast!=null){
					this.geocoding.add(
							new GeocodingData(jObjectAddress!=null?new Address(
									APIUtils.getStringorNull(jObjectAddress,"address"),
									APIUtils.getStringorNull(jObjectAddress,"cross_street"),
									APIUtils.getStringorNull(jObjectAddress,"state"),
									APIUtils.getStringorNull(jObjectAddress,"administrative_area"),
									APIUtils.getStringorNull(jObjectAddress,"country"),
									APIUtils.getStringorNull(jObjectAddress,"postal_code")):null, jObjectLocation!=null?
							new Location(jObjectLocation.optDouble("latitude"),
									jObjectLocation.optDouble("longitude")):null, jObjectBounds==null? null:(
											jObjectNortheast!=null&&jObjectSouthwest!=null?
							new ViewportType(new Location(jObjectSouthwest.optDouble("latitude"),
									jObjectSouthwest.optDouble("longitude")),new Location(jObjectNortheast.optDouble("latitude"),
											jObjectNortheast.optDouble("longitude"))):null)));
				}
				
			}

		} catch (Exception e) {
			if (Constants.DEBUG){
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
	 * @return the geocoding
	 */
	public ArrayList<GeocodingData> getGeocoding() {
		return geocoding;
	}



	/**
	 * @param geocoding the geocoding to set
	 */
	public void setGeocoding(ArrayList<GeocodingData> geocoding) {
		this.geocoding = geocoding;
	}

	
	
	
}
