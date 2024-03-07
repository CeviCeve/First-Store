package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdLayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therd_layer);
    }

    //----переход к главному меню----//
    public void openMain(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    //----переход к избранному----//
    public void openSecond(View view){
        finish();
        Intent intent = new Intent(this, SecondLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    //----переход к ЛК----//
    public void openFourth(View view){
        finish();
        Intent intent = new Intent(this, FourthLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}