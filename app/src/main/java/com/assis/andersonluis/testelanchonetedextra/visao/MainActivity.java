package com.assis.andersonluis.testelanchonetedextra.visao;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.assis.andersonluis.testelanchonetedextra.R;
import com.assis.andersonluis.testelanchonetedextra.componentes.DaggerMainViewComponent;
import com.assis.andersonluis.testelanchonetedextra.module.MainModule;
import com.assis.andersonluis.testelanchonetedextra.presenter.MainPresenter;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import org.json.JSONArray;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView navigation;

    @Inject
    LunchListView lunchs;

    @Inject
    OrderListView orders;

    @Inject
    PromoListView promos;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configureColorOfIconsAtNavbar();

        JSONArray json = new JSONArray();
        json.put(1);
        json.put(2);
        json.put(3);
        json.put(4);

        Log.i("INFO", "json: " + json.toString());

        navigation.setOnNavigationItemSelectedListener(getNavigationListener());
        navigation.setSelectedItemId(R.id.lanches);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener getNavigationListener(){
        return new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                configureColorOfIconsAtNavbar();

                switch (item.getItemId()){
                    case R.id.lanches:
                        onClickListOfLunchsOption();
                        item.setIcon(getLunchIcon(android.R.color.white));
                        break;
                    case R.id.pedidos:
                        onClickListOfOrdersOption();
                        item.setIcon(getOrderIcon(android.R.color.white));
                        break;
                    case R.id.promocao:
                        onClickListOfPromosOption();
                        item.setIcon(getPromoIcon(android.R.color.white));
                        break;
                }

                return true;
            }

        };
    }

    @Override
    public void onClickListOfLunchsOption() {
        presenter.showListOfLunchs();
    }

    @Override
    public void onClickListOfPromosOption() {
        presenter.showListOfPromos();
    }

    @Override
    public void onClickListOfOrdersOption() {
        presenter.showListOfOrders();
    }

    @Override
    public void showListOfLunchsFragment() {
        show((Fragment) lunchs);
    }

    @Override
    public void showListOfPromosFragment() {
        show((Fragment) promos);
    }

    @Override
    public void showListOfOrdersFragment() {
        show((Fragment) orders);
    }

    public void show(Fragment fragment){
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        tx.replace(R.id.main_container, fragment);
        tx.commit();
    }

    @Override
    public void inject() {
        DaggerMainViewComponent.builder()
                .applicationComponent(getApp().getAppComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);
    }

    public void configureColorOfIconsAtNavbar(){
        navigation.getMenu()
                .findItem(R.id.lanches)
                .setIcon(getLunchIcon(android.R.color.darker_gray));
        navigation.getMenu()
                .findItem(R.id.pedidos)
                .setIcon(getOrderIcon(android.R.color.darker_gray));
        navigation.getMenu()
                .findItem(R.id.promocao)
                .setIcon(getPromoIcon(android.R.color.darker_gray));
    }

    public IconDrawable getOrderIcon(int color){
        return new IconDrawable(this, FontAwesomeIcons.fa_shopping_cart)
                .actionBarSize()
                .colorRes(color);
    }

    public IconDrawable getLunchIcon(int color){
        return new IconDrawable(this, FontAwesomeIcons.fa_list)
                .actionBarSize()
                .colorRes(color);
    }

    public IconDrawable getPromoIcon(int color){
        return new IconDrawable(this, FontAwesomeIcons.fa_smile_o)
                .actionBarSize()
                .colorRes(color);
    }

}
