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
import com.assis.andersonluis.testelanchonetedextra.adapter.PromoListAdapter;
import com.assis.andersonluis.testelanchonetedextra.modelos.Promo;
import com.assis.andersonluis.testelanchonetedextra.presenter.PromoListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentPromoListView  extends BaseFragment implements PromoListView {

    @BindView(R.id.list)
    RecyclerView recycler;

    private PromoListAdapter adapter;
    private PromoListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("Lista de Promoções");
        presenter.getListOfPromo();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.recycler, container, false);
        ButterKnife.bind(this, inflated);

        return inflated;
    }

    @Override
    public void onShowLoading() {
        startProgress();
    }

    @Override
    public void onDismissLoading() {
        stopProgress();
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
    public void showListOfPromos(List<Promo> list) {
        if(recycler.getAdapter() == null){
            adapter = new PromoListAdapter(list);

            recycler.setLayoutManager(new LinearLayoutManager(getContext()));
            recycler.setAdapter(adapter);
        }
    }

    public PromoListPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(PromoListPresenter presenter) {
        this.presenter = presenter;
    }

}