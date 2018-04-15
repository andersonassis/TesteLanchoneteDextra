package com.assis.andersonluis.testelanchonetedextra.visao;

/**
 * Created by AndersonLuis on 12/04/2018.
 */

public interface MainView extends BaseView {

    void onClickListOfLunchsOption();
    void onClickListOfOrdersOption();
    void onClickListOfPromosOption();

    void showListOfLunchsFragment();
    void showListOfOrdersFragment();
    void showListOfPromosFragment();

}