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
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * The Class Operations.
 *
 * @author topoos
 */
public class Operations {
	
	/** The Constant DATA_TRACK. */
	public static final String DATA_TRACK= topoos.APIAccess.Operations.ExportLayerTrack.DATA_TRACK;
	
	/** The Constant TYPE_LAYER. */
	public static final String TYPE_LAYER= topoos.APIAccess.Operations.ExportLayerTrack.TYPE_LAYER;
	
	/** The Constant EXPORT_FORMAT. */
	public static final String EXPORT_FORMAT_KML=topoos.APIAccess.Operations.ExportLayerTrack.EXPORT_FORMAT_KML;
	
	/** The Constant EXPORT_FORMAT. */
	public static final String EXPORT_FORMAT_JSON=topoos.APIAccess.Operations.ExportLayerTrack.EXPORT_FORMAT_JSON;	
	/**
	 * Export track.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param trackID the track id
	 * @param export_format the export_format
	 * @param total the total
	 * @param initDate the init date
	 * @param endDate the end date
	 * @return TrackResource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (AccessTokenOAuth accessTokenPregenerated, Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return Translator.ExportTrack(trackID, export_format, total, initDate, endDate, accessTokenPregenerated);
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
	 * @return TrackResource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return Translator.ExportTrack(context, trackID, export_format, total, initDate, endDate);
	}
	
}
