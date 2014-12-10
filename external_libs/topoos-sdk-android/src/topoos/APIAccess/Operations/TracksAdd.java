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
 * Create a new Track. A Track represent a sequence of registered positions.
 * during a session
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class TracksAdd extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The device. */
										private String device = null; // (opcional) dispositivo que crea el Track.
									// Es un parámetro obligatorio cuando la
									// aplicación puede utilizar los
									// dispositivos físicos de un usuario,
									// opción que por defecto está
									// deshabilitada.
	/** The name. */
									private String name = null; // (opcional) descripción del Track, máx. 100
								// caracteres.

	/**
								 * Instantiates a new tracks add.
								 *
								 * @param operationName the operation name
								 * @param method the method
								 * @param format the format
								 * @param version the version
								 * @param oauth_token the oauth_token
								 * @param device the device
								 * @param name the name
								 */
								public TracksAdd(String operationName, String method, String format,
			Integer version, String oauth_token, String device, String name) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(name);
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
			params = "/"
					+ this.Version
					+ "/tracks/add."
					+ this.Format
					+ "?oauth_token="
					+ URLEncoder.encode(this.oauth_token)
					+ (name == null ? "" : "&name="
							+ URLEncoder.encode(APIUtils.toStringUrlEncoded(name)))
					+ (device == null ? "" : "&device=" + URLEncoder.encode(device));

		}
		return params;
	}

}