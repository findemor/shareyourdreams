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
 * 
 * 
 * Update the description of a category. The category has to belong to the
 * application
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class POISCategoriesUpdate extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The desc. */
										private String desc = null; // : (obligatorio) descripción de la categoría
	
	/** The category. */
	private Integer category = null; // (obligatorio) identificador de la
									// categoría a modificar

	/**
									 * Instantiates a new pOIS categories update.
									 *
									 * @param operationName the operation name
									 * @param method the method
									 * @param format the format
									 * @param version the version
									 * @param oauth_token the oauth_token
									 * @param desc the desc
									 * @param category the category
									 */
									public POISCategoriesUpdate(String operationName, String method,
			String format, Integer version, String oauth_token, String desc,
			Integer category) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.desc = desc;
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringUrlEncoded(desc));
		validate = validate && isValid(APIUtils.toStringInteger(category));
		validate = validate && isValid(oauth_token);

		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/categories/update."
					+ this.Format + "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+ "&desc=" + URLEncoder.encode(APIUtils.toStringUrlEncoded(desc))
					+ "&category=" + URLEncoder.encode(APIUtils.toStringInteger(category));
		}
		return params;
	}
}