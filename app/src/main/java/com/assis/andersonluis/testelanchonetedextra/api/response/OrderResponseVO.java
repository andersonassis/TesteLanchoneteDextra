package com.assis.andersonluis.testelanchonetedextra.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class OrderResponseVO  {

    public Integer id;
    @SerializedName("id_sandwich")
    public Integer lunchId;
    @SerializedName("extras")
    public List<Integer> extras;
    public Date date;

    public OrderResponseVO() {}

    public OrderResponseVO(Integer id) {
        this.id = id;
    }

    public OrderResponseVO(Integer id, Integer lunchId, List<Integer> extras, Date date) {
        this.id = id;
        this.lunchId = lunchId;
        this.extras = extras;
        this.date = date;
    }


}
