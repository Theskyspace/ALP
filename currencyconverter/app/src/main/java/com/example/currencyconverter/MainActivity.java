package com.example.currencyconverter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.rupees);
        textView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.Meme);


        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Voila done! ", Toast.LENGTH_SHORT).show();

                String s = editText.getText().toString();
                int a = Integer.parseInt(s);
                double doller = 70*a;
                editText.setText("");
                textView.setText("Value in $ is : $" + doller);

                if (doller > 10000){
                    imageView.setImageDrawable(getDrawable(R.drawable.after));
                }
                else{
                    imageView.setImageDrawable(getDrawable(R.drawable.paisa));
                }
            }
        });
    }
}