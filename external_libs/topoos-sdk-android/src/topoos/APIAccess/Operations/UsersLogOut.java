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
 * Class that log out.
 * 
 * @see APIOperation
 * @author topoos
 */
public class UsersLogOut extends APIOperation {

	/** The oauth_token. */
	private String oauth_token; //(Required) access_token that will be deleted.
	
	
	/***
	 * Instantiates a new UsersLogOut.
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 */
	public UsersLogOut(String operationName, String method, String format,
			Integer version, String oauth_token) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		return validate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/login."
					+ this.Format
					+ "?access_token=" + URLEncoder.encode(this.oauth_token);

		}
		return params;
	}

}
