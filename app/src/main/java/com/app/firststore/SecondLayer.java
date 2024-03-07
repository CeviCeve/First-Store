package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.firststore.Model.Bucket;
import com.app.firststore.Model.Course;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SecondLayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layer);

        ListView bucket_list = findViewById(R.id.bucketList);

        List<String> coursesTitle = new ArrayList<>();
//        for(Course c : MainActivity.fullList){
//            if(Bucket.items_id.contains(c.getId())){
//                coursesTitle.add(c.getTitle());
//            }
//        }

        FirebaseDatabase rootRef = FirebaseDatabase.getInstance();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = rootRef.getReference("Users//" + userId + "//favorite");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Course> list = new ArrayList<>();
                coursesTitle.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.d("ds", ds.getValue().toString());
                    Course c = ds.getValue(Course.class);
                    list.add(c);
                    coursesTitle.add(c.getTitle());
                }
                bucket_list.setAdapter(new ArrayAdapter<>(SecondLayer.this, android.R.layout.simple_list_item_1, coursesTitle));


                //Do what you need to do with your list
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("EEROR", databaseError.getMessage()); //Don't ignore errors!
            }
        };
        myRef.addListenerForSingleValueEvent(valueEventListener);


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