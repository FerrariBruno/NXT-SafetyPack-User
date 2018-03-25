package com.user.obligatorio.robotica.nxt_safetypack_user;

import com.user.obligatorio.robotica.nxt_safetypack_user.controller.BluetoothController;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.configuration.ConfigurationActivity;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.configuration.ConfigurationFragment;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.configuration.ConfigurationPresenter;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.user.UserActivity;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.user.UserFragment;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.user.UserPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bruno on 18/3/2018.
 */
@Component
@Singleton
public interface ApplicationComponent {
  void inject(NXTSafetyPackUserApplication nxtSafetyPackUserApplication);

  void inject(ConfigurationActivity configurationActivity);
  void inject(UserActivity userActivity);

  void inject(BluetoothController bluetoothController);

  void inject(ConfigurationFragment bluetoothFragment);
  void inject(UserFragment userFragment);

  void inject(ConfigurationPresenter configurationPresenter);
  void inject(UserPresenter userPresenter);
}
