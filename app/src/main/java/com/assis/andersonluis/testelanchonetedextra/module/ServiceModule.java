package com.assis.andersonluis.testelanchonetedextra.module;


import com.assis.andersonluis.testelanchonetedextra.api.API;
import com.assis.andersonluis.testelanchonetedextra.service.IngredientService;
import com.assis.andersonluis.testelanchonetedextra.service.IngredientServiceRESTImpl;
import com.assis.andersonluis.testelanchonetedextra.service.LunchService;
import com.assis.andersonluis.testelanchonetedextra.service.LunchServiceRESTImpl;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.service.OrderServiceRESTImpl;
import com.assis.andersonluis.testelanchonetedextra.service.PromoService;
import com.assis.andersonluis.testelanchonetedextra.service.PromoServiceRESTImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    public LunchService provideServiceLunch(API api){
        return new LunchServiceRESTImpl(api);
    }

    @Singleton @Provides
    public OrderService provideOrderService(API api){
        return new OrderServiceRESTImpl(api);
    }

    @Singleton @Provides
    public PromoService providePromoService(API api){
        return new PromoServiceRESTImpl(api);
    }

    @Singleton @Provides
    public IngredientService provideIngredientService(API api){
        return new IngredientServiceRESTImpl(api);
    }

}
