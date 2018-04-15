package com.assis.andersonluis.testelanchonetedextra.component;


import com.assis.andersonluis.testelanchonetedextra.module.MainModule;
import com.assis.andersonluis.testelanchonetedextra.presenter.MainPresenter;
import com.assis.andersonluis.testelanchonetedextra.visao.LunchListView;
import com.assis.andersonluis.testelanchonetedextra.visao.MainActivity;
import com.assis.andersonluis.testelanchonetedextra.visao.OrderListView;
import com.assis.andersonluis.testelanchonetedextra.visao.PromoListView;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainViewComponent {

    MainPresenter provideMainPresenter();

    LunchListView provideLunchView();
    OrderListView provideOrderView();
    PromoListView providePromoView();

    public void inject(MainActivity activity);

}
