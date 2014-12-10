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
 * The Class UserResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class UserResult extends APICallResult {

	/** The user. */
	private User user = null;

	/**
	 * Instantiates a new user result.
	 */
	public UserResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new user result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public UserResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new user result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param user
	 *            the user
	 */
	public UserResult(String error, String result, User user) {
		super(error, result);
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		String Id = null;
		String Name = null;
		String Email = null;
		Profile Profile = null;
		ArrayList<Integer> Ugroup = null;
		Acreditation Acreditation = null;
		// Processing result
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				Id = APIUtils.getStringorNull(jObject, "id");
				if (Id != null) {
					Name = APIUtils.getStringorNull(jObject, "name");
					if (jObject.optJSONObject("profile") != null) {
						Date birthday = null;
						if (!jObject.getJSONObject("profile")
								.isNull("birthday")) {
							birthday = APIUtils.toDateString(jObject
									.getJSONObject("profile").getString(
											"birthday"));
						}

						Profile = new Profile(birthday,
								APIUtils.getStringorNull(
										jObject.getJSONObject("profile"),
										"gender"));
					} else
						Profile = null;
					Email = APIUtils.getStringorNull(jObject, "email");
					JSONArray jarray = jObject.getJSONArray("ugroup");
					if (Ugroup == null)
						Ugroup = new ArrayList<Integer>();
					for (int i = 0; i < jarray.length(); i++) {
						Ugroup.add(jarray.getInt(i));
					}

					if (jObject.optJSONObject("accreditation") != null) {
						ArrayList<VisibleDevice> arrayV = new ArrayList<VisibleDevice>();

						JSONArray jarray2 = jObject.getJSONObject(
								"accreditation").getJSONArray("visibledevices");
						for (int i = 0; i < jarray2.length(); i++) {
							arrayV.add(new VisibleDevice(jarray2.getJSONObject(
									i).getString("id"), APIUtils
									.getStringorNull(jarray2.getJSONObject(i),
											"name"), APIUtils.getIntegerorNull(
									jarray2.getJSONObject(i), "model"),
									APIUtils.getBooleanorNull(
											jarray2.getJSONObject(i),
											"islogical")));
						}
						Acreditation = new Acreditation(
								APIUtils.getStringorNull(
										jObject.getJSONObject("accreditation"),
										"expirationtime"), jObject
										.getJSONObject("accreditation")
										.getString("client_id"),
								APIUtils.getStringorNull(
										jObject.getJSONObject("accreditation"),
										"access_token"),
								APIUtils.getStringorNull(
										jObject.getJSONObject("accreditation"),
										"refresh_token"), arrayV);
					} else
						Acreditation = null;

					this.user = new User(Id, Name, Email, Profile, Ugroup,
							Acreditation);
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
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
