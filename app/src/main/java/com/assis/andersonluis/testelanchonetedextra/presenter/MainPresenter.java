package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.visao.MainView;

public interface MainPresenter  extends BasePresenter<MainView> {

    public void showListOfLunchs();
    public void showListOfOrders();
    public void showListOfPromos();

}