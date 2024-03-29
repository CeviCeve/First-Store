package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.firststore.Adapters.CategoryAdapter;
import com.app.firststore.Adapters.CourseAdapter;
import com.app.firststore.Model.Category;
import com.app.firststore.Model.Course;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullList = new ArrayList<>();
    static List<Course> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // FirebaseAuth.getInstance().signOut();//<-- выход из аккаунта

        Log.d("fbAdd", "ds.getValue().toString()");


        //----1----//
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Движки"));
        categoryList.add(new Category(2, "Дизайн"));
        categoryList.add(new Category(3, "Языки"));

        categoryList.add(new Category(987, "Reset"));

        setCategoryRecycler(categoryList);

        //----2----//
        TextView textView = findViewById(R.id.cache);

        FirebaseDatabase rootRef = FirebaseDatabase.getInstance();
        DatabaseReference myRef = rootRef.getReference("Course");

        ValueEventListener valueEventListener = new ValueEventListener() { //реакция на изменение бд
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //List<Course> list = new ArrayList<>();
                fullList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.d("fbAdd", ds.getValue().toString());
                    Course c = ds.getValue(Course.class);
                    list.add(c);
                }

                fullList.addAll(list);
                courseList.addAll(list);

                setCourseRecycler(courseList);
                money(textView);
                //Do what you need to do with your list
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { // реакция если ошибка
                Log.d("EEROR", databaseError.getMessage()); //Don't ignore errors!
            }
        };
        myRef.addValueEventListener(valueEventListener);
    }




    //----покаазывать кошелек----//
public static void money(TextView textView)
{
    if(FirebaseAuth.getInstance().getCurrentUser() != null)
    {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users//" + userId + "/balance");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                // теперь у вас есть значение из Firebase

                //TextView textView = (TextView) findViewById(R.id.my_textview);
                textView.setText(String.valueOf(value)+" р");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // обработка ошибок
            }
        });
    }


}

    //----переход к избранному----//
    public void openSecond(View view){
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
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

    public void reset(View view){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = firebaseDatabase.getReference("Course/");

        String a1 = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems. Разработка ведётся сообществом, организованным через Java Community Process; язык и основные реализующие его технологии распространяются по лицензии GPL.";
        String a2 = "Adobe Photoshop — многофункциональный растровый графический редактор, разрабатываемый и распространяемый компанией Adobe Systems. В основном работает с растровыми изображениями, однако имеет некоторые векторные инструменты. Продукт является лидером рынка в области коммерческих средств редактирования растровых изображений и наиболее известной программой разработчика.";
        String a3 = "Unity — кроссплатформенная среда разработки компьютерных игр[3], разработанная американской компанией Unity Technologies. Unity позволяет создавать приложения, работающие на более чем 25 различных платформах, включающих персональные компьютеры, игровые консоли, мобильные устройства, интернет-приложения и другие[4]. Выпуск Unity состоялся в 2005 году и с того времени идёт постоянное развитие.";
        String a4 = "Python  — высокоуровневый язык программирования общего назначения с динамической строгой типизацией и автоматическим управлением памятью[19][20], ориентированный на повышение производительности разработчика, читаемости кода и его качества, а также на обеспечение переносимости написанных на нём программ[21]. Язык является полностью объектно-ориентированным в том плане, что всё является объектами[19]. Необычной особенностью языка является выделение блоков кода отступами[22]. Синтаксис ядра языка минималистичен, за счёт чего на практике редко возникает необходимость обращаться к документации[21]. Сам же язык известен как интерпретируемый и используется в том числе для написания скриптов";
        String a5 = "Unreal Engine — игровой движок, разрабатываемый и поддерживаемый компанией Epic Games. Первой игрой на этом движке был шутер от первого лица Unreal, выпущенный в 1998 году. Хотя движок первоначально был предназначен для разработки шутеров от первого лица, его последующие версии успешно применялись в играх самых различных жанров, в том числе стелс-играх, файтингах, массовых многопользовательских ролевых онлайн-играх и многих других ";

        myRef1.push().setValue(new Course(1, "200","Рhotoshop", "Высокие запросы\nКачественный подход\nДоступное объяснение" ,"Профессионал",R.drawable.gradient_6, a2, 2));
        myRef1.push().setValue(new Course(2, "150","Разработка приложений на Java", "Высокие запросы\nКачественный подход\nДоступное объяснение" ,"Начинающий",R.drawable.gradient_4, a1,3));
        myRef1.push().setValue(new Course(3, "310","Unity для чайников", "Высокие запросы\nКачественный подход\nДоступное объяснение" ,"Начинающий",R.drawable.gradient_5, a3,1));
        myRef1.push().setValue(new Course(4, "666","Разработка приложений на петухоне", "Высокие запросы\nКачественный подход\nДоступное объяснение" ,"Продвинутый",R.drawable.gradient_2, a4,3));
        myRef1.push().setValue(new Course(5, "200","UnrealEngine 5 с помощью C++", "Высокие запросы\nКачественный подход\nДоступное объяснение" ,"Продвинутый",R.drawable.gradient_1, a5,1));
        myRef1.push().setValue(new Course(1, "300","Рhotoshop", "Высокие запросы\nКачественный подход\nДоступное объяснение" ,"Профессионал",R.drawable.gradient_6, a2, 2));

    }
    //----переход к чатам----//
    public void openThird(View view){
        Intent intent = new Intent(this, ThirdLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //----переход к ЛК----//
    public void openFourth(View view){
        Intent intent = new Intent(this, FourthLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //----2----//
    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        courseRecycler = findViewById(R.id.recyclerCourse);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this,courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    //----1----//
    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }



    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullList);

        if(category != 987) {
            List<Course> filter = new ArrayList<>();
            for (Course c : courseList) {
                if (c.getCategory() == category)
                    filter.add(c);
            }

            courseList.clear();
            courseList.addAll(filter);
        }

        courseAdapter.notifyDataSetChanged();
    }
}