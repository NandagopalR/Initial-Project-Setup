package com.food.base;

/**
 * Created by kalpesh on 11/05/16.
 */
public interface BasePresenter<V extends BaseView> {
    void setView(V view);

    void destroyView();

    void destroy();
}