package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bmiapp.databinding.ActivitySplahBinding;

public class SplahActivity extends AppCompatActivity {
    private ActivitySplahBinding binding;
    String height , weight;
    int intbmi,intheight,intweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle=getIntent().getExtras();
        height=bundle.getString(Const.HEIGHT);
        weight=bundle.getString(Const.WEIGHT);
        intheight=Integer.parseInt(height);
        intweight=Integer.parseInt(weight);
        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);
        String intbmi2= String.valueOf(intbmi);

        if (intbmi<16)
        {
            binding.textviewHealth.setText("severe Thinness");
            binding.lottieSplash.setImageResource(R.drawable.img_1);
            binding.textviewResult.setText(intbmi2);
        }

        else if (intbmi<16.9 && intbmi>16)
        {
            binding.textviewHealth.setText("moderate Thinness");
            binding.lottieSplash.setImageResource(R.drawable.img_2);
            binding.textviewResult.setText(intbmi2);

        }

        else if (intbmi<18.4 && intbmi>17)
        {
            binding.textviewHealth.setText("Mild Thinness");
            binding.textviewResult.setText(intbmi2);
            binding.lottieSplash.setImageResource(R.drawable.img_1);

        }

        else if (intbmi<25 && intbmi>18.4)
        {
            binding.textviewHealth.setText("normal");
            binding.lottieSplash.setImageResource(R.drawable.img);
            binding.textviewResult.setText(intbmi2);

        }
        else if (intbmi<29.4 && intbmi>25)
        {
            binding.textviewHealth.setText("overweight");
            binding.lottieSplash.setImageResource(R.drawable.img_1);
            binding.textviewResult.setText(intbmi2);

        }
        else
        {
            binding.textviewHealth.setText("obese class I");
            binding.lottieSplash.setImageResource(R.drawable.img_1);
            binding.textviewResult.setText(intbmi2);

        }
        binding.backButton.setOnClickListener(view -> {
            Intent intent=new Intent(SplahActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}