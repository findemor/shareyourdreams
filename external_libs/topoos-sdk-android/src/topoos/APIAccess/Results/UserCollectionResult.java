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
 * The Class UserCollectionResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class UserCollectionResult extends APICallResult {

	/** The user. */
	private Users users = null;

	/**
	 * Instantiates a new user result.
	 */
	public UserCollectionResult() {
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
	public UserCollectionResult(String error, String result) {
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
	public UserCollectionResult(String error, String result, Users users) {
		super(error, result);
		this.users = users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		
		// Processing result
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			ArrayList<User> l_users = null;
			try {
				String Id = null;
				String Name = null;
				String Email = null;
				Profile Profile = null;
				ArrayList<Integer> Ugroup = null;
				Acreditation Acreditation = null;
				
				JSONArray jArray = (JSONArray) new JSONTokener(
						APIUtils.getcorrectJSONARRAYstring(Result)).nextValue();
				l_users = new ArrayList<User>();
				JSONObject userAux = null;
				for (int user_i = 0; user_i < jArray.length(); user_i++) {
					// Extracting content
					userAux = jArray.getJSONObject(user_i);
					Id = APIUtils.getStringorNull(jArray.getJSONObject(user_i), "id");
					if (Id != null) {
						Name = APIUtils.getStringorNull(jArray.getJSONObject(user_i), "name");
						if (jArray.getJSONObject(user_i).optJSONObject("profile") != null) {
							String birthdayS = null;
							Date birthday = null;
							if (!userAux.getJSONObject("profile").isNull("birthday"))
								birthdayS = userAux.getJSONObject("profile").getString("birthday");
							if (birthdayS!=null){
								birthday = APIUtils.toDateString (birthdayS);
							}
							Profile = new Profile(
									birthday,
									APIUtils.getStringorNull(
											jArray.getJSONObject(user_i).getJSONObject("profile"),
											"gender"));
						} else
							Profile = null;
						Email = APIUtils.getStringorNull(jArray.getJSONObject(user_i), "email");
						JSONArray jarray = jArray.getJSONObject(user_i).getJSONArray("ugroup");
						if (Ugroup == null)
							Ugroup = new ArrayList<Integer>();
						for (int i = 0; i < jarray.length(); i++) {
							Ugroup.add(jarray.getInt(i));
						}
						
						if  (jArray.getJSONObject(user_i).optJSONObject("accreditation") != null){
							ArrayList<VisibleDevice> arrayV = new ArrayList<VisibleDevice>();
							
							JSONArray jarray2 = jArray.getJSONObject(user_i).getJSONObject("accreditation")
									.getJSONArray("visibledevices");
							for (int i = 0; i < jarray2.length(); i++) {
								arrayV.add(new VisibleDevice(jarray2.getJSONObject(i)
										.getString("id"), APIUtils.getStringorNull(
										jarray2.getJSONObject(i), "name"), APIUtils
										.getIntegerorNull(jarray2.getJSONObject(i),
												"model"), APIUtils.getBooleanorNull(
										jarray2.getJSONObject(i), "islogical")));
							}
							Acreditation = new Acreditation(APIUtils.getStringorNull(
									jArray.getJSONObject(user_i).getJSONObject("accreditation"),
									"expirationtime"), jArray.getJSONObject(user_i).getJSONObject(
									"accreditation").getString("client_id"), APIUtils.getStringorNull(
											jArray.getJSONObject(user_i).getJSONObject("accreditation"),
											"access_token"), APIUtils.getStringorNull(
													jArray.getJSONObject(user_i).getJSONObject("accreditation"),
													"refresh_token"),arrayV);
						}else 
							Acreditation = null;
						l_users.add(new User(Id, Name, Email, Profile, Ugroup,
								Acreditation));
					}
				}
				this.users = new Users(l_users);
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
	public Users getUsers() {
		return users;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the user to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

}
