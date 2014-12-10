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

package topoos.APIAccess.Results;

import topoos.Exception.TopoosException;

/**
 * The Class WebMapURIResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class TrackResourceExportedResult extends APICallResult{

	/** The trackresource. */
	String trackresource=null;
	
	
	
	/**
	 * Instantiates a track resource result.
	 */
	public TrackResourceExportedResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * Instantiates a track resource result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public TrackResourceExportedResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		this.trackresource=this.Result;
	}



	/**
	 * Gets the trackresource.
	 *
	 * @return the trackresource
	 */
	public String getTrackresource() {
		return trackresource;
	}



	/**
	 * Sets the webmapuri.
	 *
	 * @param trackresource the trackresource to set
	 */
	public void setTrackresource(String trackresource) {
		this.trackresource = trackresource;
	}

	
}
