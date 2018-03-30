package com.user.obligatorio.robotica.nxt_safetypack_user.ui.configuration;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.annimon.stream.Optional;
import com.user.obligatorio.robotica.nxt_safetypack_user.controller.BluetoothController;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpPresenter;

import javax.inject.Inject;

/**
 * Created by Bruno on 25/3/2018.
 */

public class ConfigurationPresenter extends BaseMvpPresenter<ConfigurationView> {
  @Inject
  @NonNull
  BluetoothController bluetoothController;

  @Inject
  public ConfigurationPresenter() { }

  void connect(@NonNull Intent data) {
    bluetoothController.connect(data);
  }

  void startBluetoothConnection() {
    if (bluetoothController.isBluetoothEnabled()) {
      if (!bluetoothController.isServiceAvailable()) {
        bluetoothController.startBluetoothConnection();
      }
    } else {
      Optional.ofNullable(getView())
          .ifPresent(ConfigurationView::askToEnableBluetooth);
    }
  }

  boolean isBluetoothEnabled() {
    return bluetoothController.isBluetoothEnabled();
  }

  void setupService() {
    bluetoothController.setupService();
  }

  void startServiceAndroid() {
    bluetoothController.startServiceAndroid();
  }

  void stopBluetooth() {
    bluetoothController.stopBluetooth();
  }
}
