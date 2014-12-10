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
 * The Class TrackResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class TrackResult extends APICallResult {

	/** The track. */
	private Track track = null;

	/**
	 * Instantiates a new track result.
	 */
	public TrackResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new track result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public TrackResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new track result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param track
	 *            the track
	 */
	public TrackResult(String error, String result, Track track) {
		super(error, result);
		this.track = track;
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
		String name = null;
		Integer device = null;
		ArrayList<Position> positions = null;
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {

				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				id = APIUtils.getIntegerorNull(jObject, "id");
				device = APIUtils.getIntegerorNull(jObject, "device");
				name = APIUtils.getStringorNull(jObject, "name");

				positions = new ArrayList<Position>();
				if (jObject.optJSONArray("positions") != null) {
					JSONArray jArrayPositions = jObject
							.getJSONArray("positions");
					for (int i = 0; i < jArrayPositions.length(); i++) {
						Integer id_pos = null;
						String device_pos = null;
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
						JSONObject jObjectPosition = (JSONObject) new JSONTokener(
								Result).nextValue();
						// Extracting content
						id_pos = APIUtils.getIntegerorNull(jObjectPosition,
								"id");
						device_pos = APIUtils.getStringorNull(jObjectPosition,
								"device");
						latitude = APIUtils.getDoubleorNull(jObjectPosition,
								"latitude");
						longitude = APIUtils.getDoubleorNull(jObjectPosition,
								"longitude");
						elevation = APIUtils.getDoubleorNull(jObjectPosition,
								"elevation");
						accuracy = APIUtils.getDoubleorNull(jObjectPosition,
								"accuracy");
						vaccuracy = APIUtils.getDoubleorNull(jObjectPosition,
								"vaccuracy");
						bearing = APIUtils.getDoubleorNull(jObjectPosition,
								"bearing");
						velocity = APIUtils.getDoubleorNull(jObjectPosition,
								"velocity");
						track_id = APIUtils.getStringorNull(jObjectPosition,
								"track_id");
						timestamp = APIUtils.toDateString(jObjectPosition
								.getString("timestamp"));
						registerTime = APIUtils.toDateString(jObjectPosition
								.getString("registerTime"));
						positionType = new PositionType(
								APIUtils.getStringorNull(jObjectPosition
										.getJSONObject("positiotype"), "id"),
								APIUtils.getStringorNull(jObjectPosition
										.getJSONObject("positiotype"),
										"description"));

						positions.add(new Position(id_pos, device_pos,
								timestamp, registerTime, latitude, longitude,
								elevation, positionType, accuracy, vaccuracy,
								bearing, velocity, track_id));
					}
				}
				this.track = new Track(id, name, device, positions);

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
	 * Gets the track.
	 * 
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * Sets the track.
	 * 
	 * @param track
	 *            the track to set
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

}
