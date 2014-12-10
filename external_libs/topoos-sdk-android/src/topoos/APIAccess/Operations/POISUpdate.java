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
 * The Class POISUpdate.
 *
 * @see APIOperation
 * @author topoos
 */
public class POISUpdate extends APIOperation{

	/** The oauth_token. */
	private String  oauth_token=null; //  (Required) access_token to user resources.
	
	/** The poi. */
	private Integer poi=null; //  (Required)  POI identifier we want Update. Integer.
	
	/** The name. */
	private String  name=null; // (Optional) (can’t be null if it is specified) landmark name. String. 255 characters.
	
	/** The desc. */
	private String  desc=null; //  (Optional) landmark description. String. Maximum 500 characters.
	
	/** The lat. */
	private Double 	lat=null; //  (Optional) (can’t be null if it is specified) latitude of the new position. Required if specified lng. Decimal.
	
	/** The lng. */
	private Double 	lng=null; // (No puede ser null) longitud de la nueva posición. Obligatorio si se especifica lat. Decimal.
	
	/** The geocode*/
	private Boolean geocode = null; //(Optional) Try to geocode the specified lat and lng, to fill unspecified attributes.
	
	/** The accuracy. */
	private Double 	accuracy=null; // (opcional) precisión de la posición (latitud, longitud). Decimal.
	
	/** The vaccuracy. */
	private Double 	vaccuracy=null; // (opcional) precisión de la elevación. Decimal.
	
	/** The elevation. */
	private Double 	elevation=null; // (opcional) elevación respecto al nivel del mar. Decimal.
	
	/** The categories. */
	private String 	categories=null; // (No puede ser null) identificadores de las categorías a las que pertenece este POI, separados por comas
	
	/** The address. */
	private String address=null; // (Optional) direction of the point of interest. String. Maximum 50 characters.
	
	/** The cross_street. */
	private String cross_street=null; //(Optional) cross street. String. Maximum 50 characters.
	
	/** The city. */
	private String city=null; //(Optional) City landmark. String. Maximum 50 characters.
	
	/** The country. */
	private String country=null; // (Optional) status. String. Maximum 30 characters.
	
	/** The postal_code. */
	private String postal_code=null; // (Optional) ZIP code. String. Maximum 12 characters.
	
	/** The phone. */
	private String phone=null; // (Optional) telephone number. String. Maximum 20 characters.
	
	/** The twitter. */
	private String twitter=null; // (Optional) userid or Twitter hashtag. String. Maximum 50 characters.
	

	/**
	 * Instantiates a new pOIS update.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 * @param name the name
	 * @param desc the desc
	 * @param lat the lat
	 * @param lng the lng
	 * @param geocode the geocode
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @param categories the categories
	 * @param address the address
	 * @param cross_street the cross_street
	 * @param city the city
	 * @param country the country
	 * @param postal_code the postal_code
	 * @param phone the phone
	 * @param twitter the twitter
	 */
	public POISUpdate(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String name,
			String desc, Double lat, Double lng, Boolean geocode, Double accuracy,
			Double vaccuracy, Double elevation, String categories,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.name = name;
		this.desc = desc;
		this.lat = lat;
		this.lng = lng;
		this.geocode = geocode;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.categories = categories;
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
		validate = validate && isValid(categories);
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValidorNull(APIUtils.toStringBoolean(geocode));
		validate = validate && isValidorNull(APIUtils.toStringDouble(accuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(vaccuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(elevation));
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(name));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(desc));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(address));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(cross_street));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(city));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(country));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(postal_code));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(phone));
		validate = validate && isValidorNull(APIUtils.toStringUrlEncoded(twitter));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/update." + this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+ "&poi="+URLEncoder.encode(APIUtils.toStringInteger(poi))
					+ "&lat="+URLEncoder.encode(APIUtils.toStringDouble(lat))
					+ "&lng="+URLEncoder.encode(APIUtils.toStringDouble(lng))
					+ (geocode == null ? "" : "&geocode="
							+ URLEncoder.encode(APIUtils.toStringBoolean(geocode)))	
					+(accuracy == null? "" : "&accuracy="+URLEncoder.encode(APIUtils.toStringDouble(accuracy)))
					+(vaccuracy == null? "" : "&vaccuracy="+URLEncoder.encode(APIUtils.toStringDouble(vaccuracy)))
					+(elevation == null? "" :  "&elevation="+URLEncoder.encode(APIUtils.toStringDouble(elevation)))
					+(categories == null? "" :  "&categories="+URLEncoder.encode(APIUtils.toStringUrlEncoded(categories)))
					+(name == null? "" :  "&name="+URLEncoder.encode(APIUtils.toStringUrlEncoded(name)))
					+(desc == null? "" :  "&desc="+URLEncoder.encode(APIUtils.toStringUrlEncoded(desc)))
					+(address == null? "" :  "&address="+URLEncoder.encode(APIUtils.toStringUrlEncoded(address)))
					+(cross_street == null? "" :  "&cross_street="+URLEncoder.encode(APIUtils.toStringUrlEncoded(cross_street)))
					+(city == null? "" :  "&city="+URLEncoder.encode(APIUtils.toStringUrlEncoded(city)))
					+(country == null? "" :  "&country="+URLEncoder.encode(APIUtils.toStringUrlEncoded(country)))
					+(postal_code == null? "" :  "&postal_code="+URLEncoder.encode(APIUtils.toStringUrlEncoded(postal_code)))
					+(phone == null? "" :  "&phone="+URLEncoder.encode(APIUtils.toStringUrlEncoded(phone)))
					+(twitter == null? "" :  "&twitter="+URLEncoder.encode(APIUtils.toStringUrlEncoded(twitter)))
					;
		}
		return params;
	}
}
