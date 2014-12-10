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

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The Class PositionKML.
 *
 * @see APICallResult
 * @author topoos
 */
public class PositionKML extends APICallResult {

	/** The timestamp. */
	Date timestamp = null;
	
	/** The name. */
	String name = null;
	
	/** The description. */
	String description = null;
	
	/** The point. */
	Point point = null;
	
	/** The extended data. */
	ExtendedData extendedData = null;

	/**
	 * Instantiates a new position kml.
	 *
	 * @param error the error
	 * @param result the result
	 * @param timestamp the timestamp
	 * @param name the name
	 * @param description the description
	 * @param point the point
	 * @param extendedData the extended data
	 */
	public PositionKML(String error, String result, Date timestamp,
			String name, String description, Point point,
			ExtendedData extendedData) {
		super(error, result);
		this.timestamp = timestamp;
		this.name = name;
		this.description = description;
		this.point = point;
		this.extendedData = extendedData;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		/* Get a SAXParser from the SAXPArserFactory. */
		if (this.Result != null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			try {
				db = dbf.newDocumentBuilder();
				Document doc = db.parse(this.Result);
				NodeList nodelist = doc.getElementsByTagName("Placemark");
				if (nodelist != null) {
					Node node = nodelist.item(0);
					NodeList childnodes = node.getChildNodes();
					for (int i = 0; i < childnodes.getLength(); i++) {
						if (childnodes.item(i).getNodeName().toLowerCase()
								.equals("TimeStamp".toLowerCase())) {
							this.timestamp = APIUtils.toDateString(childnodes
									.item(i).getFirstChild().getNodeValue());
						} else if (childnodes.item(i).getNodeName()
								.toLowerCase().equals("name".toLowerCase())) {
							this.name = childnodes.item(i).getNodeValue();
						} else if (childnodes.item(i).getNodeName()
								.toLowerCase()
								.equals("description".toLowerCase())) {
							this.description = childnodes.item(i)
									.getNodeValue();
						} else if (childnodes.item(i).getNodeName()
								.toLowerCase().equals("Point".toLowerCase())) {
							String value = childnodes.item(i).getFirstChild()
									.getNodeValue();
							String[] values = value.split(",");
							this.point = new Point(Double.valueOf(values[0]),
									Double.valueOf(values[1]), 4);
						} else if (childnodes.item(i).getNodeName()
								.toLowerCase()
								.equals("ExtendedData".toLowerCase())) {
							NodeList childnodes2 = childnodes.item(i)
									.getChildNodes();
							String id = null;
							String device = null;
							Date registerTime = null;
							Double accuracy = null;
							PositionType positionType = null;
							Double elevation = null;
							Double vaccuracy = null;
							Double bearing = null;
							Double velocity = null;
							for (int j = 0; j < childnodes2.getLength(); j++) {
								if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("id".toLowerCase())) {
									id = childnodes.item(j).getNodeValue();
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("device".toLowerCase())) {
									device = childnodes.item(j).getNodeValue();
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("RegisterTime".toLowerCase())) {
									registerTime = APIUtils
											.toDateString(childnodes.item(j)
													.getNodeValue());
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("Accuracy".toLowerCase())) {
									accuracy = Double.valueOf(childnodes
											.item(j).getNodeValue());
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("PositionType".toLowerCase())) {
									NodeList childnodes3 = childnodes.item(j)
											.getChildNodes();
									String idtype = null;
									String destype = null;
									for (int k = 0; k < childnodes3.getLength(); k++) {
										if (childnodes.item(k).getNodeName()
												.toLowerCase()
												.equals("id".toLowerCase())) {
											idtype = childnodes.item(k)
													.getNodeValue();
										} else if (childnodes
												.item(k)
												.getNodeName()
												.toLowerCase()
												.equals("description"
														.toLowerCase())) {
											destype = childnodes.item(k)
													.getNodeValue();
										}
									}
									positionType = new PositionType(idtype,
											destype);
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("elevation".toLowerCase())) {
									elevation = Double.valueOf(childnodes.item(
											j).getNodeValue());
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("Vaccuracy".toLowerCase())) {
									vaccuracy = Double.valueOf(childnodes.item(
											j).getNodeValue());
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("Bearing".toLowerCase())) {
									bearing = Double.valueOf(childnodes.item(j)
											.getNodeValue());
								} else if (childnodes.item(j).getNodeName()
										.toLowerCase()
										.equals("Velocity".toLowerCase())) {
									velocity = Double.valueOf(childnodes
											.item(j).getNodeValue());
								}
							}
							this.extendedData = new ExtendedData(id, device,
									registerTime, accuracy, positionType,
									elevation, vaccuracy, bearing, velocity);
						}
					}
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * Sets the point.
	 *
	 * @param point the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * Gets the extended data.
	 *
	 * @return the extendedData
	 */
	public ExtendedData getExtendedData() {
		return extendedData;
	}

	/**
	 * Sets the extended data.
	 *
	 * @param extendedData the extendedData to set
	 */
	public void setExtendedData(ExtendedData extendedData) {
		this.extendedData = extendedData;
	}

	/**
	 * The Class ExtendedData.
	 */
	public class ExtendedData {
		
		/** The id. */
		String id = null;
		
		/** The device. */
		String device = null;
		
		/** The register time. */
		Date registerTime = null;
		
		/** The accuracy. */
		Double accuracy = null;
		
		/** The position type. */
		PositionType positionType = null;
		
		/** The elevation. */
		Double elevation = null;
		
		/** The vaccuracy. */
		Double vaccuracy = null;
		
		/** The bearing. */
		Double bearing = null;
		
		/** The velocity. */
		Double velocity = null;

		/**
		 * Instantiates a new extended data.
		 *
		 * @param id the id
		 * @param device the device
		 * @param registerTime the register time
		 * @param accuracy the accuracy
		 * @param positionType the position type
		 * @param elevation the elevation
		 * @param vaccuracy the vaccuracy
		 * @param bearing the bearing
		 * @param velocity the velocity
		 */
		public ExtendedData(String id, String device, Date registerTime,
				Double accuracy, PositionType positionType, Double elevation,
				Double vaccuracy, Double bearing, Double velocity) {
			super();
			this.id = id;
			this.device = device;
			this.registerTime = registerTime;
			this.accuracy = accuracy;
			this.positionType = positionType;
			this.elevation = elevation;
			this.vaccuracy = vaccuracy;
			this.bearing = bearing;
			this.velocity = velocity;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Gets the device.
		 *
		 * @return the device
		 */
		public String getDevice() {
			return device;
		}

		/**
		 * Sets the device.
		 *
		 * @param device the device to set
		 */
		public void setDevice(String device) {
			this.device = device;
		}

		/**
		 * Gets the register time.
		 *
		 * @return the registerTime
		 */
		public Date getRegisterTime() {
			return registerTime;
		}

		/**
		 * Sets the register time.
		 *
		 * @param registerTime the registerTime to set
		 */
		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
		}

		/**
		 * Gets the accuracy.
		 *
		 * @return the accuracy
		 */
		public Double getAccuracy() {
			return accuracy;
		}

		/**
		 * Sets the accuracy.
		 *
		 * @param accuracy the accuracy to set
		 */
		public void setAccuracy(Double accuracy) {
			this.accuracy = accuracy;
		}

		/**
		 * Gets the position type.
		 *
		 * @return the positionType
		 */
		public PositionType getPositionType() {
			return positionType;
		}

		/**
		 * Sets the position type.
		 *
		 * @param positionType the positionType to set
		 */
		public void setPositionType(PositionType positionType) {
			this.positionType = positionType;
		}

		/**
		 * Gets the elevation.
		 *
		 * @return the elevation
		 */
		public Double getElevation() {
			return elevation;
		}

		/**
		 * Sets the elevation.
		 *
		 * @param elevation the elevation to set
		 */
		public void setElevation(Double elevation) {
			this.elevation = elevation;
		}

		/**
		 * Gets the vaccuracy.
		 *
		 * @return the vaccuracy
		 */
		public Double getVaccuracy() {
			return vaccuracy;
		}

		/**
		 * Sets the vaccuracy.
		 *
		 * @param vaccuracy the vaccuracy to set
		 */
		public void setVaccuracy(Double vaccuracy) {
			this.vaccuracy = vaccuracy;
		}

		/**
		 * Gets the bearing.
		 *
		 * @return the bearing
		 */
		public Double getBearing() {
			return bearing;
		}

		/**
		 * Sets the bearing.
		 *
		 * @param bearing the bearing to set
		 */
		public void setBearing(Double bearing) {
			this.bearing = bearing;
		}

		/**
		 * Gets the velocity.
		 *
		 * @return the velocity
		 */
		public Double getVelocity() {
			return velocity;
		}

		/**
		 * Sets the velocity.
		 *
		 * @param velocity the velocity to set
		 */
		public void setVelocity(Double velocity) {
			this.velocity = velocity;
		}

	}

	/**
	 * The Class Point.
	 */
	public class Point {
		
		/** The latitude. */
		Double latitude = null;
		
		/** The longitude. */
		Double longitude = null;
		
		/** The value. */
		Integer value = 4;

		/**
		 * Instantiates a new point.
		 *
		 * @param latitude the latitude
		 * @param longitude the longitude
		 * @param value the value
		 */
		public Point(Double latitude, Double longitude, Integer value) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
			this.value = value;
		}

		/**
		 * Gets the latitude.
		 *
		 * @return the latitude
		 */
		public Double getLatitude() {
			return latitude;
		}

		/**
		 * Sets the latitude.
		 *
		 * @param latitude the latitude to set
		 */
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		/**
		 * Gets the longitude.
		 *
		 * @return the longitude
		 */
		public Double getLongitude() {
			return longitude;
		}

		/**
		 * Sets the longitude.
		 *
		 * @param longitude the longitude to set
		 */
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public Integer getValue() {
			return value;
		}

		/**
		 * Sets the value.
		 *
		 * @param value the value to set
		 */
		public void setValue(Integer value) {
			this.value = value;
		}

	}

	/**
	 * The Class PositionType.
	 */
	public class PositionType {
		
		/** The id. */
		String id = null;
		
		/** The description. */
		String description = null;

		/**
		 * Instantiates a new position type.
		 *
		 * @param id the id
		 * @param description the description
		 */
		public PositionType(String id, String description) {
			super();
			this.id = id;
			this.description = description;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Gets the description.
		 *
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the description.
		 *
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

	}
}
