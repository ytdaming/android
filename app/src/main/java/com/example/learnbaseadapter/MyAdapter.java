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
        ViewHolder viewHolder;
        //View view=mInflater.inflate(R.layout.item,null); 第一种方法，比较逗逼
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemBean bean = mList.get(position);
        System.out.println(position);

        viewHolder.imageView.setImageResource(bean.itemImageId);
        viewHolder.title.setText(bean.itemTitle);
        viewHolder.content.setText(bean.itemContent);


        return convertView;
    }

    class ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
