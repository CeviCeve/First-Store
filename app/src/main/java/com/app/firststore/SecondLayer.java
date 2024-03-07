package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.firststore.Model.Bucket;
import com.app.firststore.Model.Course;

import java.util.ArrayList;
import java.util.List;

public class SecondLayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layer);

        ListView bucket_list = findViewById(R.id.bucketList);

        List<String> coursesTitle = new ArrayList<>();
        for(Course c : MainActivity.fullList){
            if(Bucket.items_id.contains(c.getId())){
                coursesTitle.add(c.getTitle());
            }
        }
        bucket_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }

    //----переход к главному меню----//
    public void openMain(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    //----переход к чатам----//
    public void openThird(View view){
        finish();
        Intent intent = new Intent(this, ThirdLayer.class);
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