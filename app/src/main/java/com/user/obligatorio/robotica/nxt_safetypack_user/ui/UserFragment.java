package com.user.obligatorio.robotica.nxt_safetypack_user.ui;

import android.support.annotation.NonNull;

import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.user.obligatorio.robotica.nxt_safetypack_user.R;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpFragment;

import javax.inject.Inject;

/**
 * Created by Bruno on 18/3/2018.
 */
@FragmentWithArgs
public class UserFragment extends BaseMvpFragment<UserView, UserPresenter> implements UserView {
  @Inject
  UserPresenter userPresenter;

  @NonNull
  @Override
  protected UserPresenter createPresenter() {
    return userPresenter;
  }

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_user;
  }
}
