package com.app.recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.ic_android, "Line 1", "Line 2"));
        itemList.add(new Item(R.drawable.ic_audio, "Line 3", "Line 4"));
        itemList.add(new Item(R.drawable.ic_sun, "Line 5", "Line 6"));
        itemList.add(new Item(R.drawable.ic_android, "Line 7", "Line 8"));
        itemList.add(new Item(R.drawable.ic_audio, "Line 9", "Line 10"));
        itemList.add(new Item(R.drawable.ic_sun, "Line 11", "Line 12"));
        itemList.add(new Item(R.drawable.ic_android, "Line 13", "Line 14"));
        itemList.add(new Item(R.drawable.ic_audio, "Line 15", "Line 16"));
        itemList.add(new Item(R.drawable.ic_sun, "Line 17", "Line 18"));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
