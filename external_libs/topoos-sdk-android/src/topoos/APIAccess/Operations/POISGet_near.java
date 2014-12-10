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
 * The Class POISGet_near.
 *
 * @see APIOperation
 * @author topoos
 */
public class POISGet_near extends APIOperation{

	/** The oauth_token. */
	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	
	/** The lat. */
	private Double  lat=null; // (obligatorio) latitud del punto central de búsqueda
	
	/** The lng. */
	private Double  lng=null; // (obligatorio) longitud del punto central de búsqueda
	
	/** The radius. */
	private Integer  radius=null; // (obligatorio) radio de búsqueda en metros
	
	/** The categories. */
	private String  categories=null; // (obligatorio) identificadores de las categorías de filtrado, los POI obtenidos pertenecerán a todas las especificadas, separadas por comas

	/** The total. */
	private Integer  total=null; // (opcional) obtiene un número determinado de pois
	
	/**
	 * Instantiates a new pOIS get_near.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 * @param categories the categories
	 */
	public POISGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng,
			Integer radius, String categories, Integer total){
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
		this.categories = categories;
		this.total = total;
	}

	
	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(APIUtils.toStringInteger(radius));
		validate = validate && isValid(categories);
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/get_near." + this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+ "&lat="+URLEncoder.encode(APIUtils.toStringDouble(lat))
					+ "&lng="+URLEncoder.encode(APIUtils.toStringDouble(lng))
					+ "&radius="+URLEncoder.encode(APIUtils.toStringInteger(radius))
					+ "&categories="+URLEncoder.encode(APIUtils.toStringUrlEncoded(categories))
					+(total == null? "" : "&total="+URLEncoder.encode(APIUtils.toStringInteger(total)))
					;
		}
		return params;
	}


}