package com.assis.andersonluis.testelanchonetedextra.adapter;

import com.assis.andersonluis.testelanchonetedextra.modelos.Ingredient;
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
import com.assis.andersonluis.testelanchonetedextra.BuildConfig;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static com.assis.andersonluis.testelanchonetedextra.adapter.IngredientAdapter.*;



@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class IngredientAdapterTest {

    @Mock
    private Picasso mockPicasso;

    @Mock
    private OnIngredientModifierListener listener;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void theSizeOfAdapterMustBeTheSameSizeOfList(){
        List<Ingredient> mockList = mock(List.class);
        when(mockList.size()).thenReturn(15);

        IngredientAdapter adapter = new IngredientAdapter(mockList, mockPicasso, listener);
        Assert.assertEquals(mockList.size(), adapter.getItemCount());

    }

}

