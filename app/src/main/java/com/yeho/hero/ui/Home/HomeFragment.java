package com.yeho.hero.ui.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.yeho.hero.R;
import com.yeho.hero.adapter.RvHeroListAdapter;
import com.yeho.hero.common.BaseFragment;
import com.yeho.hero.data.UserData;
import com.yeho.hero.data.remote.model.Result;
import com.yeho.hero.ui.HeroDetail.HeroDetailActivity;

public final class HomeFragment extends BaseFragment implements HomeContract.View, RvHeroListAdapter.HeroesOnClickHandler {

  Context context;
  private HomeContract.Presenter mPresenter;
  private RecyclerView rvCharacters;
  private RvHeroListAdapter adapter;
  // Your presenter is available using the mPresenter variable
  public HomeFragment() {
    // Required empty public constructor
  }

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Override public void setPresenter(HomeContract.Presenter presenter) {
    this.mPresenter = presenter;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home_layout, container, false);

    context = getActivity().getApplicationContext();

    rvCharacters = view.findViewById(R.id.rvCharacters);

    //  lyProgressBar = findViewById(R.id.lyPbAdopcion);

    adapter = new RvHeroListAdapter(this, context);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
    layoutManager.setAutoMeasureEnabled(false);
    rvCharacters.setLayoutManager(layoutManager);
    if (UserData.getInstance().getHeroResp() != null) {
      adapter.setCharacters(UserData.getInstance().getHeroResp().getData().getResults());
    }
    rvCharacters.setAdapter(adapter);

    mPresenter.getCharacters();

    return view;
  }

  @Override public void showErrorMessage(String message) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }

  @Override public void updateUI() {
    adapter.setCharacters(UserData.getInstance().getHeroResp().getData().getResults());
  }

  @Override public void onClick(Result heroDetail) {
    try {
      UserData.getInstance().setHeroSelected(heroDetail);
      Intent intent = new Intent(context, HeroDetailActivity.class);
      startActivity(intent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnHomeFragmentInteractionListener {
    // TODO: Update argument type and name
    void onHomeFragmentInteraction();
  }
}
