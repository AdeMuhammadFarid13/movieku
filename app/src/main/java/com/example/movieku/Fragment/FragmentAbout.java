package com.example.movieku.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movieku.R;

public class FragmentAbout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Tombol WhatsApp
        ImageButton btnWhatsApp = view.findViewById(R.id.btn_whatsapp);
        btnWhatsApp.setOnClickListener(v -> {
            String phoneNumber = "081461152511"; // Ganti dengan nomor WhatsApp
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + phoneNumber));
            startActivity(intent);
        });

        // Tombol Instagram
        ImageButton btnInstagram = view.findViewById(R.id.btn_instagram);
        btnInstagram.setOnClickListener(v -> {
            String instagramProfile = "https://www.instagram.com/admffrd?igsh=Z3NrbHp5YW9sN2U4"; // Ganti dengan username Instagram
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfile));
            startActivity(intent);
        });

        // Tombol Email
        ImageButton btnEmail = view.findViewById(R.id.btn_email);
        btnEmail.setOnClickListener(v -> {
            String email = "ademuhammadfarid130704@gmail.com"; // Ganti dengan alamat email
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + email));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Email"); // Opsional
            intent.putExtra(Intent.EXTRA_TEXT, "Isi Email"); // Opsional
            startActivity(intent);
        });

        return view;
    }
}
