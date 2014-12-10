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
 * Class that implements a list of users that are near.
 *
 * @author topoos
 */
public class UsersNear  implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The userid positions. */
	private ArrayList<UserIdPosition> useridPositions=null;
	
	/**
	 * Instantiates a new users near.
	 *
	 * @param userPositions the user positions
	 */
	public UsersNear(
			ArrayList<UserIdPosition> userPositions) {
		this.useridPositions = userPositions;
	}

	/**
	 * get the user positions.
	 *
	 * @return the userPositions
	 */
	public ArrayList<UserIdPosition> getUserPositions() {
		return useridPositions;
	}

	/**
	 * Sets the user positions.
	 *
	 * @param userPositions the userPositions to set
	 */
	public void setUserPositions(ArrayList<UserIdPosition> userPositions) {
		this.useridPositions = userPositions;
	}



	
}

