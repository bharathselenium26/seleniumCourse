package com.slokam.videoblog.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutomationUtils {
	public static String getTimestamp() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		return timeStamp;
	}
}
