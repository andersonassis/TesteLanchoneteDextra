package com.assis.andersonluis.testelanchonetedextra.component;


import android.content.Context;

import com.assis.andersonluis.testelanchonetedextra.App;
import com.assis.andersonluis.testelanchonetedextra.api.API;
import com.assis.andersonluis.testelanchonetedextra.module.ApplicationModule;
import com.assis.andersonluis.testelanchonetedextra.module.HTTPModule;
import com.assis.andersonluis.testelanchonetedextra.module.ServiceModule;
import com.assis.andersonluis.testelanchonetedextra.service.IngredientService;
import com.assis.andersonluis.testelanchonetedextra.service.LunchService;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.service.PromoService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, HTTPModule.class, ServiceModule.class })
public interface ApplicationComponent {

    Context provideContext();
    Gson provideGson();
    Picasso providePicasso();

    API provideAPI();

    LunchService provideServiceLunch();
    OrderService provideOrderService();
    PromoService providePromoService();
    IngredientService provideIngredientService();

    void inject(App application);

}