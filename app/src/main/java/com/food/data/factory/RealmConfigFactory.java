package com.food.data.factory;

import com.food.data.module.AdminModule;
import io.realm.RealmConfiguration;

/**
 * Created by nandagopal on 1/23/17.
 */
public class RealmConfigFactory {

  //public static RealmConfiguration createAdminRealmRealmConfiguration() {
  //  return new RealmConfiguration.Builder().modules(new AdminModule())
  //      .name("AdminFoodModule")
  //      .build();
  //}

  public static RealmConfiguration createAdminRealmRealmConfiguration() {
    return new RealmConfiguration.Builder().name("AdminFoodModule")
        .build();
  }
}
