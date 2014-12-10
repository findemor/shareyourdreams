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
 * Class that implements a object Checkin.
 *
 * @author topoos
 */
public class Checkin implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id=null;
	
	/** The User */
	private String user_id=null;
	
	/** The device_id. */
	private Integer device_id=null;
	
	/** The poi_id. */
	private Integer poi_id=null;
	
	/** The register_time. */
	private Date register_time=null;
	
	/** The timestamp. */
	private Date timestamp=null;
	
	/**
	 * Instantiates a new checkin.
	 *
	 * @param id the id
	 * @param user_id the user
	 * @param device_id the device_id
	 * @param poi_id the poi_id
	 * @param register_time the register_time
	 * @param timestamp the timestamp
	 */
	public Checkin(Integer id, String user_id, Integer device_id, Integer poi_id,
			Date register_time, Date timestamp) {
		super();
		this.id = id;
		this.setUser_id(user_id);
		this.device_id = device_id;
		this.poi_id = poi_id;
		this.register_time = register_time;
		this.timestamp = timestamp;
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
	 * get the user_id.
	 *
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	
	
	/**
	 * Sets the user_id.
	 *
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * get the device id.
	 *
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	
	/**
	 * Sets the device_id.
	 *
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	
	/**
	 * get the id of the poi.
	 *
	 * @return the poi_id
	 */
	public Integer getPoi_id() {
		return poi_id;
	}
	
	/**
	 * Sets the poi_id.
	 *
	 * @param poi_id the poi_id to set
	 */
	public void setPoi_id(Integer poi_id) {
		this.poi_id = poi_id;
	}
	
	/**
	 * get the register time.
	 *
	 * @return the register_time
	 */
	public Date getRegister_time() {
		return register_time;
	}
	
	/**
	 * Sets the register_time.
	 *
	 * @param register_time the register_time to set
	 */
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	
	/**
	 * get the timestamp.
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
	
	
}
