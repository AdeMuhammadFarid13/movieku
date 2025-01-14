package com.example.movieku.Login;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movieku.R;

public class RegisterActivity extends AppCompatActivity {

    EditText TxUsername, TxPassword, TxConPassword;
    Button BtnRegister;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);

        // Initialize views
        TxUsername = findViewById(R.id.et_username);  // Menyesuaikan ID dengan XML
        TxPassword = findViewById(R.id.et_password);  // Menyesuaikan ID dengan XML
        TxConPassword = findViewById(R.id.et_con_password);  // Menyesuaikan ID dengan XML
        BtnRegister = findViewById(R.id.btnRegister);
        TextView tvRegister = findViewById(R.id.tvRegister);

        // Set up the "Back to Login" TextView with HTML styled text
        tvRegister.setText(fromHtml("Back to </font><font color='#3b5998'>Login</font>"));

        // Handle "Back to Login" click
        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });

        // Handle Register button click
        BtnRegister.setOnClickListener(v -> {
            String username = TxUsername.getText().toString().trim();
            String password = TxPassword.getText().toString().trim();
            String conPassword = TxConPassword.getText().toString().trim();

            // Validation
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(conPassword)) {
                Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                // Insert user data into the database
                ContentValues values = new ContentValues();
                values.put(DBHelper.row_username, username);
                values.put(DBHelper.row_password, password);

                long result = dbHelper.insertData(values);
                if (result > 0) {
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Utility method to handle HTML rendering
    public static Spanned fromHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }
}
