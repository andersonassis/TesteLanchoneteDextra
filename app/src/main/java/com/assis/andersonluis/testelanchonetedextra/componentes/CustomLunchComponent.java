package com.assis.andersonluis.testelanchonetedextra.componentes;


import com.assis.andersonluis.testelanchonetedextra.module.CustomLunchModule;
import com.assis.andersonluis.testelanchonetedextra.presenter.CustomLunchPresenter;
import com.assis.andersonluis.testelanchonetedextra.visao.CustomLunchActivity;

import dagger.Component;

@ActivityScope
@Component(modules = CustomLunchModule.class, dependencies = ApplicationComponent.class)
public interface CustomLunchComponent {

    CustomLunchPresenter provideCustomLunchPresenter();

    public void inject(CustomLunchActivity activity);

}
