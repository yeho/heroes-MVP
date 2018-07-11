package com.yeho.hero.ui.Home;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import com.yeho.hero.R;
import com.yeho.hero.common.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeFragment.OnHomeFragmentInteractionListener {

  HomeContract.Presenter mPresenter;

  @Override protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_home_layout);

    HomeFragment HomeFragment = (HomeFragment) getFragmentManager().findFragmentById(R.id.frame_layout_content);
    if (HomeFragment == null) {
      HomeFragment = HomeFragment.newInstance();
      FragmentTransaction transaction = getFragmentManager().beginTransaction();
      transaction.add(R.id.frame_layout_content, HomeFragment);
      transaction.commit();
    }
    mPresenter = new HomePresenter(HomeFragment);
  }

  @Override protected void onStart() {
    super.onStart();
    mPresenter.start();
  }

  @Override protected void onStop() {
    super.onStop();
    mPresenter.stop();
  }

  @Override public void onHomeFragmentInteraction() {

  }
}
