package com.user.obligatorio.robotica.nxt_safetypack_user.ui.configuration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.user.obligatorio.robotica.nxt_safetypack_user.R;
import com.xmartlabs.bigbang.ui.BaseFragment;
import com.xmartlabs.bigbang.ui.SingleFragmentActivity;

/**
 * Created by Bruno on 25/3/2018.
 */
public class ConfigurationActivity extends SingleFragmentActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupToolbar();
  }

  @NonNull
  @Override
  protected BaseFragment createFragment() {
    return new ConfigurationFragmentBuilder().build();
  }

  private void setupToolbar() {
    setSupportActionBar(findViewById(R.id.toolbar));
    //noinspection ConstantConditions
    getSupportActionBar().setDisplayShowTitleEnabled(false);
  }
}
