package com.food.ui.home;

import com.food.base.BasePresenter;

/**
 * Created by nandagopal on 1/24/17.
 */
public class HomePresenter implements BasePresenter<HomeView> {

  private HomeView view;

  @Override public void setView(HomeView view) {
    this.view = view;
  }

  @Override public void destroyView() {
    view = null;
  }

  @Override public void destroy() {

  }
}
