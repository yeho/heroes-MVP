package com.yeho.hero.ui.Home;

import com.yeho.hero.common.BaseContract;

public interface HomeContract {

  interface View extends BaseContract.View<Presenter> {
    void showErrorMessage(String message);
    void updateUI();
  }

  interface Presenter extends BaseContract.Presenter {
    void showErrorMessage(String message);
    void updateUI();
    void getCharacters();

  }

  interface Model extends BaseContract.Model {
    void getCharacters();
  }
}
