package com.example.movieku.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieku.MainActivity;
import com.example.movieku.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText TxUsername, TxPassword;
    Button BtnLogin;
    TextView BtnSignUp;  // This should be TextView for SignUp
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize layout elements
        TxUsername = findViewById(R.id.et_username); // Match the ID with XML TextInputEditText
        TxPassword = findViewById(R.id.et_password); // Match the ID with XML TextInputEditText
        BtnLogin = findViewById(R.id.btn_login);  // This ID is correct
        BtnSignUp = findViewById(R.id.btn_signup); // Correct TextView ID for SignUp

        dbHelper = new DBHelper(this);

        // Listener for Login Button
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Check user credentials using DBHelper
                    boolean res = dbHelper.checkUser(username, password);
                    if (res) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish(); // Close LoginActivity so it doesn't appear when back is pressed
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Listener for SignUp Button (TextView)
        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to RegisterActivity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
