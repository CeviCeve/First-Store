package com.app.firststore;

import static com.app.firststore.MainActivity.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.firststore.Model.Course;
import com.app.firststore.Model.UserData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Fourth_layer_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer_account);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseDatabase rootRef = FirebaseDatabase.getInstance();
        DatabaseReference myRef = rootRef.getReference("Users//" + userId);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.child("username").getValue(String.class);
                String email = snapshot.child("email").getValue(String.class);
                String status = snapshot.child("status").getValue(String.class);
                Integer numCourses = snapshot.child("numCourses").getValue(Integer.class);
                Integer percent;

                if(numCourses <=10){ percent = numCourses;}
                else if(numCourses>100){ percent = 9 + numCourses - (int)(numCourses * 0.75);}
                else{percent = 35;}

                if(username != null) {
                    Log.d("username", username);
                    Log.d("email", email);
                    Log.d("status", status);

                    TextView textView1 = (TextView) findViewById(R.id.UserName);
                    textView1.setText(String.valueOf(username));

                    TextView textView2 = (TextView) findViewById(R.id.pochta);
                    textView2.setText(String.valueOf(email));

                    TextView textView3 = (TextView) findViewById(R.id.status);
                    textView3.setText(String.valueOf(status));

                    TextView textView4 = (TextView) findViewById(R.id.numCourses);
                    textView4.setText(String.valueOf(numCourses.toString()));

                    TextView textView5 = (TextView) findViewById(R.id.percent);
                    textView5.setText(String.valueOf(percent.toString()+"%"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    //----назад----//
    public void closeAccount(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //------редактировать аккаунт------//
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