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
 * Class that implements a poi warning.
 *
 * @author topoos
 */
public class POIWarning implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id=null;
	
	/** The poi_id. */
	private Integer poi_id=null;
	
	/** The type. */
	private String type=null;
	
	/** The user_id. */
	private String user_id=null;
	
	/** The timestamp. */
	private Date timestamp=null;
	
	/** The data. */
	private POIWarningData data=null;
	
	
	/**
	 * Instantiates a new pOI warning.
	 *
	 * @param id the id
	 * @param poi_id the poi_id
	 * @param type the type
	 * @param user_id the user_id
	 * @param timestamp the timestamp
	 * @param data the data
	 */
	public POIWarning(Integer id, Integer poi_id, String type, String user_id,
			Date timestamp, POIWarningData data) {
		super();
		this.id = id;
		this.poi_id = poi_id;
		this.type = type;
		this.user_id = user_id;
		this.timestamp = timestamp;
		this.data = data;
	}
	
	/**
	 * get the id of the warning.
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
	 * get the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * get the id of the user.
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
	 * get the data of the warning.
	 *
	 * @return the data
	 */
	public POIWarningData getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the data to set
	 */
	public void setData(POIWarningData data) {
		this.data = data;
	}

	
}
