package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.modelos.Order;
import com.assis.andersonluis.testelanchonetedextra.service.BaseRequestCallback;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.visao.OrderListView;

import java.util.List;

public class OrderListPresenterImpl implements OrderListPresenter {

    private OrderListView view;
    private OrderService service;

    public OrderListPresenterImpl() {}

    public OrderListPresenterImpl(OrderService service) {
        this.service = service;
    }

    @Override
    public void getListOfOrders() {
        if(view == null)
            throw new IllegalStateException("A view deve ser setada.");

        service.getOrders(getOrdersCallback());
    }

    public BaseRequestCallback<List<Order>,RuntimeException> getOrdersCallback() {
        return new BaseRequestCallback<List<Order>, RuntimeException>() {

            @Override
            public void onSuccess(List<Order> result) {
                view.showListOfOrder(result);
            }

            @Override
            public void onErro(RuntimeException err) {
                view.onShowErrorMessage("Não foi possivel buscar a lista de pedidos");
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
    public OrderListView getView() {
        return view;
    }

    @Override
    public void setView(OrderListView view) {
        this.view = view;
    }

}
