package com.example.movieku.Film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.movieku.R;
import com.example.movieku.VideoChainsawman;


public class Chainsaw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chainsawman);

        LinearLayout TrailerChainsaw = (LinearLayout)findViewById(R.id.trailer_chainsaw);
        TrailerChainsaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chainsaw.this, VideoChainsawman.class));
            }
        });
    }
}