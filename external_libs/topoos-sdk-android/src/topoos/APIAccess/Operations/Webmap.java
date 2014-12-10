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
 * The Class ResourceWebmap.
 *
 * @see APIOperation
 * @author topoos
 */
public class Webmap extends APIOperation {

	/** The Constant TYPE_LAYER. */
	public static final String TYPE_LAYER = "layer";

	/** The api_key. */
	private String api_key = null; // (obligatorio)
	
	/** The type. */
	private String type = null; // (obligatorio) el nombre del parámetro type
								// determina el tipo de recurso que se desea
								// obtener. Por ejemplo para obtener un recurso
								// previamente exportado de tipo capa KML, su
								// valor es layer. Valores permitidos: layer.
	/** The id. */
								private String id = null; // (obligatorio) el valor del parámetro type
								// indica el identificador del recurso que se
								// desea visualizar, este se obtuvo como
								// respuesta de la operación de exportación de
								// recurso.

	/**
								 * Instantiates a new resource webmap.
								 *
								 * @param operationName the operation name
								 * @param method the method
								 * @param format the format
								 * @param version the version
								 * @param api_key the api_key
								 * @param type the type
								 * @param id the id
								 */
	public Webmap(String operationName, String method, String format,
			Integer version, String api_key, String type, String id) {
		super(operationName, method, format, version);
		this.api_key = api_key;
		this.type = type;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(api_key);
		validate = validate && isValid(type);
		validate = validate && isValid(id);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/webmap" + "?" + type+"="+ id + "&api_key="
					+ URLEncoder.encode(api_key) ;
		}
		return params;
	}

}
