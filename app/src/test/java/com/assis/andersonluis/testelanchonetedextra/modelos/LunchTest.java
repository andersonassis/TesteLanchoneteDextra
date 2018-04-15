package com.assis.andersonluis.testelanchonetedextra.modelos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LunchTest {

    @Mock
    private Ingredient mockIngredient;

    @Spy
    private Lunch lunch;

    private BigDecimal price = BigDecimal.ONE;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void theListOfIngredientsMustBeSeparatedByCommasIfNeeded(){
        Ingredient i1 = mock(Ingredient.class);
        Ingredient i2 = mock(Ingredient.class);

        when(i1.getName()).thenReturn("frango");
        when(i2.getName()).thenReturn("batata");

        assertEquals(lunch.getIngredientListDescription(), "");

        lunch.addIngredient(i1);

        assertEquals(lunch.getIngredientListDescription(), i1.getName());

        lunch.addIngredient(i2);

        assertEquals(lunch.getIngredientListDescription(),
                i1.getName()
                        .concat(", ")
                        .concat(i2.getName()));

        lunch.removeIngredient(i2);

        assertEquals(lunch.getIngredientListDescription(), i1.getName());
    }

    @Test
    public void priceMustBeASumOfIngredientsPrice(){
        when(mockIngredient.getPrice()).thenReturn(price);

        Lunch lunch = new Lunch();

        /*  zero ingredientes */

        assertEquals(BigDecimal.ZERO, lunch.getPrice());

        /* adicionando 1 ingrediente */

        lunch.addIngredient(mockIngredient);
        assertEquals(price, lunch.getPrice());

        /* adicionando 2 ingredientes */

        lunch.addIngredient(mockIngredient);
        assertEquals(price.multiply(BigDecimal.valueOf(2)), lunch.getPrice());
    }



}
