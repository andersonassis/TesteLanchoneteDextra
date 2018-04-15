package com.assis.andersonluis.testelanchonetedextra.visao;

import java.util.List;

/**
 * Created by AndersonLuis on 12/04/2018.
 */

public interface PromoListView extends BaseView {

    void onShowErrorMessage(String message);
    void showListOfPromos(List<Promo> list);

}