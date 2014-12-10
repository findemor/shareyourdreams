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

import java.io.IOException;
import java.util.Date;

import topoos.APIAccess.mime.HttpMultipartMode;
import topoos.APIAccess.mime.MultipartEntity;
import topoos.APIAccess.mime.content.StringBody;

/**
 * Class that register membership.
 * 
 * Register a new user in your own client database.
 * 
 * @see APIOperation
 * @author topoos
 */
public class UsersRegisterMembership extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; //(Required if your app doesn’t allow Implicit Flow) access_token to user resources.

	/** The api_key. */
	private String api_key = null; //(Required if access_token is not provided) your client id.
	
	/** The username. */
	private String username = null; // (Required) username for your new user. Must be between 6 and 40 characters length.
	
	/** The pwd*/
	private String pwd = null; // (Required) password for your new user. Must be between 6 and 40 characters length and it will be stored encrypted.
	
	/** the email*/
	private String email = null; //(Required) email for your new user. Must be shorter than 255 characters. It must exists for Reset Password purposes.
	
	/** the gender*/
	private String gender = null; //(Optional) gender for your new user. Allowed values are ‘male’ or ‘female’. Default value is ‘Undefined’.
	
	/** the birthday*/
	private Date birthday = null; //(Optional) birthday date for your new user. according to the ISO 8601 standard.
	
	/** the expiresIn*/
	private Integer expiresIn = null;
	
	/***
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param api_key
	 * @param username
	 * @param pwd
	 * @param email
	 * @param gender
	 * @param birthday
	 */
	public UsersRegisterMembership(String operationName, String method,
			String format, Integer version, String oauth_token, String api_key,
			String username, String pwd, String email, String gender,
			Date birthday, Integer expiresIn) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.api_key = api_key;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.expiresIn = expiresIn;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && (isValid(oauth_token)|| isValid(api_key));
		validate = validate && isValid(username);
		validate = validate && isValid(pwd);
		validate = validate && isValid(email);
		validate = validate && isValidorNull(gender);
		validate = validate && isValidorNull(APIUtils.toStringDate(birthday));
		validate = validate && isValidorNull(APIUtils.toStringInteger(expiresIn));
		
		return validate;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#BodyParams()
	 */
	@Override
	public MultipartEntity BodyParams() throws IOException {
		MultipartEntity multipart = null;
		if (this.ValidateParams()) {
			multipart = new MultipartEntity(
					HttpMultipartMode.BROWSER_COMPATIBLE);// ,contentType,Charset.forName("UTF-8"));
			
			if (oauth_token != null && !oauth_token.equals("")){
				multipart.addPart("access_token", 
						new StringBody(oauth_token));
			}
			
			if (api_key != null && !api_key.equals("")){
				multipart.addPart("api_key", 
						new StringBody(api_key));
			} 
			
			multipart.addPart("username", 
					new StringBody(username));
			multipart.addPart("pwd", 
					new StringBody(pwd));
			
			multipart.addPart("email", 
					new StringBody(email));
			
			if (gender != null){
				multipart.addPart("gender", 
						new StringBody(gender));
			}
			
			if (birthday != null){
				multipart.addPart("birthday", 
						new StringBody(APIUtils.toStringDate(birthday)));
			}
			
			if (expiresIn != null)
				multipart.addPart("expiresIn", 
						new StringBody(APIUtils.toStringInteger(expiresIn)));
		}
		return multipart;
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
			params = "/" + this.Version + "/users."+this.Format;
		}
		return params;
	}
	
	
	
	
}