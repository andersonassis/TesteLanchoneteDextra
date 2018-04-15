package com.assis.andersonluis.testelanchonetedextra.service;

import com.assis.andersonluis.testelanchonetedextra.modelos.Ingredient;

import java.util.List;

public interface IngredientService  {

    void getListOfIngredients(BaseRequestCallback<List<Ingredient>, RuntimeException> callback);
}
