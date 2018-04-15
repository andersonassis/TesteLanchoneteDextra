package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.modelos.Promo;
import com.assis.andersonluis.testelanchonetedextra.service.BaseRequestCallback;
import com.assis.andersonluis.testelanchonetedextra.service.PromoService;
import com.assis.andersonluis.testelanchonetedextra.visao.PromoListView;

import java.util.List;

public class PromoListPresenterImpl  implements PromoListPresenter {

    private PromoService service;
    private PromoListView view;

    public PromoListPresenterImpl() {}

    public PromoListPresenterImpl(PromoService service) {
        this.service = service;
    }

    @Override
    public void getListOfPromo() {
        if (view == null)
            throw new IllegalStateException("A view não foi setada para a classe: " + getClass().getName());

        service.getListOfPromos(getCallback());
    }

    public BaseRequestCallback<List<Promo>,RuntimeException> getCallback() {
        return new BaseRequestCallback<List<Promo>, RuntimeException>() {

            @Override
            public void onSuccess(List<Promo> result) {
                view.showListOfPromos(result);
            }

            @Override
            public void onErro(RuntimeException err) {
                view.onShowErrorMessage("Não foi possivel buscar as promoções");
            }

            @Override
            public void onStart() {
                view.onShowLoading();
            }

            @Override
            public void onEnd() {
                view.onDismissLoading();
            }

        };
    }

    @Override
    public PromoListView getView() {
        return getView();
    }

    @Override
    public void setView(PromoListView view) {
        this.view = view;
    }

}
