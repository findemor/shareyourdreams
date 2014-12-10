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
 * Get a document that represents the last registered Track by a device.
 * 
 * @author topoos
 * 
 */
public class TracksGet_last extends APIOperation {

	/** The Constant LAYER_DEFAULT. */
	public static final String LAYER_DEFAULT = "default";
	
	/** The Constant LAYER_BEARING. */
	public static final String LAYER_BEARING = "bearing";
	
	/** The Constant LAYER_TRACKLINE. */
	public static final String LAYER_TRACKLINE = "trackline";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The device. */
										private String device = null; // (opcional) dispositivo del que vamos a
									// recuperar el último Track, es obligatorio
									// si la aplicación puede utilizar los
									// dispositivos físicos de un usuario,
									// opción que por defecto está
									// deshabilitada.
	/** The total. */
									private Integer total = null; // (opcional) si se especifica un valor N, se
									// obtendrán las últimas N posiciones del
									// Track
	/** The layer. */
									private String[] layer = null; // (opcional) capas KML solicitadas,
									// separadas por comas.

	// default (valor por defecto) marcadores de posición
	// bearing flechas de rumbo
	// trackline línea de trayectoria

	/**
									 * Instantiates a new tracks get_last.
									 *
									 * @param operationName the operation name
									 * @param method the method
									 * @param format the format
									 * @param version the version
									 * @param oauth_token the oauth_token
									 * @param device the device
									 * @param total the total
									 * @param layer the layer
									 */
									public TracksGet_last(String operationName, String method, String format,
			Integer version, String oauth_token, String device, Integer total,
			String[] layer) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.total = total;
		this.layer = layer;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		validate = validate && isValid(oauth_token);
		for (int i = 0; i < layer.length; i++) {
			validate = validate && isValidorNull(layer[i]);
		}
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/"
					+ this.Version
					+ "/tracks/get_last."
					+ this.Format
					+ "?oauth_token="
					+ URLEncoder.encode(this.oauth_token)
					+ (total == null ? "" : "&total="
							+ URLEncoder.encode(APIUtils.toStringInteger(total)))
					+ (device == null ? "" : "&device=" + URLEncoder.encode(device));
			if (layer != null)
				params = params + "&layer=";
			for (int i = 0; i < layer.length; i++) {
				if (i == 0) {
					params = params + layer[i];
				} else {
					params = params + "," + layer[i];
				}
			}
			;

		}
		return params;
	}

}