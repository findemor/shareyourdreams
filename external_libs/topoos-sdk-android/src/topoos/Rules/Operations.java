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

package topoos.Rules;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Rule;
import android.content.Context;


/**
 * Operations related to rules management.
 *
 * @author topoos
 */
public class Operations {
	
	/**
	 * Create a new rule of one of the following types:TRACK_OUT_OF_BOUNDS.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param track (required) Track ID that associate the rule
	 * @param lat (required) latitude of the new position
	 * @param lng (required) longitude of the new position
	 * @param radius (required) search radius in meters
	 * @return Rule
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Rule AddTrackOutOfBounds(
			AccessTokenOAuth accessTokenPregenerated, Integer track,
			Double lat, Double lng, Integer radius) throws IOException,
			TopoosException {
		return Translator.AddTrackOutOfBounds(track, lat, lng, radius,
				accessTokenPregenerated);
	}

	/**
	 * Create a new rule of one of the following types:TRACK_OUT_OF_BOUNDS.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param track (required) Track ID that associate the rule
	 * @param lat (required) latitude of the new position
	 * @param lng (required) longitude of the new position
	 * @param radius (required) search radius in meters
	 * @return Rule
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Rule AddTrackOutOfBounds(Context context, Integer track,
			Double lat, Double lng, Integer radius) throws IOException,
			TopoosException {
		return Translator.AddTrackOutOfBounds(context, track, lat, lng, radius);
	}
}
