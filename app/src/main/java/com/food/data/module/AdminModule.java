package com.food.data.module;

//import io.realm.annotations.RealmModule;

import com.food.data.model.TestModel;
import io.realm.annotations.RealmModule;

/**
 * Created by nandagopal on 1/23/17.
 */
@RealmModule(classes = { TestModel.class }) public class AdminModule {

  public static final String TAG = "AdminModule";
}
