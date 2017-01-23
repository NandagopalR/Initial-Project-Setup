package com.food.utils;

import android.util.Base64;

/**
 * Created by nandagopal on 1/23/17.
 */
public class SecurityUtils {

  public static String getBase64EncodeData(byte[] data) {
    return Base64.encodeToString(data, Base64.NO_WRAP);
  }

  public static String convertToBase64(byte[] attachment) {
    return SecurityUtils.getBase64EncodeData(attachment);
  }
}
