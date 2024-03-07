package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class FourthLayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer);
    }
    //------------------------нижнее меню------------------------//
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
    //----переход к чатам----//
    public void openThird(View view){
        finish();
        Intent intent = new Intent(this, ThirdLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //------------------------кнопки------------------------//
    //----переход к мои курсам----//
    public void myCourses(View view){
        Intent intent = new Intent(this, Fourth_layer_my_courses.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    //----переход к пополнению счета----//
    public void giveCache(View view){
        Log.d("text", "textextext");
        Intent intent = new Intent(this, Fourth_layer_money.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    //----переход к данным аккаунта----//
    public void accountLayer(View view){
        Log.d("text","texttexttex");

        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            startActivity(new Intent(this, Fourth_layer_Entrance.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else {
        Intent intent = new Intent(this, Fourth_layer_account.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

}