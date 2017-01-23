package com.food.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.food.utils.LoggerUtils;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
  private static final String TAG = LoggerUtils.makeLogTag(BaseActivity.class);

  @Override protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
  }

  @Override public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  public void setHeaderTitle(String title) {
    if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
  }

  public void showBackButton(boolean status) {
    if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(status);
  }

  public void hideSoftInput() {
    try {
      InputMethodManager manager =
          (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
      manager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
    } catch (NullPointerException e) {
      LoggerUtils.e(TAG, "Exception in hideSoftInput", e);
    }
  }

  public Fragment getVisibleFragment() {
    FragmentManager fragmentManager = getSupportFragmentManager();
    List<Fragment> fragments = fragmentManager.getFragments();
    if (fragments != null) {
      for (Fragment fragment : fragments) {
        if (fragment != null && fragment.isVisible()) return fragment;
      }
    }
    return null;
  }

  @Override public boolean dispatchTouchEvent(MotionEvent event) {
    boolean userEvent = false;
    try {
      View v = getCurrentFocus();
      userEvent = super.dispatchTouchEvent(event);
      if (v instanceof EditText) {
        View w = getCurrentFocus();
        int scr[] = new int[2];
        if (w != null) {
          w.getLocationOnScreen(scr);
        }
        assert w != null;
        float x = event.getRawX() + w.getLeft() - scr[0];
        float y = event.getRawY() + w.getTop() - scr[1];
        if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft()
            || x >= w.getRight()
            || y < w.getTop()
            || y > w.getBottom())) {
          hideSoftInput();
        }
      }
    } catch (Exception e) {
      LoggerUtils.e(TAG, "Exception in dispatchTouchEvent", e);
    }
    return userEvent;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
