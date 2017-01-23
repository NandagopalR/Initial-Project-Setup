package com.food.utils;

import com.food.app.AppConstants;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by nandagopal on 1/23/17.
 */
public class DateTimeUtils {

  public static final String TAG = LoggerUtils.makeLogTag(DateTimeUtils.class);

  private static final Calendar localTimeZoneCalendar = Calendar.getInstance();
  private static final SimpleDateFormat dateTimeformatter =
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ");
  private static final SimpleDateFormat DISPLAY_DATE_TIME_FORMATTER =
      new SimpleDateFormat("MM/dd/yy , hh:mm a");

  public static String dateAndTimeDifference(Date inputDate) {
    if (inputDate == null) {
      return null;
    }
    StringBuilder mBuffer = new StringBuilder();
    try {
      DateTime startTime = new DateTime(inputDate);
      DateTime endTime = new DateTime(new Date());
      int years = Years.yearsBetween(startTime, endTime).getYears();
      int months = Months.monthsBetween(startTime, endTime).getMonths();
      int weeks = Weeks.weeksBetween(startTime, endTime).getWeeks();
      int days = Days.daysBetween(startTime, endTime).getDays();
      int hours = Hours.hoursBetween(startTime, endTime).getHours();
      int minutes = Minutes.minutesBetween(startTime, endTime).getMinutes();
      if (years > 0) {
        mBuffer.append(years);
        if (years > 1) {
          mBuffer.append(" years ago");
        } else {
          mBuffer.append(" year ago");
        }
      } else if (months > 0) {
        mBuffer.append(months);
        if (months > 1) {
          mBuffer.append(" months ago");
        } else {
          mBuffer.append(" month ago");
        }
      } else if (weeks > 0) {
        mBuffer.append(weeks);
        if (weeks > 1) {
          mBuffer.append(" weeks ago");
        } else {
          mBuffer.append(" week ago");
        }
      } else if (days > 0) {
        mBuffer.append(days);
        if (days > 1) {
          mBuffer.append(" days ago");
        } else {
          mBuffer.append(" day ago");
        }
      } else if (hours > 0) {
        mBuffer.append(hours);
        if (hours > 1) {
          mBuffer.append(" hours ago");
        } else {
          mBuffer.append(" hour ago");
        }
      } else {
        if (minutes > 3) {
          mBuffer.append(minutes).append(" minutes ago");
        } else {
          mBuffer.append("Just now");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mBuffer.toString();
  }

  public static String getDisplayDate(String input) {
    if (input == null) return "";
    DateTime dateTime = DateTime.parse(input);
    DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yy");
    return fmt.print(dateTime);
  }

  public static String getDisplayMonth(Date input) {
    if (input == null) return "";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy");
    simpleDateFormat.setTimeZone(AppConstants.USER_PROFILE_TIMEZONE);
    return simpleDateFormat.format(input);
  }

  public static String getDisplayDate(Date input) {
    if (input == null) return "";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");
    simpleDateFormat.setTimeZone(AppConstants.USER_PROFILE_TIMEZONE);
    return simpleDateFormat.format(input);
  }

  public static String getStringFromDate(Date input) {
    if (input == null) return "";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    simpleDateFormat.setTimeZone(AppConstants.USER_PROFILE_TIMEZONE);
    return simpleDateFormat.format(input);
  }

  public static String getDisplayDateWithTime(String input) {
    if (input == null) return "";
    return getDisplayDateWithTime(DateTime.parse(input).toDate());
  }

  public static String getDisplayDayOfMonth(Date date) {
    if (date == null) return null;

    SimpleDateFormat outFormat = new SimpleDateFormat("dd");
    outFormat.setTimeZone(AppConstants.USER_PROFILE_TIMEZONE);
    return outFormat.format(date);
  }

  public static String getDisplayTime(Date date) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
    simpleDateFormat.setTimeZone(AppConstants.USER_PROFILE_TIMEZONE);
    return simpleDateFormat.format(date);
  }

  public static String getDisplayDateWithTime(Date date) {
    if (date == null) {
      return null;
    }
    DISPLAY_DATE_TIME_FORMATTER.setTimeZone(AppConstants.USER_PROFILE_TIMEZONE);
    return DISPLAY_DATE_TIME_FORMATTER.format(date);
  }

  public static Date getTomorrowsDate() {
    Calendar calendar = Calendar.getInstance();
    calendar.roll(Calendar.DATE, true);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DATE), 0, 0, 0);
    return calendar.getTime();
  }

  public static Date getDayStartDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DATE), 0, 0, 0);
    return calendar.getTime();
  }

  public static Date getDayEndDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DATE), 23, 59, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }

  public static Date getDateFromDateTime(Date dateTime) {
    if (dateTime == null) {
      return null;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    Calendar date = Calendar.getInstance();
    date.clear();
    date.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
    date.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
    date.set(Calendar.DATE, calendar.get(Calendar.DATE));
    return date.getTime();
  }

  public static Date getTimeFromDateTime(Date dateTime) {
    if (dateTime == null) {
      return null;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    Calendar time = Calendar.getInstance();
    time.clear();
    time.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
    time.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
    time.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
    time.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND));
    return time.getTime();
  }

  public static Date getDurationAddedDate(Date dateTime, int hour, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    calendar.add(Calendar.HOUR, hour);
    calendar.add(Calendar.MINUTE, minute);

    return calendar.getTime();
  }

  public static Date getDurationAddedDate(Date dateTime, double hoursAndMinutes) {
    int[] hoursAndMins = convertDoubleToHoursAndMin(hoursAndMinutes);
    return getDurationAddedDate(dateTime, hoursAndMins[0], hoursAndMins[1]);
  }

  public static Date getDurationSubtractedDate(Date dateTime, int hour, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    calendar.add(Calendar.HOUR, -hour);
    calendar.add(Calendar.MINUTE, -minute);

    return calendar.getTime();
  }

  public static Date getDurationSubtractedDate(Date dateTime, double hoursAndMinutes) {
    int[] hoursAndMins = convertDoubleToHoursAndMin(hoursAndMinutes);
    return getDurationSubtractedDate(dateTime, hoursAndMins[0], hoursAndMins[1]);
  }

  public static String getStringTimeDiffInHoursAndMin(Date startDateTime, Date finishDateTime,
      String divider) {
    long diffInMilliseconds = finishDateTime.getTime() - startDateTime.getTime();
    long minutes = TimeUnit.MILLISECONDS.toMinutes(diffInMilliseconds);
    long hours = minutes / 60;
    long remainingMinutes = minutes % 60;
    return formatHoursAndMinutes((int) hours, (int) remainingMinutes, divider);
  }

  public static double getTimeDiffBetweenDate(Date startDateTime, Date finishDateTime) {
    long diffInMilliseconds = finishDateTime.getTime() - startDateTime.getTime();
    return TimeUnit.MILLISECONDS.toMinutes(diffInMilliseconds) / 60.0;
  }

  public static long getTimeDiffInSeconds(Date startDateTime, Date finishDateTime) {
    long diffInMilliseconds = finishDateTime.getTime() - startDateTime.getTime();
    return TimeUnit.MILLISECONDS.toSeconds(diffInMilliseconds);
  }

  public static Date createDateObject(int year, int monthOfYear, int dayOfMonth) {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, monthOfYear);
    calendar.set(Calendar.DATE, dayOfMonth);
    return calendar.getTime();
  }

  public static Date createDateObject(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTime();
  }

  public static Date combineDateAndTime(Date date, Date time) {
    if (date == null && time == null) {
      return null;
    } else if (date == null) {
      return time;
    } else if (time == null) {
      return date;
    } else {
      Calendar dateTime = Calendar.getInstance();
      Calendar date1 = Calendar.getInstance();
      date1.setTime(date);
      Calendar time1 = Calendar.getInstance();
      time1.setTime(time);
      dateTime.set(date1.get(Calendar.YEAR), date1.get(Calendar.MONTH), date1.get(Calendar.DATE),
          time1.get(Calendar.HOUR_OF_DAY), time1.get(Calendar.MINUTE), time1.get(Calendar.SECOND));
      dateTime.set(Calendar.MILLISECOND, time1.get(Calendar.MILLISECOND));
      return dateTime.getTime();
    }
  }

  public static String convertMinutesToHoursAndMinutes(int totalMinutes, String divider) {
    int hours = totalMinutes / 60;
    int minutes = totalMinutes - (hours * 60);
    return formatHoursAndMinutes(hours, minutes, divider);
  }

  private static String formatHoursAndMinutes(int hours, int minutes, String divider) {
    return String.format(Locale.getDefault(), "%d%s%02d", hours, divider, minutes);
  }

  public static String convertFloatingTimeToHoursAndMin(double time, String divider) {
    int[] hoursAndMins = convertDoubleToHoursAndMin(time);
    return formatHoursAndMinutes(hoursAndMins[0], hoursAndMins[1], divider);
  }

  private static int[] convertDoubleToHoursAndMin(double time) {
    int hours = (int) time;
    return new int[] { hours, (int) (60 * (time - hours)) };
  }

  public static int convertDoubleToMin(double time, boolean doRoundOff) {
    int hours = (int) time;
    double totalMinutes = (60 * (time - hours)) + (60 * hours);
    return (int) (doRoundOff ? Math.round(totalMinutes) : totalMinutes);
  }

  public static double convertHoursAndMinutesInDouble(int hours, int minutes) {
    int totalMinutes = (hours * 60) + minutes;
    return totalMinutes / 60.0;
  }

  public static Date getGreatestDate(Date date1, Date date2) {
    if (date1 == null && date2 == null) return null;
    if (date1 == null) return date2;
    if (date2 == null) return date1;
    return date1.getTime() > date2.getTime() ? date1 : date2;
  }

  public static void changeParserTimeZone(TimeZone usrTz) {
    localTimeZoneCalendar.setTimeZone(usrTz);
  }

  public static double getAfterDecimalValue(double input) {
    input = Double.parseDouble(new DecimalFormat("##.##").format(input));
    return input;
  }

  public static int compareDateForDescendingOrder(Date lhs, Date rhs) {
    if (lhs == null && rhs == null) {
      return 0;
    } else if (lhs == null || rhs == null) {
      if (lhs == null) {
        return 1;
      } else {
        return -1;
      }
    } else {
      return rhs.compareTo(lhs);
    }
  }

  public static int compareDateForAscendingOrder(Date lhs, Date rhs) {
    if (lhs == null && rhs == null) {
      return 0;
    } else if (lhs == null || rhs == null) {
      if (lhs == null) {
        return -1;
      } else {
        return 1;
      }
    } else {
      return lhs.compareTo(rhs);
    }
  }

  public static boolean isToday(Date date) {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
    calendar.setTime(date);
    return year == calendar.get(Calendar.YEAR) && dayOfYear == calendar.get(Calendar.DAY_OF_YEAR);
  }

  public static String convertToString(Date date) {
    if (date == null) {
      return null;
    }
    return dateTimeformatter.format(date);
  }

  public static Date convertToDate(String date) {
    if (date == null) {
      return null;
    }
    try {
      return dateTimeformatter.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
}
