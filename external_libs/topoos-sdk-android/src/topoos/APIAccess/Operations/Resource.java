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

/**
* 
* Get resource previously exported.
* 
* @see APIOperation
* @author topoos
* 
*/
public class Resource extends APIOperation {

	/** The type of resource (layer). */
	private String type = null; 
	/** The api_key . */
	private String api_key = null; 
	/** The id of resource. */
	private Integer id =null;





	/**
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param type
	 * @param api_key
	 * @param id
	 */
	public Resource(String operationName, String method, String format,
			Integer version, String type, String api_key, Integer id) {
		super(operationName, method, format, version);
		this.type = type;
		this.api_key = api_key;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate
				&& ((isValid(APIUtils.toStringInteger(id)) && isValid(APIUtils
						.toStringUrlEncoded(api_key))));
		validate = isValid(type);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/resource/"+type+"/"+id+"."
						+ this.Format+"?api_key="+URLEncoder.encode(api_key);
		}
		return params;
	}

}