package com.example.demofragment43;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment {

    Button btnAdd, btnSingeFragment, btnMultiFragment;

    public static AddFragment newInstance() {

        Bundle args = new Bundle();

        AddFragment fragment = new AddFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, container, false);

        btnAdd = view.findViewById(R.id.btnAddFragment);
        btnSingeFragment = view.findViewById(R.id.btnSingeFragment);
        btnMultiFragment = view.findViewById(R.id.btnMultiFragment);

        //Dialog thông thường thông báo
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Thông Báo")
                        .setMessage("Bạn có chắc chắn add không")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();


            }
        });

        //Dialog Single
        btnSingeFragment.setOnClickListener(v -> {
            String[] strings = {"Android", "Kotlin", "Flutter"};

            AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                    .setTitle("Chọn 1 ngôn ngữ")
                    .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), strings[which], Toast.LENGTH_LONG).show();
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .create();
            alertDialog.show();


        });

        //Dialog Multi
        btnMultiFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Android", "Kotlin", "Flutter"};
                boolean[] booleans = {false, true, false};

                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Chọn 1 ngôn ngữ")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(getContext(),strings[which],Toast.LENGTH_LONG).show();
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();

            }
        });


        return view;
    }
}
