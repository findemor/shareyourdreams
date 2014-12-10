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
 * The Class PositionsGet_between.
 *
 * @see APIOperation
 * @author topoos
 */
public class PositionsGet_between extends APIOperation{

	/** The oauth_token. */
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	
	/** The initdate. */
	private Date	initdate=null; // (obligatorio) fecha de inicio, según el estándar ISO 8601
	
	/** The enddate. */
	private Date	enddate=null; // (obligatorio) fecha de fin, según el estándar ISO 8601
	
	/** The device. */
	private String	device=null; // (opcional) obtiene solo las posiciones del dispositivo indicado. Si no se especifica, se obtienen las posiciones del dispositivo por defecto. Es un parámetro obligatorio cuando la aplicación puede acceder a los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.

	/**
	 * Instantiates a new positions get_between.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param initdate the initdate
	 * @param enddate the enddate
	 * @param device the device
	 */
	public PositionsGet_between(String operationName, String method,
			String format, Integer version, String oauth_token,
			Date initdate, Date enddate, String device) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.initdate = initdate;
		this.enddate = enddate;
		this.device = device;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringDate(initdate));
		validate = validate && isValid(APIUtils.toStringDate(enddate));
		validate = validate && isValidorNull(device);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/positions/get_between." + this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+"&initdate="+URLEncoder.encode(APIUtils.toStringDate(initdate))
					+"&enddate="+URLEncoder.encode(APIUtils.toStringDate(enddate))
					+(device == null? "" : "&device="+URLEncoder.encode(device));
		}
		return params;
	}
	

}
