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

package topoos.Track;

import java.io.IOException;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * The Class Translator.
 *
 * @author topoos
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
	 * @param name the name
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Add(String name,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {

		Track track = null;
		if (accessTokenPregenerated.isValid()) {
			TracksAdd tracksAdd = new TracksAdd("Add", method, format, version,
					accessTokenPregenerated.getAccessToken(), null, name);
			TrackResult trackResult = new TrackResult();
			APICaller.ExecuteOperation(tracksAdd, trackResult);
			track = trackResult.getTrack();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return track;

	}

	/**
	 * Gets the.
	 *
	 * @param trackID the track id
	 * @param numberPositions the number positions
	 * @param layers the layers
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Get(Integer trackID, Integer numberPositions,
			String[] layers, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Track track = null;
		if (accessTokenPregenerated.isValid()) {
			TracksGet tracksGet = new TracksGet("Get", method, format, version,
					accessTokenPregenerated.getAccessToken(), trackID,
					numberPositions, null, null, layers);
			TrackResult trackResult = new TrackResult();
			APICaller.ExecuteOperation(tracksGet, trackResult);
			track = trackResult.getTrack();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return track;

	}

	/**
	 * Gets the last.
	 *
	 * @param numberPOIS the number pois
	 * @param layers the layers
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track GetLast(Integer numberPOIS, String[] layers,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Track track = null;
		if (accessTokenPregenerated.isValid()) {
			TracksGet_last tracksGet_last = new TracksGet_last("GetLast",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), null, numberPOIS,
					layers);
			TrackResult trackResult = new TrackResult();
			APICaller.ExecuteOperation(tracksGet_last, trackResult);
			track = trackResult.getTrack();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return track;

	}

	/**
	 * Adds the.
	 *
	 * @param context the context
	 * @param name the name
	 * @return the track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Add(Context context, String name) throws IOException,
			TopoosException {
		return Add(name, AccessTokenOAuth.GetAccessToken(context));

	}

	/**
	 * Gets the.
	 *
	 * @param context the context
	 * @param trackID the track id
	 * @param numberPositions the number positions
	 * @param layers the layers
	 * @return the track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Get(Context context, Integer trackID,
			Integer numberPositions, String[] layers) throws IOException,
			TopoosException {
		return Get(trackID, numberPositions, layers, AccessTokenOAuth.GetAccessToken(context));

	}

	/**
	 * Gets the last.
	 *
	 * @param context the context
	 * @param numberPOIS the number pois
	 * @param layers the layers
	 * @return the track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track GetLast(Context context, Integer numberPOIS,
			String[] layers) throws IOException, TopoosException {
		return GetLast(numberPOIS, layers, AccessTokenOAuth.GetAccessToken(context));

	}

}
