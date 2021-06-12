package com.example.workingwithjson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView QUES;
    private TextView options;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QUES = findViewById(R.id.Question);
        options = findViewById(R.id.Option);

        mQueue = Volley.newRequestQueue(this);
        String url = "http://myjson.dit.upm.es/api/bins/19fz";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = response.getJSONObject(0);
                            String Question = jsonObject.getString("Question");

                            QUES.setText(Question);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("myapp", "onResponse: Didn't work");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error .printStackTrace();
                Log.d("myapp", "onErrorResponse: Didn't work");
            }
        });
        mQueue.add(request);


    }

}