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
 * Get a KML document that allow to represent a polygon in a map that accept KML
 * layers.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class ResourcesGet_polygon extends APIOperation {

	/** The Constant SHAPE_CIRCLE. */
	public static final String SHAPE_CIRCLE = "circle";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The shape. */
										private String shape = null; // (obligatorio) forma del polígono (valor
									// admitido "circle")
	/** The resolution. */
									private Integer resolution = null; // (obligatorio) vértices para un círculo
	
	/** The lat. */
	private Double lat = null; // (obligatorio) latitud del centro del circulo
	
	/** The lng. */
	private Double lng = null; // (obligatorio)longitud del centro del círculo
	
	/** The radius. */
	private Double radius = null; // (obligatorio)radio en metros

	/**
	 * Instantiates a new resources get_polygon.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param shape the shape
	 * @param resolution the resolution
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 */
	public ResourcesGet_polygon(String operationName, String method,
			String format, Integer version, String oauth_token, String shape,
			Integer resolution, Double lat, Double lng, Double radius) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.shape = shape;
		this.resolution = resolution;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(APIUtils.toStringDouble(radius));
		validate = validate && isValid(APIUtils.toStringInteger(resolution));
		validate = validate && isValid(shape);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/resources/get_polygon."
					+ this.Format + "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+ "&lat=" + URLEncoder.encode(APIUtils.toStringDouble(lat)) + "&lng="
					+ URLEncoder.encode(APIUtils.toStringDouble(lng)) + "&radius="
					+ URLEncoder.encode(APIUtils.toStringDouble(radius)) + "&resolution="
					+ URLEncoder.encode(APIUtils.toStringInteger(resolution)) + "&shape=" + URLEncoder.encode(shape);
		}
		return params;
	}

}
