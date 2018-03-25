package com.user.obligatorio.robotica.nxt_safetypack_user.ui.user;

import com.annimon.stream.Optional;
import com.user.obligatorio.robotica.nxt_safetypack_user.controller.BluetoothController;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpPresenter;

import javax.inject.Inject;

/**
 * Created by Bruno on 18/3/2018.
 */
public class UserPresenter extends BaseMvpPresenter<UserView> {
  @Inject
  BluetoothController bluetoothController;

  @Inject
  public UserPresenter() { }

  void onLeftSignalButtonClicked() {
    bluetoothController.sendLeftSignalCommand();
    Optional.ofNullable(getView())
        .executeIfPresent(UserView::setBlinkingLeftSignal);
  }

  void onRightSignalButtonClicked() {
    bluetoothController.sendRightSignalCommand();
    Optional.ofNullable(getView())
        .executeIfPresent(UserView::setBlinkingRightSignal);
  }
}
