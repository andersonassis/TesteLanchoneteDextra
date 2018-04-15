package com.assis.andersonluis.testelanchonetedextra.service;

import com.assis.andersonluis.testelanchonetedextra.model.Promo;

import java.util.List;

public interface PromoService  {

    void getListOfPromos(BaseRequestCallback<List<Promo>, RuntimeException> callback);
}
