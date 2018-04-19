package com.dxt2.monigouwu2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxt2.monigouwu2.R;
import com.dxt2.monigouwu2.bean.CategoryList;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class MyDetailAdapter extends BaseAdapter {
    List<CategoryList.DataBean.ItemsBean> itemsBeans;
    Context context;

    public MyDetailAdapter(List<CategoryList.DataBean.ItemsBean> itemsBeans, Context context) {
        this.itemsBeans = itemsBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemsBeans.size();
    }

    @Override
    public CategoryList.DataBean.ItemsBean getItem(int i) {
        return itemsBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
       if(convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.item_gv_detail,parent,false);
           viewHolder = new ViewHolder();
           viewHolder.imageView = convertView.findViewById(R.id.imageView);
           viewHolder.textView = convertView.findViewById(R.id.textView);
           viewHolder.tv_price = (TextView) convertView.findViewById(R.id.tv_shopping_cart_price);
           viewHolder.tv_origin_price = (TextView) convertView.findViewById(R.id.tv_origin_price);
           viewHolder.tv_sales = (TextView) convertView.findViewById(R.id.tv_sales);
           convertView.setTag(viewHolder);
       }
       else{
           viewHolder = (ViewHolder) convertView.getTag();
       }
        viewHolder.textView.setText(itemsBeans.get(pos).getComponent().getDescription());
        Picasso.with(context).load(itemsBeans.get(pos).getComponent().getPicUrl()).placeholder(R.mipmap.ic_launcher).into(viewHolder.imageView);
        viewHolder.tv_price.setText("¥"+itemsBeans.get(pos).getComponent().getPrice());
        viewHolder.tv_origin_price.setText("原¥"+itemsBeans.get(pos).getComponent().getOrigin_price());
        viewHolder.tv_sales.setText("销量:"+itemsBeans.get(pos).getComponent().getSales());

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView tv_price;
        TextView tv_origin_price;
        TextView tv_sales;
    }
}
























