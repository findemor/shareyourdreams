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
 * Class that implements a type of position.
 *
 * @author topoos
 */
public class PositionType implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	String id = null;
	
	/** The description. */
	String description = null;

	/**
	 * Instantiates a new position type.
	 *
	 * @param id the id
	 * @param description the description
	 */
	public PositionType(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	/**
	 * get the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
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

}