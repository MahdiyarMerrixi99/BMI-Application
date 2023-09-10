package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.bmiapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String typeofuser="";
    String mintprogress="170";
    int currentprogress;
    int intage=28;
    int intweight=55;
    String strAge="";
    String strWeight="";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageviewManIcone.setImageResource(R.drawable.man_icone);
        binding.imageviewFamelIcone.setImageResource(R.drawable.woman_icone);
        binding.textmale.setText(R.string.male);
        binding.textmale.setTextSize(18);
        binding.textfemale.setText(R.string.female);
        binding.textfemale.setTextSize(18);
        binding.HeightSeekbar.setText("Height");
        binding.HeightSeekbar.setTextSize(20);
        binding.textmale.setTypeface(Typeface.DEFAULT_BOLD);
        binding.textfemale.setTypeface(Typeface.DEFAULT_BOLD);
        binding.HeightSeekbar.setTypeface(Typeface.DEFAULT_BOLD);
        binding.textmale.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.textfemale.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.HeightSeekbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.cm.setText("cm");
        binding.cm.setTextSize(20);
        binding.cm.setTypeface(Typeface.DEFAULT_BOLD);
        binding.textweight.setText("Weight");
        binding.textweight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.textweight.setTextSize(18);
        binding.textweight.setTypeface(Typeface.DEFAULT_BOLD);
        binding.currentweight.setText("55");
        binding.currentweight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.currentweight.setTextSize(30);
        binding.currentweight.setTypeface(Typeface.DEFAULT_BOLD);
        binding.decrementweight.setImageResource(R.drawable.minus);
        binding.incrementweight.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);
        binding.textage.setTextSize(18);
        binding.textage.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.textage.setTypeface(Typeface.DEFAULT_BOLD);
        binding.textage.setText("Age");
        binding.currentage.setText("28");
        binding.currentage.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.currentage.setTextSize(30);
        binding.currentage.setTypeface(Typeface.DEFAULT_BOLD);
        binding.decrementage.setImageResource(R.drawable.minus);
        binding.incrementage.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);
        binding.calculatembmi.setText("Result");
        binding.calculatembmi.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.calculatembmi.setTypeface(Typeface.DEFAULT_BOLD);
        binding.calculatembmi.setTextSize(16);










        binding.male.setOnClickListener(view -> {
            binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
            typeofuser="Male";
            binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onbackground));
        });

        binding.female.setOnClickListener(view -> {
            binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
            typeofuser="Female";
            binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onbackground));
        });

        binding.currentheight.setText("170");
        binding.seekbarforheight.setMax(300);
        binding.seekbarforheight.setProgress(170);

        binding.seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentprogress=i;
                mintprogress=String.valueOf(i);
                binding.currentheight.setText(mintprogress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        binding.incrementage.setOnClickListener(view -> {
            intage +=1;
            strAge=String.valueOf(intage);
            binding.currentage.setText(strAge);
        });
        binding.decrementage.setOnClickListener(view -> {
            intage -=1;
            strAge=String.valueOf(intage);
            binding.currentage.setText(strAge);
        });
        binding.incrementweight.setOnClickListener(view -> {
            intweight+=1;
            strWeight=String.valueOf(intweight);
            binding.currentweight.setText(strWeight);
        });
        binding.decrementweight.setOnClickListener(view -> {
            intweight -=1;
            strWeight=String.valueOf(intweight);
            binding.currentweight.setText(strWeight);
        });

        binding.calculatembmi.setOnClickListener(view -> {
            if (typeofuser.equals("")) {
                Snackbar snackbar = Snackbar.make(binding.coordinator, "Select your Gender", Snackbar.LENGTH_LONG);
                snackbar.show();
            } else if (mintprogress.equals("0")) {
                Snackbar snackbar = Snackbar.make(binding.coordinator, "Select your Height", Snackbar.LENGTH_LONG);
                snackbar.show();
            } else if (intage == 0 || intage < 0) {
                Snackbar snackbar = Snackbar.make(binding.coordinator, "Age is iccorrect", Snackbar.LENGTH_LONG);
                snackbar.show();
            } else if (intweight == 0 || intweight < 0) {
                Snackbar snackbar = Snackbar.make(binding.coordinator, "weight is iccorrect", Snackbar.LENGTH_LONG);
                snackbar.show();
            } else {
                Intent intent=new Intent(MainActivity.this,SplahActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(Const.GENDER, typeofuser);
                bundle.putString(Const.HEIGHT, mintprogress);
                bundle.putString(Const.WEIGHT, strWeight);
                bundle.putString(Const.AGE, strAge);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}