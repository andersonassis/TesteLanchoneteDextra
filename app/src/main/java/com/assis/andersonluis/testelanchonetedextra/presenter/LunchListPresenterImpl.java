package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.modelos.Lunch;
import com.assis.andersonluis.testelanchonetedextra.modelos.Order;
import com.assis.andersonluis.testelanchonetedextra.service.BaseRequestCallback;
import com.assis.andersonluis.testelanchonetedextra.service.LunchService;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.visao.LunchListView;

import java.util.List;

import javax.inject.Inject;

public class LunchListPresenterImpl implements LunchListPresenter {

    private LunchService service;
    private LunchListView view;
    private OrderService orderService;

    public LunchListPresenterImpl() {}

    @Inject
    public LunchListPresenterImpl(LunchService service, OrderService orderService) {
        this.service = service;
        this.orderService = orderService;
    }

    @Override
    public void getListOfLunch() {
        if(view == null)
            throw new IllegalStateException("A view não foi setada para a classe: " + getClass().getName());

        service.getListOfLunchs(getOnRequestListOfLunchsFinishedCallback());
    }

    public BaseRequestCallback<List<Lunch>,RuntimeException> getOnRequestListOfLunchsFinishedCallback() {
        return new BaseRequestCallback<List<Lunch>, RuntimeException>() {

            @Override
            public void onSuccess(List<Lunch> result) {
                view.showListOfLunch(result);
            }

            @Override
            public void onErro(RuntimeException err) {
                view.onShowErrorMessage("Desculpe. Não foi possivel carregar a lista de lanches.");
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
    public void onMakeOrder(Lunch lunch) {
        orderService.createOrder(new Order(lunch), getOnRequestOrderFinishedCallback());
    }

    public BaseRequestCallback<Order,RuntimeException> getOnRequestOrderFinishedCallback(){
        return new BaseRequestCallback<Order, RuntimeException>() {

            @Override
            public void onSuccess(Order result) {
                view.showSuccessMessageOfOrder();
            }

            @Override
            public void onErro(RuntimeException err) {
                view.onShowErrorMessage("Não foi possivel concluir o pedido. ");
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
    public void onSelectAnLunchOfList(Lunch item) {
        view.showOptionsOfLunch(item);
    }

    @Override
    public LunchListView getView() {
        return view;
    }

    @Override
    public void setView(LunchListView view) {
        this.view = view;
    }

    public void setService(LunchService service) {
        this.service = service;
    }

    public LunchService getService() {
        return service;
    }

}
