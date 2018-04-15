package com.assis.andersonluis.testelanchonetedextra.service;

import com.assis.andersonluis.testelanchonetedextra.model.Ingredient;

import java.util.List;

public interface IngredientService  {

    void getListOfIngredients(BaseRequestCallback<List<Ingredient>, RuntimeException> callback);
}
