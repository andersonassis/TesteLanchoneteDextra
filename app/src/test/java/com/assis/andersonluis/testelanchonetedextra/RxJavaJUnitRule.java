package com.assis.andersonluis.testelanchonetedextra;


import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class RxJavaJUnitRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                RxAndroidPlugins.reset();
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(android());

                RxJavaPlugins.reset();
                RxJavaPlugins.setComputationSchedulerHandler(rx());
                RxJavaPlugins.setIoSchedulerHandler(rx());
                RxJavaPlugins.setNewThreadSchedulerHandler(rx());

                base.evaluate();

                RxAndroidPlugins.reset();
                RxJavaPlugins.reset();
            }

        };
    }

    public static Function<Callable<Scheduler>, Scheduler> android(){
        return new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(@NonNull Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        };
    }

    public static Function<Scheduler, Scheduler> rx(){
        return new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(@NonNull Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        };
    }

}
