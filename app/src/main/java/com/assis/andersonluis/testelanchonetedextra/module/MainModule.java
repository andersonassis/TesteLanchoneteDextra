package com.assis.andersonluis.testelanchonetedextra.module;


import com.assis.andersonluis.testelanchonetedextra.component.ActivityScope;
import com.assis.andersonluis.testelanchonetedextra.presenter.LunchListPresenter;
import com.assis.andersonluis.testelanchonetedextra.presenter.LunchListPresenterImpl;
import com.assis.andersonluis.testelanchonetedextra.presenter.MainPresenter;
import com.assis.andersonluis.testelanchonetedextra.presenter.MainPresenterImpl;
import com.assis.andersonluis.testelanchonetedextra.presenter.OrderListPresenter;
import com.assis.andersonluis.testelanchonetedextra.presenter.OrderListPresenterImpl;
import com.assis.andersonluis.testelanchonetedextra.presenter.PromoListPresenter;
import com.assis.andersonluis.testelanchonetedextra.presenter.PromoListPresenterImpl;
import com.assis.andersonluis.testelanchonetedextra.service.LunchService;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.service.PromoService;
import com.assis.andersonluis.testelanchonetedextra.visao.FragmentLunchListView;
import com.assis.andersonluis.testelanchonetedextra.visao.FragmentOrderListView;
import com.assis.andersonluis.testelanchonetedextra.visao.FragmentPromoListView;
import com.assis.andersonluis.testelanchonetedextra.visao.LunchListView;
import com.assis.andersonluis.testelanchonetedextra.visao.MainView;
import com.assis.andersonluis.testelanchonetedextra.visao.OrderListView;
import com.assis.andersonluis.testelanchonetedextra.visao.PromoListView;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }




    @ActivityScope
    @Provides
    public MainPresenter provideMainPresenter(){
        return new MainPresenterImpl(view);
    }

    /* lunch */

    @Provides @ActivityScope
    public LunchListView provideLunchListView(LunchListPresenter presenter, Picasso picasso){
        FragmentLunchListView view = new FragmentLunchListView();
        view.setPresenter(presenter);
        view.setPicasso(picasso);

        presenter.setView(view);
        return view;
    }

    @Provides @ActivityScope
    public LunchListPresenter provideLunchListPresenter(LunchService service, OrderService orderService){
        return new LunchListPresenterImpl(service, orderService);
    }

    /* promo */

    @Provides @ActivityScope
    public PromoListView providePromoListView(PromoListPresenter presenter){
        FragmentPromoListView view = new FragmentPromoListView();
        view.setPresenter(presenter);

        presenter.setView(view);
        return view;
    }

    @Provides @ActivityScope
    public PromoListPresenter providePromoListPresenter(PromoService service){
        return new PromoListPresenterImpl(service);
    }

    /* orders */

    @Provides @ActivityScope
    public OrderListView provideOrderListView(OrderListPresenter presenter, Picasso picasso){
        FragmentOrderListView view = new FragmentOrderListView();
        view.setPresenter(presenter);
        view.setPicasso(picasso);

        presenter.setView(view);

        return view;
    }

    @Provides @ActivityScope
    public OrderListPresenter provideOrderListPresenter(OrderService service){
        return new OrderListPresenterImpl(service);
    }

}
