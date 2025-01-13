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
    TextView BtnSignUp;  // Ganti menjadi TextView karena itu adalah elemen dalam layout
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi elemen-elemen di layout
        TxUsername = findViewById(R.id.txUsername);
        TxPassword = findViewById(R.id.txPassword);
        BtnLogin = findViewById(R.id.btn_login);
        BtnSignUp = findViewById(R.id.btn_signup); // Menggunakan TextView di sini

        dbHelper = new DBHelper(this);

        // Listener untuk tombol Login
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean res = dbHelper.checkUser(username, password);
                    if (res) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Listener untuk tombol SignUp
        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengarahkan pengguna ke halaman RegisterActivity (Sign Up)
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
