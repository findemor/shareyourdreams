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
import java.util.Date;

/**
 * Class that implements a profile.
 *
 * @author topoos
 */
public class Profile implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Birthday. */
	private Date Birthday = null;
	
	/** The Gender. */
	private String Gender = null;

	/**
	 * Instantiates a new profile.
	 *
	 * @param birthday the birthday
	 * @param gender the gender
	 */
	public Profile(Date birthday, String gender) {
		super();
		Birthday = birthday;
		Gender = gender;
	}

	/**
	 * get the birthday.
	 *
	 * @return Date of birthday
	 */
	public Date getBirthday() {
		return Birthday;
	}

	/**
	 * Set the birthday date.
	 *
	 * @param birthday date of birthday to set
	 */
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	/**
	 * get the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}
}