package com.yeho.hero.data;

import com.yeho.hero.data.remote.model.HeroResp;
import com.yeho.hero.data.remote.model.Result;

/**
 * Created by yeho on 10/07/2018
 */
public class UserData {

    private static UserData instance;
    private HeroResp heroResp;
    private Result heroSelected;


    private UserData() {
    }

    public static synchronized UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public UserData getNewInstance() {
        instance = null;
        instance = new UserData();
        return instance;
    }

  public void clearInstance() {
    instance = null;
  }

  public HeroResp getHeroResp() {
    return heroResp;
  }

  public void setHeroResp(HeroResp heroResp) {
    this.heroResp = heroResp;
  }

  public Result getHeroSelected() {
    return heroSelected;
  }

  public void setHeroSelected(Result heroSelected) {
    this.heroSelected = heroSelected;
  }
}
