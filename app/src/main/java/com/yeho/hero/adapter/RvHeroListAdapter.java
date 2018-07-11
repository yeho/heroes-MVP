package com.yeho.hero.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.yeho.hero.R;
import com.yeho.hero.data.remote.model.Result;
import java.util.ArrayList;

public class RvHeroListAdapter extends RecyclerView.Adapter<RvHeroListAdapter.HeroesViewHolder> {

    private final HeroesOnClickHandler clickHandler;
    Context context;
    private ArrayList<Result> characterList;

    public RvHeroListAdapter(HeroesOnClickHandler clickHandler, Context context) {
        this.context = context;
        this.clickHandler = clickHandler;
    }

    @Override public HeroesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        HeroesViewHolder pvh = new HeroesViewHolder(v);
        return pvh;
    }

    @Override public void onBindViewHolder(HeroesViewHolder holder, final int position) {
        if (characterList.get(position).getThumbnail() != null)
                Picasso.get().load(characterList.get(position).getThumbnail().getPath()
                    + "."+ characterList.get(position).getThumbnail().getExtension()).fit().into(holder.ivCharacter);

        if (characterList.get(position).getName() != null) holder.tvCharacterName.setText(characterList.get(position).getName());
    }


    @Override public int getItemCount() {
        if (null == characterList) return 0;
        return characterList.size();
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

    public void setCharacters(ArrayList<Result> listadoPerdidos) {
        this.characterList = listadoPerdidos;
        notifyDataSetChanged();
    }

    public interface HeroesOnClickHandler {
        void onClick(Result listadoPerdidos);
    }

    public class HeroesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivCharacter;
        TextView tvCharacterName;

        HeroesViewHolder(View itemView) {
            super(itemView);
          ivCharacter = itemView.findViewById(R.id.ivCharacter);
          tvCharacterName = itemView.findViewById(R.id.tvCharacterName);

            itemView.setOnClickListener(this);
        }

        @Override public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition < 0 || adapterPosition >= characterList.size()) return;
          Result character = characterList.get(adapterPosition);
            clickHandler.onClick(character);
        }
    }
}
