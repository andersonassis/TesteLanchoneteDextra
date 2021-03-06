package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.adapter.IngredientAdapter;
import com.assis.andersonluis.testelanchonetedextra.modelos.Ingredient;
import com.assis.andersonluis.testelanchonetedextra.modelos.Lunch;
import com.assis.andersonluis.testelanchonetedextra.modelos.Order;
import com.assis.andersonluis.testelanchonetedextra.service.BaseRequestCallback;
import com.assis.andersonluis.testelanchonetedextra.service.IngredientService;
import com.assis.andersonluis.testelanchonetedextra.service.LunchService;
import com.assis.andersonluis.testelanchonetedextra.service.OrderService;
import com.assis.andersonluis.testelanchonetedextra.visao.CustomLunchView;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomLunchPresenterImpl implements CustomLunchPresenter, IngredientAdapter.OnIngredientModifierListener {

    private LunchService lunchService;
    private IngredientService ingredientService;
    private OrderService orderService;

    private CustomLunchView viewteste;
    private AtomicInteger counter = new AtomicInteger(0);

    private Order order = new Order();

    public CustomLunchPresenterImpl() {}

    public CustomLunchPresenterImpl(LunchService lunchService, IngredientService ingredientService, OrderService orderService) {
        this.lunchService = lunchService;
        this.ingredientService = ingredientService;
        this.orderService = orderService;
    }

    @Override
    public void getLunchInfo(Integer id) {
        if(viewteste == null)
            throw new IllegalStateException("A view esta nula.");

        lunchService.getInfoOfLunch(id, getLunchInfoRequestCallback());
    }

    public BaseRequestCallback<Lunch, RuntimeException> getLunchInfoRequestCallback(){
        return new BaseRequestCallback<Lunch, RuntimeException>() {

            @Override
            public void onSuccess(Lunch result) {
                viewteste.showInfoLunch(result);

                order.setLunch(result);
            }

            @Override
            public void onErro(RuntimeException err) {
                viewteste.showMessageOfError("erro ao buscar as informações ");
            }

            @Override
            public void onStart() {
                counter.incrementAndGet();
                viewteste.onShowLoading();

            }

            @Override
            public void onEnd() {
                if(counter.decrementAndGet() == 0)
                    viewteste.onDismissLoading();
            }

        };
    }

    @Override
    public void getListOfIngredients() {
        if(viewteste == null)
            throw new IllegalStateException("A view esta nula.");

        ingredientService.getListOfIngredients(getListOfIngredientsRequestCallback());
    }

    public BaseRequestCallback<List<Ingredient>, RuntimeException> getListOfIngredientsRequestCallback(){
        return new BaseRequestCallback<List<Ingredient>, RuntimeException>() {

            @Override
            public void onSuccess(List<Ingredient> result) {
                viewteste.showListOfIngredients(result);
            }

            @Override
            public void onErro(RuntimeException err) {
                viewteste.showMessageOfError("Não foi possivel listar os ingredientes.");
            }

            @Override
            public void onStart() {
                counter.incrementAndGet();
                viewteste.onShowLoading();
            }

            @Override
            public void onEnd() {
                if(counter.decrementAndGet() == 0)
                    viewteste.onDismissLoading();
            }

        };
    }

    @Override
    public void finalizeOrder() {
        orderService.createOrder(order, getOrderCreateRequest());
    }

    public BaseRequestCallback<Order, RuntimeException> getOrderCreateRequest(){
        return new BaseRequestCallback<Order, RuntimeException>() {

            @Override
            public void onSuccess(Order result) {
                viewteste.showMessageOfSuccessOfOrder("Pedido solicitado com sucesso.");
            }

            @Override
            public void onErro(RuntimeException err) {
                viewteste.showMessageOfError("Ocorreu um erro ao finalizar o pedido.");
            }

            @Override
            public void onStart() {
                viewteste.onShowLoading();
            }

            @Override
            public void onEnd() {
                viewteste.onDismissLoading();
            }

        };
    }

    @Override
    public void increase(int times, Ingredient ingredient) {
        for (int i = 0; i < times; i++) order.addIngredient(ingredient);

        viewteste.showTotalPrice(order.getFinalPrice());
    }

    @Override
    public void decrease(int times, Ingredient ingredient) {
        for (int i = 0; i < times; i++) order.removeIngredient(ingredient);

        viewteste.showTotalPrice(order.getFinalPrice());
    }

    public Order getOrder() {
        return order;
    }

    public CustomLunchView getView() {
        return viewteste;
    }

    public void setView(CustomLunchView view) {
        this.viewteste = view;
    }

    public IngredientService getIngredientService() {
        return ingredientService;
    }

    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public LunchService getLunchService() {
        return lunchService;
    }

    public void setLunchService(LunchService lunchService) {
        this.lunchService = lunchService;
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}
