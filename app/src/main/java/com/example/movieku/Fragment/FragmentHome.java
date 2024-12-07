package com.example.movieku.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movieku.Film.Alice;
import com.example.movieku.Film.Blacka;
import com.example.movieku.Film.BlackP;
import com.example.movieku.Film.Chainsaw;
import com.example.movieku.Film.Avatar;
import com.example.movieku.Film.Transformers;
import com.example.movieku.Film.Mario;
import com.example.movieku.Film.Pinocchio;
import com.example.movieku.R;
import com.example.movieku.Film.Thebig4;
import com.example.movieku.Film.Wednesday;

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView img1 = view.findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Avatar.class);
                startActivity(intent);
            }
        });
        ImageView img2 = view.findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Transformers.class);
                startActivity(intent);
            }
        });
        ImageView img3 = view.findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), BlackP.class);
                startActivity(intent);
            }
        });
        ImageView img4 = view.findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Blacka.class);
                startActivity(intent);
            }
        });
        ImageView img5 = view.findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Wednesday.class);
                startActivity(intent);
            }
        });
        ImageView img6 = view.findViewById(R.id.img6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Thebig4.class);
                startActivity(intent);
            }
        });
        ImageView img7 = view.findViewById(R.id.img7);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Pinocchio.class);
                startActivity(intent);
            }
        });
        ImageView img8 = view.findViewById(R.id.img8);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Alice.class);
                startActivity(intent);
            }
        });
        ImageView img9 = view.findViewById(R.id.img9);
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Chainsaw.class);
                startActivity(intent);
            }
        });
        ImageView img10 = view.findViewById(R.id.img10);
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Mario.class);
                startActivity(intent);
            }
        });

        LinearLayout Avatar = view.findViewById(R.id.avatar);
        Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(),Avatar.class);
                startActivity(intent);
            }
        });
        LinearLayout Transformer = view.findViewById(R.id.transformer);
        Transformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Transformers.class);
                startActivity(intent);
            }
        });
        LinearLayout Blackp = view.findViewById(R.id.blackpanther);
        Blackp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), BlackP.class);
                startActivity(intent);
            }
        });
        LinearLayout Blacka = view.findViewById(R.id.blackadam);
        Blacka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Blacka.class);
                startActivity(intent);
            }
        });
        LinearLayout Wednesday = view.findViewById(R.id.wednesday);
        Wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Wednesday.class);
                startActivity(intent);
            }
        });
        LinearLayout Pinocchio = view.findViewById(R.id.pinocchio);
        Pinocchio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Pinocchio.class);
                startActivity(intent);
            }
        });
        LinearLayout Big4 = view.findViewById(R.id.thebig4);
        Big4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Thebig4.class);
                startActivity(intent);
            }
        });
        LinearLayout Alice = view.findViewById(R.id.alice);
        Alice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Alice.class);
                startActivity(intent);
            }
        });
        LinearLayout Chain = view.findViewById(R.id.chainsawman);
        Chain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Chainsaw.class);
                startActivity(intent);
            }
        });
        LinearLayout Mario = view.findViewById(R.id.mario);
        Mario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(getActivity(), Mario.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
