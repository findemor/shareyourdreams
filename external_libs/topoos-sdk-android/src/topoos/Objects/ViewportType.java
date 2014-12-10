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

/**
 * Class that implements a view of the type of port.
 *
 * @author topoos
 */
public class ViewportType implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;
	
	/** The southwest. */
	Location southwest=null;
	
	/** The northeast. */
	Location northeast=null;
	
	/**
	 * Instantiates a new viewport type.
	 *
	 * @param southwest the southwest
	 * @param northeast the northeast
	 */
	public ViewportType(Location southwest, Location northeast) {
		super();
		this.southwest = southwest;
		this.northeast = northeast;
	}
	
	/**
	 * get the northeast.
	 *
	 * @return the northeast
	 */
	public Location getNortheast() {
		return northeast;
	}
	
	/**
	 * Sets the northeast.
	 *
	 * @param northeast the northeast to set
	 */
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}
	
	/**
	 * get the southwest.
	 *
	 * @return the southwest
	 */
	public Location getSouthwest() {
		return southwest;
	}
	
	/**
	 * Sets the southwest.
	 *
	 * @param southwest the southwest to set
	 */
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	
	
	
}
