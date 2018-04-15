package com.assis.andersonluis.testelanchonetedextra.visao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assis.andersonluis.testelanchonetedextra.R;
import com.assis.andersonluis.testelanchonetedextra.adaptadores.OrderListAdapter;
import com.assis.andersonluis.testelanchonetedextra.modelos.Order;
import com.assis.andersonluis.testelanchonetedextra.presenter.OrderListPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentOrderListView  extends BaseFragment implements OrderListView {

    @BindView(R.id.list)
    RecyclerView recycler;

    private Picasso picasso;

    private OrderListPresenter presenter;
    private OrderListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("Lista de Pedidos");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.recycler, container, false);
        ButterKnife.bind(this, inflated);

        return inflated;
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.getListOfOrders();
    }

    @Override
    public void onShowErrorMessage(String message) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Atencao")
                .setMessage(message)
                .setNeutralButton("OK", null)
                .show();
    }

    @Override
    public void showListOfOrder(List<Order> list) {

        if(recycler.getAdapter() == null){
            adapter = new OrderListAdapter(list, picasso);

            recycler.setLayoutManager(new LinearLayoutManager(getContext()));
            recycler.setAdapter(adapter);
        }

    }

    public OrderListPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(OrderListPresenter presenter) {
        this.presenter = presenter;
    }

    public Picasso getPicasso() {
        return picasso;
    }

    public void setPicasso(Picasso picasso) {
        this.picasso = picasso;
    }

}
