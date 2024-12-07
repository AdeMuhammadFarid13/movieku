package com.example.movieku.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movieku.R;
import com.example.movieku.ReviewAlice;
import com.example.movieku.ReviewAvatar;
import com.example.movieku.ReviewBig4;
import com.example.movieku.ReviewBlackAdam;
import com.example.movieku.ReviewBlackPanther;
import com.example.movieku.ReviewChainsaw;
import com.example.movieku.ReviewMario;
import com.example.movieku.ReviewPinocchio;
import com.example.movieku.ReviewTranformer;
import com.example.movieku.ReviewWednesday;

public class FragmentReview extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_review, container, false);
        Button Avatar = view.findViewById(R.id.btnrv_avatar);
        Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewAvatar.class);
                startActivity(intent);
            }
        });
        Button Transformer = view.findViewById(R.id.btnrv_transformer);
        Transformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewTranformer.class);
                startActivity(intent);
            }
        });
        Button BlackPanther = view.findViewById(R.id.btnrv_blackp);
        BlackPanther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewBlackPanther.class);
                startActivity(intent);
            }
        });
        Button BlackAdam = view.findViewById(R.id.btnrv_blacka);
        BlackAdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewBlackAdam.class);
                startActivity(intent);
            }
        });
        Button Wednesday = view.findViewById(R.id.btnrv_wednesday);
        Wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewWednesday.class);
                startActivity(intent);
            }
        });
        Button Big4 = view.findViewById(R.id.btnrv_big4);
        Big4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewBig4.class);
                startActivity(intent);
            }
        });
        Button Pino = view.findViewById(R.id.btnrv_pino);
        Pino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewPinocchio.class);
                startActivity(intent);
            }
        });
        Button Chainsaw = view.findViewById(R.id.btnrv_chainsaw);
        Chainsaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewChainsaw.class);
                startActivity(intent);
            }
        });
        Button Mario = view.findViewById(R.id.btnrv_mario);
        Mario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewMario.class);
                startActivity(intent);
            }
        });
        Button Alice = view.findViewById(R.id.btnrv_alice);
        Alice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), ReviewAlice.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
