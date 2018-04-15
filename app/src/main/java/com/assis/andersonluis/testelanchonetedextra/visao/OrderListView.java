package com.assis.andersonluis.testelanchonetedextra.visao;

import com.assis.andersonluis.testelanchonetedextra.modelos.Order;

import java.util.List;

/**
 * Created by AndersonLuis on 12/04/2018.
 */

public interface OrderListView extends BaseView {

    void onShowErrorMessage(String message);
    void showListOfOrder(List<Order> list);

}