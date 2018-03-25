package com.user.obligatorio.robotica.nxt_safetypack_user.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.user.obligatorio.robotica.nxt_safetypack_user.NXTSafetyPackUserApplication;

import javax.inject.Inject;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;

/**
 * Created by Bruno on 25/3/2018.
 */

public class BluetoothController {
  @NonNull
  private BluetoothSPP bluetoothSPP = new BluetoothSPP(NXTSafetyPackUserApplication.getContext());

  @Inject
  BluetoothController() { }

  public void connect(@NonNull Intent data) {
    bluetoothSPP.connect(data);
  }

  public boolean isBluetoothEnabled() {
    return bluetoothSPP.isBluetoothEnabled();
  }

  public boolean isServiceAvailable() {
    return bluetoothSPP.isServiceAvailable();
  }

  public void sendLeftSignalCommand() {

  }

  public void sendRightSignalCommand() {

  }

  public void setupService() {
    bluetoothSPP.setupService();
  }

  public void startBluetoothConnection() {
    setupService();
    startServiceAndroid();
  }

  public void startServiceAndroid() {
    bluetoothSPP.startService(BluetoothState.DEVICE_ANDROID);
  }

  public void stopBluetooth() {
    bluetoothSPP.stopService();
  }
}
