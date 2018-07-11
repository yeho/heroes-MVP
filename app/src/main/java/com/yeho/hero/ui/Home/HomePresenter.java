package com.yeho.hero.ui.Home;

import android.support.annotation.NonNull;
import com.yeho.hero.common.BasePresenter;
import com.yeho.hero.model.HomeModel;

public class HomePresenter extends BasePresenter implements HomeContract.Presenter {

  private HomeContract.View mView;
  private HomeContract.Model model;


  public HomePresenter( @NonNull HomeContract.View view) {
    this.mView = view;
    this.mView.setPresenter(this);
    model = new HomeModel(this);
  }

  @Override public void start() {

  }

  @Override public void stop() {

  }

  @Override public void showErrorMessage(String message) {
    mView.showErrorMessage(message);
  }

  @Override public void updateUI() {
    mView.updateUI();
  }

  @Override public void getCharacters() {
    model.getCharacters();
  }
}
