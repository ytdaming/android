package com.example.learnbaseadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ItemBean> mList;
    private LayoutInflater mInflater;

    public MyAdapter(Context context, List<ItemBean> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View view=mInflater.inflate(R.layout.item,null); 第一种方法，比较逗逼
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_title);
        TextView contentTextView = (TextView) convertView.findViewById(R.id.tv_content);

        ItemBean bean = mList.get(position);
        System.out.println(position);

        imageView.setImageResource(bean.itemImageId);
        titleTextView.setText(bean.itemTitle);
        contentTextView.setText(bean.itemContent);


        return convertView;
    }
}
