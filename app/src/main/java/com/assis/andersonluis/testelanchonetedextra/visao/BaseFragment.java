package com.assis.andersonluis.testelanchonetedextra.visao;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.assis.andersonluis.testelanchonetedextra.App;

public class BaseFragment extends Fragment implements BaseView {

    private ProgressManager manager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        manager = new ProgressManager(getActivity());
    }

    public ApplicationComponent getAppComponent(){
        App app = (App) getActivity().getApplication();
        return app.getAppComponent();
    }

    public void startProgress(){
        manager.show();
    }

    public void stopProgress(){
        manager.dismiss();
    }

    @Override
    public void onShowLoading() {
        startProgress();
    }

    @Override
    public void onDismissLoading() {
        stopProgress();
    }

}