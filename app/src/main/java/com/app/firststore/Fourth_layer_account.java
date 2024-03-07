package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Fourth_layer_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer_account);
    }

    //----назад----//
    public void closeAccount(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void openReg(View view){
        Intent intent = new Intent(this, Fourth_layer_reg_update.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    //----выход из аккаунта----//
    public void login(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, Fourth_layer_Entrance.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}