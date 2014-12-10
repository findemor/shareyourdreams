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
 * Class that implements a visible device.
 *
 * @author topoos
 */
public class VisibleDevice implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	private String Id = null;
	
	/** The Name. */
	private String Name = null;
	
	/** The Model. */
	private Integer Model = null;
	
	/** The is logical. */
	private Boolean isLogical = null;
	
	/**
	 * Instantiates a new visible device.
	 *
	 * @param id the id
	 * @param name the name
	 * @param model the model
	 * @param isLogical the is logical
	 */
	public VisibleDevice(String id, String name, Integer model,
			Boolean isLogical) {
		super();
		Id = id;
		Name = name;
		Model = model;
		this.isLogical = isLogical;
	}
	
	/**
	 * get the device id.
	 *
	 * @return the device id
	 */
	public String getId() {
		return Id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id set the device큦 id
	 */
	public void setId(String id) {
		Id = id;
	}
	
	/**
	 * get the name of the device.
	 *
	 * @return the name
	 * name of the device
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name set the device큦 name
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * get the model of the device.
	 *
	 * @return the model
	 * model of the device
	 */
	public Integer getModel() {
		return Model;
	}
	
	/**
	 * Sets the model.
	 *
	 * @param model set device큦 model
	 */
	public void setModel(Integer model) {
		Model = model;
	}
	
	/**
	 * get the type of the device true if it is logical.
	 *
	 * @return the checks if is logical
	 * if is a logical device
	 */
	public Boolean getIsLogical() {
		return isLogical;
	}
	
	/**
	 * Sets the checks if is logical.
	 *
	 * @param isLogical set device큦 type
	 */
	public void setIsLogical(Boolean isLogical) {
		this.isLogical = isLogical;
	}
}