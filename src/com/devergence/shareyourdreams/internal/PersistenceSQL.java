package com.devergence.shareyourdreams.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PersistenceSQL {

	private static final String DBNAME = "DBDreams";
	
	private static int CURRENT_BBDD_VERSION = 1;

	
	public static int getDreamsCounter(Context context, int type) {

		int retorno = -1;

		try {
			PersistenceSQLiteHelper usdbh = new PersistenceSQLiteHelper(
					context, DBNAME, null, CURRENT_BBDD_VERSION);

			SQLiteDatabase db = usdbh.getReadableDatabase();

			if (db != null) {
				
				Cursor c= db.rawQuery("select count(*) from Poi where type="+ type, null);

				try {
					c.moveToFirst();
					retorno = c.getInt(0);
					c.close();
				} catch (Exception e) {
					Log.e("SQL", e.getMessage());
				} finally {
					c.close();
				}

				db.close();
			}

			return retorno;
		} catch (Exception ex) {
			return -1;
		}
	}
	

	/**
	 * Get all Dreams in Database ordered by date desc
	 * @param context
	 * @return
	 */
	public static ArrayList<Dream> obtainDreams(Context context) {

		ArrayList<Dream> dreams = new ArrayList<Dream>();

		try {
			PersistenceSQLiteHelper usdbh = new PersistenceSQLiteHelper(
					context, DBNAME, null, CURRENT_BBDD_VERSION);

			SQLiteDatabase db = usdbh.getReadableDatabase();

			if (db != null) {
				Cursor c = db.query("Poi", new String[] { "id", "type",
						"desc", "date" }, null,
						null, null, null, "date DESC");

				try {
					c.moveToFirst();
					while (c.isAfterLast() == false) {

						try {
							Dream d = new Dream(c.getInt(0), c.getInt(1), c.getString(2), getDatetimeSQLiteToDate(c.getString(3)));
							dreams.add(d);

						} catch (Exception e) {
							Log.e("SQL", e.getMessage());
						}

						c.moveToNext();
					}
				} catch (Exception e) {
					Log.e("SQL", e.getMessage());
				} finally {
					c.close();
				}

				db.close();
			}

			return dreams;
		} catch (Exception ex) {
			return null;
		}
	}


	

	/**
	 * Insert a new Dream in Database
	 * @param context
	 * @param poi_id
	 * @param description
	 * @param date
	 * @param type
	 */
	public static void insertDream(Context context, Dream d) {

		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		PersistenceSQLiteHelper usdbh = new PersistenceSQLiteHelper(context,
				DBNAME, null, CURRENT_BBDD_VERSION);

		SQLiteDatabase db = usdbh.getWritableDatabase();

		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			db.beginTransaction();
			try {
					ContentValues cv = new ContentValues();

					cv.put("id", d.getPoiId());
					cv.put("type", d.getType());
					cv.put("desc", d.getDescription());
					cv.put("date", getDatetimeSQLiteFormat(d.getDate()));
					
					db.insert("Poi", null, cv);

					db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}

			// Cerramos la base de datos
			db.close();
		}
	}
	
	
	/**
	 * Return "YYYY-MM-DD HH:MM:SS.SSS"
	 * 
	 * @param cal
	 * @return
	 */
	private static String getDatetimeSQLiteFormat(Date cal) {

		// http://sqlite.org/datatype3.html
		// http://www.perturb.org/display/entry/629/
		return String.format("%4s", cal.getYear() + 1900).replace(' ', '0')
				+ "-"
				+ String.format("%2s", cal.getMonth() + 1).replace(' ',
						'0')
				+ "-"
				+ String.format("%2s", cal.getDate()).replace(
						' ', '0')
				+ " "
				+ String.format("%2s", cal.getHours()).replace(
						' ', '0')
				+ ":"
				+ String.format("%2s", cal.getMinutes()).replace(' ',
						'0')
				+ ":"
				+ String.format("%2s", cal.getSeconds()).replace(' ',
						'0')
				+ "."
				+ String.format("%3s", 0)
						.replace(' ', '3').substring(3);

	}

	private static Date getDatetimeSQLiteToDate(String strCal) {

		Date cal = null;

		try {
			// String str_date = "11-June-07";
			DateFormat formatter;
			// formatter = new SimpleDateFormat("dd-MMM-yy");
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.");// SSS");
			cal = (Date) formatter.parse(strCal);
			
			// System.out.println("Today is " + date);
		} catch (Exception e) {
			Log.e("SQL", e.getMessage());
		}

		return cal;

	}

}
