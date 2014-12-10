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
 * Class that implements a collection of POI.
 *
 * @author FBP
 */
public class POICollection implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The poi list. */
	private ArrayList<POI> poiList = null;

	/**
	 * Instantiates a new pOI collection.
	 *
	 * @param poiList the poi list
	 */
	public POICollection(ArrayList<POI> poiList) {
		super();
		this.poiList = poiList;
	}

	/**
	 * get the poiList.
	 *
	 * @return the poiList
	 */
	public ArrayList<POI> getPoiList() {
		return poiList;
	}

	/**
	 * Sets the poi list.
	 *
	 * @param poiList the poiList to set
	 */
	public void setPoiList(ArrayList<POI> poiList) {
		this.poiList = poiList;
	}

}
