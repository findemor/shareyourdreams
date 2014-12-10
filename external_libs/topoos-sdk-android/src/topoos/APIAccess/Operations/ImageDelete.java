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
 * The Class ImageDelete.
 * @see APIOperation
 * @author topoos
 */
public class ImageDelete extends APIOperation {
	
	/** The oauth_token. */
	private String oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	/** The id unique image */
	private String ID_Image = null; // (Obligatorio) nombre de la imagen necesario para borrar la foto
	
	
	/**
	 * Instantiates a new image delete.
	 * 
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param filename_unique Unique image ID
	 * 
	 */
	public ImageDelete (String operationName, String method, String format,
			Integer version,String accessTokenPregenerated,
			String fileName){
		super(operationName, method, format, version);
		this.oauth_token = accessTokenPregenerated;
		this.ID_Image = fileName;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(ID_Image);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	/**
	 * Build params for URI.
	 * 
	 * @return String
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/image/delete/"+ID_Image+"."+this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token);
		}
		return params;
	}

}
