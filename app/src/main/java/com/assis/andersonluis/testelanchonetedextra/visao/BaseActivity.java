package com.assis.andersonluis.testelanchonetedextra.visao;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.assis.andersonluis.testelanchonetedextra.App;
import com.assis.andersonluis.testelanchonetedextra.util.ProgressManager;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressManager manager;

    public App getApp(){
        return (App) getApplication();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        manager = new ProgressManager(this);

        if(!isTaskRoot()){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        inject();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return super.onSupportNavigateUp();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onShowLoading() {
        startProgress();
    }

    @Override
    public void onDismissLoading() {
        stopProgress();
    }

    public synchronized void startProgress(){
        if(!manager.getDialog().isShowing()) manager.show();
    }

    public synchronized void stopProgress(){
        if(manager.getDialog().isShowing()) manager.dismiss();
    }

    public abstract void inject();

}