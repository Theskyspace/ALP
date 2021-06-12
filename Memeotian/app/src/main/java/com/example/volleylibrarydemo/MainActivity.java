package com.example.volleylibrarydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        memeload();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memeload();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memeload();
            }
        });


    }

    private void memeload(){
        String url = "https://meme-api.herokuapp.com/gimme";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        String url = null;
                        try {
                            url = response.getString("url");
                            Log.d("working", "onResponse:" + url);
                            Glide.with(MainActivity.this).load(url).into(imageView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("Working", "onResponse: Not working");
                            Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                            button.setText("Refresh");
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("working", "onErrorResponse: Not working");
                        Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                        button.setText("Refresh");

                    }
                });
        queue.add(jsonObjectRequest);


    }
}
