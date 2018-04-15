package com.assis.andersonluis.testelanchonetedextra.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils  {

    private static Context context;

    public static void init(Context ctx){
        context = ctx;
    }

    public static boolean isConnected(){
        if(context == null)
            throw new IllegalStateException("É necessário inicializar o o utilitário de rede: " + NetworkUtils.class.getCanonicalName());

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
