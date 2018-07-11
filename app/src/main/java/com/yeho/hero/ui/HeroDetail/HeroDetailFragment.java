package com.yeho.hero.ui.HeroDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.yeho.hero.R;
import com.yeho.hero.adapter.RvComicsAdapter;
import com.yeho.hero.common.BaseFragment;
import com.yeho.hero.data.Constants;
import com.yeho.hero.data.UserData;
import com.yeho.hero.data.remote.model.Result;
import java.util.ArrayList;

public final class HeroDetailFragment extends BaseFragment implements HeroDetailContract.View {

  private HeroDetailContract.Presenter mPresenter;
  private Result heroDetails;
  private ImageView ivCharacter;
  private TextView tvCharacterName;
  private TextView tvCharacterDescription;
  private RecyclerView rvComics;
  private RvComicsAdapter adapter;
  private Context context;

  // Your presenter is available using the mPresenter variable
  public HeroDetailFragment() {
    // Required empty public constructor
  }

  public static HeroDetailFragment newInstance(Result heroDetails) {
    HeroDetailFragment fragment = new HeroDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(Constants.HERO_DETAILS, heroDetails);
    fragment.setArguments(bundle);

    return fragment;
  }

  @Override public void setPresenter(HeroDetailContract.Presenter presenter) {
    this.mPresenter = presenter;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_hero_detail_layout, container, false);

    context = getActivity().getApplicationContext();

    heroDetails = (Result) getArguments().getSerializable(Constants.HERO_DETAILS);

    ivCharacter = view.findViewById(R.id.ivCharacter);
    tvCharacterName = view.findViewById(R.id.tvCharacterName);
    tvCharacterDescription = view.findViewById(R.id.tvCharacterDescription);
    rvComics = view.findViewById(R.id.rvComics);

    if (heroDetails.getThumbnail() != null) {
      Picasso.get().load(heroDetails.getThumbnail().getPath() + "." + heroDetails.getThumbnail().getExtension()).fit().into(ivCharacter);
    }

    tvCharacterName.setText(heroDetails.getName());
    tvCharacterDescription.setText(heroDetails.getDescription());

    adapter = new RvComicsAdapter(context);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
    layoutManager.setAutoMeasureEnabled(false);
    rvComics.setLayoutManager(layoutManager);
    if (UserData.getInstance().getHeroSelected().getComics() != null) {
      ArrayList<String> comicsArrayList = new ArrayList<>();
      for (int i = 0; i < UserData.getInstance().getHeroSelected().getComics().getItems().size(); i++) {
        comicsArrayList.add(UserData.getInstance().getHeroSelected().getComics().getItems().get(i).getName());
      }
      adapter.setComics(comicsArrayList);
    }
    rvComics.setAdapter(adapter);

    return view;
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
  public interface OnHeroDetailFragmentInteractionListener {
    // TODO: Update argument type and name
    void onHeroDetailFragmentInteraction();
  }
}
