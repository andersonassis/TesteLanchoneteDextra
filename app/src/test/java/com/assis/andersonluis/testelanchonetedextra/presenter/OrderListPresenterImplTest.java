package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.visao.OrderListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderListPresenterImplTest {

    @Mock
    private OrderListView mockView;

    @Spy
    private OrderListPresenterImpl presenter;

    @Test(expected = IllegalStateException.class)
    public void whenViewIsNotSetTheMethodGetListOfPromoMustThrowAnException(){
        presenter.getListOfOrders();
    }

    @Test
    public void whenServiceStartsTheRequestTheViewMustShowProgress(){
        presenter.setView(mockView);

        presenter.getOrdersCallback().onStart();
        Mockito.verify(mockView).onShowLoading();
    }

    @Test
    public void whenServiceEndTheRequestTheViewMustRemoveTheProgress(){
        presenter.setView(mockView);

        presenter.getOrdersCallback().onEnd();
        Mockito.verify(mockView).onDismissLoading();
    }

    @Test
    public void whenServiceReturnWithSuccessTheViewMustShowTheListOfItens(){
        presenter.setView(mockView);

        presenter.getOrdersCallback().onSuccess(Mockito.anyList());
        Mockito.verify(mockView).showListOfOrder(Mockito.anyList());
    }

    @Test
    public void whenServiceReturnWithErrorTheViewMustShowAnErrorMessage(){
        presenter.setView(mockView);

        presenter.getOrdersCallback().onErro(Mockito.any(RuntimeException.class));
        Mockito.verify(mockView).onShowErrorMessage(Mockito.anyString());
    }

}
