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
 * Class that implements a topoos social relationship between users.
 *
 * @author topoos
 */
public class Relationship implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	private String user_id = null;
	
	/** The user name. */
	private String name = null;
	
	/** The description. */
	private ArrayList<RelationshipConnectionType> connections = null;
	
	/**
	 * Instantiates a new relationship.
	 *
	 * @param user_id the user id
	 * @param name the user name
	 * @param connections the connections with the specified user
	 */
	public Relationship(String user_id, String name, ArrayList<RelationshipConnectionType> connections) {
		this.user_id = user_id;
		this.name = name;
		this.connections = connections;
	}

	/**
	 * Get the user id.
	 *
	 * @return the id
	 */
	public String getUserId() {
		return user_id;
	}

	/**
	 * Sets the user id.
	 *
	 * @param id the id to set
	 */
	public void setUserId(String user_id) {
		this.user_id = user_id;
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
	 * get the connections.
	 *
	 * @return the description
	 */
	public ArrayList<RelationshipConnectionType> getConnections() {
		return connections;
	}

	/**
	 * Sets the connections.
	 *
	 * @param connections the connections to set
	 */
	public void setConnections(ArrayList<RelationshipConnectionType> connections) {
		this.connections = connections;
	}


}