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
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * The Class PositionCollectionResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class PositionCollectionResult extends APICallResult {

	/** The positions. */
	List<Position> positions = null;

	
	/**
	 * Instantiates a new position collection result.
	 */
	public PositionCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * Instantiates a new position collection result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public PositionCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Instantiates a new position collection result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param positions the positions
	 */
	public PositionCollectionResult(String error, String result,
			List<Position> positions) {
		super(error, result);
		this.positions = positions;
	}


	/**
	 * Parses the position.
	 *
	 * @param job the job
	 * @return the position
	 * @throws TopoosException the topoos exception
	 */
	private Position parsePosition(JSONObject job) throws TopoosException{
		Position position=null;
		Integer id = null;
		String device = null;
		Date timestamp = null;
		Date registerTime = null;
		Double latitude = null;
		Double longitude = null;
		Double elevation = null;
		PositionType positionType = null;
		Double accuracy = null;
		Double vaccuracy = null;
		Double bearing = null;
		Double velocity = null;
		String track_id = null;
		try {
			JSONObject jObject = job;
			// Extracting content
			id = APIUtils.getIntegerorNull(jObject,"id");
			device = APIUtils.getStringorNull(jObject,"device");
			latitude = APIUtils.getDoubleorNull(jObject,"latitude");
			longitude = APIUtils.getDoubleorNull(jObject,"longitude");
			elevation = APIUtils.getDoubleorNull(jObject,"elevation");
			accuracy = APIUtils.getDoubleorNull(jObject,"accuracy");
			vaccuracy = APIUtils.getDoubleorNull(jObject,"vaccuracy");
			bearing = APIUtils.getDoubleorNull(jObject,"bearing");
			velocity = APIUtils.getDoubleorNull(jObject,"velocity");
			track_id = APIUtils.getStringorNull(jObject,"track_id");
			timestamp = APIUtils.toDateString(jObject
					.getString("timestamp"));
			registerTime = APIUtils.toDateString(jObject
					.getString("registerTime"));
			positionType = new PositionType(jObject.getJSONObject(
					"position_type").getString("id"), jObject.getJSONObject(
					"position_type").getString("description"));
			
			position= new Position( id,  device,
					 timestamp,  registerTime,  latitude,
					 longitude,  elevation,  positionType,
					 accuracy,  vaccuracy,  bearing,  velocity,
					 track_id);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
		return position;
	}



	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		if (APIUtils.getcorrectJSONARRAYstring(Result) != null) {
		ArrayList<Position> array=null;
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(APIUtils.getcorrectJSONARRAYstring(Result))
					.nextValue();
			array = new ArrayList<Position>();
			// Extracting content
			for (int i = 0; i < jArray.length(); i++) {
				array.add(parsePosition(jArray.getJSONObject(i)));
			}
			//this.checkinCollection=new CheckinCollection(array);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
		this.positions=array;
	} else {
		if (Constants.DEBUG) {
			Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
		}
	}
	}



	/**
	 * Gets the positions.
	 *
	 * @return the positions
	 */
	public List<Position> getPositions() {
		return positions;
	}



	/**
	 * Sets the positions.
	 *
	 * @param positions the positions to set
	 */
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	
	
}
