package com.michel.plannings.constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constants {

	public static final int DELAY_MIN = 5;
	public static final int PROLONGEMENT_WEEK = 4;
	public static final int PROLONGEMENT_MIN = 4;

	public final static String YOUR_SECRET = "secret";
	public final static String USER_ID = "userId";
	public final static String ROLE = "role";
	public final static String AUTHORIZATION_HEADER = "Authorization";
	public final static String BEARER_TOKEN = "Bearer ";

	public static LocalDateTime formatStringToDate(String dateString) {

		LocalDateTime date = LocalDateTime.parse(dateString + " " + "00:00:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		return date;
	}

}
