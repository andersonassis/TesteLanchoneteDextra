package com.assis.andersonluis.testelanchonetedextra.service;

import com.assis.andersonluis.testelanchonetedextra.RxJavaJUnitRule;
import com.assis.andersonluis.testelanchonetedextra.api.API;
import com.assis.andersonluis.testelanchonetedextra.api.response.PromoResponseVO;
import com.assis.andersonluis.testelanchonetedextra.modelos.Promo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PromoServiceRESTImplTest {

    @Rule
    public RxJavaJUnitRule rule = new RxJavaJUnitRule();

    @Mock
    private API mockApi;

    @Mock
    private BaseRequestCallback<List<Promo>, RuntimeException> mockCallback;

    @Spy
    private PromoServiceRESTImpl mockService;

    @Captor
    private ArgumentCaptor<List<Promo>> captor;

    private Throwable exception = new RuntimeException("ERROR");

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        mockService.setApi(mockApi);
    }

    @Test
    public void afterSuccessOfRequestTheCallbackMethodOnSuccessMustBeCalledWithListOfPromos(){
        List<PromoResponseVO> result = Arrays.asList(new PromoResponseVO(), new PromoResponseVO());

        when(mockApi.getPromos()).thenReturn(Observable.just(result));

        mockService.getListOfPromos(mockCallback);

        verify(mockCallback).onStart();
        verify(mockCallback).onSuccess(captor.capture());
        verify(mockCallback).onEnd();

        Assert.assertEquals(result.size(), captor.getValue().size());
    }

    @Test
    public void afterAnErrorOfRequestTheCallbackMethodOnErrorMustBeCalled(){
        Observable<List<PromoResponseVO>> error = Observable.error(exception);
        when(mockApi.getPromos()).thenReturn(error);

        mockService.getListOfPromos(mockCallback);

        verify(mockCallback).onStart();
        verify(mockCallback).onErro(any(RuntimeException.class));
        verify(mockCallback).onEnd();
    }

}

