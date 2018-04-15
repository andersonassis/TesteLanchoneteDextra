package com.assis.andersonluis.testelanchonetedextra.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assis.andersonluis.testelanchonetedextra.R;
import com.assis.andersonluis.testelanchonetedextra.modelos.Ingredient;
import com.shawnlin.numberpicker.NumberPicker;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientAdapter  extends RecyclerView.Adapter<IngredientAdapter.ItemViewHolder> {

    private List<Ingredient> ingredients;

    private OnIngredientModifierListener listener;
    private Picasso picasso;

    public IngredientAdapter() {}

    public IngredientAdapter(List<Ingredient> ingredients, Picasso picasso, OnIngredientModifierListener listener) {
        this.ingredients = ingredients;
        this.listener = listener;
        this.picasso = picasso;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflated = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_ingredient, parent, false);

        return new ItemViewHolder(inflated);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Ingredient ingredient = ingredients.get(position);

        holder.title.setText(ingredient.getName());
        holder.price.setText("R$ " + ingredient.getPrice().toString() + "/und");
        picasso.load(ingredient.getImage())
                .resize(200, 200)
                .into(holder.img);

        holder.picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                if(newVal > oldVal){
                    listener.increase(newVal - oldVal, ingredient);
                } else {
                    listener.decrease(oldVal - newVal, ingredient);
                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_lunch_img)
        ImageView img;

        @BindView(R.id.txt_lunch_title)
        TextView title;

        @BindView(R.id.txt_lunch_price)
        TextView price;

        @BindView(R.id.picker)
        NumberPicker picker;

        public ItemViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnIngredientModifierListener {

        void increase(int times, Ingredient ingredient);
        void decrease(int times, Ingredient ingredient);

    }

}

