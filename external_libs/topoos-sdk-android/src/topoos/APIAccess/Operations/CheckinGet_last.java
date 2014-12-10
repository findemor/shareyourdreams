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

package topoos.APIAccess.Operations;

import java.net.URLEncoder;


/**
 * Get the information from last CheckIn that have been registered by a user
 * with a visible device.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class CheckinGet_last extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The usr. */
										private String usr = null; // (obligatorio) identificador del usuario

	/**
	 * Instantiates a new checkin get_last.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param usr the usr
	 */
	public CheckinGet_last(String operationName, String method, String format,
			Integer version, String oauth_token, String usr) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.usr = usr;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(usr);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/checkin/get_last." + this.Format
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) + "&usr=" + URLEncoder.encode(this.usr);

		}
		return params;
	}

}