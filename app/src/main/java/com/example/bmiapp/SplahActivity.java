package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.RelativeLayout;

import com.example.bmiapp.databinding.ActivitySplahBinding;

public class SplahActivity extends AppCompatActivity {
    private ActivitySplahBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}