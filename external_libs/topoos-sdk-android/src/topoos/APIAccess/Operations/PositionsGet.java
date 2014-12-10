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
 * @see APIOperation
 * @author topoos
 * 
 */
public class PositionsGet extends APIOperation {

	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	private Integer posid = null; // (obligatorio) identificador de una posición
									// concreta.
	private String usr = null; // (opcional) identificador del usuario, si no se
								// indica se obtendrá la última posición del
								// usuario actual
	private String device = null; // (obligatorio) identificador del dispositivo
									// del cual vamos a obtener la última
									// posición.

	public PositionsGet(String operationName, String method, String format,
			Integer version, String oauth_token, Integer posid, String usr,
			String device) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.posid = posid;
		this.usr = usr;
		this.device = device;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate
				&& (isValid(APIUtils.toStringInteger(posid)) || isValid(device) || isValidorNull(usr));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			if (isValid(APIUtils.toStringInteger(posid))) {
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) + "&posid="
						+ URLEncoder.encode(APIUtils.toStringInteger(posid));
			} else if (isValid(device)) {
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) + "&device="
						+ URLEncoder.encode(device);
			}else if (isValid(usr)) {
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) + "&usr=" + URLEncoder.encode(usr);
			} else{
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + URLEncoder.encode(this.oauth_token);
			}
		}
		return params;
	}

}
