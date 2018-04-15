package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.modelos.Lunch;
import com.assis.andersonluis.testelanchonetedextra.visao.LunchListView;

public interface LunchListPresenter  extends BasePresenter<LunchListView> {

    public void getListOfLunch();

    public void onSelectAnLunchOfList(Lunch item);
    public void onMakeOrder(Lunch lunch);

}
