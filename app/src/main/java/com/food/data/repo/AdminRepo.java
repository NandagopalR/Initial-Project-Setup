package com.food.data.repo;

//import io.realm.RealmConfiguration;

import io.realm.RealmConfiguration;

/**
 * Created by nandagopal on 1/23/17.
 */
public class AdminRepo {

  private RealmConfiguration adminRealmConfig;

  public AdminRepo(RealmConfiguration adminRealmConfig) {
    this.adminRealmConfig = adminRealmConfig;
  }
}
