package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

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
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            finish();
            Intent intent = new Intent(this, SecondLayer.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else {
            Toast.makeText(getApplicationContext(), "Пройдите регистрацию", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Fourth_layer_Entrance.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
    //----переход к ЛК----//
    public void openFourth(View view){
        finish();
        Intent intent = new Intent(this, FourthLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}