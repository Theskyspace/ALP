package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] arr = {"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8","Item 9","Item 10","Item 11",
            "Item 12","Item 13","Item 14","Item 10","Item 11","Item 12","Item 13","Item 14"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.ListView);

        // Inbuilt Adapter
       // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
       // listView.setAdapter(ad);

        // Using Custom Adapter.
        AkashAdapter ad = new AkashAdapter(this,R.layout.customlayout , arr);
        listView.setAdapter(ad);
    }
}