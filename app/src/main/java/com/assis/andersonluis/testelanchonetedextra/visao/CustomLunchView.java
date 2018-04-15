package com.assis.andersonluis.testelanchonetedextra.visao;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by AndersonLuis on 12/04/2018.
 */

public interface CustomLunchView {

    public void showMessageOfError(String err);
    public void showMessageOfSuccessOfOrder(String succ);

    public void showInfoLunch(Lunch lunch);
    public void showListOfIngredients(List<Ingredient> ingredients);
    public void showTotalPrice(BigDecimal total);




}
