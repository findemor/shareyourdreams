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
 * Class that delete Follows.
 * 
 * @see APIOperation
 * @author topoos
 */
public class SocialDeleteFollow extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token
		
	/** The target user id. */
	private String usr_b = null; // (obligatorio) terget user identifier to follow
	

	/**
	 * Instantiates a new Social follow delete.
	 * 
	 * @param operationName
	 *            the operation name
	 * @param method
	 *            the method
	 * @param format
	 *            the format
	 * @param version
	 *            the version
	 * @param oauth_token
	 *            the oauth_token
	 * @param user_b
	 *            the user_b
	 */
	public SocialDeleteFollow(String operationName, String method, String format,
			Integer version, String oauth_token, String user_b) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.usr_b = user_b;
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
		validate = validate && isValid(usr_b);
		return validate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/"
					+ this.Version
					+ "/follows/delete."
					+ this.Format
					+ "?access_token="
					+ URLEncoder.encode(this.oauth_token)
					+ "&usr_b="
					+ URLEncoder.encode(this.usr_b);
		}
		return params;
	}

}
