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
 * The Class UsersGet_near.
 *
 * @see APIOperation
 * @author topoos
 */
public class UsersGet_near extends APIOperation {

	/** The oauth_token. */
	private String oauth_token=null;// (obligatorio) access_token a los recursos del usuario
	
	/** The lat. */
	private Double lat=null;// (opcional) latitud del punto central de búsqueda. Es un parámetro obligatorio si no se especifica poi.
	
	/** The lng. */
	private Double lng=null;// (opcional) longitud del punto central de búsqueda. Es un parámetro obligatorio si no se especifica poi.
	
	/** The poi. */
	private Integer poi=null;// (opcional) identificador del punto de interés alrededor del cual se realiza la búsqueda. Es un parámetro obligatorio si no se especifican lat y lng.
	
	/** The radius. */
	private Integer radius=null;// (obligatorio) radio de búsqueda en metros > 0
	
	/** The active. */
	private Boolean active=null;// (opcional) true|false la búsqueda se realiza únicamente entre aquellos usuarios que tengan Track activos en este momento. Valores permitidos “true”. Por defecto “true”
	
	/** The ugroup. */
	private Integer ugroup=null;// (opcional) identificador de grupo de usuario. Si se especifica, los resultados solo incluirán usuarios que pertenezcan a dicho grupo.
	
	/** The Count. */
	private Integer Count=null;// (opcional) número de usuarios devueltos. Los devueltos siempre serán los más cercanos al punto. Valor por defecto 1.


	/**
	 * Instantiates a new users get_near.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 * @param active the active
	 * @param ugroup the ugroup
	 * @param count the count
	 */
	public UsersGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng,
			Integer radius, Boolean active, Integer ugroup, Integer count) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
		this.active = active;
		this.ugroup = ugroup;
		Count = count;
	}

	/**
	 * Instantiates a new users get_near.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 * @param radius the radius
	 * @param active the active
	 * @param ugroup the ugroup
	 * @param count the count
	 */
	public UsersGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, Integer radius,
			Boolean active, Integer ugroup, Integer count) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.radius = radius;
		this.active = active;
		this.ugroup = ugroup;
		Count = count;
	}


	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && ((isValid(APIUtils.toStringDouble(lat)) && isValid(APIUtils.toStringDouble(lng)) )||(isValid(APIUtils.toStringInteger(poi))));
		validate = validate && isValid(oauth_token);
		validate = validate && (isValidorNull(APIUtils.toStringInteger(ugroup)));
		validate = validate && isValid(APIUtils.toStringInteger(radius)) && radius!=null && radius>0;
		validate = validate && (isValidorNull(APIUtils.toStringBoolean(active)));
		validate = validate && (isValidorNull(APIUtils.toStringInteger(Count)));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			if(poi==null){
				params = "/" + this.Version + "/users/get_near."
						+ this.Format + "?lat="+URLEncoder.encode(APIUtils.toStringDouble(lat))+"&lng="+ URLEncoder.encode(APIUtils.toStringDouble(this.lng))
						+(ugroup==null?"":"&ugroup=" + URLEncoder.encode(APIUtils.toStringInteger(this.ugroup)))
						+"&radius=" + URLEncoder.encode(APIUtils.toStringInteger(this.radius))
						+(active == null? "" : "&active=" + URLEncoder.encode(APIUtils.toStringBoolean(this.active)))
						+(Count == null? "" : "&Count=" + URLEncoder.encode(APIUtils.toStringInteger(this.Count)))
						+"&oauth_token=" + URLEncoder.encode(this.oauth_token);
			}else{
				params = "/" + this.Version + "/users/get_near."
						+ this.Format + "?poi="+URLEncoder.encode(APIUtils.toStringInteger(this.poi))
						+(ugroup == null?"":"&ugroup=" + URLEncoder.encode(APIUtils.toStringInteger(this.ugroup)))
						+"&radius=" + URLEncoder.encode(APIUtils.toStringInteger(this.radius))
						+(active == null? "" : "&active=" + URLEncoder.encode(APIUtils.toStringBoolean(this.active)))
						+(Count == null? "" : "&Count=" + URLEncoder.encode(APIUtils.toStringInteger(this.Count)))
						+"&oauth_token=" + URLEncoder.encode(this.oauth_token);
			}

		}
		return params;
	}


}
