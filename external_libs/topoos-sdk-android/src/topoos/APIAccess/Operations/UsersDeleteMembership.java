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
 * Class that delete membership.
 * 
 * It deletes permanently a membership register (client user) from the database. 
 * This operation can not delete oauth users.
 * 
 * @see APIOperation
 * @author topoos
 */
public class UsersDeleteMembership extends APIOperation {

	/** The oauth_token. */
	private String oauth_token; //(Required) administrator access_token.

	/** Count*/
	private String usr; //(Required) user id to delete membership.
	
	
	/***
	 * //Instantiates a new Delete Membership.
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param usr
	 */
	public UsersDeleteMembership(String operationName, String method,
			String format, Integer version, String oauth_token, String usr) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.usr = usr;
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
		validate = validate && isValid(usr);
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
			params = "/" + this.Version + "/users/"+usr+"."+URLEncoder.encode(this.Format)+"?"+ "access_token="+URLEncoder.encode(this.oauth_token);
		}
		return params;
	}

}