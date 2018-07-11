package com.yeho.hero.common;

/**
 * @author yeho
 * fecha: 10/07/2018
 */

public interface MvpPresenter<V> {

  void attachView(V view);

  void detachView();
}