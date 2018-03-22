package com.user.obligatorio.robotica.nxt_safetypack_user.ui;

import android.support.annotation.NonNull;

import com.annimon.stream.Optional;
import com.annimon.stream.function.Consumer;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpPresenter;

import javax.inject.Inject;

/**
 * Created by Bruno on 18/3/2018.
 */
public class UserPresenter extends BaseMvpPresenter<UserView> {
  @Inject
  public UserPresenter() { }

  void onLeftSignalButtonClicked() {
    //TODO send appropiate command via bluetooth
    Optional.ofNullable(getView())
        .executeIfPresent(new Consumer<UserView>() {
          @Override
          public void accept(@NonNull UserView userView) {
            userView.setBlinkingLeftSignal();
          }
        });
  }

  void onRightSignalButtonClicked() {
    //TODO send appropiate command via bluetooth
    Optional.ofNullable(getView())
        .executeIfPresent(new Consumer<UserView>() {
          @Override
          public void accept(@NonNull UserView userView) {
            userView.setBlinkingRightSignal();
          }
        });
  }
}
