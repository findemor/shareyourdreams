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

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * 
 * @author topoos
 * 
 */
class Translator {

	private final static String VERB_GET = "GET";
	private final static String VERB_POST = "POST";
	private final static String VERB_PUT = "PUT";
	private final static String VERB_DELETE = "DELETE";
	
	private final static String GENDER_MALE = "male";
	private final static String GENDER_FEMALE = "female";
	
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User Get(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		User user = null;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRShow usersUSRShow = new UsersUSRShow("Get", VERB_GET, format,
					version, accessTokenPregenerated.getAccessToken(), userID);
			UserResult userResult = new UserResult();
			APICaller.ExecuteOperation(usersUSRShow, userResult);
			user = userResult.getUser();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return user;
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static boolean GroupSet(String userID, Integer groupID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean groupSet = false;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRAdd_group usersUSRAdd_group = new UsersUSRAdd_group(
					"GroupSet", VERB_GET, format, version,
					accessTokenPregenerated.getAccessToken(), userID, groupID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(usersUSRAdd_group, genericResult);
			groupSet = genericResult.getCode() != null
					&& genericResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return groupSet;
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static boolean GroupRemove(String userID, Integer groupID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean groupRemove = false;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRRemove_group usersUSRRemove_group = new UsersUSRRemove_group(
					"GroupRemove", VERB_GET, format, version,
					accessTokenPregenerated.getAccessToken(), userID, groupID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(usersUSRRemove_group, genericResult);
			groupRemove = genericResult.getCode() != null
					&& genericResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return groupRemove;

	}

	/**
	 * 
	 * @param POIID
	 * @param radius
	 * @param groupID
	 * @param usersCount
	 * @param activeTrack
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPOIGet(Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		List<UserIdPosition> list = null;
		UsersNear usersNear = null;
		if (accessTokenPregenerated.isValid()) {
			UsersGet_near usersGet_near = new UsersGet_near("NearPOIGet",
					VERB_GET, format, version,
					accessTokenPregenerated.getAccessToken(), POIID, radius,
					activeTrack, groupID, usersCount);
			UsersNearResult usersNearResult = new UsersNearResult();
			APICaller.ExecuteOperation(usersGet_near, usersNearResult);
			if (usersNearResult.getUsersnear() != null) {
				usersNear = usersNearResult.getUsersnear();
				list = usersNear.getUserPositions();
			}
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return list;
	}

	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param radius
	 * @param groupID
	 * @param numberUsers
	 * @param activeTrack
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPositionGet(Double lat, Double lng,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		List<UserIdPosition> list = null;
		UsersNear usersNear = null;
		if (accessTokenPregenerated.isValid()) {
			UsersGet_near usersGet_near = new UsersGet_near("NearPOIGet",
					VERB_GET, format, version,
					accessTokenPregenerated.getAccessToken(), lat, lng, radius,
					activeTrack, groupID, usersCount);
			UsersNearResult usersNearResult = new UsersNearResult();
			APICaller.ExecuteOperation(usersGet_near, usersNearResult);
			if (usersNearResult.getUsersnear() != null) {
				usersNear = usersNearResult.getUsersnear();
				list = usersNear.getUserPositions();
			}
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return list;
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User Get(Context context, String userID) throws IOException,
			TopoosException {
		return Get(userID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @param groupID
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static boolean GroupSet(Context context, String userID,
			Integer groupID) throws IOException, TopoosException {
		return GroupSet(userID, groupID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @param groupID
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static boolean GroupRemove(Context context, String userID,
			Integer groupID) throws IOException, TopoosException {
		return GroupRemove(userID, groupID, AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @param radius
	 * @param groupID
	 * @param usersCount
	 * @param activeTrack
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPOIGet(Context context,
			Integer POIID, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) throws IOException, TopoosException {
		return NearPOIGet(POIID, radius, groupID, usersCount, activeTrack,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param radius
	 * @param groupID
	 * @param numberUsers
	 * @param activeTrack
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPositionGet(Context context,
			Double lat, Double lng, Integer radius, Integer groupID,
			Integer usersCount, Boolean activeTrack) throws IOException,
			TopoosException {
		return NearPositionGet(lat, lng, radius, groupID, usersCount,
				activeTrack, AccessTokenOAuth.GetAccessToken(context));
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
		boolean reset = false;
		UsersResetPass resetPass = new UsersResetPass("Reset_pass", VERB_GET, format,
					version, api_key, username);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(resetPass, genericResult);
			reset = genericResult.getCode() == 200;
		
		return reset;
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
		List<User> users = null;
		if (accessTokenPregenerated != null && accessTokenPregenerated.isValid()) {
			UsersGetMembership usrsGetM = new UsersGetMembership ("Get_Membership", VERB_GET, format,
					version,accessTokenPregenerated.getAccessToken(), count, page);
			UserCollectionResult userCollectionResult = new UserCollectionResult();
			APICaller.ExecuteOperation(usrsGetM, userCollectionResult);
			users = userCollectionResult.getUsers().getUsers();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return users;
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
		boolean reset = false;
		if (accessTokenPregenerated != null && accessTokenPregenerated.isValid()) {
			
			UsersPutMembership resetPass = new UsersPutMembership("Put_Membership", VERB_PUT, format,
					version, accessTokenPregenerated.getAccessToken(), user_id,new_pass, old_pass, getGender (gender), birthdate );
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(resetPass, genericResult);
			reset = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		
		
		return reset;
	}
	
	private static String getGender (String gender){
		String result =null;
		if (gender != null){
			if (gender.equals(GENDER_MALE)){
				result = GENDER_MALE;
			}else if (gender.equals(GENDER_FEMALE)){
				result = GENDER_FEMALE;
			}
		}
		return result;
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
		User user = null;
		String token;
		if (accessTokenPregenerated != null && accessTokenPregenerated.isValid() ) {
			token = accessTokenPregenerated.getAccessToken();
		}else {
			token = null;
		}
		
		UsersRegisterMembership usersRegMem = new UsersRegisterMembership("Register Membership", VERB_POST, format,
				version, token, api_key, user_name, pwd, email, getGender(gender), birthdate, expiresIn);
		UserResult userResult = new UserResult();
		APICaller.ExecuteOperation(usersRegMem, userResult);
		user = userResult.getUser();
		return user;
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
		User user = null;
		UsersRegisterLogin usersRegMem = new UsersRegisterLogin("Register login", VERB_POST, format,
				version, api_key, username, pwd, expiresIn);
		UserResult userResult = new UserResult();
		APICaller.ExecuteOperation(usersRegMem, userResult);
		user = userResult.getUser();
		
		return user;
	}

	
	/**
	 * 
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Logout (AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		boolean completed = false;
		if (accessTokenPregenerated != null && accessTokenPregenerated.isValid()) {
			UsersLogOut logout = new UsersLogOut("Log out", VERB_DELETE, format,
					version, accessTokenPregenerated.getAccessToken());
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(logout, genericResult);
			completed = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return completed;
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
		boolean delete = false;
		if (accessTokenPregenerated != null && accessTokenPregenerated.isValid()) {
			UsersDeleteMembership delMember = new UsersDeleteMembership ("Delete membership", VERB_DELETE, format,
					version,accessTokenPregenerated.getAccessToken(), user_id);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(delMember, genericResult);
			delete = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}
}
