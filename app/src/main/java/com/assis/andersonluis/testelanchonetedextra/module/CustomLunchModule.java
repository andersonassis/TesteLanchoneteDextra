package com.assis.andersonluis.testelanchonetedextra.module;

import com.assis.andersonluis.testelanchonetedextra.component.ActivityScope;
import com.assis.andersonluis.testelanchonetedextra.presenter.CustomLunchPresenter;
import com.assis.andersonluis.testelanchonetedextra.presenter.CustomLunchPresenterImpl;
import com.assis.andersonluis.testelanchonetedextra.service.IngredientService;
import com.assis.andersonluis.testelanchonetedextra.service.LunchService;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.visao.CustomLunchView;

import dagger.Module;
import dagger.Provides;
@Module
public class CustomLunchModule  {

    private final CustomLunchView view;

    public CustomLunchModule(CustomLunchView view) {
        this.view = view;
    }

    @Provides @ActivityScope
    public CustomLunchPresenter providePresenter(LunchService lunchService, IngredientService ingredientService, OrderService orderService){
        CustomLunchPresenterImpl presenter = new CustomLunchPresenterImpl(lunchService, ingredientService, orderService);
        presenter.setView(view);

        return presenter;
    }
}
