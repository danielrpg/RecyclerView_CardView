package com.app.recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> itemList;

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button btnInsert, btnRemove;
    private EditText etInsert, etRemove;

    private static final String MSG_ADDED_TITLE = "New line";
    private static final String MSG_ADDED = "The new Item added ";
    private static final String MSG_ADDED_SUCCESS = "Your item was successfully added!";
    private static final String MSG_REMOVED = "Your Item was successfully removed!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemList();
        buildRecyclerView();
        setButtons();
    }

    public void insertItem(View v) {
        int position = Integer.parseInt(etInsert.getText().toString());
        itemList.add(position, new Item(R.drawable.ic_android, MSG_ADDED_TITLE + position, MSG_ADDED + position ));
        adapter.notifyItemInserted(position);
        Toast.makeText(this, MSG_ADDED_SUCCESS, Toast.LENGTH_LONG).show();
    }

    public void removeItem(View v) {
        int position = Integer.parseInt(etRemove.getText().toString());
        removeItemMethod(position);
    }

    private void removeItemMethod(int position) {
        itemList.remove(position);
        adapter.notifyItemRemoved(position);
        Toast.makeText(this, MSG_REMOVED, Toast.LENGTH_LONG).show();
    }

    public void changeItem(int position, String text) {
        itemList.get(position).changeText1(text);
        adapter.notifyItemChanged(position);
    }

    public void createItemList() {
        itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.ic_android, "Line 1", "Line 2"));
        itemList.add(new Item(R.drawable.ic_audio, "Line 3", "Line 4"));
        itemList.add(new Item(R.drawable.ic_sun, "Line 5", "Line 6"));
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked!");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItemMethod(position);
            }
        });
    }

    private void setButtons() {
        btnInsert = findViewById(R.id.button_insert);
        btnRemove = findViewById(R.id.button_remove);

        etInsert = findViewById(R.id.edittext_insert);
        etRemove = findViewById(R.id.edittext_remove);
    }
}
