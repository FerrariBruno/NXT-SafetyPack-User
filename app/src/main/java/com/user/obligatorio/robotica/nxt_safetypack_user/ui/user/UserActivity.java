package com.user.obligatorio.robotica.nxt_safetypack_user.ui.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.f2prateek.dart.HensonNavigable;
import com.user.obligatorio.robotica.nxt_safetypack_user.R;
import com.xmartlabs.bigbang.ui.BaseFragment;
import com.xmartlabs.bigbang.ui.SingleFragmentActivity;

/**
 * Created by Bruno on 18/3/2018.
 */
@HensonNavigable
public class UserActivity extends SingleFragmentActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupToolbar();
  }

  @NonNull
  @Override
  protected BaseFragment createFragment() {
    return new UserFragmentBuilder().build();
  }

  private void setupToolbar() {
    setSupportActionBar(findViewById(R.id.toolbar));
    //noinspection ConstantConditions
    getSupportActionBar().setDisplayShowTitleEnabled(false);
  }
}
