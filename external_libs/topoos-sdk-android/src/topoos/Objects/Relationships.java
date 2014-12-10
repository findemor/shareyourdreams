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
 * Class that implements a topoos social relationship collection between users.
 *
 * @author topoos
 */
public class Relationships implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The cursor prev. */
	private Integer cursor_prev = -1;
	/** The cursor next */
	private Integer cursor_next = -1;
	
	/** The description. */
	private ArrayList<Relationship> relationship = null;
	
	/**
	 * Instantiates a new relationship.
	 *
	 * @param status the relationship response status
	 * @param relationship the relationship collection
	 * @param cursor_prev the cursor prev
	 * @param cursor_next the cursor next
	 */
	public Relationships(ArrayList<Relationship> relationship, Integer cursor_prev, Integer cursor_next) {
		this.cursor_prev = cursor_prev;
		this.cursor_next = cursor_next;
		this.relationship = relationship;
	}

	/**
	 * get the cursor prev.
	 *
	 * @return cursor prev
	 */
	public Integer getCursorPrev() {
		return this.cursor_prev;
	}

	/**
	 * Sets The cursor prev.
	 *
	 * @param cursor_prev The cursor prev.
	 */
	public void setCursorPrev(Integer cursor_prev) {
		this.cursor_prev = cursor_prev;
	}
	

	/**
	 * get the cursor next.
	 *
	 * @return cursor next
	 */
	public Integer getCursorNext() {
		return this.cursor_next;
	}

	/**
	 * Sets The cursor next.
	 *
	 * @param cursor_next The cursor next.
	 */
	public void setCursorNext(Integer cursor_next) {
		this.cursor_next = cursor_next;
	}

	/**
	 * get the relationship collection.
	 *
	 * @return the relationship collection
	 */
	public ArrayList<Relationship> getRelationship() {
		return this.relationship;
	}

	/**
	 * Sets the relationships.
	 *
	 * @param relationship the relationships to set
	 */
	public void setConnections(ArrayList<Relationship> relationship) {
		this.relationship = relationship;
	}


}