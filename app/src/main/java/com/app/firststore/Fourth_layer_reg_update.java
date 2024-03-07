package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Fourth_layer_reg_update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer_reg_update);
    }

    //----назад----//
    public void closeAccount(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}