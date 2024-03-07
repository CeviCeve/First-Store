package com.app.firststore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.firststore.Adapters.CacheMashine;
import com.app.firststore.Adapters.DataValidator;

import org.checkerframework.checker.signedness.qual.Unsigned;

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
                    int a = Integer.parseInt(value4);
                    CacheMashine.getCache(a);
                    Toast.makeText(getApplicationContext(), "Cчет пополнен", Toast.LENGTH_SHORT).show();
                } else {
                    // Данные невалидны
                    Toast.makeText(getApplicationContext(), "Данные невалидны", Toast.LENGTH_SHORT).show();
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