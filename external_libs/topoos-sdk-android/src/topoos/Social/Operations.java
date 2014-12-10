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

package topoos.Social;

import java.io.IOException;
import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.FriendRecommendations;
import topoos.Objects.Relationship;
import topoos.Objects.RelationshipCounter;
import topoos.Objects.Relationships;

/**
 * 
 * @author topoos
 * 
 * Operations related to Social management
 * 
 */
public class Operations {

	/**
	 * Add a following relationship between both users, the authenticated user and the specified one.
	 *
	 * The specified user will be followed by the current authorized user.
	 * 
	 * @param targetUserId
	 *            target user identifier to follow.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Relationship
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationship AddFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.AddFollow(targetUserId, accessTokenPregenerated);
	}

	/**
	 * Remove a following relationship between both users, the authenticated user and the specified one.
	 *
	 * As result, the specified user will not be followed by the current authorized user.
	 * 
	 * @param targetUserId
	 *            target user identifier to follow.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Relationship
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationship DeleteFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.DeleteFollow(targetUserId, accessTokenPregenerated);
	}


	/**
	 * Get the detail of the single relationship between the specified origin user and the targed user.
	 * 
	 * 
	 * @param USR
	 *            origin user id, use "me" for current user
	 * @param targetUserId
	 *            target user identifier to get wich relationships has the origin user with him.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Relationship
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationship GetFriendship(String USR, String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.GetFriendship(USR, targetUserId, accessTokenPregenerated);
	}
	
	/**
	 * Get followed users collection for the specified user.
	 * All returned relationship are users followed by the specified user. The max number or records that you can get in one single call is 50 per page.
	 * @param USR
	 * @param cursor integer value that identifies the result page. Default value (-1), or unspecified parameter, will return the first results page. You can navigate between pages using the cursor (cursor_next and cursor_prev) that you obtain as result.
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationships GetFollowed(String USR, Integer cursor, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.GetFollowed(USR, cursor, accessTokenPregenerated);
	}
	

	/**
	 * Get followers users collection for the specified user.
	 * All returned relationship are users that are currently following the specified user. The max number or records that you can get in one single call is 50 per page.
	 * @param USR
	 * @param cursor integer value that identifies the result page. Default value (-1), or unspecified parameter, will return the first results page. You can navigate between pages using the cursor (cursor_next and cursor_prev) that you obtain as result.
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationships GetFollowers(String USR, Integer cursor, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.GetFollowers(USR, cursor, accessTokenPregenerated);
	}
	
	/**
	 * Get the number of both relationships (followers and followed by) for the specified user id.
	 * 
	 * @param USR target user identifier to get its relationships counters. You can use the special value “me” for this parameter, to get the counters of the current authenticated user.
	 * @param accessTokenPregenerated access_token to current authorized user resources.
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static RelationshipCounter GetCounters(String USR, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.GetCounters(USR, accessTokenPregenerated);
	}
	
	/**
	 * Get recommended users collection for the specified user based on his connections with other users in his mesh.
	 *
	 * As result you will get also the number of connections with the other users. The maximum number of results for this call is 5 recommended relationships.
	 *
	 * @param USR origin user identifier to get its relationships counters. You can use the special value “me” for this parameter, to get the counters of the current authenticated user.
	 * @param accessTokenPregenerated access_token to current authorized user resources.
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static FriendRecommendations GetFriendRecommendations(String USR, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.GetFriendsRecommendation(USR, accessTokenPregenerated);
	}
}
