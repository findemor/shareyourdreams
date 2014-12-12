package com.devergence.shareyourdreams.topoos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.POI;
import topoos.Objects.POICategory;

public class AccessInterface {
	
	////Must get your tokens from topoos developer panel https://developers.topoos.com
	private static final String TOPOOS_ADMIN_APP_TOKEN = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	
	////We must use the integer id that we got when we registered this POI the first time (manually)
	private static final int PREREGISTERED_POI_FOR_COUNTERS = -1;


	public static final int SEARCH_RADIUS_METERS = 500000;
	
	/**
     * Prepare a valid AccessTokenOAuth
     */
    public static void initializeTopoosSession(Context ctx) {
    	AccessTokenOAuth token = topoos.AccessTokenOAuth.GetAccessToken(ctx);
    	if (token == null || !token.isValid())
    	{
    		token = new AccessTokenOAuth(TOPOOS_ADMIN_APP_TOKEN);
    		token.save_Token(ctx); //save on preferences
    	}
    }
    
    /**
     * Get POIs registered by any user near the specified location
     * 
     * @param ctx
     * @param location
     * @return
     * @throws IOException
     * @throws TopoosException
     */
    public static List<POI> GetUserDreamsNear(Context ctx, Location location) throws IOException, TopoosException
    {
    	Integer[] categories = new Integer[1];
		categories[0] = POICategories.USER;
    	
    	List<POI> pois = topoos.POI.Operations.GetNear(ctx, location.getLatitude(), location.getLongitude(), SEARCH_RADIUS_METERS, categories);
    	
    	return pois;
    }
    
    /**
     * Register a new user POI and updates the globals counters
     * @throws TopoosException 
     * @throws IOException 
     */
    public static int RegisterDream(Context ctx, int poiType, String description, Location location) throws IOException, TopoosException
    {
    	//Prepare the categories for the user new POI
		Integer[] categories = new Integer[2];
		categories[0] = poiType;
		categories[1] = POICategories.USER;
		
		//Register the user new POI
		POI newPoi = topoos.POI.Operations.Add(ctx, Integer.toString(poiType), location.getLatitude(), location.getLongitude(), categories, (double)0, (double)0, (double)0, description, null, null, null, null, null, null, null);
		
		//Use warning in the linked internal poi for global counters (trick!)
		if (poiType == POICategories.DREAM){
			IncreaseGlobalDreamCounter(ctx);
		}else if (poiType == POICategories.NIGHTMARE){
			IncreaseGlobalNightmareCounter(ctx);
		}
		
		return newPoi.getId();
    }
    
    
    private static void IncreaseGlobalDreamCounter(Context ctx) throws IOException, TopoosException
    {
    	//Trick: Use the warnings in a internal preregistered POI as global counter
    	topoos.POIWarning.Operations.AddClosed(ctx, PREREGISTERED_POI_FOR_COUNTERS);
    }
    

    private static void IncreaseGlobalNightmareCounter(Context ctx) throws IOException, TopoosException
    {
    	//Trick: Use the warnings in a internal preregistered POI as global counter
    	topoos.POIWarning.Operations.AddDuplicated(ctx, PREREGISTERED_POI_FOR_COUNTERS);
    }
    
    public static GlobalDreamCounters GetGlobalDreamCounters(Context ctx) throws IOException, TopoosException
    {
    	//Trick for global counters
    	topoos.Objects.POI p = topoos.POI.Operations.Get(ctx, PREREGISTERED_POI_FOR_COUNTERS);
    	
    	if (p != null){
    		return new GlobalDreamCounters(p.getWarningcount().getClosed(), p.getWarningcount().getDuplicated());
    	}else
    	{
    		return null;
    	}
    	
    }
    
    
    
    /**
     * Application context preregistration
     * @param ctx
     * @throws IOException
     * @throws TopoosException
     */
    public static void PreregisterApplicationNeccessaryItems(Context ctx) throws IOException, TopoosException
    {
    	int CategoryDreamID = topoos.POICategories.Operations.Add(ctx, "DREAM").getId();
    	int CategoryNightmareID = topoos.POICategories.Operations.Add(ctx, "NIGHTMARE").getId();
    	int CategorySystemID = topoos.POICategories.Operations.Add(ctx, "SYSTEM").getId();
    	int CategoryUserID = topoos.POICategories.Operations.Add(ctx, "USER").getId();
    	
    	Integer[] categories = new Integer[1];
		categories[0] = CategorySystemID;
    	
    	POI poi = topoos.POI.Operations.Add(ctx, "GlobalCounter", (double)0, (double)0, categories, (double)0, (double)0, (double)0, "GlobalCounter", null, null, null, null, null, null, null);
    	
    	
    	Log.i("POIS", "POI CATEGORY DREAM ID " + CategoryDreamID);
    	Log.i("POIS", "POI CATEGORY NIGHTMARE ID " + CategoryNightmareID);
    	Log.i("POIS", "POI CATEGORY SYSTEM ID " + CategorySystemID);
    	Log.i("POIS", "POI CATEGORY USER ID " + CategoryUserID);
        Log.i("POIS", "POI GLOBAL COUNTER ID " + poi.getId());
    }
    
    
    public static boolean IsDream(ArrayList<POICategory> poiCategories)
    {
    	try
    	{
    		if (poiCategories == null)
    		{
    			return false;
    		}else
    		{
    			for(POICategory c : poiCategories)
    			{
    				if (c.getId() == POICategories.DREAM)
    				{
    					return true;
    				}
    			}
    			return false;
    		}
    	}catch (Exception ex)
    	{
    		return false;
    	}
    }
    
}
