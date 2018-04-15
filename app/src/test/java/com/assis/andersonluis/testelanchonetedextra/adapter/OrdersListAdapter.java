package com.assis.andersonluis.testelanchonetedextra.adapter;


import com.assis.andersonluis.testelanchonetedextra.BuildConfig;
import com.assis.andersonluis.testelanchonetedextra.modelos.Order;
import com.squareup.picasso.Picasso;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class OrdersListAdapter {

    @Mock
    private Picasso picasso;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void theSizeOfAdapterMustBeTheSameSizeOfList() {
        List<Order> mockList = mock(List.class);
        when(mockList.size()).thenReturn(15);

        OrderListAdapter adapter = new OrderListAdapter(mockList, picasso);
        Assert.assertEquals(mockList.size(), adapter.getItemCount());
    }

}
