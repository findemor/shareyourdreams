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
 * Get information of a Track.
 * 
 * @see APIOperation
 * @author topoos
 */

public class TracksGet extends APIOperation {

	/** The Constant LAYER_DEFAULT. */
	public static final String LAYER_DEFAULT = "default";

	/** The Constant LAYER_BEARING. */
	public static final String LAYER_BEARING = "bearing";

	/** The Constant LAYER_TRACKLINE. */
	public static final String LAYER_TRACKLINE = "trackline";

	/** The oauth_token. */
	protected String oauth_token = null; // (obligatorio) access_token a los
											// recursos del usuario
	/** The track. */
	protected Integer track = null; // (obligatorio) identificador del Track
	// solicitado
	/** The total. */
	protected Integer total = null; // (opcional) si se especifica un valor N,
									// se obtendrán las últimas N posiciones del
									// Track
	/** The initdate. */
	protected Date initdate = null;

	/** The endate. */
	protected Date endate = null;
	// : (opcional) fechas en formato UTC que permiten filtrar posiciones
	// registradas dentro del rango especificado, según el estándar ISO 8601. No
	// se incluyen las posiciones registradas en la fecha indicada.
	/** The layer. */
	protected String[] layer = null; // :(opcional) capas KML solicitadas,
										// separadas por comas

	// default (valor por defecto) marcadores de posición
	// bearing flechas de rumbo
	// trackline línea de trayectoria

	/**
	 * Instantiates a new tracks get.
	 * 
	 * @param operationName
	 *            the operation name
	 * @param method
	 *            the method
	 * @param format
	 *            the format
	 * @param version
	 *            the version
	 * @param oauth_token
	 *            the oauth_token
	 * @param track
	 *            the track
	 * @param total
	 *            the total
	 * @param initdate
	 *            the initdate
	 * @param endate
	 *            the endate
	 * @param layer
	 *            the layer
	 */
	public TracksGet(String operationName, String method, String format,
			Integer version, String oauth_token, Integer track, Integer total,
			Date initdate, Date endate, String[] layer) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.track = track;
		this.total = total;
		this.initdate = initdate;
		this.endate = endate;
		this.layer = layer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringInteger(track));
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(APIUtils.toStringDate(initdate));
		validate = validate && isValidorNull(APIUtils.toStringDate(endate));
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		if (layer != null) {
			for (int i = 0; i < layer.length; i++) {
				validate = validate && isValidorNull(layer[i]);
			}
		}
		return validate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/"
					+ this.Version
					+ "/tracks/get."
					+ this.Format
					+ "?oauth_token="
					+ URLEncoder.encode(this.oauth_token)
					+ "&track="
					+ URLEncoder.encode(APIUtils.toStringInteger(this.track))
					+ (total == null ? "" : "&total="
							+ URLEncoder.encode(APIUtils.toStringInteger(total)))
					+ (initdate == null ? "" : "&initdate="
							+ URLEncoder.encode(APIUtils.toStringDate(initdate)))
					+ (endate == null ? "" : "&endate="
							+ URLEncoder.encode(APIUtils.toStringDate(endate)));
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
