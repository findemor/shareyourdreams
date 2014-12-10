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
 * Class that add POIS.
 * 
 * @see APIOperation
 * @author topoos
 */
public class POISAdd extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The lat. */
	private Double lat = null; // (obligatorio) latitud de la nueva posición.
	// Decimal.
	/** The lng. */
	private Double lng = null; // (obligatorio) longitud de la nueva posición.
	// Decimal.
	/** The geocode*/
	private Boolean geocode = null; //(Optional) Try to geocode the specified lat and lng, to fill unspecified attributes.
	/** The accuracy. */
	private Double accuracy = null; // (opcional) precisión de la posición
	// (latitud, longitud). Decimal.
	/** The vaccuracy. */
	private Double vaccuracy = null; // (opcional) precisión de la elevación.
	// Decimal.
	/** The elevation. */
	private Double elevation = null; // (opcional) elevación respecto al nivel
	// del mar. Decimal.
	/** The categories. */
	private String categories = null; // (obligatorio) identificadores de las
	// categorías a las que pertenece este
	// POI, separados por comas
	/** The name. */
	private String name = null; // (obligatorio) nombre del punto de interés.
	// Cadena de texto. Máximo 255 caracteres.
	/** The desc. */
	private String desc = null; // (opcional) descripción del punto de interés.
	// Cadena de texto. Máximo 500 caracteres.
	/** The address. */
	private String address = null; // (opcional) dirección del punto del
	// interés. Cadena de texto. Máximo 50
	// caracteres.
	/** The cross_street. */
	private String cross_street = null; // (opcional) calle transversal. Cadena
	// de texto. Máximo 50 caracteres.
	/** The city. */
	private String city = null; // (opcional) ciudad del punto de interés.
	// Cadena de texto. Máximo 50 caracteres.
	/** The country. */
	private String country = null; // (opcional) estado. Cadena de texto. Máximo
	// 30 caracteres.
	/** The postal_code. */
	private String postal_code = null; // (opcional) código postal. Cadena de
	// texto. Máximo 12 caracteres.
	/** The phone. */
	private String phone = null; // (opcional) teléfono de contacto. Cadena de
	// texto. Máximo 20 caracteres.
	/** The twitter. */
	private String twitter = null; // (opcional) identificador de usuario o

	// hashtag de Twitter. Cadena de texto.
	// Máximo 50 caracteres.

	/**
	 * Instantiates a new pOIS add.
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
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param geocode
	 * 			  the geocode
	 * @param accuracy
	 *            the accuracy
	 * @param vaccuracy
	 *            the vaccuracy
	 * @param elevation
	 *            the elevation
	 * @param categories
	 *            the categories
	 * @param name
	 *            the name
	 * @param desc
	 *            the desc
	 * @param address
	 *            the address
	 * @param cross_street
	 *            the cross_street
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 * @param postal_code
	 *            the postal_code
	 * @param phone
	 *            the phone
	 * @param twitter
	 *            the twitter
	 */
	public POISAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng, Boolean geocode,
			Double accuracy, Double vaccuracy, Double elevation,
			String categories, String name, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.geocode = geocode;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValidorNull(APIUtils.toStringBoolean(geocode));
		validate = validate && isValidorNull(APIUtils.toStringDouble(accuracy));
		validate = validate
				&& isValidorNull(APIUtils.toStringDouble(vaccuracy));
		validate = validate
				&& isValidorNull(APIUtils.toStringDouble(elevation));
		validate = validate && isValidorNull(categories);
		validate = validate && isValid(name);
		validate = validate && isValidorNull(desc);
		validate = validate && isValidorNull(address);
		validate = validate && isValidorNull(cross_street);
		validate = validate && isValidorNull(city);
		validate = validate && isValidorNull(country);
		validate = validate && isValidorNull(postal_code);
		validate = validate && isValidorNull(phone);
		validate = validate && isValidorNull(twitter);
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
			params = "/"
					+ this.Version
					+ "/pois/add."
					+ this.Format
					+ "?oauth_token="
					+ URLEncoder.encode(this.oauth_token)
					+ "&lat="
					+ URLEncoder.encode(APIUtils.toStringDouble(lat))
					+ "&lng="
					+ URLEncoder.encode(APIUtils.toStringDouble(lng))
					+ (geocode == null ? "" : "&geocode="
							+ URLEncoder.encode(APIUtils.toStringBoolean(geocode)))		
					+ (accuracy == null ? "" : "&accuracy="
							+ URLEncoder.encode(APIUtils.toStringDouble(accuracy)))
					+ (vaccuracy == null ? "" : "&vaccuracy="
							+ URLEncoder.encode(APIUtils.toStringDouble(vaccuracy)))
					+ (elevation == null ? "" : "&elevation="
							+ URLEncoder.encode(APIUtils.toStringDouble(elevation)))
					+ (categories == null ? "" : "&categories="
							+ URLEncoder.encode(APIUtils.toStringUrlEncoded(categories)))
					+ (name == null ? "" : "&name="
							+ URLEncoder.encode(APIUtils.toStringUrlEncoded(name)))
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
		return params;
	}

}
