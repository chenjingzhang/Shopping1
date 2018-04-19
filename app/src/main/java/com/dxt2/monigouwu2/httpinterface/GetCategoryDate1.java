package com.dxt2.monigouwu2.httpinterface;

import com.dxt2.monigouwu2.bean.ListItems;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public interface GetCategoryDate1 {
    @GET("category/list?ga=%2Fcategory%2Flist")
    Call<ListItems> getCategoryData();
}
