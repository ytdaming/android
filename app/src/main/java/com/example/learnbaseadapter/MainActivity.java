package com.example.learnbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            itemBeanList.add(new ItemBean(R.mipmap.ic_launcher, "Title" + i, "Content" + "\n" + "Content" + i));
        }

        mListView = (ListView) findViewById(R.id.lv_main);
        mListView.setAdapter(new MyAdapter(this, itemBeanList));
    }
}
