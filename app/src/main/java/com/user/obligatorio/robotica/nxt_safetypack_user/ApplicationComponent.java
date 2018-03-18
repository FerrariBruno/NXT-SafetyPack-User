package com.user.obligatorio.robotica.nxt_safetypack_user;

import com.user.obligatorio.robotica.nxt_safetypack_user.ui.UserActivity;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.UserFragment;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.UserPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bruno on 18/3/2018.
 */
@Component
@Singleton
public interface ApplicationComponent {
  void inject(NXTSafetyPackUserApplication nxtSafetyPackUserApplication);

  void inject(UserActivity userActivity);

  void inject(UserFragment userFragment);

  void inject(UserPresenter userPresenter);
}
