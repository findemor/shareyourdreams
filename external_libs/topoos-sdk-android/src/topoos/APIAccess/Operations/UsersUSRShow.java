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
 * Get the information of a user. You can check the oauth_token.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class UsersUSRShow extends APIOperation {

	private String OAuthToken = null;
	private String USR = null;

	public UsersUSRShow(String operationName, String method, String format,
			Integer version, String oAuth_token, String uSR) {
		super(operationName, method, format, version);
		USR = uSR;
		OAuthToken = oAuth_token;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(USR);
		validate = validate && isValid(OAuthToken);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/" + this.USR + "/show."
					+ this.Format + "?oauth_token=" + URLEncoder.encode(this.OAuthToken);

		}
		return params;
	}

}
