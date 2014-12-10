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
import topoos.Objects.GeoData;
import topoos.Objects.Image;

/**
 * The Class ImageResult.
 */
public class ImageResult extends APICallResult {

	/** The image. */
	private Image image = null;

	/**
	 * Instantiates a new image result.
	 */
	public ImageResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new image result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public ImageResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new image result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param image
	 *            the image
	 */
	public ImageResult(String error, String result, Image image) {
		super(error, result);
		this.image = image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				this.image = new Image(APIUtils.getStringorNull(jObject, "id"),
						APIUtils.getStringorNull(jObject, "client_id"),
						APIUtils.getStringorNull(jObject, "user_id"),
						APIUtils.getStringorNull(jObject, "filename"),
						APIUtils.getStringorNull(jObject, "filename_unique"),
						APIUtils.getStringorNull(jObject, "file_ext"),
						APIUtils.getStringorNull(jObject, "uri"),
						APIUtils.toDateString(APIUtils.getStringorNull(jObject,
								"register_date")),
						jObject.isNull("geo_data") ? null : new GeoData(jObject
								.getJSONObject("geo_data").optInt("id"),
								jObject.getJSONObject("geo_data").optInt(
										"position_id"), jObject.getJSONObject(
										"geo_data").optInt("poi_id")));
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
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 * 
	 * @param image
	 *            the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

}
