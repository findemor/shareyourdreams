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

// TODO: Auto-generated Javadoc
/**
 * Make a track public that´s belong to an user and application.
 * 
 * @see APIOperation
 * @author topoos
 */
public class ExportLayerTrack extends APIOperation {

	/** The Constant DATA_TRACK. */
	public static final String DATA_TRACK = "Track";

	/** The Constant TYPE_LAYER. */
	public static final String TYPE_LAYER = "layer";

	/** The Constant EXPORT_FORMAT_KML. */
	public static final String EXPORT_FORMAT_KML = "kml";

	/** The Constant EXPORT_FORMAT_JSON. */
	public static final String EXPORT_FORMAT_JSON = "json";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The type. */
	private String type = null; // (obligatorio) este fragmento determina el
	// tipo de recurso que se desea generar. Por
	// ejemplo para generar un recurso de tipo capa
	// KML, su valor es layer. Valores permitidos:
	// layer.
	/** The data. */
	private String data = null; // (obligatorio) este fragmento especifica los
	// datos que se almacenarán en el recurso
	// exportado. Por ejemplo, es posible almacenar
	// un Track. Valores permitidos: Track.

	// Parametros de TracksGet

	/** The export_format. */
	private String export_format; // (obligatorio) este fragmento establece el
	// formato de la respuesta de esta operación
	// (no el formato del recurso). Valores
	// disponibles: json.
	/** The track. */
	protected Integer track = null; // (obligatorio) identificador del Track
	// solicitado
	/** The total. */
	protected Integer total = null; // (opcional) si se especifica un valor N,
	// se obtendrán las últimas N posiciones del
	// Track
	/** The initdate. */
	protected Date initdate = null;

	/** The enddate. */
	protected Date enddate = null;

	// : (opcional) fechas en formato UTC que permiten filtrar posiciones
	// registradas dentro del rango especificado, según el estándar ISO 8601. No
	// se incluyen las posiciones registradas en la fecha indicada.

	/**
	 * Instantiates a new export layer track.
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
	 * @param type
	 *            the type
	 * @param data
	 *            the data
	 * @param export_format
	 *            the export_format
	 * @param track
	 *            the track
	 * @param total
	 *            the total
	 * @param initdate
	 *            the initdate
	 * @param endate
	 *            the endate
	 */
	public ExportLayerTrack(String operationName, String method, String format,
			Integer version, String oauth_token, String type, String data,
			String export_format, Integer track, Integer total, Date initdate,
			Date endate) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.type = type;
		this.data = data;
		this.export_format = export_format;
		this.track = track;
		this.total = total;
		this.initdate = initdate;
		this.enddate = endate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(data);
		validate = validate && isValid(type);
		validate = validate && isValid(export_format);
		validate = validate && isValid(APIUtils.toStringInteger(track));
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		validate = validate && isValidorNull(APIUtils.toStringDate(initdate));
		validate = validate && isValidorNull(APIUtils.toStringDate(enddate));
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
					+ "/export/"
					+ ExportLayerTrack.TYPE_LAYER
					+ "/"
					+ ExportLayerTrack.DATA_TRACK
					+ "."
					+ this.Format
					+ "?oauth_token="
					+ URLEncoder.encode(this.oauth_token)
					+ (track == null ? "" : "&track="
							+ URLEncoder.encode(APIUtils.toStringInteger(track)))
					+ (export_format == null ? "" : "&format="
							+ URLEncoder.encode(APIUtils.toStringUrlEncoded(export_format)))
					+ (total == null ? "" : "&total="
							+ URLEncoder.encode(APIUtils.toStringInteger(total)))
					+ (initdate == null ? "" : "&initdate="
							+ URLEncoder.encode(APIUtils.toStringDate(initdate)))
					+ (enddate == null ? "" : "&endate="
							+ URLEncoder.encode(APIUtils.toStringDate(enddate)));
		}
		return params;
	}

}
