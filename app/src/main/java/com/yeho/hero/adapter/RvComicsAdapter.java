package com.yeho.hero.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yeho.hero.R;
import java.util.ArrayList;

public class RvComicsAdapter extends RecyclerView.Adapter<RvComicsAdapter.HeroesViewHolder> {

  Context context;
  private ArrayList<String> comicsList;

  public RvComicsAdapter(Context context) {
    this.context = context;
  }

  @Override public HeroesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
    HeroesViewHolder pvh = new HeroesViewHolder(v);
    return pvh;
  }

  @Override public void onBindViewHolder(HeroesViewHolder holder, final int position) {

    if (comicsList.get(position) != null) holder.tvComicName.setText(comicsList.get(position));
  }

  @Override public int getItemCount() {
    if (null == comicsList) return 0;
    return comicsList.size();
  }

  @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemViewType(int position) {
    return position;
  }

  public void setComics(ArrayList<String> listadoPerdidos) {
    this.comicsList = listadoPerdidos;
    notifyDataSetChanged();
  }

  public class HeroesViewHolder extends RecyclerView.ViewHolder {

    TextView tvComicName;

    HeroesViewHolder(View itemView) {
      super(itemView);
      tvComicName = itemView.findViewById(R.id.tvComicName);
    }
  }
}
