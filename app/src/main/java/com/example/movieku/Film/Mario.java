package com.example.movieku.Film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.movieku.R;
import com.example.movieku.VideoMario;

public class Mario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mario);

        LinearLayout TrailerMario = (LinearLayout)findViewById(R.id.trailer_mario);
        TrailerMario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mario.this, VideoMario.class));
            }
        });
    }
}