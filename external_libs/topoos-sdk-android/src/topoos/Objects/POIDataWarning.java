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
 * Class that implements a poi data warning.
 *
 * @author topoos
 */
public class POIDataWarning implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;
	
	/** The poi. */
	private POI poi=null;
	
	/** The poi warnings. */
	private ArrayList<POIWarning> poiWarnings=null;
	
	/**
	 * Instantiates a new pOI data warning.
	 *
	 * @param poi the poi
	 * @param poiWarnings the poi warnings
	 */
	public POIDataWarning(POI poi, ArrayList<POIWarning> poiWarnings) {
		super();
		this.poi = poi;
		this.poiWarnings = poiWarnings;
	}
	
	/**
	 * get the poi.
	 *
	 * @return the poi
	 */
	public POI getPoi() {
		return poi;
	}
	
	/**
	 * Sets the poi.
	 *
	 * @param poi the poi to set
	 */
	public void setPoi(POI poi) {
		this.poi = poi;
	}
	
	/**
	 * get the poi warnings.
	 *
	 * @return the poiWarnings
	 */
	public ArrayList<POIWarning> getPoiWarnings() {
		return poiWarnings;
	}
	
	/**
	 * Sets the poi warnings.
	 *
	 * @param poiWarnings the poiWarnings to set
	 */
	public void setPoiWarnings(ArrayList<POIWarning> poiWarnings) {
		this.poiWarnings = poiWarnings;
	}

}
