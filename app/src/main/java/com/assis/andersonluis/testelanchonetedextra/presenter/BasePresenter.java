package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.visao.BaseView;

public interface BasePresenter <T extends BaseView> {

    public T getView();
    public void setView(T view);

}
