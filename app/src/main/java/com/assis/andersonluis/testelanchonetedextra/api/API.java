package com.assis.andersonluis.testelanchonetedextra.api;

import com.assis.andersonluis.testelanchonetedextra.api.request.AddOrderRequestVO;
import com.assis.andersonluis.testelanchonetedextra.api.response.InfoLunchResponseVO;
import com.assis.andersonluis.testelanchonetedextra.api.response.IngredientResponseVO;
import com.assis.andersonluis.testelanchonetedextra.api.response.OrderResponseVO;
import com.assis.andersonluis.testelanchonetedextra.api.response.PromoResponseVO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface API  {

    @GET("lanche")
    @Headers("Cache-Control: public, max-age=" + (60 * 60 * 24))
    Observable<List<InfoLunchResponseVO>> getLunchs();

    @GET("ingrediente/de/{lanche}")
    Observable<List<IngredientResponseVO>> getIngredientsOfLunch(@Path("lanche") Integer lanche);

    @GET("lanche/{lanche}")
    Observable<InfoLunchResponseVO> getInfoOfLunch(@Path("lanche") Integer lanche);

    @PUT("pedido/{lanche}")
    Observable<OrderResponseVO> createOrder(@Path("lanche") Integer lanche, @Body AddOrderRequestVO request);

    @GET("promocao")
    @Headers("Cache-Control: public, max-age=" + (60 * 60 * 24))
    Observable<List<PromoResponseVO>> getPromos();

    @GET("pedido")
    Observable<List<OrderResponseVO>> getOrders();

    @GET("ingrediente")
    @Headers("Cache-Control: public, max-age=" + (60 * 60 * 24))
    Observable<List<IngredientResponseVO>> getListOfIngredients();



}
