package com.example.lee.loading_page_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.PM.Demo.UnityPlayerActivity;

public class MainActivity extends AppCompatActivity {
    Button fa_button;
    Button ar_button;
    //ImageButton ar_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ar_button = (Button)findViewById(R.id.imageButton1);
        ar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn = new Intent(MainActivity.this, UnityPlayerActivity.class);
                startActivity(btn);
                //startActivity(new Intent(MainActivity.this,SubActivity.class));
            }
        });
    }
}
