package com.example.movieku.Film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.movieku.R;
import com.example.movieku.VideoTransformer;

public class Transformers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformer);
        LinearLayout TrailerTransformer = (LinearLayout)findViewById(R.id.trailer_transformer);
        TrailerTransformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Transformers.this, VideoTransformer.class));
            }
        });
    }
}