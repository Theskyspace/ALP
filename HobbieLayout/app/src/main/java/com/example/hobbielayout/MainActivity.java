package com.example.hobbielayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button op_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op_camera = findViewById(R.id.open_Camera);

        op_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(Open_camera);
            }
        });

    }
}