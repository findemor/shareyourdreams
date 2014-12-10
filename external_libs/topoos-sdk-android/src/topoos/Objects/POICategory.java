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
 * Class that implements a category of a POI.
 *
 * @author topoos
 */
public class POICategory implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id = null;
	
	/** The description. */
	private String description = null;
	
	/** The is system. */
	private Boolean isSystem = null;

	/**
	 * Instantiates a new pOI category.
	 *
	 * @param id the id
	 * @param description the description
	 * @param isSystem the is system
	 */
	public POICategory(Integer id, String description, Boolean isSystem) {
		super();
		this.id = id;
		this.description = description;
		this.isSystem = isSystem;
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
	 * get the is system status.
	 *
	 * @return the isSystem
	 */
	public Boolean getIsSystem() {
		return isSystem;
	}

	/**
	 * Sets the checks if is system.
	 *
	 * @param isSystem the isSystem to set
	 */
	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}

}