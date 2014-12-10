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
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

class Translator {

	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	public static Relationship AddFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationship rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialAddFollow relAdd = new SocialAddFollow("SocialFollowAdd", method, format, version,
					accessTokenPregenerated.getAccessToken(), targetUserId);
			SocialRelationshipResult relResult = new SocialRelationshipResult();
			APICaller.ExecuteOperation(relAdd, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationship();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}

	public static Relationship DeleteFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationship rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialDeleteFollow relDelete = new SocialDeleteFollow("SocialFollowDelete", method, format, version,
					accessTokenPregenerated.getAccessToken(), targetUserId);
			SocialRelationshipResult relResult = new SocialRelationshipResult();
			APICaller.ExecuteOperation(relDelete, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationship();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	

	public static Relationship GetFriendship(String usr, String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationship rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialGetFriendship relFriendship = new SocialGetFriendship("GetFriendship", method, format, version,
					accessTokenPregenerated.getAccessToken(), usr, targetUserId);
			SocialRelationshipResult relResult = new SocialRelationshipResult();
			APICaller.ExecuteOperation(relFriendship, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationship();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	

	public static Relationships GetFollowed(String usr, Integer cursor, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationships rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialGetFollowed relFollowed = new SocialGetFollowed("GetFollowed", method, format, version,
					accessTokenPregenerated.getAccessToken(), usr, cursor);
			SocialRelationshipsResult relResult = new SocialRelationshipsResult();
			APICaller.ExecuteOperation(relFollowed, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationships();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	

	public static Relationships GetFollowers(String usr, Integer cursor, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationships rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialGetFollowers relFollowed = new SocialGetFollowers("GetFollowers", method, format, version,
					accessTokenPregenerated.getAccessToken(), usr, cursor);
			SocialRelationshipsResult relResult = new SocialRelationshipsResult();
			APICaller.ExecuteOperation(relFollowed, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationships();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	

	public static RelationshipCounter GetCounters(String usr, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		RelationshipCounter rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialGetRelationshipCounter relCounters = new SocialGetRelationshipCounter("GetCounters", method, format, version,
					accessTokenPregenerated.getAccessToken(), usr);
			SocialRelationshipCounterResult relResult = new SocialRelationshipCounterResult();
			APICaller.ExecuteOperation(relCounters, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationshipCounters();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	

	public static FriendRecommendations GetFriendsRecommendation(String usr, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		FriendRecommendations rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialGetFriendRecommendations relRecommendations = new SocialGetFriendRecommendations("GetFriendsRecommendation", method, format, version,
					accessTokenPregenerated.getAccessToken(), usr);
			SocialFriendRecommendationsResult relResult = new SocialFriendRecommendationsResult();
			APICaller.ExecuteOperation(relRecommendations, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationships();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	

}
