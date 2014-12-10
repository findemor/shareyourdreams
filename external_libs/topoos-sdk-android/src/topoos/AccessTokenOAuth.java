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

package topoos;


import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * Implements AccesToken
 * @author topoos
 *
 */
public class AccessTokenOAuth {



	String AccessToken;
	Long ExpiresIn;
	
	private String KEY_ACCESS_TOKEN="KEY_ACCESS_TOKEN";
	private String KEY_EXPIREIN="KEY_EXPIREIN";
	
	/**
	 * 
	 */
	public AccessTokenOAuth() {
		super();
		AccessToken="";
		ExpiresIn=(long) 0;
	}
	
	/**
	 * set the token without expires time
	 * @param token
	 */
	public AccessTokenOAuth(String token) {
		super();
		AccessToken=token;
		ExpiresIn=(long) 0;
	}
	/**
	 * set the token with the parameters that received
	 * @param token
	 * @param expiresIn
	 */
	public AccessTokenOAuth(String token, Long expiresIn) {
		super();
		AccessToken=token;
		ExpiresIn=expiresIn;
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}
	}


	
	/**
	 * get the time that token expires
	 * @return the expiresIn
	 */
	public Long getExpiresIn() {
		return ExpiresIn;
	}


	/** set the expires time of the token acces
	 * @param expiresIn the expiresIn to set
	 */
	public void setExpiresIn(Long expiresIn) {
		ExpiresIn = expiresIn;
	}

	
	/** get the access token
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return AccessToken;
	}


	/**
	 * set the access token that received as parameter
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		AccessToken = accessToken;
	}

	/**
	 * save the token
	 * @param context
	 */
	public synchronized void save_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(KEY_ACCESS_TOKEN,this.AccessToken );
		editor.putLong(KEY_EXPIREIN,this.ExpiresIn );
		editor.commit();	
		if(Constants.DEBUG){
			Log.i(Constants.TAG, this.toStringToken());
		}
	}
	/**
	 * load the Token that recieved as parameter
	 * @param context
	 */
	public synchronized void load_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		this.AccessToken=settings.getString(KEY_ACCESS_TOKEN,"");
		this.ExpiresIn=settings.getLong(KEY_EXPIREIN,-1);
		//this.RefreshToken=settings.getString(KEY_REFRESHTOKEN,"");
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}
	}	
	/**
	 * delete the token that has been saved previously
	 * @param context
	 */
	public synchronized void delete_Token(Context context){
		this.AccessToken="";
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}		
	}
	/**
	 * check if the token is valid, it has not expired
	 * @return boolean
	 */
	public boolean isValid(){
		boolean isvalid=true;
		Calendar cal=Calendar.getInstance();
		isvalid=cal.getTimeInMillis()<ExpiresIn || ExpiresIn==0;
		isvalid=isvalid&&(AccessToken!=null &&!AccessToken.equals(""));
		if(Constants.DEBUG){
			Log.i(Constants.TAG, "Valido: "+isvalid);
		}
		return isvalid;
	}
	
	
	
	/**
	 * get the access token that is previously saved
	 * @param context
	 * @return AccessTokenOAuth
	 */
	public static AccessTokenOAuth GetAccessToken(Context context){
		AccessTokenOAuth access=new AccessTokenOAuth();
		access.load_Token(context);
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, access.toStringToken());
		}
		return access;
	}
	
	/**
	 * delete the access token
	 * @param context
	 */
	public static void DeleteAccessToken(Context context){
		AccessTokenOAuth access=new AccessTokenOAuth();
		access.save_Token(context);
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, access.toStringToken());
		}		
	}
	/**
	 * convert to string the Access Token
	 * @return
	 */
	private String toStringToken(){
		return "Token: "+this.AccessToken+" Time: "+this.ExpiresIn;
	}
}
