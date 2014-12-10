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
 * Create a new rule of one this types: TRACK_OUT_OF_BOUNDS: Rule associated to
 * a Track. Each time that a position that is associated to a track will check
 * if it is out of the specified zone if it is out,a push alert will be generate
 * to the Endpoint that is specified in the application configuration.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class RulesAdd extends APIOperation {

	/** The Constant TYPE_TRACK_OUT_OF_BOUNDS. */
	public static final String TYPE_TRACK_OUT_OF_BOUNDS = "TRACK_OUT_OF_BOUNDS";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio)access_token de Acceso a
										// recursos
	/** The lat. */
										private Double lat = null; // (obligatorio) latitud del centro del círculo
								// del área permitida, en grados decimales
	/** The lng. */
								private Double lng = null; // (obligatorio) longitud del centro del círculo
								// del área permitida, en grados decimales
	/** The radius. */
								private Integer radius = null; // (obligatorio) radio del círculo del área
									// permitida, en grados decimales.
	/** The type. */
									private String type = null; // TRACK_OUT_OF_BOUNDS
	
	/** The track. */
	private Integer track = null; // Identificador del track que vamos a añadir

	/**
	 * Instantiates a new rules add.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 * @param type the type
	 * @param track the track
	 */
	public RulesAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng,
			Integer radius, String type, Integer track) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
		this.type = type;
		this.track = track;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {

		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringInteger(radius));
		validate = validate && isValid(type);
		validate = validate && isValid(APIUtils.toStringInteger(track));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/rules/add." + this.Format
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) + "&lat="
					+ URLEncoder.encode(APIUtils.toStringDouble(lat)) + "&lng="
					+ URLEncoder.encode(APIUtils.toStringDouble(lng)) + "&radius="
					+ URLEncoder.encode(APIUtils.toStringInteger(radius)) + "&track="
					+ URLEncoder.encode(APIUtils.toStringInteger(track)) + "&type=" + URLEncoder.encode(type);
		}
		return params;
	}

}