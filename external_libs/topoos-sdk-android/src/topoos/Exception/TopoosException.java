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

package topoos.Exception;

/**
 * The Class TopoosException.
 */
public class TopoosException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant NOT_VALID_PARAMS. */
	public static final String NOT_VALID_PARAMS= "Params not valid";
	
	/** The Constant NOT_VALID_TOKEN. */
	public static final String NOT_VALID_TOKEN= "Token not valid";
	
	/** The Constant ERROR400. */
	public static final String ERROR400="Bad request";
	
	/** The Constant ERROR405. */
	public static final String ERROR405="Not Allowed";
	
	/** The Constant ERROR_PARSE. */
	public static final String ERROR_PARSE="Parser Error";
	
	/**
	 * Instantiates a new topoos exception.
	 *
	 * @param msg the msg
	 */
	public TopoosException(String msg) {
		super(msg);
	}

}
