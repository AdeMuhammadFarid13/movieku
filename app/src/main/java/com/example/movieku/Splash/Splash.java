package com.example.movieku.Splash;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieku.Login.LoginActivity;
import com.example.movieku.R;  // Ensure this import is correct for resource references

public class Splash extends AppCompatActivity {
    private static final int SPLASH_SCREEN_DURATION = 3000; // Duration of the splash screen in milliseconds

    // Declare animations and UI elements
    private Animation topAnim, bottomAnim;
    private ImageView img;
    private TextView txtNameApp, txtSubNameApp, txtCopyright;

    @RequiresApi(api = Build.VERSION_CODES.P)  // Ensure this works on Android P and above
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the application to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set the content view to the splash screen layout
        setContentView(R.layout.splash);

        // Load animations from the resource files
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Link UI elements with their corresponding IDs from the layout
        img = findViewById(R.id.img_logo);
        txtNameApp = findViewById(R.id.tv_nameApp);
        txtSubNameApp = findViewById(R.id.tv_sub_nameApp);
        txtCopyright = findViewById(R.id.tv_copyright);

        // Apply animations to the UI elements
        img.setAnimation(topAnim);
        txtNameApp.setAnimation(bottomAnim);
        txtSubNameApp.setAnimation(bottomAnim);
        txtCopyright.setAnimation(bottomAnim);

        // Use a handler to delay the transition to the LoginActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After the splash screen duration, navigate to LoginActivity
                Intent intent = new Intent(Splash.this, LoginActivity.class);

                // Add transition animations for the login activity
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash.this,
                        Pair.create(img, "logo_img"),  // Shared element transition for logo
                        Pair.create(txtNameApp, "textnameApp"));  // Shared element transition for app name

                startActivity(intent, options.toBundle());
                finish();  // Close Splash activity so the user cannot navigate back to it
            }
        }, SPLASH_SCREEN_DURATION); // Wait for the specified duration before transitioning
    }
}
