package com.dxt2.monigouwu2.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dxt2.monigouwu2.R;
import com.dxt2.monigouwu2.adapter.ListItemAdapter;
import com.dxt2.monigouwu2.adapter.MyDetailAdapter;
import com.dxt2.monigouwu2.bean.CategoryList;
import com.dxt2.monigouwu2.constants.Constant;
import com.dxt2.monigouwu2.httpinterface.GetCategoryListData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailListActivity extends AppCompatActivity {
    MyDetailAdapter mydetailAdapter;

    @BindView(R.id.gv_detail)
    GridView gridView;

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        ButterKnife.bind(this);
        toolbar.setTitle("列表详情");
        toolbar.setTitleTextColor(Color.WHITE);
//        toolbar.setNavigationIcon(R.drawable.);
        setSupportActionBar(toolbar);
        String key = getIntent().getStringExtra("key");
        getCategoryList(key);
    }

    private void getCategoryList(String key) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.CATEGORY_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //http://api-v2.mall.hichao.com/search/skus?query=%E8%BF%9E%E8%A1%A3%E8%A3%99%20%20&sort=all&ga=%252Fsearch%252Fskus&flag=&cat=&asc=1
        GetCategoryListData categoryListData = retrofit.create(GetCategoryListData.class);
        Call<CategoryList> categoryListCall = categoryListData.getCategoryData(key,"all","%2Fsearch%2Fskus",
                "","","1");
        categoryListCall.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                mydetailAdapter = new MyDetailAdapter(response.body().getData().getItems(),DetailListActivity.this);
                gridView.setAdapter(mydetailAdapter);
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {

            }
        });
    }

    @OnItemClick(R.id.gv_detail)
    public void itemClick(AdapterView<?> adapterView, View view,int pos,long id){
        Intent intent = new Intent(this,ItemListDetailActivity.class);
        String sid = mydetailAdapter.getItem(pos).getComponent().getAction().getSourceId();
        intent.putExtra("id",sid);
        intent.putExtra("type","0");
        intent.putExtra("itembean",mydetailAdapter.getItem(0));
        startActivity(intent);
    }
}




















