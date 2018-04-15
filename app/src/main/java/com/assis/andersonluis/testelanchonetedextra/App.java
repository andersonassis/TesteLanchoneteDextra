package com.assis.andersonluis.testelanchonetedextra;

import android.app.Application;

import com.assis.andersonluis.testelanchonetedextra.component.ApplicationComponent;
import com.assis.andersonluis.testelanchonetedextra.module.ApplicationModule;
import com.assis.andersonluis.testelanchonetedextra.net.NetworkUtils;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class App  extends Application {

    private ApplicationComponent app;

    @Override
    public void onCreate() {
        super.onCreate();

        Iconify.with(new FontAwesomeModule());

        NetworkUtils.init(this);

        app = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return app;
    }

}
