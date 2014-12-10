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
 * Class that implements a checkingcollection where are saves all check ins.
 *
 * @author topoos
 */
public class CheckinCollection implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Check ins. */
	ArrayList<Checkin> CheckIns=null;

	/**
	 * Instantiates a new checkin collection.
	 *
	 * @param checkIns the check ins
	 */
	public CheckinCollection(ArrayList<Checkin> checkIns) {
		super();
		CheckIns = checkIns;
	}

	/**
	 * Get the check ins.
	 *
	 * @return the checkIns
	 */
	public ArrayList<Checkin> getCheckIns() {
		return CheckIns;
	}

	/**
	 * Sets the check ins.
	 *
	 * @param checkIns the checkIns to set
	 */
	public void setCheckIns(ArrayList<Checkin> checkIns) {
		CheckIns = checkIns;
	}
	
	
}
