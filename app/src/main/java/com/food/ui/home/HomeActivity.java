package com.food.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.food.R;
import com.food.base.BaseActivity;

/**
 * Created by nandagopal on 1/24/17.
 */
public class HomeActivity extends BaseActivity implements HomeView {

  private HomePresenter presenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);

    presenter = new HomePresenter();
    presenter.setView(this);
  }

  @Override public Context context() {
    return this;
  }
}
