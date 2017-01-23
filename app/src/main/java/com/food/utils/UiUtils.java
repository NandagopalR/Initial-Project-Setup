package com.food.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nandagopal on 1/23/17.
 */
public class UiUtils {

  public static void showSnackBar(View view, String message, int length) {
    Snackbar snackbar = Snackbar.make(view, message, length);
    View v = snackbar.getView();
    TextView textView = (TextView) v.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(Color.WHITE);
    textView.setMaxLines(4);
    snackbar.show();
  }

  public static void showSnackBarWithAction(View view, int messageResId, int length,
      int actionResId, View.OnClickListener actionClickListener) {
    Snackbar snackbar = Snackbar.make(view, messageResId, length);
    View v = snackbar.getView();
    TextView textView = (TextView) v.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(Color.WHITE);
    textView.setMaxLines(4);
    snackbar.setAction(actionResId, actionClickListener);
    snackbar.show();
  }

  public static void showSnackBarWithAction(View view, String message, int length, String action,
      View.OnClickListener actionClickListener) {
    Snackbar snackbar = Snackbar.make(view, message, length);
    View v = snackbar.getView();
    TextView textView = (TextView) v.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(Color.WHITE);
    textView.setMaxLines(4);
    snackbar.setAction(action, actionClickListener);
    snackbar.show();
  }

  public static void showSnackBar(View view, int message, int length) {
    Snackbar snackbar = Snackbar.make(view, message, length);
    View v = snackbar.getView();
    TextView textView = (TextView) v.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(Color.WHITE);
    textView.setMaxLines(4);
    snackbar.show();
  }

  public static void showToast(AppCompatActivity mActivity, String message) {
    Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
  }

  public static void showToast(Context context, String message) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
  }

  public static AlertDialog createAlertDialogWithTwoButtons(Context context, String title,
      String message, String buttonFirstText, String buttonSecondText,
      DialogInterface.OnClickListener firstListener,
      DialogInterface.OnClickListener secondListener) {
    AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title)
        .setMessage(message)
        .setPositiveButton(buttonFirstText, firstListener)
        .setNegativeButton(buttonSecondText, secondListener)
        .create();
    if (TextUtils.isEmpty(title)) {
      alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    return alertDialog;
  }

  public static AlertDialog createAlertDialog(Context context, String title, String message,
      String buttonText, DialogInterface.OnClickListener onClickListener) {
    AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title)
        .setMessage(message)
        .setCancelable(true)
        .setPositiveButton(buttonText, onClickListener)
        .create();
    if (TextUtils.isEmpty(title)) {
      alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    return alertDialog;
  }
}
