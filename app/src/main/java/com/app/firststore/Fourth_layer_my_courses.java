package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.firststore.Adapters.CategoryAdapter;
import com.app.firststore.Adapters.CourseAdapter;
import com.app.firststore.Model.Course;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Fourth_layer_my_courses extends AppCompatActivity {

    RecyclerView courseRecycler;
    static CourseAdapter courseAdapter;
    static List<Course> list = new ArrayList<>();
    static List<Course> fullList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fourth_layer_my_courses);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase rootRef = FirebaseDatabase.getInstance();
        DatabaseReference myRef = rootRef.getReference("Users/"+userId+"/Purchased");

        ValueEventListener valueEventListener = new ValueEventListener() { //реакция на изменение бд
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.d("Add", ds.getValue().toString());
                    Course c = ds.getValue(Course.class);
                    list.add(c);
                }

                //Do what you need to do with your list
                setCourseRecycler(list);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { // реакция если ошибка
                Log.d("EEROR", databaseError.getMessage()); //Don't ignore errors!
            }
        };
        myRef.addValueEventListener(valueEventListener);
    }


    //----2----//
    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        courseRecycler = findViewById(R.id.recyclerCours);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this,courseList);
        courseRecycler.setAdapter(courseAdapter);
    }
    //----назад----//
    public void closeMyCourses(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}