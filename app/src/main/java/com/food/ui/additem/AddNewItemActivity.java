package com.food.ui.additem;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.food.R;
import com.food.base.BaseActivity;

/**
 * Created by nandagopal on 1/24/17.
 */
public class AddNewItemActivity extends BaseActivity implements AddItemView {

  private AddItemPresenter presenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_item);
    ButterKnife.bind(this);

    presenter = new AddItemPresenter();
    presenter.setView(this);
  }

  @Override public Context context() {
    return this;
  }
}
