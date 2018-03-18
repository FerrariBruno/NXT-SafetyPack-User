package com.user.obligatorio.robotica.nxt_safetypack_user;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.annimon.stream.Optional;
import com.xmartlabs.bigbang.core.Injector;

import bullet.ObjectGraph;

/**
 * Created by Bruno on 17/3/2018.
 */

public class NXTSafetyPackUserApplication extends Application {
  @Nullable
  private static NXTSafetyPackUserApplication instance;

  public NXTSafetyPackUserApplication() {
    instance = this;
  }

  public static NXTSafetyPackUserApplication getContext() {
    return Optional.ofNullable(instance).get();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    initializeInjections();
  }

  private void initializeInjections() {
    ApplicationComponent component = createComponent();
    ObjectGraph bullet = createBullet(component);
    Injector.getInstance().setObjectGraph(bullet);
    Injector.inject(this);
  }

  @NonNull
  protected ApplicationComponent createComponent() {
    return DaggerApplicationComponent.builder()
        .build();
  }

  @NonNull
  protected ObjectGraph createBullet(ApplicationComponent component) {
    return new BulletApplicationComponent(component);
  }
}
