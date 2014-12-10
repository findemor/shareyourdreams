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

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;


/**
 * The Class SocialFriendRecommendationsResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class SocialFriendRecommendationsResult extends APICallResult {

	/** The recommended Relationships. */
	private FriendRecommendations relationships = null;

	/**
	 * Instantiates a new Relationship result.
	 */
	public SocialFriendRecommendationsResult() {
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
	public SocialFriendRecommendationsResult(String error, String result) {
		super(error, result);
	}

	/**
	 * Instantiates a new pOI result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param relationships
	 *            the friends recommendations
	 */
	public SocialFriendRecommendationsResult(String error, String result, FriendRecommendations relationships) {
		super(error, result);
		this.relationships = relationships;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		
		Integer count = 0;
		String user_id = null;
		String name = null;
		ArrayList<RelationshipConnectionType> connections;
		ArrayList<FriendRecommendation> relationships = new ArrayList<FriendRecommendation>();
		
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
										
				JSONArray jRels = jObject.getJSONArray("relationship");
				
				if (jRels != null){
					
					for (int j = 0; j < jRels.length(); j++)
					{
						JSONObject jRel = jRels.getJSONObject(j);
						// Extracting content
						user_id = APIUtils.getStringorNull(jRel, "user_id");
						name = APIUtils.getStringorNull(jRel, "name");
						count = APIUtils.getIntegerorNull(jRel, "count");
						JSONArray jArray = jRel.getJSONArray("connections");
						connections = new ArrayList<RelationshipConnectionType>();
						for (int i = 0; i < jArray.length(); i++) {
							String job = jArray.getString(i);
							connections.add(new RelationshipConnectionType(job, job));
						}
						relationships.add(new FriendRecommendation(user_id, name, count, connections));
					}
				}
				
				this.relationships = new FriendRecommendations(relationships);
				
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
	 * Gets the Relationship recommendations collection.
	 * 
	 * @return the Relationships recommendations collection
	 */
	public FriendRecommendations getRelationships() {
		return relationships;
	}

	/**
	 * Sets the Relationships recommendations.
	 * 
	 * @param Relationships
	 *            the Relationships recommendations to set
	 */
	public void setRelationships(FriendRecommendations relationships) {
		this.relationships = relationships;
	}

}