package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class FourthLayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer);

        TextView textView = findViewById(R.id.cache);
        MainActivity.money(textView);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseDatabase rootRef = FirebaseDatabase.getInstance();
        DatabaseReference myRef = rootRef.getReference("Users//" + userId);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.child("username").getValue(String.class);

                if(username != null) {
                    Log.d("username", username);

                    TextView textView1 = (TextView) findViewById(R.id.UserName);
                    textView1.setText(String.valueOf(username));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    //------------------------нижнее меню------------------------//
    //----переход к главному меню----//
    public void openMain(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    //----переход к избранному----//
    public void openSecond(View view){
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            finish();
            Intent intent = new Intent(this, SecondLayer.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else {
            Toast.makeText(getApplicationContext(), "Пройдите регистрацию", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Fourth_layer_Entrance.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
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