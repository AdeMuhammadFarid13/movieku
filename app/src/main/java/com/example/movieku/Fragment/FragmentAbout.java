package com.example.movieku.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.movieku.Login.LoginActivity;
import com.example.movieku.R;

public class FragmentAbout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout for the fragment
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

        // Tombol Logout
        ImageButton btnLogout = view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(v -> {
            // Check if context is available and show confirmation dialog before logging out
            if (getContext() != null) {
                new AlertDialog.Builder(requireContext())
                        .setMessage("Are you sure you want to log out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Optionally, clear user session data (e.g., SharedPreferences)
                                Intent intent = new Intent(getActivity(), LoginActivity.class); // Ensure LoginActivity is correct
                                startActivity(intent);
                                if (getActivity() != null) {
                                    getActivity().finish(); // Finish current activity so user can't go back to it
                                }
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        return view;
    }
}
