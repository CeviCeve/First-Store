package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.firststore.databinding.ActivityFourthLayerEntranceBinding;
import com.app.firststore.databinding.ActivityFourthLayerRegBinding;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Fourth_layer_Entrance extends AppCompatActivity {

    private ActivityFourthLayerEntranceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFourthLayerEntranceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_fourth_layer_entrance);
        //Button login = findViewById(R.id.login_btn);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.email.getText().toString().isEmpty() || binding.password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.email.getText().toString(), binding.password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
                                        finish();
                                        //startActivity(new Intent(Fourth_layer_Entrance.this, MainActivity.class));///<-переход н новую страницу
                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                    }
                                }
                            });
                }
            }
        });
    }

    //----переход к окну аккаунта----//
    public void close(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void openReg(View view){
        Intent intent = new Intent(this, Fourth_layer_Reg.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}