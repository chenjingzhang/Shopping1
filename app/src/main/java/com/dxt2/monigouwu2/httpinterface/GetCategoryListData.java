package com.dxt2.monigouwu2.httpinterface;

import com.dxt2.monigouwu2.bean.CategoryList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public interface GetCategoryListData {
    @GET("search/skus")
    Call<CategoryList> getCategoryData(
            @Query("query") String query,
            @Query("sort") String sort,
            @Query("ga") String ga,
            @Query("flag") String flag,
            @Query("cat") String cat,
            @Query("asc") String asc
    );
}























