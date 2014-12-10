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
 * Class that implements a collection of warning of the pois.
 *
 * @author FBP
 */
public class POIWarningCollection implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	
	/** The POI warnings. */
	private ArrayList<POIDataWarning> POIWarnings=null;

	/**
	 * Instantiates a new pOI warning collection.
	 *
	 * @param pOIWarnings the oI warnings
	 */
	public POIWarningCollection(ArrayList<POIDataWarning> pOIWarnings) {
		super();
		POIWarnings = pOIWarnings;
	}

	/**
	 * get the poi warnings.
	 *
	 * @return the pOIWarnings
	 */
	public ArrayList<POIDataWarning> getPOIWarnings() {
		return POIWarnings;
	}

	/**
	 * Sets the pOI warnings.
	 *
	 * @param pOIWarnings the pOIWarnings to set
	 */
	public void setPOIWarnings(ArrayList<POIDataWarning> pOIWarnings) {
		POIWarnings = pOIWarnings;
	}


	
	
	

}
