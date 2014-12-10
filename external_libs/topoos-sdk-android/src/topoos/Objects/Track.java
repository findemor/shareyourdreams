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
 * The Class Track.
 *
 * @author topoos
 */
public class Track implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id=null;
	
	/** The name. */
	private String name=null;
	
	/** The device. */
	private Integer device=null;
	
	/** The positions. */
	private ArrayList<Position> positions=null;
	
	/**
	 * Instantiates a new track.
	 *
	 * @param id the id
	 * @param name the name
	 * @param device the device
	 * @param positions the positions
	 */
	public Track(Integer id, String name, Integer device,
			ArrayList<Position> positions) {
		super();
		this.id = id;
		this.name = name;
		this.device = device;
		this.positions = positions;
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
	 * get the device.
	 *
	 * @return the device
	 */
	public Integer getDevice() {
		return device;
	}
	
	/**
	 * Sets the device.
	 *
	 * @param device the device to set
	 */
	public void setDevice(Integer device) {
		this.device = device;
	}
	
	/**
	 * get the positions.
	 *
	 * @return the positions
	 */
	public ArrayList<Position> getPositions() {
		return positions;
	}
	
	/**
	 * Sets the positions.
	 *
	 * @param positions the positions to set
	 */
	public void setPositions(ArrayList<Position> positions) {
		this.positions = positions;
	}
	
	
}
