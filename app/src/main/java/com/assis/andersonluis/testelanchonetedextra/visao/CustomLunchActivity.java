package com.assis.andersonluis.testelanchonetedextra.visao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.assis.andersonluis.testelanchonetedextra.Constants;
import com.assis.andersonluis.testelanchonetedextra.R;
import com.assis.andersonluis.testelanchonetedextra.adapter.IngredientAdapter;
import com.assis.andersonluis.testelanchonetedextra.component.DaggerCustomLunchComponent;
import com.assis.andersonluis.testelanchonetedextra.modelos.Ingredient;
import com.assis.andersonluis.testelanchonetedextra.modelos.Lunch;
import com.assis.andersonluis.testelanchonetedextra.module.CustomLunchModule;
import com.assis.andersonluis.testelanchonetedextra.presenter.CustomLunchPresenter;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomLunchActivity  extends BaseActivity implements CustomLunchView {

    @BindView(R.id.txt_lunch_title)
    TextView lunchName;

    @BindView(R.id.txt_lunch_price)
    TextView lunchPrice;

    @BindView(R.id.txt_lunch_ingredients)
    TextView lunchIngredients;

    @BindView(R.id.img_lunch_img)
    ImageView lunchImg;

    @BindView(R.id.list)
    RecyclerView recycler;

    @BindView(R.id.txt_order_total)
    TextView orderPrice;

    @Inject
    CustomLunchPresenter presenter;

    @Inject
    Picasso picasso;

    private IngredientAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_lunch);
        ButterKnife.bind(this);

        setTitle("Do seu Jeito");

        int lunchId = getIntent().getExtras().getInt(Constants.BUNDLE_KEY_LUNCH_ID);

        presenter.getListOfIngredients();
        presenter.getLunchInfo(lunchId);
    }

    @Override
    public void showMessageOfError(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Atencao")
                .setMessage(message)
                .setNeutralButton("OK", null)
                .show();
    }

    @Override
    public void showMessageOfSuccessOfOrder(String succ) {
        Toast.makeText(getContext(), succ, Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void showInfoLunch(Lunch lunch) {
        lunchName.setText(lunch.getName());
        lunchPrice.setText(lunch.getPrice().toString());
        lunchIngredients.setText(lunch.getIngredientListDescription());
        orderPrice.setText("TOTAL: " +lunch.getPrice().toString());

        picasso.load(lunch.getImage())
                .resize(100, 100)
                .into(lunchImg);

    }

    @Override
    public void showListOfIngredients(List<Ingredient> ingredients) {

        if(recycler.getAdapter() == null){
            adapter = new IngredientAdapter(ingredients, picasso, (IngredientAdapter.OnIngredientModifierListener) presenter);

            recycler.setAdapter(adapter);
            recycler.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    @Override
    public void showTotalPrice(BigDecimal total) {
        orderPrice.setText("R$ " + total.toString());
    }

    @OnClick(R.id.btn_finalize_order)
    public void finalizeOrder(){
        presenter.finalizeOrder();
    }

    @Override
    public void inject() {
        DaggerCustomLunchComponent.builder()
                .applicationComponent(getApp().getAppComponent())
                .customLunchModule(new CustomLunchModule(this))
                .build()
                .inject(this);
    }

}
