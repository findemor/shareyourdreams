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
 * The Class Image.
 *
 * @author topoos
 */
public class Image implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private String id = null;
	
	/** The client_id. */
	private String client_id = null;
	
	/** The user_id. */
	private String user_id = null;
	
	/** The filename. */
	private String filename = null;
	
	/** The filename_unique. */
	private String filename_unique = null;
	
	/** The file_ext. */
	private String file_ext = null;
	
	/** The uri. */
	private String uri = null;
	
	/** The register_date. */
	private Date register_date = null;
	
	/** The geo_data. */
	private GeoData geo_data = null;
	
	/**
	 * Instantiates a new image.
	 *
	 * @param id the id
	 * @param client_id the client_id
	 * @param user_id the user_id
	 * @param filename the filename
	 * @param filename_unique the filename_unique
	 * @param file_ext the file_ext
	 * @param uri the uri
	 * @param register_date the register_date
	 * @param geo_data the geo_data
	 */
	public Image(String id, String client_id, String user_id, String filename,
			String filename_unique, String file_ext, String uri,
			Date register_date, GeoData geo_data) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.user_id = user_id;
		this.filename = filename;
		this.filename_unique = filename_unique;
		this.file_ext = file_ext;
		this.uri = uri;
		this.register_date = register_date;
		this.geo_data = geo_data;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the client_id.
	 *
	 * @return the client_id
	 */
	public String getClient_id() {
		return client_id;
	}

	/**
	 * Sets the client_id.
	 *
	 * @param client_id the client_id to set
	 */
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	/**
	 * Gets the user_id.
	 *
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * Sets the user_id.
	 *
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * Gets the filename.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the filename.
	 *
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Gets the filename_unique.
	 *
	 * @return the filename_unique
	 */
	public String getFilename_unique() {
		return filename_unique;
	}

	/**
	 * Sets the filename_unique.
	 *
	 * @param filename_unique the filename_unique to set
	 */
	public void setFilename_unique(String filename_unique) {
		this.filename_unique = filename_unique;
	}

	/**
	 * Gets the file_ext.
	 *
	 * @return the file_ext
	 */
	public String getFile_ext() {
		return file_ext;
	}

	/**
	 * Sets the file_ext.
	 *
	 * @param file_ext the file_ext to set
	 */
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}

	/**
	 * Gets the uri.
	 *
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the uri.
	 *
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Gets the register_date.
	 *
	 * @return the register_date
	 */
	public Date getRegister_date() {
		return register_date;
	}

	/**
	 * Sets the register_date.
	 *
	 * @param register_date the register_date to set
	 */
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	/**
	 * Gets the geo_data.
	 *
	 * @return the geo_data
	 */
	public GeoData getGeo_data() {
		return geo_data;
	}

	/**
	 * Sets the geo_data.
	 *
	 * @param geo_data the geo_data to set
	 */
	public void setGeo_data(GeoData geo_data) {
		this.geo_data = geo_data;
	}

	
	
}
