package com.assis.andersonluis.testelanchonetedextra.visao;

import java.util.List;

/**
 * Created by AndersonLuis on 12/04/2018.
 */

public interface LunchListView extends BaseView {

    void onShowErrorMessage(String message);

    void showListOfLunch(List<Lunch> list);
    void showOptionsOfLunch(Lunch lunch);

    void showSuccessMessageOfOrder();
    void goToCustomize(Lunch lunch);
}
