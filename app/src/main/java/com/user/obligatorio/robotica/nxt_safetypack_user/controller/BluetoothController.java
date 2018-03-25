package com.user.obligatorio.robotica.nxt_safetypack_user.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.user.obligatorio.robotica.nxt_safetypack_user.NXTSafetyPackUserApplication;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;

/**
 * Created by Bruno on 25/3/2018.
 */
@Singleton
public class BluetoothController {
  private static final String LEFT_SIGNAL_DISABLED = "LEFT_SIGNAL_DISABLED";
  private static final String LEFT_SIGNAL_ENABLED = "LEFT_SIGNAL_ENABLED";
  private static final String RIGHT_SIGNAL_DISABLED = "RIGHT_SIGNAL_DISABLED";
  private static final String RIGHT_SIGNAL_ENABLED = "RIGHT_SIGNAL_ENABLED";

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

  public void sendLeftSignalCommand(boolean shouldBlink) {
    if (shouldBlink) {
      sendLeftSignalEnabledCommand();
    } else {
      sendLeftSignalDisabledCommand();
    }
  }

  public void sendLeftSignalDisabledCommand() {
    bluetoothSPP.send(LEFT_SIGNAL_DISABLED, true);
    Toast.makeText(NXTSafetyPackUserApplication.getContext(),
        "Left signal disabled",
        Toast.LENGTH_SHORT)
        .show();
  }

  public void sendLeftSignalEnabledCommand() {
    bluetoothSPP.send(LEFT_SIGNAL_ENABLED, true);
    Toast.makeText(NXTSafetyPackUserApplication.getContext(),
        "Left signal enabled",
        Toast.LENGTH_SHORT)
        .show();
  }

  public void sendRightSignalCommand(boolean shouldBlink) {
    if (shouldBlink) {
      sendRightSignalEnabledCommand();
    } else {
      sendRightSignalDisabledCommand();
    }
  }

  public void sendRightSignalDisabledCommand() {
    bluetoothSPP.send(RIGHT_SIGNAL_DISABLED, true);
    Toast.makeText(NXTSafetyPackUserApplication.getContext(),
        "Right signal disabled",
        Toast.LENGTH_SHORT)
        .show();
  }

  public void sendRightSignalEnabledCommand() {
    bluetoothSPP.send(RIGHT_SIGNAL_ENABLED, true);
    Toast.makeText(NXTSafetyPackUserApplication.getContext(),
        "Right signal enabled",
        Toast.LENGTH_SHORT)
        .show();
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
