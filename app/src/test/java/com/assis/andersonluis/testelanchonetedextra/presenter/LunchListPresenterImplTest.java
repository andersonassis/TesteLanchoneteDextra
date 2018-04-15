package com.assis.andersonluis.testelanchonetedextra.presenter;

import com.assis.andersonluis.testelanchonetedextra.modelos.Lunch;
import com.assis.andersonluis.testelanchonetedextra.modelos.Order;
import com.assis.andersonluis.testelanchonetedextra.visao.LunchListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LunchListPresenterImplTest {

    @Mock
    private LunchListView mockView;

    @Spy
    private LunchListPresenterImpl presenter;

    @Test(expected = IllegalStateException.class)
    public void whenViewIsNotSetTheMethodGetListOfPromoMustThrowAnException(){
        presenter.getListOfLunch();
    }

    @Test
    public void whenServiceStartTheRequestOfAnOrderTheViewMustShowProgress(){
        presenter.setView(mockView);

        presenter.getOnRequestOrderFinishedCallback().onStart();
        verify(mockView).onShowLoading();
    }

    @Test
    public void whenServiceEndTheRequestOfAnOrderTheViewMustRemoveTheProgress(){
        presenter.setView(mockView);

        presenter.getOnRequestOrderFinishedCallback().onEnd();
        verify(mockView).onDismissLoading();
    }

    @Test
    public void whenServiceEndTheRequestOfAnOrderWithSuccessTheViewMustShowAnSuccessMessage(){
        presenter.setView(mockView);

        presenter.getOnRequestOrderFinishedCallback().onSuccess(mock(Order.class));
        verify(mockView).showSuccessMessageOfOrder();
    }

    @Test
    public void whenServiceEndTheRequestOfAnOrderWithErrorTheViewMustShowAnErrorMessage(){
        presenter.setView(mockView);

        presenter.getOnRequestOrderFinishedCallback().onErro(any(RuntimeException.class));
        verify(mockView).onShowErrorMessage(anyString());
    }

    @Test
    public void whenServiceStartsTheRequestOfListOfLunchsTheViewMustShowProgress(){
        presenter.setView(mockView);

        presenter.getOnRequestListOfLunchsFinishedCallback().onStart();
        verify(mockView).onShowLoading();
    }

    @Test
    public void whenServiceEndTheRequestOfListOfLunchsTheViewMustRemoveTheProgress(){
        presenter.setView(mockView);

        presenter.getOnRequestListOfLunchsFinishedCallback().onEnd();
        verify(mockView).onDismissLoading();
    }

    @Test
    public void whenServiceEndTheRequestOfListOfLunchsWithSuccessTheViewMustShowTheListOfItens(){
        presenter.setView(mockView);

        presenter.getOnRequestListOfLunchsFinishedCallback().onSuccess(anyList());
        verify(mockView).showListOfLunch(anyList());
    }

    @Test
    public void whenServiceEndTheRequestOfListOfLunchsReturnWithErrorTheViewMustShowAnErrorMessage(){
        presenter.setView(mockView);

        presenter.getOnRequestListOfLunchsFinishedCallback().onErro(any(RuntimeException.class));
        verify(mockView).onShowErrorMessage(anyString());
    }

    @Test
    public void whenAnItemIsSelectedTheViewMustShowOptions(){
        presenter.setView(mockView);

        presenter.onSelectAnLunchOfList(any(Lunch.class));
        verify(mockView).showOptionsOfLunch(any(Lunch.class));
    }


}
