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

package topoos.APIAccess.Operations;

import java.net.URLEncoder;
import java.util.Date;


/**
 * Get all CheckIns that have been realized in a POI.
 *
 * @see APIOperation
 * @author topoos
 */
public class CheckinGet_where extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The poi. */
	private Integer poi = null; // (obligatorio)identificador del POI
	
	/**
	 * The initdate
	 */
	private Date initdate = null;  //(opcional)
	
	/**
	 * The enddate
	 */
	private Date enddate = null; //(opcional)
	
	
	
	/**
	 * Instantiates a new checkin get_where.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 * @param initdate
	 * @param enddate
	 */
	public CheckinGet_where(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, Date initdate, Date enddate) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.enddate=enddate;
		this.initdate=initdate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(APIUtils.toStringDate(initdate));
		validate = validate && isValidorNull(APIUtils.toStringDate(enddate));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/checkin/get_where." + this.Format
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token) 
					+ "&poi=" + URLEncoder.encode(APIUtils.toStringInteger(this.poi))
					+ (initdate!=null? "&initdate="+URLEncoder.encode(APIUtils.toStringDate(initdate)) : "") 
					+ (enddate!=null? "&enddate="+URLEncoder.encode(APIUtils.toStringDate(enddate)) : "");

		}
		return params;
	}

}