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

package topoos.APIAccess.Operations;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * Class that implements the utils of Api.
 *
 * @author topoos
 */
class APIUtils {
	
	/**
	 * Convert to String a date that is received as parameter.
	 *
	 * @param date the date
	 * @return String
	 */
	
	public static String toStringDate(Date date){
		String formatoFecha = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return date== null? null : sdf.format(date);
	}
	
	/**
	 * Convert to String a double value that received as parameter.
	 *
	 * @param doub the doub
	 * @return String
	 */
	public static String toStringDouble(Double doub){
		return doub==null? null:Double.toString(doub).replace(',',
				'.');
	}
	
	/**
	 * Convert to String an integer value that received as parameter.
	 *
	 * @param inte the inte
	 * @return String
	 */
	public static String toStringInteger(Integer inte){
		return inte==null? null:Integer.toString(inte);
	}
	
	/**
	 * Convert to String an url that received as parameter.
	 *
	 * @param str the str
	 * @return String
	 */
	public static String toStringUrlEncoded(String str){
		return str==null? null:str;
	}
	
	/**
	 * Convert to String a boolean value that received as parameter.
	 *
	 * @param bool the bool
	 * @return String
	 */
	public static String toStringBoolean(Boolean bool){
		return bool==null? null:Boolean.toString(bool);
	}
	
	/**
	 * Convert to String a Integer[] value that received as parameter.
	 *
	 * @param array the array
	 * @return String
	 */
	public static String toStringIntegerArray(Integer[] array){
		String strarray = "";
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				if (i < array.length - 1) {
					strarray = strarray + array[i] + ",";
				} else {
					strarray = strarray + array[i];
				}
			}
		}
		return strarray;
	}
	
	/**
	 * Convert to String a String[] value that received as parameter.
	 *
	 * @param array of String
	 * @return String
	 */
	public static String toStringStringArray (String [] array){
		String strarray=  "";
		if (array !=null){
			if (array.length >0){
				for (int i =0; i < array.length ; i++){
					strarray += array[i];
					if (i+1 <array.length){
						strarray +=",";
					}
				}
			}
		}
		return strarray;
	}
}
