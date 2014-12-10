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
	 * Adds the track out of bounds.
	 *
	 * @param track the track
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the rule
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Rule AddTrackOutOfBounds (Integer track, Double lat, Double lng, Integer radius, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		Rule Rule = null;
		if (accessTokenPregenerated.isValid()) {
			RulesAdd rulesAdd = new RulesAdd("Get",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),lat,lng,radius,RulesAdd.TYPE_TRACK_OUT_OF_BOUNDS,track);
			RuleResult ruleResult = new RuleResult();
			APICaller.ExecuteOperation(rulesAdd, ruleResult);
			Rule = ruleResult.getRule();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return Rule;
		
	}
	
	/**
	 * Adds the track out of bounds.
	 *
	 * @param context the context
	 * @param track the track
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 * @return the rule
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static Rule AddTrackOutOfBounds (Context context, Integer track, Double lat, Double lng, Integer radius) throws IOException, TopoosException{
		return AddTrackOutOfBounds(track,lat, lng, radius, AccessTokenOAuth.GetAccessToken(context));
		
	}
}
