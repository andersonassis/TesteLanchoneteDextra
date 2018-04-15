package com.assis.andersonluis.testelanchonetedextra.visao;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.assis.andersonluis.testelanchonetedextra.BuildConfig;
import com.assis.andersonluis.testelanchonetedextra.R;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void whenMainActivityStartsTheOptionSelectedOnBottomBarMustBeTheLunchList(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Assert.assertEquals(activity.navigation.getSelectedItemId(), R.id.lanches);
    }

    @Test
    public void whenMainActivityStartsTheFragmentWithListOfLunchsMustBePresented(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Assert.assertEquals(((Fragment) activity.lunchs).isVisible(), true);
        Assert.assertEquals(((Fragment) activity.promos).isVisible(), false);
        Assert.assertEquals(((Fragment) activity.orders).isVisible(), false);
    }

    @Test
    public void whenSelectTheListOfLunchOptionTheListOfLunchsMustBePresented(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.navigation.setSelectedItemId(R.id.pedidos);
        activity.navigation.setSelectedItemId(R.id.lanches);

        Assert.assertEquals(((Fragment) activity.lunchs).isVisible(), true);
        Assert.assertEquals(((Fragment) activity.promos).isVisible(), false);
        Assert.assertEquals(((Fragment) activity.orders).isVisible(), false);
    }

    @Test
    public void whenSelectTheListOfPromosOptionTheListOfPromosMustBePresented(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.navigation.setSelectedItemId(R.id.promocao);

        Assert.assertEquals(((Fragment) activity.lunchs).isVisible(), false);
        Assert.assertEquals(((Fragment) activity.promos).isVisible(), true);
        Assert.assertEquals(((Fragment) activity.orders).isVisible(), false);
    }

    @Test
    public void whenSelectTheListOfOrdersOptionTheListOfOrdersMustBePresented(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.navigation.setSelectedItemId(R.id.pedidos);

        Assert.assertEquals(((Fragment) activity.lunchs).isVisible(), false);
        Assert.assertEquals(((Fragment) activity.promos).isVisible(), false);
        Assert.assertEquals(((Fragment) activity.orders).isVisible(), true);
    }

    @Test
    public void whenSelectTheListOfLunchOptionAtBottomBarTheViewMethodOnClickListOfLunchsOptionMustBeCalled(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity = spy(activity);

        activity.navigation.setSelectedItemId(R.id.lanches);

        MenuItem item = mock(MenuItem.class);
        when(item.getItemId()).thenReturn(R.id.lanches);

        activity.getNavigationListener().onNavigationItemSelected(item);
        verify(activity).onClickListOfLunchsOption();
    }

    @Test
    public void whenSelectTheListOfPromoOptionAtBottomBarTheViewMethodOnClickListOfPromoOptionMustBeCalled(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity = spy(activity);

        MenuItem item = mock(MenuItem.class);
        when(item.getItemId()).thenReturn(R.id.promocao);

        activity.getNavigationListener().onNavigationItemSelected(item);
        verify(activity).onClickListOfPromosOption();
    }

    @Test
    public void whenClickOnListOfOrdersOptionTheMethodOnClickListOfOrdersOptionMustBeCalled(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity = spy(activity);

        MenuItem item = mock(MenuItem.class);
        when(item.getItemId()).thenReturn(R.id.pedidos);

        activity.getNavigationListener().onNavigationItemSelected(item);
        verify(activity).onClickListOfOrdersOption();
    }

}
