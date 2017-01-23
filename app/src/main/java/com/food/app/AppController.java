package com.food.app;

import android.app.Application;
import com.food.data.factory.RealmConfigFactory;
import com.food.data.repo.AdminRepo;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by nandagopal on 1/23/17.
 */
public class AppController extends Application {

  private static AppController appController;

  private AdminRepo adminRepo;
  private RealmConfiguration realmConfiguration;

  @Override public void onCreate() {
    super.onCreate();

    appController = this;
    Realm.init(this);

    realmConfiguration = RealmConfigFactory.createAdminRealmRealmConfiguration();
  }

  public static AppController getInstance() {
    return appController;
  }

  public AdminRepo getAdminRepo() {
    if (adminRepo == null) adminRepo = createAdminRepo();
    return adminRepo;
  }

  private AdminRepo createAdminRepo() {
    return new AdminRepo(realmConfiguration);
  }
}
