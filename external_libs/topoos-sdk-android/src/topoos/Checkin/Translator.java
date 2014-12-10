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

package topoos.Checkin;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * The Class Translator.
 */
class Translator {
	
	/** The method. */
	private static String method = "GET";
	
	/** The format. */
	private static String format = "json";
	
	/** The version. */
	private static Integer version = topoos.Constants.APIVERSION;
	
	/**
	 * Adds the.
	 *
	 * @param POIID the poiid
	 * @param timestamp the timestamp
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Add(Integer POIID, Date timestamp,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		Checkin checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinAdd checkinAdd = new CheckinAdd("Add", method, format,
					version, accessTokenPregenerated.getAccessToken(), POIID,
					null, timestamp);
			CheckinResult checkinResult = new CheckinResult();
			APICaller.ExecuteOperation(checkinAdd, checkinResult);
			checkin = checkinResult.getCheckin();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	/**
	 * Gets the.
	 *
	 * @param checkinID the checkin id
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Get(Integer checkinID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		Checkin checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinGet checkinGet = new CheckinGet("Get", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					checkinID);
			CheckinResult checkinResult = new CheckinResult();
			APICaller.ExecuteOperation(checkinGet, checkinResult);
			checkin = checkinResult.getCheckin();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	/**
	 * Gets the last.
	 *
	 * @param userID the user id
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin GetLast(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		Checkin checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinGet_last checkinGet_last = new CheckinGet_last("GetLast",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), userID);
			CheckinResult checkinResult = new CheckinResult();
			APICaller.ExecuteOperation(checkinGet_last, checkinResult);
			checkin = checkinResult.getCheckin();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	/**
	 * Gets the poi.
	 *
	 * @param POIID the poiid
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<Checkin> GetPOI(Integer POIID,Date initdate, Date enddate,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		List<Checkin> checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinGet_where checkinGet_where = new CheckinGet_where("GetPOI",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POIID,initdate,enddate);
			CheckinCollectionResult checkinResult = new CheckinCollectionResult();
			APICaller.ExecuteOperation(checkinGet_where, checkinResult);
			checkin = checkinResult.getCheckinCollection().getCheckIns();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	/**
	 * Adds the.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @param timestamp the timestamp
	 * @return the checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Add(Context context, Integer POIID, Date timestamp) throws IOException, TopoosException {
		return Add(POIID, timestamp, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Gets the.
	 *
	 * @param context the context
	 * @param checkinID the checkin id
	 * @return the checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Get(Context context, Integer checkinID) throws IOException, TopoosException {
		return Get(checkinID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Gets the last.
	 *
	 * @param context the context
	 * @param userID the user id
	 * @return the checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin GetLast(Context context, String userID) throws IOException, TopoosException {
		return GetLast(userID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Gets the poi.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<Checkin> GetPOI(Context context, Integer POIID,Date initdate,Date enddate) throws IOException, TopoosException {
		return GetPOI(POIID,initdate,enddate, AccessTokenOAuth.GetAccessToken(context));
	}
}
