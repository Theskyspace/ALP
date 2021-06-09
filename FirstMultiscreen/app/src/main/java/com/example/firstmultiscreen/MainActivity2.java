package com.example.firstmultiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private TextView welcome_text;
    private Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        welcome_text = findViewById(R.id.Hellotext);
        String name = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        welcome_text.setText("Welcome," + name);

    }

    public void Goback(View v){
        Toast.makeText(this, "Looking back at your mistakes is good", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

}