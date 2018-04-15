package com.assis.andersonluis.testelanchonetedextra.service;

import com.assis.andersonluis.testelanchonetedextra.model.Lunch;

import java.util.List;

public interface LunchService  {

    void getListOfLunchs(final BaseRequestCallback<List<Lunch>, RuntimeException> callback);
    void getInfoOfLunch(Integer id, final BaseRequestCallback<Lunch, RuntimeException> callback);


}
