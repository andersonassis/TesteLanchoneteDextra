package com.assis.andersonluis.testelanchonetedextra.util;

import android.app.Activity;
import android.app.ProgressDialog;

public class ProgressManager  {
    private Activity activity;
    private ProgressDialog dialog;

    public ProgressManager(Activity context) {
        this.activity = (Activity) context;
        this.dialog = new ProgressDialog(context);
    }

    public synchronized void show() {
        dialog.setTitle("Atenção!!!");
        dialog.setMessage("Aguarde baixando os dados");

        if(!activity.isFinishing())
            dialog.show();
    }

    public synchronized void dismiss() {
        if(dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    public synchronized ProgressDialog getDialog() {
        return dialog;
    }

}
