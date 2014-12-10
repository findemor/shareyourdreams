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
 * The Class UsersUSRRemove_group.
 *
 * @see APIOperation
 * @author topoos
 */
public class UsersUSRRemove_group  extends APIOperation{
	
	/** The oauth_token. */
	private String oauth_token;
	
	/** The usr. */
	private String USR;
	
	/** The ugroup. */
	private Integer ugroup;


	/**
	 * Instantiates a new users usr remove_group.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param uSR the u sr
	 * @param ugroup the ugroup
	 */
	public UsersUSRRemove_group(String operationName, String method,
			String format, Integer version, String oauth_token, String uSR,
			Integer ugroup) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		USR = uSR;
		this.ugroup = ugroup;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(USR);
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(String.valueOf(ugroup));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/" + this.USR + "/remove_group."
					+ this.Format + "?ugroup="+ugroup+"&oauth_token=" + URLEncoder.encode(this.oauth_token);

		}
		return params;
	}
}
