package com.assis.andersonluis.testelanchonetedextra.adaptadores;


import com.assis.andersonluis.testelanchonetedextra.BuildConfig;
import com.assis.andersonluis.testelanchonetedextra.modelos.Promo;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class PromoListAdapterTest {

    @Test
    public void theSizeOfAdapterMustBeTheSameSizeOfList(){
        List<Promo> mockList = mock(List.class);
        when(mockList.size()).thenReturn(15);

        PromoListAdapter adapter = new PromoListAdapter(mockList);
        Assert.assertEquals(mockList.size(), adapter.getItemCount());
    }

}
