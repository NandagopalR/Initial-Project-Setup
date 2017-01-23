package com.food.app;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by nandagopal on 1/23/17.
 */
public class AppConstants {

  //-------------------------------------------- Date Formatter ------------------------------------------------//
  public static TimeZone USER_PROFILE_TIMEZONE;

  public static final SimpleDateFormat API_DATE_TIME_WITH_TIME_ZONE_STRING_FORMATTER =
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.ENGLISH);
  public static final SimpleDateFormat API_DATE_WITH_TIME_STRING_FORMATTER =
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
  public static final SimpleDateFormat API_DATE_STRING_FORMATTER =
      new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
  public static final SimpleDateFormat API_TIME_STRING_FORMATTER =
      new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);

  public static void changeApiRequestDateTimeFormatterTimeZone(TimeZone timeZone) {
    API_DATE_STRING_FORMATTER.setTimeZone(timeZone);
    API_TIME_STRING_FORMATTER.setTimeZone(timeZone);
    API_DATE_WITH_TIME_STRING_FORMATTER.setTimeZone(timeZone);
  }

  public static void setUserProfileTimeZone(TimeZone userProfileTimeZone) {
    AppConstants.USER_PROFILE_TIMEZONE = userProfileTimeZone;
  }
}
