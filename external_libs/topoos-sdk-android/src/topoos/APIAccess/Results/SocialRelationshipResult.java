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
 * The Class SocialRelationshipResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class SocialRelationshipResult extends APICallResult {

	/** The Relationship. */
	private Relationship relationship = null;

	/**
	 * Instantiates a new Relationship result.
	 */
	public SocialRelationshipResult() {
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
	public SocialRelationshipResult(String error, String result) {
		super(error, result);
	}

	/**
	 * Instantiates a new pOI result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param relationship
	 *            the relationship
	 */
	public SocialRelationshipResult(String error, String result, Relationship relationship) {
		super(error, result);
		this.relationship = relationship;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		String user_id = null;
		String name = null;
		ArrayList<RelationshipConnectionType> connections = new ArrayList<RelationshipConnectionType>();
		
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				
				JSONObject jRel = jObject.getJSONObject("relationship");
				
				// Extracting content
				user_id = APIUtils.getStringorNull(jRel, "user_id");
				name = APIUtils.getStringorNull(jRel, "name");
				JSONArray jArray = jRel.getJSONArray("connections");
				for (int i = 0; i < jArray.length(); i++) {
					String job = jArray.getString(i);
					connections.add(new RelationshipConnectionType(job, job));
				}
				this.relationship = new Relationship(user_id, name, connections);
				
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
	 * Gets the Relationship.
	 * 
	 * @return the Relationship
	 */
	public Relationship getRelationship() {
		return relationship;
	}

	/**
	 * Sets the Relationship.
	 * 
	 * @param Relationship
	 *            the Relationship to set
	 */
	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

}