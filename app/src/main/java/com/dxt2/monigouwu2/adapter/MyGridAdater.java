package com.dxt2.monigouwu2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxt2.monigouwu2.R;
import com.dxt2.monigouwu2.bean.ListItems;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class MyGridAdater extends BaseAdapter{
    List<ListItems.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean> itemsBeans;
    Context context;

    public MyGridAdater(List<ListItems.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean> itemsBeans, Context context) {
        this.itemsBeans = itemsBeans;
        this.context = context;
    }


    @Override
    public int getCount() {
        return itemsBeans.size();
    }

    @Override
    public ListItems.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean getItem(int i) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.itemright,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(itemsBeans.get(pos).getComponent().getWord());
        Picasso.with(context).load(itemsBeans.get(pos).getComponent().getPicUrl())
                .placeholder(R.mipmap.ic_launcher).into(viewHolder.imageView);

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
