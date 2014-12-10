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
 * The class ImageSearch
 */
public class ImageSearch extends APIOperation{
	
	/**the token*/
	private String token;
	/**Unique identifier image*/
	private String idImage;
	/**keyworks for search*/
	private String [] keywords;
	/**number of files returned*/
	private Integer count;
	/**result page number*/
	private Integer page;
	
	
	/** 
	 * Instantiates a new search images.
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param token the token
	 * @param idImage unique identifier image
	 * @param keywords keyworks for search
	 * @param count number of files returned
	 * @param page result page number
	 */
	public ImageSearch(String operationName, String method, String format,
			Integer version, String token, String idImage, String [] keywords,
			Integer count, Integer page) {
		super(operationName, method, format, version);
		this.token = token;
		this.idImage = idImage;
		this.keywords = keywords;
		this.count = count;
		this.page = page;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(token);
		validate = validate && isValidorNull (idImage);
		validate = validate && !(keywords!= null && keywords.length ==0);
		validate = validate && isValidorNull(APIUtils.toStringInteger(count));
		validate = validate && isValidorNull(APIUtils.toStringInteger(page));
		return validate;
	}
	
	


	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/search." + this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.token)
					+ (this.idImage == null? "" : "&id="+URLEncoder.encode(this.idImage))
					+ (this.keywords == null? "":"&keywords="+URLEncoder.encode(APIUtils.toStringStringArray(this.keywords)))
					+ (this.count == null? "":"&count="+URLEncoder.encode(APIUtils.toStringInteger(this.count)))
					+ (this.page == null? "": "&page="+URLEncoder.encode(APIUtils.toStringInteger(this.page)))
					;
		}
		return params;
	}

}