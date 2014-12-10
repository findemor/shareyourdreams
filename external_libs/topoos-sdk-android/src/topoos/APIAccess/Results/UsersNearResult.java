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
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * The Class UsersNearResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class UsersNearResult extends APICallResult {

	/** The usersnear. */
	private UsersNear usersnear = null;

	/**
	 * Instantiates a new users near result.
	 */
	public UsersNearResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new users near result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public UsersNearResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new users near result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param usersnear
	 *            the usersnear
	 */
	public UsersNearResult(String error, String result, UsersNear usersnear) {
		super(error, result);
		this.usersnear = usersnear;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		if (APIUtils.getcorrectJSONARRAYstring(Result) != null) {
			ArrayList<UserIdPosition> userPositions = null;
			// Processing result
			try {
				JSONArray jArray = (JSONArray) new JSONTokener(
						APIUtils.getcorrectJSONARRAYstring(Result)).nextValue();
				userPositions = new ArrayList<UserIdPosition>();
				for (int i = 0; i < jArray.length(); i++) {
					String user_id = APIUtils.getStringorNull(
							jArray.getJSONObject(i), "user_id");
					Double latitude = APIUtils.getDoubleorNull(jArray
							.getJSONObject(i).getJSONObject("position"),
							"latitude");
					Double logitude = APIUtils.getDoubleorNull(jArray
							.getJSONObject(i).getJSONObject("position"),
							"longitude");
					Double accuracy = APIUtils.getDoubleorNull(jArray
							.getJSONObject(i).getJSONObject("position"),
							"accuracy");

					UserPosition position = new UserPosition(latitude,
							logitude, accuracy);
					userPositions.add(new UserIdPosition(user_id, position));
				}
				this.usersnear = new UsersNear(userPositions);
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
	 * Gets the usersnear.
	 * 
	 * @return the usersnear
	 */
	public UsersNear getUsersnear() {
		return usersnear;
	}

	/**
	 * Sets the usersnear.
	 * 
	 * @param usersnear
	 *            the usersnear to set
	 */
	public void setUsersnear(UsersNear usersnear) {
		this.usersnear = usersnear;
	}

}
