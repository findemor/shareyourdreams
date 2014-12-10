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
 * The Class POISWarningAdd.
 *
 * @see APIOperation
 * @author topoos
 */
public class POISWarningAdd extends APIOperation {

	/** The Constant TYPE_CLOSED. */
	public static final String TYPE_CLOSED = "CLOSED";
	
	/** The Constant TYPE_DUPLICATED. */
	public static final String TYPE_DUPLICATED = "DUPLICATED";
	
	/** The Constant TYPE_WRONG_INDICATOR. */
	public static final String TYPE_WRONG_INDICATOR = "WRONG_INDICATOR";
	
	/** The Constant TYPE_WRONG_INFO. */
	public static final String TYPE_WRONG_INFO = "WRONG_INFO";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The poi. */
										private Integer poi = null; // (opcional) lista de identificadores de POI
								// cuyos warnings deseamos recuperar, separados
								// por comas
	/** The type. */
								private String type = null; // (opcional) lista de tipos de warning que
								// deseamos recuperar, los valores pueden ser:
	// CLOSED: Marcados como cerrado o inexistente
	// DUPLICATED: Marcados como duplicado
	// WRONG_INDICATOR: La marca de posición es incorrecta o inexacta
	// WRONG_INFO: La información del punto de interés es incorrecta o
	// incompleta
	/** The lat. */
								private Double lat = null; // (obligatorio) latitud de la nueva posición
	
	/** The lng. */
	private Double lng = null; // (obligatorio) longitud de la nueva posición
	
	/** The accuracy. */
	private Double accuracy = null; // (opcional) precisión de la posición
									// (latitud, longitud)
	/** The vaccuracy. */
									private Double vaccuracy = null; // (opcional) precisión de la elevación
	
	/** The elevation. */
	private Double elevation = null; // (opcional) elevación respecto al nivel
										// del mar

	/** The categories. */
										private String categories = null; // (obligatorio) identificadores de las
										// categorías a las que pertenece este
										// POI, separados por comas
	/** The name. */
										private String name = null; // (obligatorio) nombre del punto de interés
	
	/** The desc. */
	private String desc = null; // (opcional) descripción del punto de interés
	
	/** The address. */
	private String address = null; // (opcional) dirección del punto del interés
	
	/** The cross_street. */
	private String cross_street = null; // (opcional) calle transversal
	
	/** The city. */
	private String city = null; // (opcional) ciudad del punto de interés
	
	/** The country. */
	private String country = null; // (opcional) estado
	
	/** The postal_code. */
	private String postal_code = null; // (opcional) código postal
	
	/** The phone. */
	private String phone = null; // (opcional) teléfono de contacto
	
	/** The twitter. */
	private String twitter = null; // (opcional) identificador de usuario o
									// hashtag de twitter

	/**
									 * Instantiates a new pOIS warning add.
									 *
									 * @param operationName the operation name
									 * @param method the method
									 * @param format the format
									 * @param version the version
									 * @param oauth_token the oauth_token
									 * @param poi the poi
									 * @param type the type
									 */
									public POISWarningAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String type) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
	}

	/**
	 * Instantiates a new pOIS warning add.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 * @param type the type
	 * @param lat the lat
	 * @param lng the lng
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 */
	public POISWarningAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String type,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
		this.lat = lat;
		this.lng = lng;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
	}

	/**
	 * Instantiates a new pOIS warning add.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 * @param type the type
	 * @param categories the categories
	 * @param name the name
	 * @param desc the desc
	 * @param address the address
	 * @param cross_street the cross_street
	 * @param city the city
	 * @param country the country
	 * @param postal_code the postal_code
	 * @param phone the phone
	 * @param twitter the twitter
	 */
	public POISWarningAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String type,
			String categories, String name, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
		this.categories = categories;
		this.name = name;
		this.desc = desc;
		this.address = address;
		this.cross_street = cross_street;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.phone = phone;
		this.twitter = twitter;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(type);
		validate = validate && isValid(oauth_token);
		if (type.equals(POISWarningAdd.TYPE_WRONG_INDICATOR)) {
			validate = validate && isValid(APIUtils.toStringDouble(lat));
			validate = validate && isValid(APIUtils.toStringDouble(lng));
			validate = validate
					&& isValidorNull(APIUtils.toStringDouble(accuracy));
			validate = validate
					&& isValidorNull(APIUtils.toStringDouble(vaccuracy));
			validate = validate
					&& isValidorNull(APIUtils.toStringDouble(elevation));
		} else if (type.equals(POISWarningAdd.TYPE_WRONG_INFO)) {
			validate = validate && isValid(categories);
			validate = validate && isValid(name);
			validate = validate && isValidorNull(desc);
			validate = validate && isValidorNull(address);
			validate = validate && isValidorNull(cross_street);
			validate = validate && isValidorNull(city);
			validate = validate && isValidorNull(country);
			validate = validate && isValidorNull(postal_code);
			validate = validate && isValidorNull(phone);
			validate = validate && isValidorNull(twitter);
		}
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
			params = "/" + this.Version + "/pois/warnings/add." + this.Format
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) + "&poi=" + poi
					+ "&type=" + URLEncoder.encode(type);
			if (type.equals(POISWarningAdd.TYPE_WRONG_INDICATOR)) {
				params = params
						+ "&lat="
						+ URLEncoder.encode(APIUtils.toStringDouble(lat))
						+ "&lng="
						+ URLEncoder.encode(APIUtils.toStringDouble(lng))
						+ (accuracy == null ? "" : "&accuracy="
								+ URLEncoder.encode(APIUtils.toStringDouble(accuracy)))
						+ (vaccuracy == null ? "" : "&vaccuracy="
								+ URLEncoder.encode(APIUtils.toStringDouble(vaccuracy)))
						+ (elevation == null ? "" : "&elevation="
								+ URLEncoder.encode(APIUtils.toStringDouble(elevation)));
			} else if (type.equals(POISWarningAdd.TYPE_WRONG_INFO)) {
				params = params
						+ "&categories="
						+ URLEncoder.encode(APIUtils.toStringUrlEncoded(categories))
						+ "&name="
						+ URLEncoder.encode(APIUtils.toStringUrlEncoded(name))
						+ (desc == null ? "" : "&desc="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(desc)))
						+ (address == null ? "" : "&address="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(address)))
						+ (cross_street == null ? "" : "&cross_street="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(cross_street)))
						+ (city == null ? "" : "&city="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(city)))

						+ (country == null ? "" : "&country="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(country)))
						+ (postal_code == null ? "" : "&postal_code="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(postal_code)))
						+ (phone == null ? "" : "&phone="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(phone)))
						+ (twitter == null ? "" : "&twitter="
								+ URLEncoder.encode(APIUtils.toStringUrlEncoded(twitter)));
			}
		}
		return params;
	}

}