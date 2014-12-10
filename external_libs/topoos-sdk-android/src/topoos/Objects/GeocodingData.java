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
 * Class that implements a geocoding data.
 *
 * @author topoos
 */
public class GeocodingData implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

    /** The address. */
    public Address address =null;
    
    /** The location. */
    public Location location =null;
    
    /** The bounds. */
    public ViewportType bounds =null;
	
	/**
	 * Instantiates a new geocoding data.
	 *
	 * @param address the address
	 * @param location the location
	 * @param bounds the bounds
	 */
	public GeocodingData(Address address, Location location, ViewportType bounds) {
		super();
		this.address = address;
		this.location = location;
		this.bounds = bounds;
	}
	
	/**
	 * get the address that it is saved in a geocoding data.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * get the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * get the bounds.
	 *
	 * @return the bounds
	 */
	public ViewportType getBounds() {
		return bounds;
	}
	
	/**
	 * Sets the bounds.
	 *
	 * @param bounds the bounds to set
	 */
	public void setBounds(ViewportType bounds) {
		this.bounds = bounds;
	}
	
    
    
}
