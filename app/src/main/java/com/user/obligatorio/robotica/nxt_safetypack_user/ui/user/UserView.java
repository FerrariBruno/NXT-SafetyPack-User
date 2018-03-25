package com.user.obligatorio.robotica.nxt_safetypack_user.ui.user;

import com.xmartlabs.bigbang.ui.mvp.MvpView;

/**
 * Created by Bruno on 18/3/2018.
 */

public interface UserView extends MvpView {
  void setBlinkingLeftSignal();
  void setBlinkingRightSignal();
}
