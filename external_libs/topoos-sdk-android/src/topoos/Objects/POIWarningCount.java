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
 * The Class POIWarningCount.
 */
public class POIWarningCount implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;
	
	/** The closed. */
	Integer closed=null;
	
	/** The duplicated. */
	Integer duplicated=null;
	
	/** The wrong indicator. */
	Integer wrongIndicator=null;
	
	/** The wrong info. */
	Integer wrongInfo=null;
	
	/**
	 * Instantiates a new pOI warning count.
	 *
	 * @param closed the closed
	 * @param duplicated the duplicated
	 * @param wrongIndicator the wrong indicator
	 * @param wrongInfo the wrong info
	 */
	public POIWarningCount(Integer closed, Integer duplicated,
			Integer wrongIndicator, Integer wrongInfo) {
		super();
		this.closed = closed;
		this.duplicated = duplicated;
		this.wrongIndicator = wrongIndicator;
		this.wrongInfo = wrongInfo;
	}
	
	/**
	 * get the closed.
	 *
	 * @return the closed
	 */
	public Integer getClosed() {
		return closed;
	}
	
	/**
	 * Sets the closed.
	 *
	 * @param closed the closed to set
	 */
	public void setClosed(Integer closed) {
		this.closed = closed;
	}
	
	/**
	 * get the duplicated.
	 *
	 * @return the duplicated
	 */
	public Integer getDuplicated() {
		return duplicated;
	}
	
	/**
	 * Sets the duplicated.
	 *
	 * @param duplicated the duplicated to set
	 */
	public void setDuplicated(Integer duplicated) {
		this.duplicated = duplicated;
	}
	
	/**
	 * get the wrong indicator.
	 *
	 * @return the wrongIndicator
	 */
	public Integer getWrongIndicator() {
		return wrongIndicator;
	}
	
	/**
	 * Sets the wrong indicator.
	 *
	 * @param wrongIndicator the wrongIndicator to set
	 */
	public void setWrongIndicator(Integer wrongIndicator) {
		this.wrongIndicator = wrongIndicator;
	}
	
	/**
	 * get the wrong info.
	 *
	 * @return the wrongInfo
	 */
	public Integer getWrongInfo() {
		return wrongInfo;
	}
	
	/**
	 * Sets the wrong info.
	 *
	 * @param wrongInfo the wrongInfo to set
	 */
	public void setWrongInfo(Integer wrongInfo) {
		this.wrongInfo = wrongInfo;
	}
	
	
}