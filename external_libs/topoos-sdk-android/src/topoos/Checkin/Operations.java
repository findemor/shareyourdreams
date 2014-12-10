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

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Checkin;
import android.content.Context;

/**
 * The Class Operations.
 *
 * @author topoos
 */
public class Operations {
	
	/**
	 * Adds the.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param POIID the poiid
	 * @param timestamp the timestamp
	 * @return Checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Add(AccessTokenOAuth accessTokenPregenerated,
			Integer POIID, Date timestamp) throws IOException, TopoosException {
		return Translator.Add(POIID, timestamp, accessTokenPregenerated);
	}

	/**
	 * Gets the.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param checkinID the checkin id
	 * @return Checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Get(AccessTokenOAuth accessTokenPregenerated,
			Integer checkinID) throws IOException, TopoosException {
		return Translator.Get(checkinID, accessTokenPregenerated);
	}

	/**
	 * Gets the last.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param userID the user id
	 * @return Checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin GetLast(AccessTokenOAuth accessTokenPregenerated,
			String userID) throws IOException, TopoosException {
		return Translator.GetLast(userID, accessTokenPregenerated);
	}

	/**
	 * Gets the poi.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param POIID the poiid
	 * @return List<Checkin>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<Checkin> GetPOI(
			AccessTokenOAuth accessTokenPregenerated, Integer POIID)
			throws IOException, TopoosException {
		return Translator.GetPOI(POIID,null,null, accessTokenPregenerated);
	}

	/**
	 * Gets the poi with init and end date.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param POIID the poiid
	 * @param initdate 
	 * @param enddate
	 * @return List<Checkin>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<Checkin> GetPOI(
			AccessTokenOAuth accessTokenPregenerated, Integer POIID,Date initdate, Date enddate)
			throws IOException, TopoosException {
		return Translator.GetPOI(POIID,initdate,enddate, accessTokenPregenerated);
	}
	
	/**
	 * Adds the.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @param timestamp the timestamp
	 * @return Checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin Add(Context context, Integer POIID, Date timestamp)
			throws IOException, TopoosException {
		return Translator.Add(context, POIID, timestamp);
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
	public static Checkin Get(Context context, Integer checkinID)
			throws IOException, TopoosException {
		return Translator.Get(context, checkinID);
	}

	/**
	 * Gets the last.
	 *
	 * @param context the context
	 * @param userID the user id
	 * @return Checkin
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Checkin GetLast(Context context, String userID)
			throws IOException, TopoosException {
		return Translator.GetLast(context, userID);
	}

	/**
	 * Gets the poi.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @return List<Checkin>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<Checkin> GetPOI(Context context, Integer POIID)
			throws IOException, TopoosException {
		return Translator.GetPOI(context, POIID,null,null);
	}
	
	/**
	 * Gets the poi.
	 *
	 * @param context the context
	 * @param POIID the poiid
	 * @param initdate
	 * @param enddate
	 * @return List<Checkin>
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static List<Checkin> GetPOI(Context context, Integer POIID,Date initdate,Date enddate)
			throws IOException, TopoosException {
		return Translator.GetPOI(context, POIID,initdate,enddate);
	}
}
