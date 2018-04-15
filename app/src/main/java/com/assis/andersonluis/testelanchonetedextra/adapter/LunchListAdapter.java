package com.assis.andersonluis.testelanchonetedextra.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assis.andersonluis.testelanchonetedextra.R;
import com.assis.andersonluis.testelanchonetedextra.model.Lunch;
import com.assis.andersonluis.testelanchonetedextra.presenter.LunchListPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LunchListAdapter  extends RecyclerView.Adapter<LunchListAdapter.ItemViewHolder> {

    private Context context;
    private LunchListPresenter presenter;
    private Picasso picasso;

    private List<Lunch> itens;

    public LunchListAdapter(LunchListPresenter presenter, Picasso picasso, List<Lunch> itens) {
        this.presenter = presenter;
        this.picasso = picasso;
        this.itens = itens;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lunch_view, parent, false);
        return new ItemViewHolder(inflated);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Lunch lunche = itens.get(position);

        holder.title.setText(lunche.getName());
        holder.price.setText("R$ " + lunche.getPrice().toString());
        holder.ingredients.setText("Ingredientes: "+lunche.getIngredientListDescription());

        picasso.load(lunche.getImage())
                .resize(75, 75)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.onSelectAnLunchOfList(lunche);
            }

        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_lunch_img)
        ImageView img;

        @BindView(R.id.txt_lunch_title)
        TextView title;

        @BindView(R.id.txt_lunch_price)
        TextView price;

        @BindView(R.id.txt_lunch_ingredients)
        TextView ingredients;

        public ItemViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

    }

}
