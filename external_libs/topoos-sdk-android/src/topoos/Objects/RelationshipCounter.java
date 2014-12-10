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
 * Class that implements a topoos social relationships counter.
 *
 * @author topoos
 */
public class RelationshipCounter implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	private String user_id = null;
	
	/** The number of the users following this. */
	private Integer following = null;
	
	/** The number of the users followed by this. */
	private Integer followedBy = null;
	
	/**
	 * Instantiates a new relationship counter.
	 *
	 * @param user_id the user id
	 * @param following The number of the users following this
	 * @param followedby The number of the users followed by this
	 */
	public RelationshipCounter(String user_id, Integer following, Integer followedBy) {
		this.user_id = user_id;
		this.following = following;
		this.followedBy = followedBy;
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
	 * get the number of the users following this
	 *
	 * @return the number of the users following this
	 */
	public Integer getFollowing() {
		return following;
	}

	/**
	 * Sets the number of the users following this
	 *
	 * @param name the number of the users following this
	 */
	public void setFollowing(Integer following) {
		this.following = following;
	}


	/**
	 * get the number of the users followed by this.
	 *
	 * @return the number of the users followed by this.
	 */
	public Integer getFollowedBy() {
		return followedBy;
	}

	/**
	 * Sets the number of the users followed by this.
	 *
	 * @param name the number of the users followed by this.
	 */
	public void setFollowedBy(Integer followedBy) {
		this.followedBy = followedBy;
	}



}