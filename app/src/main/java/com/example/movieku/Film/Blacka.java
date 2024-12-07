package com.example.movieku.Film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.movieku.R;
import com.example.movieku.VideoBlackA;

public class Blacka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blacka);

        LinearLayout TrailerBlacka = (LinearLayout)findViewById(R.id.trailer_blacka);
        TrailerBlacka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Blacka.this, VideoBlackA.class));
            }
        });
    }
}