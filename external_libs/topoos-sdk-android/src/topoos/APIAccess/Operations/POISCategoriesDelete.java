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
 * Delete a category of POI. The category will not appear as a result of a
 * request, but the pois are still associated to the deleted category if they
 * were associated previously. The category has to belong to the application
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class POISCategoriesDelete extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The category. */
	private Integer category = null; // (obligatorio) identificador de la

	// categoría a modificar

	/**
	 * Instantiates a new pOIS categories delete.
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
	 * @param category
	 *            the category
	 */
	public POISCategoriesDelete(String operationName, String method,
			String format, Integer version, String oauth_token, Integer category) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringInteger(category));
		validate = validate && isValid(oauth_token);

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
			params = "/" + this.Version + "/pois/categories/delete."
					+ this.Format + "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+ "&category=" + URLEncoder.encode(APIUtils.toStringInteger(category));
		}
		return params;
	}
}