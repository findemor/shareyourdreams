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

import java.io.IOException;

import topoos.APIAccess.mime.MultipartEntity;

/**
 * Class that implements the api operations.
 *
 * @author topoos
 */
public abstract class APIOperation {

	/** The Operation name. */
	String OperationName;
	
	/** The Version. */
	Integer Version;
	
	/** The Method. */
	String Method;
	
	/** The Format. */
	String Format;

	/**
	 * Instantiates a new aPI operation.
	 *
	 * @param operationName name of the operation
	 * @param method name of the method
	 * @param format format
	 * @param version version
	 */
	public APIOperation(String operationName, String method, String format,
			Integer version) {
		super();
		OperationName = operationName;
		Method = method;
		Format = format;
		Version = version;
	}

	/**
	 * Instantiates a new aPI operation.
	 */
	public APIOperation() {
		super();
		Version = -1;
	};

	/**
	 * get the operation name.
	 *
	 * @return Operation name
	 */
	public String getOperationName() {
		return OperationName;
	}

	/**
	 * set the operation name.
	 *
	 * @param operationName set the operation name
	 */
	public void setOperationName(String operationName) {
		OperationName = operationName;
	}

	/**
	 * get the method.
	 *
	 * @return Method
	 */
	public String getMethod() {
		return Method;
	}

	/**
	 * set the method.
	 *
	 * @param method set method
	 */
	public void setMethod(String method) {
		Method = method;
	}

	/**
	 * get the format.
	 *
	 * @return Format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * set the format.
	 *
	 * @param format set the format
	 */
	public void setFormat(String format) {
		Format = format;
	}

	/**
	 * get the version.
	 *
	 * @return Version
	 */
	public Integer getVersion() {
		return Version;
	}

	/**
	 * set the version.
	 *
	 * @param version set the version
	 */
	public void setVersion(Integer version) {
		Version = version;
	}

	/**
	 * check if the version is not null or not empty.
	 *
	 * @param param the param
	 * @return Boolean
	 */
	protected boolean isValid(String param) {
		return (param != null && !param.equals(""));
	}

	/**
	 * check if is valid or null the param.
	 *
	 * @param param the param
	 * @return Boolean
	 */
	protected boolean isValidorNull(String param) {
		return (param == null || !param.equals(""));
	}

	/**
	 * validate the params.
	 *
	 * @return Boolean
	 */
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(OperationName);
		validate = validate && isValid(Method);
		validate = validate && isValid(Format);
		validate = validate && (Version > 0);
		return validate;
	};
	
	/**
	 * return the object´s parameters concatenate.
	 *
	 * @return the string
	 * string
	 */
	public abstract String ConcatParams();
	
	/**
	 * Body params.
	 *
	 * @return the multipart entity
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public MultipartEntity BodyParams() throws IOException{
		return null;
	}
}
