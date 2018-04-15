package com.assis.andersonluis.testelanchonetedextra.adaptadores;


import com.assis.andersonluis.testelanchonetedextra.BuildConfig;
import com.assis.andersonluis.testelanchonetedextra.modelos.Lunch;
import com.assis.andersonluis.testelanchonetedextra.presenter.LunchListPresenter;
import com.assis.andersonluis.testelanchonetedextra.visao.LunchListView;
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
public class LunchListAdapterTest {

    @Mock
    private LunchListPresenter mockPresenter;

    @Mock
    private Picasso mockPicasso;

    @Mock
    private LunchListView mockView;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void theSizeOfAdapterMustBeTheSameSizeOfList(){
        List<Lunch> mockList = mock(List.class);
        when(mockList.size()).thenReturn(15);

        LunchListAdapter adapter = new LunchListAdapter(mockPresenter, mockPicasso, mockList);
        Assert.assertEquals(mockList.size(), adapter.getItemCount());
    }

}