package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Fourth_layer_my_courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer_my_courses);
    }

    //----назад----//
    public void closeMyCourses(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}