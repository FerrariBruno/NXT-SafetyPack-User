package com.user.obligatorio.robotica.nxt_safetypack_user.ui.user;

import com.annimon.stream.Optional;
import com.user.obligatorio.robotica.nxt_safetypack_user.controller.BluetoothController;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpPresenter;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bruno on 18/3/2018.
 */
public class UserPresenter extends BaseMvpPresenter<UserView> {
  @Getter
  @Setter
  private boolean shouldLeftSignalBlink = false;
  @Getter
  @Setter
  private boolean shouldRightSignalBlink = false;

  @Inject
  BluetoothController bluetoothController;

  @Inject
  public UserPresenter() { }

  void onLeftSignalButtonClicked() {
    Optional.ofNullable(getView())
        .executeIfPresent(userView -> {
          changeLeftBlinkingStatus();
          userView.stopBlinkingRightSignal();
          userView.setBlinkingLeftSignal(shouldLeftSignalBlink);
        });
    bluetoothController.sendLeftSignalCommand(isShouldLeftSignalBlink());
  }

  private void changeLeftBlinkingStatus() {
    shouldLeftSignalBlink = !shouldLeftSignalBlink;
  }

  void onRightSignalButtonClicked() {
    Optional.ofNullable(getView())
        .executeIfPresent(userView -> {
          changeRightBlinkingStatus();
          userView.stopBlinkingLeftSignal();
          userView.setBlinkingRightSignal(shouldRightSignalBlink);
        });
    bluetoothController.sendRightSignalCommand(isShouldRightSignalBlink());
  }

  private void changeRightBlinkingStatus() {
    shouldRightSignalBlink = !shouldRightSignalBlink;
  }

  String getConnectedDeviceName() {
    return bluetoothController.getConnectedDeviceName();
  }

  void stopBluetooth() {
    bluetoothController.stopBluetooth();
  }
}
