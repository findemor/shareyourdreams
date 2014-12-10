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
 * Class that implements a user.
 *
 * @author topoos
 */
public class User   implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	private String Id = null;
	
	/** The Name. */
	private String Name = null;
	
	/** The Email. */
	private String Email = null;
	
	/** The Profile. */
	private Profile Profile = null;
	
	/** The Ugroup. */
	private ArrayList<Integer> Ugroup = null;
	
	/** The Acreditation. */
	private Acreditation Acreditation = null;

	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param name the name
	 * @param email the email
	 * @param profile the profile
	 * @param ugroup the ugroup
	 * @param acreditation the acreditation
	 */
	public User(String id, String name,
			String email, Profile profile,
			ArrayList<Integer> ugroup,
			Acreditation acreditation) {
		Id = id;
		Name = name;
		Email = email;
		Profile = profile;
		Ugroup = ugroup;
		Acreditation = acreditation;
	}


	/**
	 * get the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * get the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * get the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * get the profile.
	 *
	 * @return the profile
	 */
	public Profile getProfile() {
		return Profile;
	}

	/**
	 * Sets the profile.
	 *
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		Profile = profile;
	}

	/**
	 * get the id of the group.
	 *
	 * @return the ugroup
	 */
	public ArrayList<Integer> getUgroup() {
		return Ugroup;
	}

	/**
	 * Sets the ugroup.
	 *
	 * @param ugroup the ugroup to set
	 */
	public void setUgroup(ArrayList<Integer> ugroup) {
		Ugroup = ugroup;
	}

	/**
	 * get the acreditation.
	 *
	 * @return the acreditation
	 */
	public Acreditation getAcreditation() {
		return Acreditation;
	}

	/**
	 * Sets the acreditation.
	 *
	 * @param acreditation the acreditation to set
	 */
	public void setAcreditation(Acreditation acreditation) {
		Acreditation = acreditation;
	}



	

}
