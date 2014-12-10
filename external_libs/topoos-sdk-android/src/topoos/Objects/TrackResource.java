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
 * Class that implements a resource of the track.
 *
 * @author topoos
 */
public class TrackResource implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id=null;
	
	/** The Type. */
	private String Type=null;
	
	/** The Format. */
	private String Format=null;

	/**
	 * Instantiates a new track resource.
	 *
	 * @param id the id
	 * @param type the type
	 * @param format the format
	 */
	public TrackResource(Integer id, String type, String format) {
		super();
		this.id = id;
		Type = type;
		Format = format;
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
	 * get the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * get the format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * Sets the format.
	 *
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}
	
	
	
}
