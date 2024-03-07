package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.firststore.Model.Bucket;
import com.app.firststore.Model.Course;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Second_layer_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layer_course);

        TextView bg1 = findViewById(R.id.bg1);
        ImageView bg2 = findViewById(R.id.bg2);
        TextView level = findViewById(R.id.courseLevel);
        TextView sale = findViewById(R.id.courseSale);
        TextView Data = findViewById(R.id.courseData);


        bg1.setBackgroundResource(getIntent().getIntExtra("courseBg", 0));
        bg1.setText(getIntent().getStringExtra("courseTitle"));
        bg2.setImageResource(getIntent().getIntExtra("courseBg", 0));
        level.setText(getIntent().getStringExtra("courseLevel"));
        sale.setText(getIntent().getStringExtra("courseSale"));
        Data.setText(getIntent().getStringExtra("courseText"));

    }

    //----в избранное----//
    public void addToCard(View view){

        ImageView star = findViewById(R.id.Star);
        star.setImageResource(R.drawable.staractiveall);
        Toast.makeText(getApplicationContext(), "Добавлено в избранные", Toast.LENGTH_SHORT).show();


        Log.d("text text", FirebaseAuth.getInstance().toString());
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance().userId;
        DatabaseReference myRef = firebaseDatabase.getReference("key");
        myRef.setValue(new Course(1, String.valueOf(1234) + " BYN","Рhotoshop", "Быстро\nКачественно\nДоступно" ,"Профессионал",R.drawable.gradient_6, "k", 2));


        int item_id = getIntent().getIntExtra("courseId", 0);
        Bucket.items_id.add(item_id);
    }

    //----назад----//
    public void close(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


}