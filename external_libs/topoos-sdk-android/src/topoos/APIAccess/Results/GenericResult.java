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

import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;

/**
 * The Class GenericResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class GenericResult extends APICallResult {

	/** The code. */
	private Integer code = null;

	/** The description. */
	private String description = null;

	/**
	 * Instantiates a new generic result.
	 */
	public GenericResult() {
		super();
	}

	/**
	 * Instantiates a new generic result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public GenericResult(String error, String result) {
		super(error, result);
	}

	/**
	 * Instantiates a new generic result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param code
	 *            the code
	 * @param description
	 *            the description
	 */
	public GenericResult(String error, String result, Integer code,
			String description) {
		super(error, result);
		this.code = code;
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// Processing result
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				this.code = APIUtils.getIntegerorNull(jObject, "code");
				this.description = APIUtils.getStringorNull(jObject,
						"description");
			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
