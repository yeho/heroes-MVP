package com.yeho.hero.common;

public interface BaseContract {

  interface View<T extends Presenter> {
    void setPresenter(T presenter);
  }

  interface Presenter {
    void start();
    void stop();
  }

  interface Model {

  }
}