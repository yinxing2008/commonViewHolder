package com.cxyzy.demo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cxyzy.commonviewholder.MultipleCommonAdapter;
import com.cxyzy.commonviewholder.SimpleCommonAdapter;
import com.cxyzy.commonviewholder.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private final List<String> data = new ArrayList<>(100);
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;
        for (int i = 0; i < 100; i++) {
            data.add("text-" + i);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        recyclerView.setAdapter(getSimpleAdapter());    // 使用单布局
//        recyclerView.setAdapter(getSingleAdapter());    // 使用单布局
        recyclerView.setAdapter(getMultipleAdapter());    // 使用多布局
    }


    private RecyclerView.Adapter getSimpleAdapter() {
        return new SimpleCommonAdapter<String>(data, android.R.layout.simple_list_item_1) {
            @Override
            protected void onBindViewHolder(ViewHolder holder, String data, int position) {
                holder.setText(android.R.id.text1, data)
                        .setTextColor(android.R.id.text1, Color.RED)
                        .setOnItemClickListener((view) ->
                                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show()
                        );

                if (position == 0) {
                    TextView textView = holder.getView(android.R.id.text1);
                    textView.setText(R.string.app_name, TextView.BufferType.NORMAL);
                }
            }
        };
    }


    private RecyclerView.Adapter getSingleAdapter() {
        return new MultipleCommonAdapter<String>(data) {

            @Override
            protected int getLayoutIdByType(int viewType) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            protected void onBindViewHolder(ViewHolder holder, String data, int position) {
                holder.setText(android.R.id.text1, data);
            }
        };
    }

    private RecyclerView.Adapter getMultipleAdapter() {
        final int TYPE_1 = 1;
        final int TYPE_2 = 2;
        return new MultipleCommonAdapter<String>(data) {

            @Override
            protected int getLayoutIdByType(int viewType) {
                return viewType == TYPE_1 ? android.R.layout.simple_list_item_1 : android.R.layout.simple_list_item_2;
            }

            @Override
            public int getItemViewType(int position) {
                return position % 2 == 0 ? TYPE_1 : TYPE_2;
            }

            @Override
            protected void onBindViewHolder(ViewHolder holder, String data, int position) {
                if (position % 2 == 0) {
                    holder.setText(android.R.id.text1, data);
                } else {
                    holder.setText(android.R.id.text1, data);
                    holder.setText(android.R.id.text2, "Android");
                }
            }

        };
    }
}