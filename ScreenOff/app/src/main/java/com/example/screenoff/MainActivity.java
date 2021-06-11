package com.example.screenoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;

    public static final String EXTRA_NAME = "com.example.screenoff.extra.URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

    }
    public void hitclick(View v){
        Intent intent = new Intent(this , Videoactivity.class);
        editText = findViewById(R.id.Linktext);
        String URL = editText.getText().toString();
        intent.putExtra(EXTRA_NAME , URL);
        startActivity(intent);
    }
}