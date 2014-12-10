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

package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class that implements the warning data of the pois.
 *
 * @author topoos
 */
public class POIWarningData implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id =null;
    
    /** The latitude. */
    private Double latitude =null;
    
    /** The longitude. */
    private Double longitude =null;
    
    /** The accuracy. */
    private Double accuracy =null;
    
    /** The vaccuracy. */
    private Double vaccuracy =null;
    
    /** The elevation. */
    private Double elevation =null;
    
    /** The name. */
    private String name =null;
    
    /** The address. */
    private String address =null;
    
    /** The cross_street. */
    private String cross_street =null;
    
    /** The city. */
    private String city =null;
    
    /** The country. */
    private String country =null;
    
    /** The postal_code. */
    private String postal_code =null;
    
    /** The phone. */
    private String phone =null;
    
    /** The twitter. */
    private String twitter =null;
    
    /** The description. */
    private String description =null;
    
    /** The categories. */
    private ArrayList<POICategory> categories =null;
	
	/**
	 * Instantiates a new pOI warning data.
	 *
	 * @param id the id
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @param name the name
	 * @param address the address
	 * @param cross_street the cross_street
	 * @param city the city
	 * @param country the country
	 * @param postal_code the postal_code
	 * @param phone the phone
	 * @param twitter the twitter
	 * @param description the description
	 * @param categories the categories
	 */
	public POIWarningData(Integer id, Double latitude, Double longitude,
			Double accuracy, Double vaccuracy, Double elevation, String name,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			String description, ArrayList<POICategory> categories) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.name = name;
		this.address = address;
		this.cross_street = cross_street;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.phone = phone;
		this.twitter = twitter;
		this.description = description;
		this.categories = categories;
	}
	
	/**
	 * get the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * get the latitude.
	 *
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 *
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * get the longitude.
	 *
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 *
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * get the accuracy.
	 *
	 * @return the accuracy
	 */
	public Double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Sets the accuracy.
	 *
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}
	
	/**
	 * get the vaccuracy.
	 *
	 * @return the vaccuracy
	 */
	public Double getVaccuracy() {
		return vaccuracy;
	}
	
	/**
	 * Sets the vaccuracy.
	 *
	 * @param vaccuracy the vaccuracy to set
	 */
	public void setVaccuracy(Double vaccuracy) {
		this.vaccuracy = vaccuracy;
	}
	
	/**
	 * get the elevation.
	 *
	 * @return the elevation
	 */
	public Double getElevation() {
		return elevation;
	}
	
	/**
	 * Sets the elevation.
	 *
	 * @param elevation the elevation to set
	 */
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	
	/**
	 * get the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * get the cross street.
	 *
	 * @return the cross_street
	 */
	public String getCross_street() {
		return cross_street;
	}
	
	/**
	 * Sets the cross_street.
	 *
	 * @param cross_street the cross_street to set
	 */
	public void setCross_street(String cross_street) {
		this.cross_street = cross_street;
	}
	
	/**
	 * get the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * get the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * get the postal code.
	 *
	 * @return the postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}
	
	/**
	 * Sets the postal_code.
	 *
	 * @param postal_code the postal_code to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	
	/**
	 * get the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * get the twitter.
	 *
	 * @return the twitter
	 */
	public String getTwitter() {
		return twitter;
	}
	
	/**
	 * Sets the twitter.
	 *
	 * @param twitter the twitter to set
	 */
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
	/**
	 * get the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * get the categories.
	 *
	 * @return the categories
	 */
	public ArrayList<POICategory> getCategories() {
		return categories;
	}
	
	/**
	 * Sets the categories.
	 *
	 * @param categories the categories to set
	 */
	public void setCategories(ArrayList<POICategory> categories) {
		this.categories = categories;
	}
	
    
    
}
