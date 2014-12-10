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

package topoos.APIAccess;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import topoos.Constants;
import topoos.APIAccess.Operations.APIOperation;
import topoos.APIAccess.Results.APICallResult;
import topoos.Exception.TopoosException;
import android.util.Log;

/**
 * Class that implements http call to topoos api
 * 
 * @author topoos
 * 
 */
public class APICaller {

	public static final int SERVICE_API = 0;
	public static final int SERVICE_LOGIN = 1;
	public static final int SERVICE_PIC = 2;
	public static final int SERVICE_SOCIAL = 3;
	
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_DELTE = "DELETE";
	

	/**
	 * Returns the url for the object operation.
	 * 
	 * @param operation
	 * @return URL
	 */
	public static String GetUriAPIOperation(APIOperation operation) {
		return Constants.TOPOOSURIAPI + operation.ConcatParams();
	}

	/**
	 * Returns the url for topoos api service
	 * 
	 * @return URL
	 */
	public static String GetURLAPItopoos() {
		return Constants.TOPOOSURIAPI;
	}

	/**
	 * Returns the url for topoos pic service
	 * 
	 * @return String
	 */
	public static String GetURLPICAPItopoos() {
		return Constants.TOPOOSURIPIC;
	}
	

	/**
	 * Returns the url for topoos social service
	 * 
	 * @return String
	 */
	public static String GetURLSOCIALAPItopoos() {
		return Constants.TOPOOSURISOCIAL;
	}

	/**
	 * Initiates an operation on topoos API.
	 * 
	 * @param operation
	 *            Represents the operation to be executed
	 * @param result
	 *            Represents a result returned from a query to API topoos
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static void ExecuteOperation(APIOperation operation,
			APICallResult result) throws IOException, TopoosException {
		HttpClient hc = new DefaultHttpClient();
		HttpParams httpParams = hc.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpConnectionParams.setSoTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpResponse rp = null;
		if (!operation.ValidateParams())
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		String OpURI = Constants.TOPOOSURIAPI + operation.ConcatParams();
		if (Constants.DEBUGURL) {
			Log.d(Constants.TAG, OpURI);
//			appendLog(OpURI);
		}
		
		Log.i("URL API TOPOOS:", OpURI);
		
		
		if (operation.getMethod().equals(METHOD_GET)) { // GET
			HttpGet get = new HttpGet(OpURI); //Antes funcionaba el Get con HttpPost
			rp = hc.execute(get);
		}else if (operation.getMethod().equals(METHOD_POST)) { // POST
			HttpPost post = new HttpPost(OpURI);
			post.setEntity(operation.BodyParams());
			rp = hc.execute(post);
		}else if (operation.getMethod().equals(METHOD_PUT)) { // PUT
			HttpPut put = new HttpPut(OpURI);
			put.setEntity(operation.BodyParams());
			rp = hc.execute(put);
		}else if (operation.getMethod().equals(METHOD_DELTE)) { // DELETE
			HttpDelete delete = new HttpDelete(OpURI);
			rp = hc.execute(delete);
		}		
		
		
		if (rp != null){
			if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result.setResult(EntityUtils.toString(rp.getEntity()));
				if (Constants.DEBUGURL) {
					Log.d(Constants.TAG, result.getResult());
	//				appendLog(result.getResult());
				}
				result.setError(null);
				result.setParameters();
			} else {
				switch (rp.getStatusLine().getStatusCode()) {
				case 400:
					throw new TopoosException(TopoosException.ERROR400);
				case 405:
					throw new TopoosException(TopoosException.ERROR405);
				default:
					throw new TopoosException("Error: "
							+ rp.getStatusLine().getStatusCode() + "");
				}
	
			}
		}
		hc.getConnectionManager().shutdown();
	}

	/**
	 * Initiates an operation on topoos API.
	 * 
	 * @param operation
	 *            Represents the operation to be executed
	 * @param result
	 *            Represents a result returned from a query to API topoos
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static void ExecuteOperation(APIOperation operation,
			APICallResult result, Integer service) throws IOException,
			TopoosException {
		HttpClient hc = new DefaultHttpClient();
		HttpParams httpParams = hc.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpConnectionParams.setSoTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpResponse rp = null;
		if (!operation.ValidateParams())
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		String OpURI = "";
		switch (service) {
		case SERVICE_API:
			OpURI = GetURLAPItopoos() + operation.ConcatParams();
			break;
		case SERVICE_PIC:
			OpURI = GetURLPICAPItopoos() + operation.ConcatParams();
			break;
		case SERVICE_SOCIAL:
			OpURI = GetURLSOCIALAPItopoos() + operation.ConcatParams();
			break;
		default:
			OpURI = GetURLAPItopoos() + operation.ConcatParams();
			break;
		}
		if (Constants.DEBUGURL) {
			Log.d(Constants.TAG, OpURI);
//			appendLog(OpURI);
		}
		
		if (operation.getMethod().equals(METHOD_GET)) { // GET
			HttpGet get = new HttpGet(OpURI); //Antes funcionaba el Get con HttpPost
			rp = hc.execute(get);
		}else if (operation.getMethod().equals(METHOD_POST)) { // POST
			HttpPost post = new HttpPost(OpURI);
			post.setEntity(operation.BodyParams());
			rp = hc.execute(post);
		}else if (operation.getMethod().equals(METHOD_PUT)) { // PUT
			HttpPut put = new HttpPut(OpURI);
			put.setEntity(operation.BodyParams());
			rp = hc.execute(put);
		}else if (operation.getMethod().equals(METHOD_DELTE)) { // DELETE
			HttpDelete delete = new HttpDelete(OpURI);
			rp = hc.execute(delete);
		}
		
		
		if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result.setResult(EntityUtils.toString(rp.getEntity()));
			if (Constants.DEBUGURL) {
				Log.d(Constants.TAG, result.getResult());
//				appendLog(result.getResult());
			}
			result.setError(null);
			result.setParameters();
		} else {
			switch (rp.getStatusLine().getStatusCode()) {
			case 400:
				throw new TopoosException(TopoosException.ERROR400);
			case 405:
				throw new TopoosException(TopoosException.ERROR405);
			default:
				throw new TopoosException("Error: "
						+ rp.getStatusLine().getStatusCode() + "");
			}

		}
		hc.getConnectionManager().shutdown();
	}

//	private static void appendLog(String text) {
//		try {
//			File logFile = new File(Environment.getExternalStorageDirectory(),
//					"logoperations.txt");
//			if (!logFile.exists()) {
//				logFile.createNewFile();
//			}
//
//			BufferedWriter buf = new BufferedWriter(new FileWriter(logFile,
//					true));
//			buf.append(text);
//			buf.newLine();
//			buf.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
