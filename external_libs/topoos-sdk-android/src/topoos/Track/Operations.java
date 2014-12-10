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

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Track;
import android.content.Context;

/**
 * Operations related to position management.
 *
 * @author topoos
 */
public class Operations {

	/** The Constant LAYER_DEFAULT. */
	public static final String LAYER_DEFAULT = topoos.APIAccess.Operations.TracksGet.LAYER_DEFAULT;
	
	/** The Constant LAYER_BEARING. */
	public static final String LAYER_BEARING = topoos.APIAccess.Operations.TracksGet.LAYER_BEARING;
	
	/** The Constant LAYER_TRACKLINE. */
	public static final String LAYER_TRACKLINE = topoos.APIAccess.Operations.TracksGet.LAYER_TRACKLINE;

	/**
	 * Create a new Track. A Track is a sequence of positions recorded during a
	 * session
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param name (optional) description of the Track
	 * @return Track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Add(AccessTokenOAuth accessTokenPregenerated,
			String name) throws IOException, TopoosException {

		return Translator.Add(name, accessTokenPregenerated);
	}

	/**
	 * Obtain information from a Track.
	 *
	 * @param accessTokenPregenerated (required) access_token to user resources
	 * @param trackID (required) requested identifier Track
	 * @param numberPositions (optional) if you specify a value N, N shows the latest
	 * positions
	 * @param layers (optional) requested KML layers, separated by commas
	 * @return Track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Get(AccessTokenOAuth accessTokenPregenerated,
			Integer trackID, Integer numberPositions, String[] layers)
			throws IOException, TopoosException {
		return Translator.Get(trackID, numberPositions, layers,
				accessTokenPregenerated);

	}

	/**
	 * Gets a document that represents the last track recorded by a device.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param numberPOIS (optional) if you specify a value N, N positions get the
	 * latest Track
	 * @param layers (Optional) requested KML layers, separated by commas
	 * @return Track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track GetLast(AccessTokenOAuth accessTokenPregenerated,
			Integer numberPOIS, String[] layers) throws IOException,
			TopoosException {
		return Translator.GetLast(numberPOIS, layers, accessTokenPregenerated);
	}

	/**
	 * Create a new Track. A Track is a sequence of positions recorded during a
	 * session
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param name (optional) description of the Track
	 * @return Track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Add(Context context, String name) throws IOException,
			TopoosException {
		return Translator.Add(context, name);
	}

	/**
	 * Obtain information from a Track.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param trackID the track id
	 * @param numberPositions the number positions
	 * @param layers the layers
	 * @return Track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track Get(Context context, Integer trackID,
			Integer numberPositions, String[] layers) throws IOException,
			TopoosException {
		return Translator.Get(context, trackID, numberPositions, layers);

	}

	/**
	 * Gets a document that represents the last track recorded by a device.
	 *
	 * @param context (required) Interface to global information about an
	 * application environment
	 * @param numberPOIS (optional) if you specify a value N, N positions get the
	 * latest Track
	 * @param layers (Optional) requested KML layers, separated by commas
	 * @return Track
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Track GetLast(Context context, Integer numberPOIS,
			String[] layers) throws IOException, TopoosException {
		return Translator.GetLast(context, numberPOIS, layers);

	}

}
