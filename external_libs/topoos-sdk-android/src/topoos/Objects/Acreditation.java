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
 * Class that implement.
 *
 * @author topoos
 */
public class Acreditation implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Expirationtime. */
	private String Expirationtime = null;
	
	/** The client id. */
	private String clientId = null;
	
	/** The access_token. */
	private String access_token = null;
	
	/** The refresh_token. */
	private String refresh_token = null;

	
	
	/** The visibledevices. */
	private ArrayList<VisibleDevice> visibledevices = null;

	/**
	 * Instantiates a new acreditation.
	 *
	 * @param expirationtime the expirationtime
	 * @param clientId the client id
	 * @param visibledevices the visibledevices
	 */
	public Acreditation(String expirationtime, String clientId, String access_token,String refresh_token,
			ArrayList<VisibleDevice> visibledevices) {
		super();
		Expirationtime = expirationtime;
		this.clientId = clientId;
		this.visibledevices = visibledevices;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
	}

	/**
	 * Gets the expirationtime.
	 *
	 * @return the expirationtime
	 */
	public String getExpirationtime() {
		return Expirationtime;
	}

	/**
	 * Sets the expirationtime.
	 *
	 * @param expirationtime the new expirationtime
	 */
	public void setExpirationtime(String expirationtime) {
		Expirationtime = expirationtime;
	}

	/**
	 * Gets the client id.
	 *
	 * @return the client id
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Sets the client id.
	 *
	 * @param clientId the new client id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Gets the visibledevices.
	 *
	 * @return the visibledevices
	 */
	public ArrayList<VisibleDevice> getVisibledevices() {
		return visibledevices;
	}

	/**
	 * Sets the visibledevices.
	 *
	 * @param visibledevices the new visibledevices
	 */
	public void setVisibledevices(ArrayList<VisibleDevice> visibledevices) {
		this.visibledevices = visibledevices;
	}

	/***
	 * Get acces_token
	 * 
	 * @return acces_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/***
	 * Set acces_token
	 * 
	 * @param access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	
	/**
	 * Get refresh_token
	 * 
	 * @return refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}
	
	/***
	 * Set Refresh_token
	 * 
	 * @param refresh_token
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	
}