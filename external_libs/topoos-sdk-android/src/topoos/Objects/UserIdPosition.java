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
 * Class that implements a user id position.
 *
 * @author topoos
 */
public class UserIdPosition implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The userid. */
	private String userid = null;
	
	/** The position. */
	private UserPosition position = null;
	
	/**
	 * Instantiates a new user id position.
	 *
	 * @param userid the userid
	 * @param position the position
	 */
	public UserIdPosition(String userid, UserPosition position) {
		super();
		this.userid = userid;
		this.position = position;
	}
	
	/**
	 * get the user position.
	 *
	 * @return the position
	 */
	public UserPosition getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param position the position to set
	 */
	public void setPosition(UserPosition position) {
		this.position = position;
	}
	
	/**
	 * get the user id.
	 *
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	
	/**
	 * Sets the userid.
	 *
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
