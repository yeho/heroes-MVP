package com.yeho.hero.ui.HeroDetail;

import android.support.annotation.NonNull;
import com.yeho.hero.common.BasePresenter;

public class HeroDetailPresenter extends BasePresenter implements HeroDetailContract.Presenter {

  private HeroDetailContract.View mView;


  public HeroDetailPresenter( @NonNull HeroDetailContract.View view) {
    this.mView = view;
    this.mView.setPresenter(this);
  }

  @Override public void start() {

  }

  @Override public void stop() {

  }
}
