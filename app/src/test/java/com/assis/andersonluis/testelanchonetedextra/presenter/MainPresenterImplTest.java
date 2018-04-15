package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.visao.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterImplTest {

    @Spy
    private MainPresenterImpl presenter;

    @Mock
    private MainView mockView;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        presenter.setView(mockView);
    }

    @Test
    public void whenShowOfListOfLunchsMethodIsCalledTheViewMustOpenListOfLunchsFragment(){
        presenter.showListOfLunchs();

        Mockito.verify(mockView).showListOfLunchsFragment();
    }

    @Test
    public void whenShowOfListOfPromosMethodIsCalledTheViewMustOpenListOfPromosFragment(){
        presenter.showListOfPromos();

        Mockito.verify(mockView).showListOfPromosFragment();
    }

    @Test
    public void whenShowOfListOfOrdersMethodIsCalledTheViewMustOpenListOfOrdersFragment(){
        presenter.showListOfOrders();

        Mockito.verify(mockView).showListOfOrdersFragment();
    }

}