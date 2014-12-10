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
 * Class that implements a position collection.
 *
 * @author topoos
 */
public class PositionCollection implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The position collection. */
	ArrayList<Position> positionCollection=null;

	/**
	 * Instantiates a new position collection.
	 *
	 * @param positionCollection the position collection
	 */
	public PositionCollection(ArrayList<Position> positionCollection) {
		super();
		this.positionCollection = positionCollection;
	}

	/**
	 * get the position of the collection.
	 *
	 * @return the positionCollection
	 */
	public ArrayList<Position> getPositionCollection() {
		return positionCollection;
	}

	/**
	 * Sets the position collection.
	 *
	 * @param positionCollection the positionCollection to set
	 */
	public void setPositionCollection(ArrayList<Position> positionCollection) {
		this.positionCollection = positionCollection;
	}
	
	
	
}
