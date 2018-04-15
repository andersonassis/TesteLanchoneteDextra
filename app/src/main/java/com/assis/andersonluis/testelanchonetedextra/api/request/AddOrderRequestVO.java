package com.assis.andersonluis.testelanchonetedextra.api.request;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class AddOrderRequestVO  {
    @SerializedName("extras")
    public JsonArray itens;

}
