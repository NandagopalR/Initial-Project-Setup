package com.food.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * Created by nandagopal on 1/23/17.
 */
public class TextUtils {

  public static boolean isEmpty(String str) {
    return str == null || str.trim().length() == 0;
  }

  public static boolean isEmpty(CharSequence str) {
    return str == null || str.toString().trim().isEmpty();
  }

  /**
   * this will prettify the input string.
   * If the string is null then it will return empty string else It will trim the string and return
   * it.
   *
   * @param str string to be prettified for display.
   * @return If the string is null then it will return empty string else It will trim the string and
   * return it.
   */
  public static String displayPretty(String str) {
    return str == null ? "" : str.trim();
  }

  public static String combineStrings(List<String> strings, String combiningCharacter) {
    if (strings == null || strings.isEmpty()) {
      return "";
    }
    StringBuilder queryBuilder = new StringBuilder(strings.get(0));
    for (int i = 1, stringsSize = strings.size(); i < stringsSize; i++) {
      String s = strings.get(i);
      queryBuilder.append(combiningCharacter).append(s);
    }

    return queryBuilder.toString();
  }

  public static String getBase64EncodeData(String input) throws UnsupportedEncodingException {
    byte[] data = input.getBytes("UTF-8");
    return Base64.encodeToString(data, Base64.NO_WRAP);
  }

  public static int compareStringsForDescendingOrder(String str1, String str2) {
    if (str1 == null && str2 == null) {
      return 0;
    } else if (str1 == null || str2 == null) {
      if (str1 == null) {
        return 1;
      } else {
        return -1;
      }
    } else {
      return str1.compareTo(str2);
    }
  }

  public static String generateUniqueClientId() {
    return UUID.randomUUID().toString();
  }
}
