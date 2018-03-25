package com.user.obligatorio.robotica.nxt_safetypack_user.ui.configuration;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.user.obligatorio.robotica.nxt_safetypack_user.NXTSafetyPackUserApplication;
import com.user.obligatorio.robotica.nxt_safetypack_user.R;
import com.user.obligatorio.robotica.nxt_safetypack_user.ui.user.Henson;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpFragment;

import javax.inject.Inject;

import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;
import butterknife.OnClick;

/**
 * Created by Bruno on 25/3/2018.
 */
@FragmentWithArgs
public class ConfigurationFragment extends BaseMvpFragment<ConfigurationView, ConfigurationPresenter> implements ConfigurationView {
  @Inject
  ConfigurationPresenter configurationPresenter;

  @NonNull
  @Override
  protected ConfigurationPresenter createPresenter() {
    return configurationPresenter;
  }

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_bluetooth;
  }

  @Override
  public void onStart() {
    super.onStart();
    configurationPresenter.startBluetoothConnection();
  }

  @OnClick(R.id.bluetoothConnect)
  void onBluetoothConnectButtonClicked() {
    if (configurationPresenter.isBluetoothEnabled()) {
      Intent intent = new Intent(NXTSafetyPackUserApplication.getContext(), DeviceList.class);
      startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);
    } else {
      askToEnableBluetooth();
    }
  }

  @Override
  public void askToEnableBluetooth() {
    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
    startActivityForResult(intent, BluetoothState.REQUEST_ENABLE_BT);
  }

  @Override
  public void goToUserActivity() {
    Intent intent = Henson.with(getContext())
        .gotoUserActivity()
        .build();
    startActivity(intent);
  }

  public void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
    if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
      if (resultCode == Activity.RESULT_OK)
        configurationPresenter.connect(data);
        configurationPresenter.handleDeviceConnection();
    } else if (requestCode == BluetoothState.REQUEST_ENABLE_BT) {
      if (resultCode == Activity.RESULT_OK) {
        configurationPresenter.setupService();
        configurationPresenter.startServiceAndroid();
      } else {
        Toast.makeText(NXTSafetyPackUserApplication.getContext(),
            R.string.bluetooth_not_enabled,
            Toast.LENGTH_SHORT).show();
      }
    }
  }
}
