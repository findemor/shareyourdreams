package com.devergence.shareyourdreams.internal;

import java.util.Date;

public class Dream {

	private int PoiId;
	private int Type;
	private String Desc;
	private Date DateRegister;
	
	public Dream(int poi_id, int type, String desc, Date date)
	{
		PoiId = poi_id;
		Type = type;
		Desc = desc;
		DateRegister = date;
	}
	
	public int getPoiId()
	{
		return PoiId;
	}
	
	public int getType()
	{
		return Type;
	}
	
	public String getDescription()
	{
		return Desc;
	}
	
	public Date getDate()
	{
		return DateRegister;
	}
}
