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
 * Geocodification service that allow to get the coordinates of an address that
 * is normalized or get a normalized address from coordinates.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class ResourcesGeocode extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The lat. */
										private Double lat = null; // (opcional) latitud en grados decimales,
								// obligatorio si se especifica lng.
	/** The lng. */
								private Double lng = null; // (opcional) longitud en grados decimales,
								// obligatorio si se especifica lat.
	/** The Address. */
								private String Address = null; // (opcional) dirección normalizada de la
									// cual se desea realizar la Geocodificación
									// regular, obligatorio si no se especifica
									// lat o lng.

	/**
									 * Instantiates a new resources geocode.
									 *
									 * @param operationName the operation name
									 * @param method the method
									 * @param format the format
									 * @param version the version
									 * @param oauth_token the oauth_token
									 * @param lat the lat
									 * @param lng the lng
									 */
									public ResourcesGeocode(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
	}

	/**
	 * Instantiates a new resources geocode.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param address the address
	 */
	public ResourcesGeocode(String operationName, String method, String format,
			Integer version, String oauth_token, String address) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		Address = address;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate
				&& ((isValid(APIUtils.toStringDouble(lat)) && isValid(APIUtils
						.toStringDouble(lng))) || isValid(Address));
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
			if (Address != null) {
				params = "/" + this.Version + "/resources/geocode."
						+ this.Format + "?oauth_token=" + URLEncoder.encode(this.oauth_token)
						+ "&Address=" + URLEncoder.encode(this.Address);
			} else {
				params = "/" + this.Version + "/resources/geocode."
						+ this.Format + "?oauth_token=" + URLEncoder.encode(this.oauth_token)
						+ "&lat=" + URLEncoder.encode(APIUtils.toStringDouble(lat)) + "&lng="
						+ URLEncoder.encode(APIUtils.toStringDouble(lng));
				;
			}

		}
		return params;
	}

}