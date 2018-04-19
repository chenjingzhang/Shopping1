package com.dxt2.monigouwu2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dxt2.monigouwu2.R;
import com.dxt2.monigouwu2.adapter.ListItemAdapter;
import com.dxt2.monigouwu2.bean.ListItems;
import com.dxt2.monigouwu2.constants.Constant;
import com.dxt2.monigouwu2.httpinterface.GetCategoryDate1;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {
    @BindView(R.id.listView1)
    ListView listView;
    ListItemAdapter adapter;
    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        //面板分类
        getFragmentManager().beginTransaction().replace(R.id.categorylayout, new CategoryFragment()).commit();
        getData2();
        return view;
    }

    @OnItemClick(R.id.listView1)
    public void itemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        //发送广播开始传值  发送广播
        Intent intent = new Intent();
        intent.setAction("com.dxt2.monigouwu2.listcheckbox");
        intent.putExtra("component", adapter.getItem(pos).getComponent());
        getContext().sendBroadcast(intent);
    }


    private void getData2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.CATEGORY_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetCategoryDate1 data1 = retrofit.create(GetCategoryDate1.class);
        Call<ListItems> listItemsCall = data1.getCategoryData();
        listItemsCall.enqueue(new Callback<ListItems>() {
            @Override
            public void onResponse(Call<ListItems> call, Response<ListItems> response) {
                adapter = new ListItemAdapter(response.body().getData().getItems(), getActivity());
                listView.setAdapter(adapter);

                //在设置listview中的值的时候 给gridView发送广播
                Intent intent = new Intent();
                intent.setAction("com.dxt2.monigouwu2.listcheckbox");
                intent.putExtra("component", adapter.getItem(0).getComponent());
                if (getActivity() != null) {
                    getActivity().sendBroadcast(intent);
                }
            }

            @Override
            public void onFailure(Call<ListItems> call, Throwable t) {

            }
        });
    }

}

