package br.com.cubotecnologia.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author william.s.soares
 * 
 *         Class to support work with maps
 *
 */
public class DateUtil {

	/**
	 * Constant represents pattern of Brazil DateTime
	 */
	private static final String DATE_PATTERN_BR = "dd/MM/yyyy HH:mm:ss";

	/**
	 * Constant represents pattern of Brazil language
	 */
	private static final String LOCALE_LANGUAGE_PATTERN_BR = "pt";

	/**
	 * Constant represents pattern of Brazil Country
	 */
	private static final String LOCALE_COUNTRY_PATTERN_BR = "BR";

	/**
	 * Constant represents Time in Seconds
	 */
	public static final String SECONDS = "SS";

	/**
	 * Constant represents Time in Minutes
	 */
	public static final String MINUTES = "MM";

	/**
	 * Constant represents Time in Hours
	 */
	public static final String HOURS = "HH";

	/**
	 * Constant represents Time in Days
	 */
	public static final String DAYS = "DD";

	/**
	 * Method to return a Date object from a String Date
	 * 
	 * @param sDateTime
	 *            String represents DateTime to convert
	 * @return Date object
	 * @throws ParseException
	 *             Exception to parse String to Date
	 */
	public static Date getDateFromString(String sDateTime) throws ParseException {
		DateFormat formatter = getDateFormat();
		return formatter.parse(sDateTime);
	}

	/**
	 * Method to return SimpleDateFormat object
	 * 
	 * @return SimpleDateFormat object
	 */
	public static SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat(DATE_PATTERN_BR, new Locale(LOCALE_LANGUAGE_PATTERN_BR, LOCALE_COUNTRY_PATTERN_BR));
	}

	/**
	 * Method to return difference between two dates
	 * 
	 * @param date1
	 *            Date object
	 * @param date2
	 *            Date object
	 * @param unity
	 *            Time unity to return
	 * @return Difference between two dates in Time unity choosed
	 */
	public static long dateDiff(final Date date1, final Date date2, String unity) {
		long diff = date2.getTime() - date1.getTime();

		switch (unity.toUpperCase()) {
		case SECONDS:
			diff = diff / 1000 % 60;
			break;

		case MINUTES:
			diff = diff / (60 * 1000) % 60;
			break;

		case HOURS:
			diff = diff / (60 * 60 * 1000) % 24;
			break;

		case DAYS:
			diff = diff / (24 * 60 * 60 * 1000);
			break;
		}

		return diff;
	}
}
