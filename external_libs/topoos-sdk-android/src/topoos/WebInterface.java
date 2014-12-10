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

package topoos;

import java.net.URLDecoder;
import java.util.Calendar;

import android.util.Log;

// TODO: Auto-generated Javadoc
/*
 * Clase que actua como interfaz a la parte nativa de la aplicaci�n, y viceversa
 */
/**
 * Class that acting as interface to the native side of the application and vice
 * versa.
 * 
 * @author topoos
 */
class WebInterface {

	/** The Constant ParamKey_AccessToken. */
	private static final String ParamKey_AccessToken = "access_token";

	/** The Constant ParamKey_ExpiresIn. */
	private static final String ParamKey_ExpiresIn = "expires_in";

	// private static final String ParamKey_TokenType = "token_type";
	// private static final String ParamKey_RefreshToken = "refresh_token";
	/**
	 * Gets the access token.
	 * 
	 * @param url
	 *            the url
	 * @param redirect_uri
	 *            the redirect_uri
	 * @return the access token o auth
	 */
	public static AccessTokenOAuth GetAccessToken(String url,
			String redirect_uri) {
		AccessTokenOAuth Access = null;

		if (url.startsWith(redirect_uri)) {
			String AuxAccessToken = "";
			String AuxExpiresIn = "";
			// String AuxTokenType= "";
			// String AuxRefreshToken= "";

			String[] urlFragment = url.split("#");
			if (url.contains("error")) {
				try {
					String[] urlFragmenterror = url.replace("?", "#").split("#");
					if (urlFragmenterror.length > 1)
						Log.e(Constants.TAG, urlFragmenterror[1].replace("&", " "));
				} catch (Exception e) {
					if (Constants.DEBUG) {
						e.printStackTrace();
					}
				}
			}
			if (urlFragment.length > 1) // #key1=value1&key2=value2...
			{
				String[] Params = urlFragment[1].split("&"); // key1=value1
				for (String param : Params) {
					String[] pair = param.split("=");

					String key = URLDecoder.decode(pair[0]);
					String value = URLDecoder.decode(pair[1]);

					if (key.equalsIgnoreCase(ParamKey_AccessToken)) {
						AuxAccessToken = value;
					} else if (key.equalsIgnoreCase(ParamKey_ExpiresIn)) {
						AuxExpiresIn = value;
					}
					/*
					 * else if (key.equalsIgnoreCase(ParamKey_RefreshToken)) {
					 * AuxRefreshToken = value; } else if
					 * (key.equalsIgnoreCase(ParamKey_TokenType)) { AuxTokenType
					 * = value; }
					 */
				}
			}
			// Obtener el valor de expiracion del token
			Integer expiresin = null;
			try {
				expiresin = Integer.parseInt(AuxExpiresIn);
			} catch (NumberFormatException nfe) {
				if (Constants.DEBUG)
					nfe.printStackTrace();
			}
			if (expiresin != null) {
				Calendar cal = Calendar.getInstance();
				cal = Calendar.getInstance();
				cal.add(Calendar.SECOND, expiresin);
				Access = new AccessTokenOAuth(AuxAccessToken,
						cal.getTimeInMillis());
			} else
				Access = new AccessTokenOAuth(AuxAccessToken);
		}

		return Access;
	}
}
