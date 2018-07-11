package com.yeho.hero.ui.HeroDetail;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import com.yeho.hero.R;
import com.yeho.hero.common.BaseActivity;
import com.yeho.hero.data.UserData;
import com.yeho.hero.data.remote.model.Result;

public class HeroDetailActivity extends BaseActivity implements HeroDetailFragment.OnHeroDetailFragmentInteractionListener {

  HeroDetailContract.Presenter mPresenter;

  @Override protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_hero_detail_layout);


    Result heroDetails = UserData.getInstance().getHeroSelected();

    HeroDetailFragment HeroDetailFragment = (HeroDetailFragment) getFragmentManager().findFragmentById(R.id.frame_layout_content);
    if (HeroDetailFragment == null) {
      HeroDetailFragment = HeroDetailFragment.newInstance(heroDetails);
      FragmentTransaction transaction = getFragmentManager().beginTransaction();
      transaction.add(R.id.frame_layout_content, HeroDetailFragment);
      transaction.commit();
    }
    mPresenter = new HeroDetailPresenter(HeroDetailFragment);
  }

  @Override protected void onStart() {
    super.onStart();
    mPresenter.start();
  }

  @Override protected void onStop() {
    super.onStop();
    mPresenter.stop();
  }

  @Override public void onHeroDetailFragmentInteraction() {

  }
}
