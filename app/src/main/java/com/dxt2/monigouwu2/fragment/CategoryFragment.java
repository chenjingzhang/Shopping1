package com.dxt2.monigouwu2.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dxt2.monigouwu2.R;
import com.dxt2.monigouwu2.activity.DetailListActivity;
import com.dxt2.monigouwu2.adapter.MyGridAdater;
import com.dxt2.monigouwu2.bean.ListItems;

import java.nio.Buffer;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    @BindView(R.id.gv)
    GridView gridView;

    MyReceiver myReceiver;

    MyGridAdater myGridAdater;


    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册广播
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.dxt2.monigouwu2.listcheckbox");
        getActivity().registerReceiver(myReceiver,intentFilter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    //接收广播
    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.dxt2.monigouwu2.listcheckbox")){
                ListItems.DataBean.ItemsBeanX.ComponentBeanX componentBeanX = (ListItems.DataBean.ItemsBeanX.ComponentBeanX) intent.getSerializableExtra("component");
                List<ListItems.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean> itemsBeans = componentBeanX.getItems();
                myGridAdater = new MyGridAdater(itemsBeans,getActivity());
                gridView.setAdapter(myGridAdater);

            }
        }
    }
    @OnItemClick(R.id.gv)
    public void onItemClickByGv(AdapterView<?> adapterView,View view,int pos,long id){
       ListItems.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean itemsBean = myGridAdater.getItem(pos);
       String query  = itemsBean.getComponent().getAction().getQuery();
       Intent intent = new Intent(getActivity(),DetailListActivity.class);
       intent.putExtra("key",query);
       startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(myReceiver);
    }
}
