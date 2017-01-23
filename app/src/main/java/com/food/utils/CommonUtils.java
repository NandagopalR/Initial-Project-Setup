package com.food.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.InputFilter;
import com.food.app.AppConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.TimeZone;

public class CommonUtils {

  public static InputFilter EMOJI_FILTER = (source, start, end, dest, dstart, dend) -> {
    for (int index = start; index < end; index++) {

      int type = Character.getType(source.charAt(index));

      if (type == Character.SURROGATE) {
        return "";
      }
    }
    return null;
  };

  public static void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
    Bitmap newBitmap =
        Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(newBitmap);
    canvas.drawColor(Color.WHITE);
    canvas.drawBitmap(bitmap, 0, 0, null);
    OutputStream stream = new FileOutputStream(photo);
    newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
    stream.close();
  }

  public static void restartActivity(Context context) {
    Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    context.startActivity(intent);
  }

  public static float dp2px(Resources resources, float dp) {
    final float scale = resources.getDisplayMetrics().density;
    return dp * scale + 0.5f;
  }

  public static float sp2px(Resources resources, float sp) {
    final float scale = resources.getDisplayMetrics().scaledDensity;
    return sp * scale;
  }

  public static boolean isAvailable(Context ctx, Intent intent) {
    final PackageManager mgr = ctx.getPackageManager();
    List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
    return list.size() > 0;
  }

  public static void changeApiRequestTimeZoneToUserProfileTimeZone(String userTimeZone) {
    if (TextUtils.isEmpty(userTimeZone)) {
      return;
    }
    TimeZone usrTz = TimeZone.getTimeZone(userTimeZone);
    AppConstants.changeApiRequestDateTimeFormatterTimeZone(usrTz);
    DateTimeUtils.changeParserTimeZone(usrTz);
    AppConstants.setUserProfileTimeZone(usrTz);
  }
}