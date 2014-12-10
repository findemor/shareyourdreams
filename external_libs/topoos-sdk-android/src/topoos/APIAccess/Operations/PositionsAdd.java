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
 * The Class PositionsAdd.
 *
 * @see APIOperation
 * @author topoos
 */
public class PositionsAdd extends APIOperation{

	

	/** The Constant TRACK_END. */
	public static final int TRACK_END =	2; 
	
	/** The Constant POS. */
	public static final int POS =	3; 
	
	/** The Constant ALARM_INIT. */
	public static final int ALARM_INIT = 6;
	
	/** The Constant ALARM_END. */
	public static final int ALARM_END =	7; 
	
	/** The Constant GPS_OK. */
	public static final int GPS_OK = 8; 
	
	/** The Constant GPS_NO. */
	public static final int GPS_NO = 9; 
	
	/** The oauth_token. */
	private String oauth_token=null; // (obligatorio)access_token de Acceso a recursos
	
	/** The device. */
	private String	device=null; // (opcional) dispositivo que capturó la posición. Se trata de un parámetro obligatorio cuando la aplicación puede manejar los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.
	
	/** The lat. */
	private Double	lat=null; // (obligatorio) latitud en grados decimales de la nueva posición
	
	/** The lng. */
	private Double	lng=null; // (obligatorio) longitud en grados decimales de la nueva posición
	
	/** The accuracy. */
	private Double	accuracy=null; // (opcional) precisión de la posición (latitud, longitud)
	
	/** The vaccuracy. */
	private Double	vaccuracy=null; // (opcional) precisión de la elevación
	
	/** The elevation. */
	private Double	elevation=null; // (opcional) elevación respecto al nivel del mar
	
	/** The timestamp. */
	private Date	timestamp=null; // (opcional) hora local con offset de conversión UTC de captura de la posición, según el estándar ISO 8601.
	 //(AAAA-MM-DDThh:mm:sszzzzzz) en UTC
	 //ejemplo: 1997-07-16T10:30:15.342+03:00
	/** The velocity. */
 	private Double	velocity=null; // (opcional) velocidad de movimiento en el instante en que se capturó la posición, en metros por segundo
	
	/** The postype. */
	private Integer	postype=null; //(opcional) tipo de posición a registrar
	
	/** The bearing. */
	private Double	bearing=null; // (opcional) rumbo de movimiento (valor entre 0 y 360)
	
	/** The track. */
	private Integer	track=null; // (opcional) identificador del Track al que pertenece la posición (excepto cuando es TRACK_INIT)

	/**
	 * Instantiates a new positions add.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param device the device
	 * @param lat the lat
	 * @param lng the lng
	 * @param accuracy the accuracy
	 * @param vaccuracy the vaccuracy
	 * @param elevation the elevation
	 * @param timestamp the timestamp
	 * @param velocity the velocity
	 * @param postype the postype
	 * @param bearing the bearing
	 * @param track the track
	 */
	public PositionsAdd(String operationName, String method, String format,
			Integer version, String oauth_token, String device, Double lat,
			Double lng, Double accuracy, Double vaccuracy, Double elevation,
			Date timestamp, Double velocity, Integer postype, Double bearing,
			Integer track) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.lat = lat;
		this.lng = lng;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.timestamp = timestamp;
		this.velocity = velocity;
		this.postype = postype;
		this.bearing = bearing;
		this.track = track;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {

		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(APIUtils.toStringDouble(accuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(vaccuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(elevation));
		validate = validate && isValidorNull(APIUtils.toStringDate(timestamp));
		validate = validate && isValidorNull(APIUtils.toStringDouble(velocity));
		validate = validate && isValidorNull(APIUtils.toStringInteger(postype));
		validate = validate && isValidorNull(APIUtils.toStringDouble(bearing));
		validate = validate && isValidorNull(APIUtils.toStringInteger(track));
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/positions/add." + this.Format 
					+ "?oauth_token=" + URLEncoder.encode(this.oauth_token)
					+ "&lat="+URLEncoder.encode(APIUtils.toStringDouble(lat))
					+ "&lng="+URLEncoder.encode(APIUtils.toStringDouble(lng))
					+(device == null? "" : "&device="+URLEncoder.encode(device))
					+(accuracy == null? "" : "&accuracy="+URLEncoder.encode(APIUtils.toStringDouble(accuracy)))
					+(vaccuracy == null? "" : "&vaccuracy="+URLEncoder.encode(APIUtils.toStringDouble(vaccuracy)))
					+(elevation == null? "" : "&elevation="+URLEncoder.encode(APIUtils.toStringDouble(elevation)))
					+(timestamp == null? "" : "&timestamp="+URLEncoder.encode(APIUtils.toStringDate(timestamp)))
					+(velocity == null? "" : "&velocity="+URLEncoder.encode(APIUtils.toStringDouble(velocity)))
					+(postype == null? "" : "&postype="+URLEncoder.encode(APIUtils.toStringInteger(postype)))
					+(bearing == null? "" : "&bearing="+URLEncoder.encode(APIUtils.toStringDouble(bearing)))
					+(track == null? "" : "&track="+URLEncoder.encode(APIUtils.toStringInteger(track)))
					;
		}
		return params;
	}
	

		
}
