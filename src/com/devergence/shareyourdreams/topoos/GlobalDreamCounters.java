package com.devergence.shareyourdreams.topoos;

public class GlobalDreamCounters {
	
	private int mDreams;
	private int mNightmares;
	
	public GlobalDreamCounters(int dreams, int nightmares)
	{
		mDreams = dreams;
		mNightmares = nightmares;
	}
	
	public int getDreamGlobalCounter()
	{
		return mDreams;
	}
	
	public int getNightmareGlobalCounter()
	{
		return mNightmares;
	}
}
