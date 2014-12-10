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

import java.io.IOException;

import topoos.APIAccess.mime.HttpMultipartMode;
import topoos.APIAccess.mime.MultipartEntity;
import topoos.APIAccess.mime.content.ByteArrayBody;
import topoos.APIAccess.mime.content.StringBody;

/**
 * The Class ImageUpload.
 */
public class ImageUpload extends APIOperation {

	/** The Constant TYPE_POI. */
	public static final Integer TYPE_POI = 0;

	/** The Constant TYPE_POS. */
	public static final Integer TYPE_POS = 1;

	/** The Constant TYPE_NONE. */
	public static final Integer TYPE_NONE = -1;

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
	// recursos del usuario
	/** The file. */
	private byte[] file = null; // (obligatorio) Imagen serializada y codificada
								// en Base64.
	/** The filename. */
	private String filename = null;
	
	/** The file_format. */
	private String file_format = null;
	
	/** The keywords*/
	private String [] keywords = null;

	/** The privacy. */
	private String privacy = null;

	/** The pos_id. */
	private Integer pos_id = null;

	/** The poi_id. */
	private Integer poi_id = null;

	/** The lat. */
	private Double lat = null; // latitud de la posición en grados decimales.

	/** The lng. */
	private Double lng = null; // longitud de la posición en grados decimales.

	/** The name. */
	private String name = null; // (obligatorio): nombre del punto de interés.

	/** The description. */
	private String description = null; // (opcional): descripción del punto de
										// interés.
	/** The elevation. */
	private Integer elevation = null; // (opcional): elevación de la posición
	// respecto al nivel del mar, en metros.
	/** The accuracy. */
	private Integer accuracy = null; // (opcional): precisión de la latitud y
										// lontigud en metros.
	/** The vaccuracy. */
	private Integer vaccuracy = null; // (opcional): precisión de la elevación
										// en metros.
	/** The address. */
	private String address = null; // (opcional): dirección del punto de interés

	/** The cross_street. */
	private String cross_street = null; // (opcional): transversal a la
										// dirección del punto de interés.
	/** The city. */
	private String city = null; // (opcional): ciudad del punto de interés

	/** The country. */
	private String country = null; // (opcional): estado al que pertenece la
									// ciudad
	/** The postal_code. */
	private String postal_code = null; // (opcional): código postal

	/** The phone. */
	private String phone = null; // (opcional): número de teléfono

	/** The twitter. */
	private String twitter = null; // (opcional): identificador de usuario en
									// twitter o hashtag
	/** The categories. */
	private Integer []categories = null; // (obligatorio):  identificadores de

	// categorías a las que pertenece el
	// punto de interés

	/**
	 * Instantiates a new image upload.
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
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param id
	 *            the id
	 * @param type_id
	 *            the type_id
	 */
	public ImageUpload(String operationName, String method, String format,
			Integer version, String oauth_token, byte[] file, String filename,
			String file_format, String [] keywords,String privacy,
			Integer id, Integer type_id) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.file = file;
		this.filename = filename;
		this.file_format = file_format;
		this.keywords = keywords;
		this.privacy = privacy;
		if (type_id == TYPE_POI) {
			this.poi_id = id;
		} else if (type_id == TYPE_POS) {
			this.pos_id = id;
		} else {
			this.pos_id = this.poi_id = null;
		}
	}


	/**
	 * Instantiates a new image upload.
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
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param elevation
	 *            the elevation
	 * @param accuracy
	 *            the accuracy
	 * @param vaccuracy
	 *            the vaccuracy
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
	 * @param categories
	 *            the categories
	 */
	public ImageUpload(String operationName, String method, String format,
			Integer version, String oauth_token, byte[] file, String filename,
			String file_format, String [] keywords,String privacy,
			Double lat, Double lng, String name, String description,
			Integer elevation, Integer accuracy, Integer vaccuracy,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter, Integer []categories) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.file = file;
		this.filename = filename;
		this.file_format = file_format;
		this.keywords = keywords;
		this.privacy = privacy;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.description = description;
		this.elevation = elevation;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.address = address;
		this.cross_street = cross_street;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.phone = phone;
		this.twitter = twitter;
		this.categories = categories;
	}

	/**
	 * Instantiates a new image upload.
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
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 *            
	 * @param file_format the fileformat
	 * 
	 * @param keywords the keywords
	 * 
	 * @param privacy the privacy
	 * 
	 */
	public ImageUpload(String operationName, String method, String format,
			Integer version,String oauth_token,byte[] file, String filename, String file_format, String [] keywords, String privacy) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.file = file;
		this.filename = filename;
		this.file_format = file_format;
		this.keywords = keywords;
		this.privacy = privacy;

	}

	/**
	 * validate the params.
	 * 
	 * @return Boolean
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && file != null;
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(filename);
		validate = validate && isValidorNull(privacy);
		validate = validate && ! (keywords != null && keywords.length ==0);
		validate = validate && isValidorNull(file_format);
		validate = validate && isValidorNull(APIUtils.toStringInteger(pos_id));
		validate = validate && isValidorNull(APIUtils.toStringInteger(poi_id));
		validate = validate && isValidorNull(APIUtils.toStringDouble(lat));
		validate = validate && isValidorNull(APIUtils.toStringDouble(lng));
		validate = validate && isValidorNull(name);
		validate = validate && isValidorNull(description);
		validate = validate
				&& isValidorNull(APIUtils.toStringInteger(elevation));
		validate = validate
				&& isValidorNull(APIUtils.toStringInteger(accuracy));
		validate = validate
				&& isValidorNull(APIUtils.toStringInteger(vaccuracy));
		validate = validate && isValidorNull(address);
		validate = validate && isValidorNull(cross_street);
		validate = validate && isValidorNull(city);
		validate = validate && isValidorNull(country);
		validate = validate && isValidorNull(postal_code);
		validate = validate && isValidorNull(phone); 
		validate = validate && isValidorNull(twitter);
		validate = validate && ! (categories != null && categories.length ==0);
		//if the user/developer, has specified some of these parameters
		if (isValid (APIUtils.toStringDouble(lat))|| isValid (APIUtils.toStringDouble(lng)) || isValid (APIUtils.toStringIntegerArray(categories)) || isValid (name) ){
			//the developer will want to include a new POI, therefore, everyone should be valid
			validate = validate && isValid (APIUtils.toStringDouble(lat))&& isValid (APIUtils.toStringDouble(lng)) && isValid (APIUtils.toStringIntegerArray(categories)) && isValid (name);
		}
		return validate;
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#BodyParams()
	 */
	@Override
	public MultipartEntity BodyParams() throws IOException {
		MultipartEntity multipart = null;
		if (this.ValidateParams()) {
			multipart = new MultipartEntity(
					HttpMultipartMode.BROWSER_COMPATIBLE);// ,contentType,Charset.forName("UTF-8"));
			ByteArrayBody bab = new ByteArrayBody(file, filename);
			if (bab != null)
				multipart.addPart("File", bab);
			multipart.addPart("Oauth_token", new StringBody(oauth_token));
			if (file_format != null)
				multipart.addPart("fileformat",
						new StringBody(file_format));
			if (keywords != null)
				multipart.addPart("keywords", 
						new StringBody(APIUtils.toStringStringArray(keywords)));
			if (privacy != null) 
				multipart.addPart("privacy",
						new StringBody(privacy));
			if (pos_id != null) {
				multipart.addPart("pos_id",
						new StringBody(APIUtils.toStringInteger(pos_id)));
			} else if (poi_id != null) {
				multipart.addPart("poi_id",
						new StringBody(APIUtils.toStringInteger(poi_id)));
			} else if (lat != null && lng != null && categories != null && name !=null) {
				multipart.addPart(
						"Lat",
						new StringBody(Double.toString(lat)
								.replace(',', '.')));
				multipart.addPart(
						"Lng",
						new StringBody(Double.toString(lng)
								.replace(',', '.')));
				if (name != null)
				multipart.addPart("Name",
						new StringBody(name));
				if (description != null)
				multipart
						.addPart(
								"Description",
								new StringBody(description));
				if (elevation != null)
				multipart.addPart("Elevation",
						new StringBody(APIUtils.toStringInteger(elevation)));
				if (accuracy != null)
				multipart.addPart("Accuracy",
						new StringBody(APIUtils.toStringInteger(accuracy)));
				if (vaccuracy != null)
				multipart.addPart("Vaccuracy",
						new StringBody(APIUtils.toStringInteger(vaccuracy)));
				if (address != null)
				multipart.addPart("Address",
						new StringBody(address));
				if (cross_street != null)
				multipart.addPart(
						"Cross_street",
						new StringBody(cross_street));
				if (city != null)
				multipart.addPart("City",
						new StringBody(city));
				if (country != null)
				multipart.addPart("Country",
						new StringBody(country));
				if (postal_code != null)
				multipart
						.addPart(
								"Postal_code",
								new StringBody(postal_code));
				if (phone != null)
				multipart.addPart("phone",
						new StringBody(phone));
				if (twitter !=null)
				multipart.addPart("twitter",
						new StringBody(twitter));
				if (categories != null)
				multipart
						.addPart(
								"categories",
								new StringBody(APIUtils.toStringIntegerArray(categories)));
			}
		}
		return multipart;
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
			params = "/" + this.Version + "/image/upload";
		}
		return params;
	}

}
