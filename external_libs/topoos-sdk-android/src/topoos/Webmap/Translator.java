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

package topoos.Webmap;

import java.io.IOException;

import topoos.APIAccess.Operations.Webmap;
import topoos.Exception.TopoosException;

/**
 * 
 * @author topoos
 *
 */
class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;
	
	
	public static String GetTrackExportedWebMapURI (String resourceID,String type,String apiKey) throws IOException, TopoosException{
		String getTrackExportedWebMapURI = null;
		if (apiKey!=null) {
			Webmap resourceWebmap = new Webmap("GetTrackExportedWebMapURI", method, format,
					version, apiKey, type,
					resourceID);
			getTrackExportedWebMapURI=resourceWebmap.ConcatParams();
		}
		return getTrackExportedWebMapURI;
	}
	
	
}
