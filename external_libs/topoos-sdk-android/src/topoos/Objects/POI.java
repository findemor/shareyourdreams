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
import java.util.Date;

/**
 * Class that implements a point of interest.
 *
 * @author topoos
 */
public class POI implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id = null;
	
	/** The name. */
	private String name = null;
	
	/** The description. */
	private String description = null;
	
	/** The latitude. */
	private Double latitude = null;
	
	/** The longitude. */
	private Double longitude = null;
	
	/** The elevation. */
	private Double elevation = null;
	
	/** The accuracy. */
	private Double accuracy = null;
	
	/** The vaccuracy. */
	private Double vaccuracy = null;
	
	/** The registertime. */
	private Date registertime = null;
	
	/** The categories. */
	private ArrayList<POICategory> categories = null;
	
	/** The address. */
	private String address = null;
	
	/** The cross street. */
	private String crossStreet = null;
	
	/** The city. */
	private String city = null;
	
	/** The country. */
	private String country = null;
	
	/** The postal code. */
	private String postalCode = null;
	
	/** The phone. */
	private String phone = null;
	
	/** The twitter. */
	private String twitter = null;
	
	/** The last update. */
	private Date lastUpdate = null;
	
	/** The warningcount. */
	private POIWarningCount warningcount = null;

	/**
	 * Instantiates a new poi.
	 *
	 * @param id the id
	 * @param name the name
	 * @param description the description
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param elevation the elevation
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param registertime the registertime
	 * @param categories the categories
	 * @param address the address
	 * @param crossStreet the cross street
	 * @param city the city
	 * @param country the country
	 * @param postalCode the postal code
	 * @param phone the phone
	 * @param twitter the twitter
	 * @param lastUpdate the last update
	 * @param warningcount the warningcount
	 */
	public POI(Integer id, String name, String description, Double latitude,
			Double longitude, Double elevation, Double accuracy,
			Double vaccuracy, Date registertime,
			ArrayList<POICategory> categories, String address,
			String crossStreet, String city, String country, String postalCode,
			String phone, String twitter, Date lastUpdate,
			POIWarningCount warningcount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.registertime = registertime;
		this.categories = categories;
		this.address = address;
		this.crossStreet = crossStreet;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.twitter = twitter;
		this.lastUpdate = lastUpdate;
		this.warningcount = warningcount;
	}

	/**
	 * Get the id of the poi.
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
	 * get the register time.
	 *
	 * @return the registertime
	 */
	public Date getRegistertime() {
		return registertime;
	}

	/**
	 * Sets the registertime.
	 *
	 * @param registertime the registertime to set
	 */
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	/**
	 * get a list of the categories.
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
	 * @return the crossStreet
	 */
	public String getCrossStreet() {
		return crossStreet;
	}

	/**
	 * Sets the cross street.
	 *
	 * @param crossStreet the crossStreet to set
	 */
	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
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
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	 * get the twitter id.
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
	 * get the last update.
	 *
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * Sets the last update.
	 *
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * get the warning count.
	 *
	 * @return the warningcount
	 */
	public POIWarningCount getWarningcount() {
		return warningcount;
	}

	/**
	 * Sets the warningcount.
	 *
	 * @param warningcount the warningcount to set
	 */
	public void setWarningcount(POIWarningCount warningcount) {
		this.warningcount = warningcount;
	}

}