package com.user.obligatorio.robotica.nxt_safetypack_user.ui;

import android.support.annotation.NonNull;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;

import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.user.obligatorio.robotica.nxt_safetypack_user.R;
import com.xmartlabs.bigbang.ui.mvp.BaseMvpFragment;

import org.threeten.bp.Duration;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Bruno on 18/3/2018.
 */
@FragmentWithArgs
public class UserFragment extends BaseMvpFragment<UserView, UserPresenter> implements UserView {
  private static final Duration ANIMATION_DURATION = Duration.ofMillis(600);
  private static final float ANIMATION_FROM_ALPHA = 0.5f;
  private static final int ANIMATION_TO_ALPHA = 1;

  private boolean isLeftSignalBlinking = false;
  private boolean isRightButtonBlinking = false;

  @BindView(R.id.leftSignalButton)
  ImageButton buttonLeftSignal;
  @BindView(R.id.rightSignalButton)
  ImageButton buttonRightSignal;

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

  @NonNull
  Animation blinkingAnimation() {
    Animation animation = new AlphaAnimation(ANIMATION_FROM_ALPHA, ANIMATION_TO_ALPHA);
    animation.setInterpolator(new LinearInterpolator());
    animation.setDuration(ANIMATION_DURATION.toMillis());
    animation.setRepeatCount(Animation.INFINITE);
    animation.setRepeatMode(Animation.REVERSE);
    return animation;
  }

  @OnClick(R.id.leftSignalButton)
  void onLeftSignalButtonClicked() {
    userPresenter.onLeftSignalButtonClicked();
  }

  @OnClick(R.id.rightSignalButton)
  void onRightSignalButtonClicked() {
    userPresenter.onRightSignalButtonClicked();
  }

  @Override
  public void setBlinkingLeftSignal() {
    stopBlinkingRightSignal();
    if (isLeftSignalBlinking) {
      buttonLeftSignal.setImageDrawable(getResources().getDrawable(R.drawable.ic_turn_signal_left));
      buttonLeftSignal.clearAnimation();
      isLeftSignalBlinking = false;
    } else {
      buttonLeftSignal.setImageDrawable(getResources().getDrawable(R.drawable.ic_turn_signal_left_green));
      buttonRightSignal.setImageDrawable(getResources().getDrawable(R.drawable.ic_turn_signal_right));
      buttonLeftSignal.startAnimation(blinkingAnimation());
      isLeftSignalBlinking = true;
    }
  }

  @Override
  public void setBlinkingRightSignal() {
    stopBlinkingLeftSignal();
    if (isRightButtonBlinking) {
      buttonRightSignal.setImageDrawable(getResources().getDrawable(R.drawable.ic_turn_signal_right));
      buttonRightSignal.clearAnimation();
      isRightButtonBlinking = false;
    } else {
      buttonRightSignal.setImageDrawable(getResources().getDrawable(R.drawable.ic_turn_signal_right_green));
      buttonLeftSignal.setImageDrawable(getResources().getDrawable(R.drawable.ic_turn_signal_left));
      buttonRightSignal.startAnimation(blinkingAnimation());
      isRightButtonBlinking = true;
    }
  }

  void stopBlinkingLeftSignal() {
    buttonLeftSignal.clearAnimation();
  }

  void stopBlinkingRightSignal() {
    buttonRightSignal.clearAnimation();
  }
}
