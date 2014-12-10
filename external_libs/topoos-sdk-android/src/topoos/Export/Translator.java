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

package topoos.Export;
import java.io.IOException;
import java.util.Date;

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
	 * Export track.
	 *
	 * @param trackID the track id
	 * @param export_format the export_format
	 * @param total the total
	 * @param initDate the init date
	 * @param endDate the end date
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the track resource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (Integer trackID, String export_format, Integer total,Date initDate,Date endDate,  AccessTokenOAuth  accessTokenPregenerated) throws IOException, TopoosException{
		TrackResource trackResource = null;
		if (accessTokenPregenerated.isValid()) {
			ExportLayerTrack exportLayerTrack = new ExportLayerTrack("ExportTrack", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					ExportLayerTrack.TYPE_LAYER, 
					ExportLayerTrack.DATA_TRACK,
					export_format, 
					trackID,
					total, 
					initDate, 
					endDate );
			TrackResourceResult trackResourceResult = new TrackResourceResult();
			APICaller.ExecuteOperation(exportLayerTrack, trackResourceResult);
			trackResource = trackResourceResult.getTrackResource();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return trackResource;
	}
	
	/**
	 * Export track.
	 *
	 * @param context the context
	 * @param trackID the track id
	 * @param export_format the export_format
	 * @param total the total
	 * @param initDate the init date
	 * @param endDate the end date
	 * @return the track resource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return ExportTrack(trackID, export_format, total, initDate, endDate, AccessTokenOAuth.GetAccessToken(context));
				}

	
}
