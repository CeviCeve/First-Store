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

    int id_, color_, category_;
    String title_;
    String data_;
    String level_;
    String sale_;
    String text_;


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

        id_ = getIntent().getIntExtra("courseId", 1);
        title_ = getIntent().getStringExtra("courseTitle");
        data_ = getIntent().getStringExtra("courseText");
        level_ = getIntent().getStringExtra("courseLevel");;
        sale_ = getIntent().getStringExtra("courseSale");;
        text_ = getIntent().getStringExtra("courseText");;

    }

    //----в избранное----//
    public void addToCard(View view){

        if(FirebaseAuth.getInstance().getCurrentUser() == null)
        {
            Intent intent = new Intent(this, Fourth_layer_Entrance.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }else {

            ImageView star = findViewById(R.id.Star);
            star.setImageResource(R.drawable.staractiveall);
            Toast.makeText(getApplicationContext(), "Добавлено в избранные", Toast.LENGTH_SHORT).show();


            Log.d("text text", FirebaseAuth.getInstance().getCurrentUser().getUid());
            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference myRef = firebaseDatabase.getReference("Users//" + userId + "//favorite");
            myRef.push().setValue(new Course(id_, sale_, title_, data_, level_, 0, text_, 0));


            int item_id = getIntent().getIntExtra("courseId", 0);
            Bucket.items_id.add(item_id);
        }
    }

    //----назад----//
    public void close(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


}