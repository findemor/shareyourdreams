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
 * Class that get membership.
 * 
 * Lists all users authorized in your app. Private info can be returned by using Administrator token. 
 * Accreditation info is never returned.
 * 
 * @see APIOperation
 * @author topoos
 */
public class UsersGetMembership extends APIOperation {

	/** The oauth_token. */
	private String oauth_token; //(Required) access_token. If Administrator token is provided, then emails and other private info is returned.

	/** Count*/
	private Integer count; //(Optional) number of elements in the page. Default is 100 users.
	
	/** Page*/
	private Integer page; //(Optional) page of results requested. Default value is page 0.
	
	

	/***
	 * Instantiates a new Reset password.
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param count
	 * @param page
	 */
	public UsersGetMembership(String operationName, String method, String format,
			Integer version, String oauth_token, Integer count, Integer page) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.count = count;
		this.page = page;
				
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
		validate = validate && isValidorNull(APIUtils.toStringInteger(count));
		validate = validate && isValidorNull(APIUtils.toStringInteger(page));
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
			params = "/" + this.Version + "/users."+this.Format+"?" + "access_token="+URLEncoder.encode(oauth_token)
					+ (count == null ? "" : "&count="+ URLEncoder.encode(APIUtils.toStringInteger(count)))
					+ (page == null ? "" : "&page="+ URLEncoder.encode(APIUtils.toStringInteger(page)));
		}
		return params;
	}

}