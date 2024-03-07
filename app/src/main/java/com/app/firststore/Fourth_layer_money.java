package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.firststore.Adapters.DataValidator;
import com.app.firststore.Model.UserData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class Fourth_layer_money extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_layer_money);

        Button validateButton = (Button) findViewById(R.id.validate_button);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText field1 = (EditText) findViewById(R.id.field1);
                EditText field2 = (EditText) findViewById(R.id.field2);
                EditText field3 = (EditText) findViewById(R.id.field3);
                EditText field3_1 = (EditText) findViewById(R.id.field3_1);
                EditText field4 = (EditText) findViewById(R.id.field4);

                //long value1 = Integer.parseInt(field1.getText().toString());
                String value1 = field1.getText().toString();
                String value2 = field2.getText().toString();
                String value3 = field3.getText().toString();
                String value3_1 = field3_1.getText().toString();
                String value4 = field4.getText().toString();

                /*int value2 = Integer.parseInt(field2.getText().toString());
                int value3 = Integer.parseInt(field3.getText().toString());
                int value3_1 = Integer.parseInt(field3_1.getText().toString());
                int value4 = Integer.parseInt(field4.getText().toString());*/

                if (DataValidator.isValid(value1, value2, value3, value3_1, value4)) {

                    // Данные валидны
                    int newCache = Integer.parseInt(value4);
                    Toast.makeText(getApplicationContext(), "Cчет пополнен", Toast.LENGTH_SHORT).show();

                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();


                    //сумма для бд-------------------
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference balanceRef = database.getReference("Users//"+userId+"/balance");
                    balanceRef.runTransaction(new Transaction.Handler() {
                        @Override
                        public Transaction.Result doTransaction(MutableData mutableData) {
                            Integer currentValue = mutableData.getValue(Integer.class);
                            if (currentValue == null) {
                                mutableData.setValue(newCache); // myNumber - ваша числовая переменная
                            } else {
                                mutableData.setValue(currentValue + newCache);
                            }

                            return Transaction.success(mutableData);
                        }

                        @Override
                        public void onComplete(DatabaseError databaseError, boolean committed, DataSnapshot dataSnapshot) {
                            // Обработка ошибок
                        }
                    });
                    //-------------------------------


                    finish();

                } else {
                    // Данные невалидны
                    Toast.makeText(getApplicationContext(), "Данные введены с ошибкой", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    //----назад----//
    public void closeCache(View view){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}