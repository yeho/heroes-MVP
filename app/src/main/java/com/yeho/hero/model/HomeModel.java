package com.yeho.hero.model;

import android.util.Log;
import com.yeho.hero.Utils.Utils;
import com.yeho.hero.data.Constants;
import com.yeho.hero.data.UserData;
import com.yeho.hero.data.remote.ApiClient;
import com.yeho.hero.data.remote.ApiManager;
import com.yeho.hero.data.remote.model.HeroResp;
import com.yeho.hero.ui.Home.HomeContract;
import java.text.SimpleDateFormat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModel implements HomeContract.Model {

  private static final String TAG = "HomeModel";
  private HomeContract.Presenter presenter;

  public HomeModel(HomeContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override public void getCharacters() {
    ApiClient service = ApiManager.createService(ApiClient.class);
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    String hash = Utils.md5(timeStamp + Utils.prepare(Constants.RANDOM_TEXT) + Constants.PUBLIC_KEY);

    Call<HeroResp> call = service.callCharacters(Constants.PUBLIC_KEY, timeStamp, hash, "100");
    call.enqueue(new Callback<HeroResp>() {
      @Override public void onResponse(Call<HeroResp> call, Response<HeroResp> response) {
        try {
          HeroResp heroResp = response.body();
          if (heroResp.getStatus().equals(Constants.STATUS_OK)) {
            UserData.getInstance().setHeroResp(heroResp);
            presenter.updateUI();
          } else {
            presenter.showErrorMessage("Error obteniendo lista de Heroes");
          }
        } catch (Exception e) {
          e.printStackTrace();
          presenter.showErrorMessage("Error mostrando lista de Heroes");
        }
      }

      @Override public void onFailure(Call<HeroResp> call, Throwable t) {
        Log.wtf("YEHO", "falla obteniendo lista de Heroes");
      }
    });
  }
}
