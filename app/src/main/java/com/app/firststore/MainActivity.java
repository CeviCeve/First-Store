package com.app.firststore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.firststore.Adapters.CacheMashine;
import com.app.firststore.Adapters.CategoryAdapter;
import com.app.firststore.Adapters.CourseAdapter;
import com.app.firststore.Model.Category;
import com.app.firststore.Model.Course;
import com.app.firststore.Repository.Courses_repository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //startActivities(new Intent(this, Fourth_layer_money.class));
        //Courses_repository.getAll();

        //----1----//
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Движки"));
        categoryList.add(new Category(2, "Дизайн"));
        categoryList.add(new Category(3, "Языки"));

        categoryList.add(new Category(987, "Reset"));

        setCategoryRecycler(categoryList);

        //----2----//
        int course1=200;
        int course2=150;
        int course3=500;
        int course4=100;
        int course5=500;


        TextView textView = findViewById(R.id.cache);
        textView.setText(CacheMashine.setCache());


        courseList.add(new Course(1, String.valueOf(course1) + " BYN","Рhotoshop", "Быстро\nКачественно\nДоступно" ,"Профессионал",R.drawable.gradient_6, "k", 2));
        courseList.add(new Course(2, String.valueOf(course2) + " BYN","Разработка приложений на Java", "Качественно\nДоступно" ,"Начинающий",R.drawable.gradient_4, "k",3));
        courseList.add(new Course(3, String.valueOf(course3) + " BYN","Unity для чайников", "Доступно" ,"Начинающий",R.drawable.gradient_5, "k",1));
        courseList.add(new Course(4, String.valueOf(course4) + " BYN","Разработка приложений на петухоне", "Быстро\nКачественно\nДоступно" ,"Продвинутый",R.drawable.gradient_2, "k",3));
        courseList.add(new Course(5, String.valueOf(course5) + " BYN","UnrealEngine 5 с помощью C++", "Быстро\nКачественно\nДоступно" ,"Продвинутый",R.drawable.gradient_1, "k",1));

        fullList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    //----переход к избранному----//
    public void openSecond(View view){

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("key");
        myRef.setValue(new Course(1, String.valueOf(1234) + " BYN","Рhotoshop", "Быстро\nКачественно\nДоступно" ,"Профессионал",R.drawable.gradient_6, "k", 2));

        TextView textView = findViewById(R.id.cache);
        textView.setText(CacheMashine.setCache());

        Intent intent = new Intent(this, SecondLayer.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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