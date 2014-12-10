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

package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;


/**
 * The Class SocialRelationshipResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class SocialRelationshipCounterResult extends APICallResult {

	/** The Relationship counter. */
	private RelationshipCounter counters = null;

	/**
	 * Instantiates a new Relationship result.
	 */
	public SocialRelationshipCounterResult() {
		super();
	}

	/**
	 * Instantiates a new Relationship result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public SocialRelationshipCounterResult(String error, String result) {
		super(error, result);
	}

	/**
	 * Instantiates a new pOI result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param counter
	 *            the counters
	 */
	public SocialRelationshipCounterResult(String error, String result, RelationshipCounter counters) {
		super(error, result);
		this.counters = counters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		String user_id = null;
		Integer following = 0;
		Integer followedBy = 0;
		
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				
				JSONObject jCounter = jObject.getJSONObject("counters");
				
				// Extracting content
				user_id = APIUtils.getStringorNull(jCounter, "user_id");
				following = APIUtils.getIntegerorNull(jCounter, "following");
				followedBy = APIUtils.getIntegerorNull(jCounter, "followed_by");
				
				this.counters = new RelationshipCounter(user_id, following, followedBy);
				
			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
	}

	/**
	 * Gets the Relationship counter.
	 * 
	 * @return the Relationship counter
	 */
	public RelationshipCounter getRelationshipCounters() {
		return counters;
	}

	/**
	 * Sets the Relationship counter.
	 * 
	 * @param counters
	 *            the Relationship counter to set
	 */
	public void setRelationshipCounters(RelationshipCounter counters) {
		this.counters = counters;
	}

}