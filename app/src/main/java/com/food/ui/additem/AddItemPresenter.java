package com.food.ui.additem;

import com.food.base.BasePresenter;

/**
 * Created by nandagopal on 1/24/17.
 */
public class AddItemPresenter implements BasePresenter<AddItemView> {

  private AddItemView view;

  @Override public void setView(AddItemView view) {
    this.view = view;
  }

  @Override public void destroyView() {
    view = null;
  }

  @Override public void destroy() {

  }
}
