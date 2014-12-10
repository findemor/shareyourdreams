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
 * Class that get users followed by user.
 * 
 * @see APIOperation
 * @author topoos
 */
public class SocialGetFollowed extends APIOperation {
	
	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token
		
	/** The target origin user id. */
	private String USR = null; // (obligatorio) origin user identifier

	/** The page cursor. */
	private Integer cursor = null; // (opcional) integer value that identifies the result page.
	

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
	 * @param USR
	 *            the USR
	 * @param cursor
	 *            the page cursor
	 */
	public SocialGetFollowed(String operationName, String method, String format,
			Integer version, String oauth_token, String USR, Integer cursor) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.USR = USR;
		this.cursor = cursor;
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
		validate = validate && isValid(USR);
		validate = validate && isValidorNull(APIUtils.toStringInteger(cursor));
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
					+ "/" + this.USR + "/follows."
					+ this.Format
					+ "?access_token="
					+ URLEncoder.encode(this.oauth_token)
					+ (this.cursor == null ? "" : "&cursor="
							+ URLEncoder.encode(APIUtils.toStringInteger(this.cursor)));
		}
		return params;
	}

}
