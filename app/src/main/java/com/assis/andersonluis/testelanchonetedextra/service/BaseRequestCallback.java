package com.assis.andersonluis.testelanchonetedextra.service;

public interface BaseRequestCallback <T, E> {

    void onSuccess(T result);
    void onErro(E err);
    void onStart();
    void onEnd();


}
