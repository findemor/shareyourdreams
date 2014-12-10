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
 * The Class ImageUpdate.
 */
public class ImageUpdate extends APIOperation{
	/** The oauth_token. */
	private String oauth_token;
	/** The id unique image */
	private String id_uniq_filename;
	/** The keywords of image */
	private String [] keywords;
	/** The privacy of image */
	private String privacy;
	
	/**
	 * Instantiates a new image delete.
	 * 
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param id_uniq_filename Unique image ID
	 * @param keywords of image
	 * @param privacy of image
	 * 
	 */
	public ImageUpdate(String operationName, String method, String format,
			Integer version,String oauth_token, String id_uniq_filename, String [] keywords,
			String privacy) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.id_uniq_filename = id_uniq_filename;
		this.keywords = keywords;
		this.privacy = privacy;
	}
	
	
	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(id_uniq_filename);
		validate = validate && isValid(oauth_token);
		validate = validate && (! (keywords != null && keywords.length ==0) || isValid (privacy));
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/image/update/"+this.id_uniq_filename+"."+this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) +"&privacy="+URLEncoder.encode(this.privacy)+"&keywords="+URLEncoder.encode(APIUtils.toStringStringArray(this.keywords));
		}
		return params;
	}
	
	

	
}

