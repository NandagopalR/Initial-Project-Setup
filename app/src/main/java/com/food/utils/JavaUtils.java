package com.food.utils;

import android.support.annotation.Nullable;
import java.util.List;

import static java.lang.Double.parseDouble;

/**
 * Created by nandagopal on 1/23/17.
 */
public class JavaUtils {

  public static Long[] convertListToArray(List<Long> longs) {
    return longs.toArray(new Long[0]);
  }

  public static boolean isValidDouble(String stringDouble) {
    if (stringDouble == null || stringDouble.isEmpty()) {
      return false;
    }
    try {
      parseDouble(stringDouble);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  @Nullable public static Double safeCastToDouble(String stringDouble) {
    if (stringDouble == null || stringDouble.isEmpty()) {
      return null;
    }
    try {
      return parseDouble(stringDouble);
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
