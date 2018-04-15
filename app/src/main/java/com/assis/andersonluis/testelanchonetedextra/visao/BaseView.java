package com.assis.andersonluis.testelanchonetedextra.visao;

import android.content.Context;

/**
 * Created by AndersonLuis on 12/04/2018.
 */

public interface BaseView {

    void onShowLoading();
    void onDismissLoading();
    Context getContext();

}
