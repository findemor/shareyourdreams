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
import java.util.Date;

/**
 * Class that implements a position.
 *
 * @author FBP
 */
public class Position implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	Integer id = null;
	
	/** The device. */
	String device = null;
	
	/** The timestamp. */
	Date timestamp = null;
	
	/** The register time. */
	Date registerTime = null;
	
	/** The latitude. */
	Double latitude = null;
	
	/** The longitude. */
	Double longitude = null;
	
	/** The elevation. */
	Double elevation = null;
	
	/** The position type. */
	PositionType positionType = null;
	
	/** The accuracy. */
	Double accuracy = null;
	
	/** The vaccuracy. */
	Double vaccuracy = null;
	
	/** The bearing. */
	Double bearing = null;
	
	/** The velocity. */
	Double velocity = null;
	
	/** The track_id. */
	String track_id = null;

	/**
	 * Instantiates a new position.
	 *
	 * @param id the id
	 * @param device the device
	 * @param timestamp the timestamp
	 * @param registerTime the register time
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param elevation the elevation
	 * @param positionType the position type
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param bearing the bearing
	 * @param velocity the velocity
	 * @param track_id the track_id
	 */
	public Position(Integer id, String device,
			Date timestamp, Date registerTime, Double latitude,
			Double longitude, Double elevation, PositionType positionType,
			Double accuracy, Double vaccuracy, Double bearing, Double velocity,
			String track_id) {
		this.id = id;
		this.device = device;
		this.timestamp = timestamp;
		this.registerTime = registerTime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.positionType = positionType;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.bearing = bearing;
		this.velocity = velocity;
		this.track_id = track_id;
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
	 * get the device.
	 *
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * get the time stamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * get the register time.
	 *
	 * @return the registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * Sets the register time.
	 *
	 * @param registerTime the registerTime to set
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
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
	 * get the position type.
	 *
	 * @return the positionType
	 */
	public PositionType getPositionType() {
		return positionType;
	}

	/**
	 * Sets the position type.
	 *
	 * @param positionType the positionType to set
	 */
	public void setPositionType(PositionType positionType) {
		this.positionType = positionType;
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
	 * get the bearing.
	 *
	 * @return the bearing
	 */
	public Double getBearing() {
		return bearing;
	}

	/**
	 * Sets the bearing.
	 *
	 * @param bearing the bearing to set
	 */
	public void setBearing(Double bearing) {
		this.bearing = bearing;
	}

	/**
	 * get the velocity.
	 *
	 * @return the velocity
	 */
	public Double getVelocity() {
		return velocity;
	}

	/**
	 * Sets the velocity.
	 *
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Double velocity) {
		this.velocity = velocity;
	}

	/**
	 * get the track id.
	 *
	 * @return the track_id
	 */
	public String getTrack_id() {
		return track_id;
	}

	/**
	 * Sets the track_id.
	 *
	 * @param track_id the track_id to set
	 */
	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}

	
}