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
public class WebMapURIResult extends APICallResult{

	/** The webmapuri. */
	String webmapuri=null;
	
	
	
	/**
	 * Instantiates a new web map uri result.
	 */
	public WebMapURIResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * Instantiates a new web map uri result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public WebMapURIResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		this.webmapuri=this.Result;
	}



	/**
	 * Gets the webmapuri.
	 *
	 * @return the webmapuri
	 */
	public String getWebmapuri() {
		return webmapuri;
	}



	/**
	 * Sets the webmapuri.
	 *
	 * @param webmapuri the webmapuri to set
	 */
	public void setWebmapuri(String webmapuri) {
		this.webmapuri = webmapuri;
	}

	
}
