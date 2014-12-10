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

package topoos.Users;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.UsersDeleteMembership;
import topoos.APIAccess.Operations.UsersGetMembership;
import topoos.APIAccess.Operations.UsersLogOut;
import topoos.APIAccess.Operations.UsersPutMembership;
import topoos.APIAccess.Operations.UsersRegisterLogin;
import topoos.APIAccess.Operations.UsersRegisterMembership;
import topoos.APIAccess.Operations.UsersResetPass;
import topoos.APIAccess.Results.GenericResult;
import topoos.APIAccess.Results.UserCollectionResult;
import topoos.APIAccess.Results.UserResult;
import topoos.Exception.TopoosException;
import topoos.Objects.User;
import topoos.Objects.UserIdPosition;
import android.content.Context;

/**
 * Operations related to user management
 * 
 * @author topoos
 * 
 */
public class Operations {

	/**
	 * Get a user
	 * 
	 * @param userID
	 *            (required) user identifier which we obtain information, the
	 *            value "me" allows authorized user information now
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return User
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User Get(AccessTokenOAuth accessTokenPregenerated, String userID) throws IOException,
			TopoosException {
		return Translator.Get(userID, accessTokenPregenerated);
	}

	/**
	 * Add user to group
	 * 
	 * @param userID
	 *            (required) user Identifier which we obtain information, the
	 *            value "me" allows authorized user information now
	 * @param groupID
	 *            (required) Identifier of the group to which the user belongs.
	 *            You happen to belong to this group.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	/*public static boolean GroupSet(AccessTokenOAuth accessTokenPregenerated, String userID, Integer groupID) throws IOException,
			TopoosException {
		return Translator.GroupSet(userID, groupID, accessTokenPregenerated);
	}*/

	/**
	 * Remove user from group
	 * 
	 * @param userID
	 *            (required) user identifier which we obtain information, the
	 *            value "me" allows authorized user information now
	 * @param groupID
	 *            (required) ID of the group to which the user belongs. The user
	 *            will belong to this group.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	/*public static boolean GroupRemove(AccessTokenOAuth accessTokenPregenerated, String userID, Integer groupID) throws IOException,
			TopoosException {
		return Translator.GroupRemove(userID, groupID, accessTokenPregenerated);
	}*/

	/**
	 * Get users near of POI
	 * 
	 * @param POIID
	 *            (required) Point of interest identifier.
	 * @param radius
	 *            (required) search radius in meters, should be greater than
	 *            zero.
	 * @param groupID
	 *            (optional) user group identifier. If specified, the results
	 *            will include only users who belong to that group.
	 * @param usersCount
	 *            (optional) number of users returned. The return will always be
	 *            those closest to the point. Default value 1.
	 * @param activeTrack
	 *            (optional) the search is performed only between users who are
	 *            currently active Track. Allowed values ​​"true". By default
	 *            "true"
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return List
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPOIGet(AccessTokenOAuth accessTokenPregenerated, Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack)
			throws IOException, TopoosException {
		return Translator.NearPOIGet(POIID, radius, groupID, usersCount,
				activeTrack, accessTokenPregenerated);
	}

	/**
	 * Get users near of a position (latitude,longitude)
	 * 
	 * @param lat
	 *            (required) latitude search center point. It is a required
	 *            parameter is not specified poi.
	 * @param lng
	 *            (required) longitude search center point. It is a required
	 *            parameter is not specified poi.
	 * @param radius
	 *            (required) search radius in meters, should be greater than
	 *            zero.
	 * @param groupID
	 *            (optional) user group identifier. If specified, the results
	 *            will include only users who belong to that group.
	 * @param usersCount
	 *            (optional) number of users returned. The return will always be
	 *            those closest to the point. Default value 1.
	 * @param activeTrack
	 *            (optional) the search is performed only between users who are
	 *            currently active Track. Allowed values ​​"true". By default
	 *            "true"
	 * @param accessTokenPregenerated 
	 *            (required) access_token to user resources
	 * @return List
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPositionGet(AccessTokenOAuth accessTokenPregenerated, Double lat, Double lng,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack)
			throws IOException, TopoosException {
		return Translator.NearPositionGet(lat, lng, radius, groupID,
				usersCount, activeTrack, accessTokenPregenerated);
	}

	/**
	 * Get a user
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param userID
	 *            (required) user identifier which we obtain information, the
	 *            value "me" allows authorized user information now
	 * @return User
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User Get(Context context, String userID) throws IOException,
			TopoosException {
		return Translator.Get(context, userID);
	}

	/**
	 * Add user to group
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param userID
	 *            (required) user identifier which we obtain information, the
	 *            value "me" allows authorized user information now
	 * @param groupID
	 *            (required) Identifier of the group to which the user belongs.
	 *            You happen to belong to this group.
	 * @return boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	/*public static boolean GroupSet(Context context, String userID,
			Integer groupID) throws IOException, TopoosException {
		return Translator.GroupSet(context, userID, groupID);
	}*/

	/**
	 * Remove user from group
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param userID
	 *            user identifier which we obtain information, the value "me"
	 *            allows authorized user information now
	 * @param groupID
	 *            (required) ID of the group to which the user belongs. The user
	 *            will belong to this group.
	 * @return boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	/*public static boolean GroupRemove(Context context, String userID,
			Integer groupID) throws IOException, TopoosException {
		return Translator.GroupRemove(context, userID, groupID);
	}*/

	/**
	 * Get users near of POI
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POIID
	 *            (required) Point of interest identifier.
	 * @param radius
	 *            (required) search radius in meters, should be greater than
	 *            zero.
	 * @param groupID
	 *            (optional) user group identifier. If specified, the results
	 *            will include only users who belong to that group.
	 * @param usersCount
	 *            (optional) number of users returned. The return will always be
	 *            those closest to the point. Default value 1.
	 * @param activeTrack
	 *            (optional) the search is performed only between users who are
	 *            currently active Track. Allowed values ​​"true". By default
	 *            "true"
	 * @return List
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPOIGet(Context context,
			Integer POIID, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) throws IOException, TopoosException {
		return Translator.NearPOIGet(context, POIID, radius, groupID,
				usersCount, activeTrack);
	}

	/**
	 * Get users near of a position (latitude,longitude)
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param lat
	 *            (required) latitude search center point. It is a required
	 *            parameter is not specified poi.
	 * @param lng
	 *            (required) longitude search center point. It is a required
	 *            parameter is not specified poi.
	 * @param radius
	 *            (required) search radius in meters, should be greater than
	 *            zero.
	 * @param groupID
	 *            (optional) user group identifier. If specified, the results
	 *            will include only users who belong to that group.
	 * @param usersCount
	 *            (optional) number of users returned. The return will always be
	 *            those closest to the point. Default value 1.
	 * @param activeTrack
	 *            (optional) the search is performed only between users who are
	 *            currently active Track. Allowed values ​​"true". By default
	 *            "true"
	 * @return List
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPositionGet(Context context,
			Double lat, Double lng, Integer radius, Integer groupID,
			Integer usersCount, Boolean activeTrack) throws IOException,
			TopoosException {
		return Translator.NearPositionGet(context, lat, lng, radius, groupID,
				usersCount, activeTrack);
	}
	
	
	/***
	 * 
	 * @param api_key
	 * @param username
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean ResetPass (String api_key , String username) throws IOException, TopoosException{
		return Translator.ResetPass(api_key, username);
	}
	
	/***
	 * 
	 * @param accessTokenPregenerated
	 * @param count
	 * @param page
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<User> GetMembership (AccessTokenOAuth accessTokenPregenerated, Integer count, Integer page)
			throws IOException, TopoosException {
		return Translator.GetMembership(accessTokenPregenerated, count, page);
	}

	
	/***
	 * 
	 * @param accessTokenPregenerated
	 * @param user_id
	 * @param new_pass
	 * @param old_pass
	 * @param gender
	 * @param birthdate
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean PutMembership (AccessTokenOAuth accessTokenPregenerated, String user_id, String new_pass, String old_pass,String gender, Date birthdate )throws IOException, TopoosException{
		return Translator.PutMembership(accessTokenPregenerated, user_id, new_pass, old_pass, gender, birthdate);
	}
	
	/***
	 * 
	 * @param accessTokenPregenerated
	 * @param api_key
	 * @param user_name
	 * @param pwd
	 * @param email
	 * @param gender
	 * @param birthdate
	 * @param expiresIn
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User RegisterMembership (AccessTokenOAuth accessTokenPregenerated, String api_key, String user_name, String pwd, String email, String gender, Date birthdate, Integer expiresIn) throws IOException, TopoosException {
		return Translator.RegisterMembership(accessTokenPregenerated, api_key, user_name, pwd, email, gender, birthdate, expiresIn);
	}
	
	/***
	 * 
	 * @param api_key
	 * @param username
	 * @param pwd
	 * @param expiresIn
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User RegisterLogin (String api_key , String username, String pwd, Integer expiresIn) throws IOException, TopoosException{
		return Translator.RegisterLogin(api_key, username, pwd, expiresIn);
	}
	
	/**
	 * 
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Logout (AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.Logout(accessTokenPregenerated);
	}
	
	/***
	 * 
	 * @param accessTokenPregenerated
	 * @param user_id
	 * @return
	 * @throws TopoosException
	 * @throws IOException
	 */
	public static Boolean DeleteMembership (AccessTokenOAuth accessTokenPregenerated, String user_id) throws TopoosException, IOException{
		return Translator.DeleteMembership(accessTokenPregenerated, user_id);
	}
}
