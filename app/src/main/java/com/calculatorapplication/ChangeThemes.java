package com.calculatorapplication;

import static android.content.SharedPreferences.*;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.calculatorapplication.databinding.ActivityChangeThemesBinding;
import com.calculatorapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarItemView;

public class ChangeThemes extends AppCompatActivity {

    ActivityChangeThemesBinding switchBinding;

    SharedPreferences sharedPreferences;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        switchBinding=ActivityChangeThemesBinding.inflate(getLayoutInflater());

        setContentView(switchBinding.getRoot());






        switchBinding.toolBar2.setOnClickListener(v->{


            finish();
        });

        switchBinding.switchDark.setOnCheckedChangeListener((buttonView,isChecked) -> {



           sharedPreferences=this.getSharedPreferences("com.calculatorapplication", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            if( isChecked){

                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
              editor.putBoolean("switch",true);
                 }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

             editor.putBoolean("switch",false);

                 }
            editor.apply();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

     sharedPreferences=this.getSharedPreferences("com.calculatorapplication", Context.MODE_PRIVATE);

    switchBinding.switchDark.setChecked(sharedPreferences.getBoolean("switch",false));



    }
}