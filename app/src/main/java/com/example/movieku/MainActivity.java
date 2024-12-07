package com.example.movieku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.movieku.Film.Alice;
import com.example.movieku.Film.Avatar;
import com.example.movieku.Film.Blacka;
import com.example.movieku.Film.BlackP;
import com.example.movieku.Film.Chainsaw;
import com.example.movieku.Film.Mario;
import com.example.movieku.Film.Pinocchio;
import com.example.movieku.Film.Thebig4;
import com.example.movieku.Film.Transformers;
import com.example.movieku.Film.Wednesday;
import com.example.movieku.Fragment.FragmentAbout;
import com.example.movieku.Fragment.FragmentReview;
import com.example.movieku.Fragment.FragmentHome;
import com.example.movieku.Login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    BottomNavigationView bottomNavigationView;
    private DBHandler dbHandler;

    // BottomNavigation Item Click Listener
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()){
                case R.id.menu_home:
                    f = new FragmentHome();
                    break;
                case R.id.menu_favorite:
                    f = new FragmentReview();
                    break;
                case R.id.menu_about:
                    f = new FragmentAbout();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(MainActivity.this);

        // Set Click Listeners for each movie button
        LinearLayout btnAvatar = findViewById(R.id.avatar);
        btnAvatar.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Avatar.class)));

        LinearLayout btnTransformer = findViewById(R.id.transformer);
        btnTransformer.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Transformers.class)));

        LinearLayout btnBlackPanther = findViewById(R.id.blackpanther);
        btnBlackPanther.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BlackP.class)));

        LinearLayout btnBlackAdam = findViewById(R.id.blackadam);
        btnBlackAdam.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Blacka.class)));

        LinearLayout btnWednesday = findViewById(R.id.wednesday);
        btnWednesday.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Wednesday.class)));

        LinearLayout btnPinocchio = findViewById(R.id.pinocchio);
        btnPinocchio.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Pinocchio.class)));

        LinearLayout btnBig4 = findViewById(R.id.thebig4);
        btnBig4.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Thebig4.class)));

        LinearLayout btnAlice = findViewById(R.id.alice);
        btnAlice.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Alice.class)));

        LinearLayout btnChainsawman = findViewById(R.id.chainsaw);
        btnChainsawman.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Chainsaw.class)));

        LinearLayout btnMario = findViewById(R.id.mariobros);
        btnMario.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Mario.class)));

        // Bottom Navigation Menu Setup
        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);

        // ViewPager2 Setup for Slider
        viewPager2 = findViewById(R.id.slider);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.image1));
        sliderItems.add(new SliderItem(R.drawable.transformer));
        sliderItems.add(new SliderItem(R.drawable.blackpanther));
        sliderItems.add(new SliderItem(R.drawable.blackadam));
        sliderItems.add(new SliderItem(R.drawable.wednesday));
        sliderItems.add(new SliderItem(R.drawable.thebig4));
        sliderItems.add(new SliderItem(R.drawable.pinocchio));
        sliderItems.add(new SliderItem(R.drawable.alice));
        sliderItems.add(new SliderItem(R.drawable.chainsawman));
        sliderItems.add(new SliderItem(R.drawable.mario));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    public void onBackPressed() {
        // Show the confirmation dialog when the user tries to go back
        new AlertDialog.Builder(this)
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Redirect to Login Activity
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish(); // Close the MainActivity
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
