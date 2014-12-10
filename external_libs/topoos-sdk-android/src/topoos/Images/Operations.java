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

package topoos.Images;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Image;
import android.content.Context;

/**
 * 
 * @author topoos
 * 
 *         Operations related to pic image services.
 * 
 */
public class Operations {

	public static final int SIZE_XXXSMALL = Translator.SIZE_XXXSMALL;
	public static final int SIZE_XXSMALL = Translator.SIZE_XXSMALL;
	public static final int SIZE_XSMALL = Translator.SIZE_XSMALL;
	public static final int SIZE_SMALL = Translator.SIZE_SMALL;
	public static final int SIZE_LARGE = Translator.SIZE_LARGE;
	public static final int SIZE_XLARGE = Translator.SIZE_XLARGE;
	public static final int SIZE_XXLARGE = Translator.SIZE_XXLARGE;
	public static final int SIZE_XXXLARGE = Translator.SIZE_XXXLARGE;

	public static final int PRIVACY_PUBLIC = Translator.PRIVACY_PUBLIC;
	public static final int PRIVACY_CLIENT = Translator.PRIVACY_CLIENT;
	public static final int PRIVACY_USER = Translator.PRIVACY_USER;

	/**
	 * Image upload.
	 * 
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename          
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(AccessTokenOAuth accessTokenPregenerated,
			byte[] file, String filename, String fileformat, String [] keywords, Integer privacy) throws IOException, TopoosException {
		return Translator.ImageUpload( accessTokenPregenerated, file, filename, fileformat, keywords, privacy);

	}
	
	/**
	 * Image upload.
	 * 
	 * @param Context the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename          
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(Context context,
			byte[] file, String filename, String fileformat, String [] keywords, Integer privacy) throws IOException, TopoosException {
		return Translator.ImageUpload( AccessTokenOAuth.GetAccessToken(context), file, filename, fileformat, keywords, privacy);

	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy
	 * @param pos_id
	 *            (required) position identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPosition(
			AccessTokenOAuth accessTokenPregenerated,
			byte[] file, String filename, String fileformat, String [] keywords, Integer privacy, Integer pos_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPosition(accessTokenPregenerated,file, filename, fileformat, keywords, privacy, pos_id
				);
	}
	
	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy
	 * @param pos_id
	 *            (required) position identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPosition(
			Context context,
			byte[] file, String filename, String fileformat, String [] keywords, Integer privacy, Integer pos_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPosition(AccessTokenOAuth.GetAccessToken(context),file, filename, fileformat, keywords, privacy, pos_id
				);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * 
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy
	 * @param poi_id
	 *            (required) point of interest identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPOI(
			AccessTokenOAuth accessTokenPregenerated, byte[] file,
			String filename, String fileformat, String [] keywords, Integer privacy, Integer poi_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPOI(accessTokenPregenerated,file, filename, fileformat, keywords,privacy, poi_id
				);
	}
	
	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * 
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy
	 * @param poi_id
	 *            (required) point of interest identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPOI(
			Context context, byte[] file,
			String filename, String fileformat, String [] keywords, Integer privacy, Integer poi_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPOI(AccessTokenOAuth.GetAccessToken(context),file, filename, fileformat, keywords,privacy, poi_id
				);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 *            
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy           
	 * @param name
	 *            (required) access_token to user resources
	 *            
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param description
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadNewPOI(
			AccessTokenOAuth accessTokenPregenerated, byte[] file,
			String filename, String fileformat, String [] keywords, Integer privacy,
			Double lat, Double lng,
			String name, String description, Integer elevation,
			Integer accuracy, Integer vaccuracy, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			Integer[] categories) throws IOException, TopoosException {
		return Translator.ImageUploadNewPOI(accessTokenPregenerated, file, filename,fileformat,keywords,
				privacy, lat, lng, name,
				description, elevation, accuracy, vaccuracy, address,
				cross_street, city, country, postal_code, phone, twitter,
				categories );
	}

	

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 *            
	 * @param fileformat         
	 * @param keywords
	 * @param privacy the privacy           
	 * @param name
	 *            (required) access_token to user resources
	 *            
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param description
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadNewPOI(
			Context context, byte[] file,
			String filename, String fileformat, String [] keywords, Integer privacy,
			Integer pos_id, Double lat, Double lng,
			String name, String description, Integer elevation,
			Integer accuracy, Integer vaccuracy, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			Integer[] categories) throws IOException, TopoosException {
		return Translator.ImageUploadNewPOI(AccessTokenOAuth.GetAccessToken(context), file, filename,fileformat,keywords,
				privacy, lat, lng, name,
				description, elevation, accuracy, vaccuracy, address,
				cross_street, city, country, postal_code, phone, twitter,
				categories );
	}

	/**
	 * Get uri of image
	 * 
	 * @param filename_unique
	 *            Unique image ID
	 * @return String
	 */
	public static String GetImageURI(String filename_unique) {
		return Translator.GetImageURI(filename_unique);
	}
	

	/**
	 * Get uri of image with privacy param
	 * 
	 * @param filename_unique
	 *            Unique image ID
	 * @param privacy
	 *            the privacy
	 * @return String
	 */
	public static String GetImageURI(String filename_unique,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.GetImageURI(filename_unique, accessTokenPregenerated);
	}

	
	/**
	 * Gets the image uri thumb by size.
	 * 
	 * AccessTokenOAuth can be null
	 * 
	 * @param accessTokenPregenerated for the privacy
	 * @param filename_unique
	 *            the filename_unique
	 * @param size the size 
	 * @return the URI
	 * 
	 */
	public static String GetImageURIThumb(AccessTokenOAuth accessTokenPregenerated,String filename_unique, Integer size, Integer dpi, Integer mode) throws TopoosException {
		return Translator.GetImageURIThumb(accessTokenPregenerated, filename_unique, size, dpi, mode);
	}
	
	/**
	 * Gets the image uri thumb by width and high.
	 * 
	 * AccessTokenOAuth can be null
	 * 
	 * @param accessTokenPregenerated for the privacy
	 * @param filename_unique
	 *            the filename_unique
	 * @param width the width
	 * @param high the high
	 * @return the URI
	 * 
	 */
	public static String GetImageURIThumb(AccessTokenOAuth accessTokenPregenerated,String filename_unique, Integer width, Integer high, Integer dpi, Integer mode) throws TopoosException {
		return Translator.GetImageURIThumb(accessTokenPregenerated, filename_unique, width, high, dpi, mode);
	}

	/**
	 * Delete image from PIC service permanently.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param filename_unique Unique image ID
	 * @return Boolean    
	 * @throws TopoosException 
	 * @throws IOException 
	 *  */
	public static Boolean Delete (AccessTokenOAuth accessTokenPregenerated, String fileName) throws IOException, TopoosException{
		return Translator.Delete (accessTokenPregenerated, fileName);
		
	}
	
	/**
	 * Update privacy, and keywords.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param filename_unique Unique image ID
	 * @param keywords for the image
	 * @param privacy for the image
	 * @return Boolean    
	 * @throws TopoosException 
	 * @throws IOException 
	 *  */
	public static Boolean ImageUpdate(AccessTokenOAuth accessTokenPregenerated,String filename_unique,
			 String[] keywords,Integer privacy) throws TopoosException, IOException {
		return Translator.ImageUpdate(filename_unique, accessTokenPregenerated, keywords, privacy);
	}
	
	/**
	 * Search images
	 * 
	 * @param accessTokenPregenerated 
	 * 			(required) access_token to user resources
	 * @param filename_unique unique identifier image
	 * @param keywords keywords id of image
	 * @param count max number of items that will be returned
	 * @param page result page number. First page is 0. Default 0
	 * @return List <Image> */
	public static List <Image> SearchImage(AccessTokenOAuth accessTokenPregenerated,String filename_unique, String [] keywords, Integer count, Integer page) throws TopoosException, IOException {
		return Translator.SearchImage(accessTokenPregenerated, filename_unique, keywords, count, page);
	}
}
