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

package topoos.Positions;

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

class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	private static Position AddPrivate(Integer Type, Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity,
			Double bearing, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("Add", method, format,
					version, accessTokenPregenerated.getAccessToken(), null,
					lat, lng, accuracy, vaccuracy, elevation, timestamp,
					velocity, Type, bearing, trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return position;
	}

	public static Position Add(Double lat, Double lng, Integer trackID,
			Double accuracy, Double vaccuracy, Double elevation,
			Date timestamp, Double velocity, Double bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.POS, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddAlarmEnd(Double lat, Double lng, Integer trackID,
			Double accuracy, Double vaccuracy, Double elevation,
			Date timestamp, Double velocity, Double bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.ALARM_END, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddAlarmInit(Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity,
			Double bearing, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return AddPrivate(PositionsAdd.ALARM_INIT, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddGPSNo(Double lat, Double lng, Integer trackID,
			Double accuracy, Double vaccuracy, Double elevation,
			Date timestamp, Double velocity, Double bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.GPS_NO, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddGPSOk(Double lat, Double lng, Integer trackID,
			Double accuracy, Double vaccuracy, Double elevation,
			Date timestamp, Double velocity, Double bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.GPS_OK, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddTrackEnd(Double lat, Double lng, Integer trackID,
			Double accuracy, Double vaccuracy, Double elevation,
			Date timestamp, Double velocity, Double bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.TRACK_END, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position Get(Integer posID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsGet positionsGet = new PositionsGet("Get", method,
					format, version, accessTokenPregenerated.getAccessToken(),
					posID, null, null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet, positionResult);
			position = positionResult.getPosition();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return position;
	}

	public static Position GetLastUser(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			if(userID==null){
				userID="me";
			}
			PositionsGet positionsGet = new PositionsGet("GetLastUser", method,
					format, version, accessTokenPregenerated.getAccessToken(),
					null, userID, null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet, positionResult);
			position = positionResult.getPosition();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return position;
	}

	public static List<Position> GetBetweenDays(Date initDate, Date endDate,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		List<Position> positions = null;

		if (accessTokenPregenerated.isValid()) {
			PositionsGet_between positionsGet_between = new PositionsGet_between(
					"AddTrackEnd", method, format, version,
					accessTokenPregenerated.getAccessToken(), initDate,
					endDate, null);
			PositionCollectionResult positionCollectionResult = new PositionCollectionResult();
			APICaller.ExecuteOperation(positionsGet_between, positionCollectionResult);
			positions = positionCollectionResult.getPositions();
		}

		return positions;
	}

	public static Position Add(Context context, Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity, Double bearing)
			throws IOException, TopoosException {
		return Add(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position AddAlarmEnd(Context context, Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity, Double bearing)
			throws IOException, TopoosException {
		return AddAlarmEnd(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position AddAlarmInit(Context context, Double lat,
			Double lng, Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity, Double bearing)
			throws IOException, TopoosException {
		return AddAlarmInit(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position AddGPSNo(Context context, Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity, Double bearing)
			throws IOException, TopoosException {
		return AddGPSNo(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position AddGPSOk(Context context, Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity, Double bearing)
			throws IOException, TopoosException {
		return AddGPSOk(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position AddTrackEnd(Context context, Double lat, Double lng,
			Integer trackID, Double accuracy, Double vaccuracy,
			Double elevation, Date timestamp, Double velocity, Double bearing)
			throws IOException, TopoosException {
		return AddTrackEnd(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position Get(Context context, Integer posID)
			throws IOException, TopoosException {
		return Get(posID, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Position GetLastUser(Context context, String userID)
			throws IOException, TopoosException {
		return GetLastUser(userID, AccessTokenOAuth.GetAccessToken(context));

	}

	public static List<Position> GetBetweenDays(Context context, Date initDate,
			Date endDate) throws IOException, TopoosException {
		return GetBetweenDays(initDate, endDate, AccessTokenOAuth.GetAccessToken(context));
	}

}
