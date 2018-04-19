package com.dxt2.monigouwu2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dxt2.monigouwu2.R;
import com.dxt2.monigouwu2.bean.ListItems;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class ListItemAdapter extends BaseAdapter{
    List<ListItems.DataBean.ItemsBeanX> list;
    Context context;
    private int selestedPosition = 0;// 初始选中第一行
    LayoutInflater inflate;

    public ListItemAdapter(List<ListItems.DataBean.ItemsBeanX> list, Context context) {
        this.list = list;
        this.context = context;
        inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ListItems.DataBean.ItemsBeanX getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_tv, parent,false);
//          convertView = inflate.inflate(R.layout.itemtvv, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.tv);
            viewHolder.item_content_layout = convertView.findViewById(R.id.item_content_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(selestedPosition ==i){
            viewHolder.item_content_layout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }
        else{
            viewHolder.item_content_layout.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }

        viewHolder.textView.setText(list.get(i).getComponent().getAction().getTitle());
        return convertView;
    }

    class ViewHolder {
        TextView textView;
        RelativeLayout item_content_layout;

    }
}
