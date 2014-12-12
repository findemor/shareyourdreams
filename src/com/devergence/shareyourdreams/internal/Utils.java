package com.devergence.shareyourdreams.internal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String getLegibleDate(Date date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM"); // "d MMM yyyy hh:mm aaa"
		String dateInit = simpleDateFormat.format(date);

		SimpleDateFormat hours24format = new SimpleDateFormat("kk");
		String timeDate = hours24format.format(date) + ":"
				+ String.format("%2s", date.getMinutes()).replace(' ', '0');

		return dateInit + " " + timeDate;
	}

}
