package com.app.firststore.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.firststore.Model.Course;
import com.app.firststore.R;
import com.app.firststore.Second_layer_course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //какой дизайн использовать для отображения каждого элемента
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) { //что подставлять в дизайн
        //holder.courseBg.setBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        holder.courseBg.setBackgroundResource(courses.get(position).getColor());

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseData.setText(courses.get(position).getData());
        holder.courseLevel.setText(courses.get(position).getLevel());
        holder.courseSale.setText(courses.get(position).getSale());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Second_layer_course.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View, String>(holder.courseSale, "CourseName"));

                intent.putExtra("courseBg", courses.get(position).getColor());
                intent.putExtra("courseSale", courses.get(position).getSale());
                intent.putExtra("courseLevel", courses.get(position).getLevel());
                intent.putExtra("courseTitle", courses.get(position).getTitle());
                intent.putExtra("courseText", courses.get(position).getText());
                intent.putExtra("courseId", courses.get(position).getId());



                context.startActivity(intent, options.toBundle());

            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder{ //c какими полями работаем

        LinearLayout courseBg;
        TextView courseTitle, courseData, courseLevel, courseSale;
        ImageView courseStar;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseBg = itemView.findViewById(R.id.courseBg);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseData = itemView.findViewById(R.id.courseData);
            courseLevel = itemView.findViewById(R.id.courseLevel);
            courseSale = itemView.findViewById(R.id.courseSale);
            //courseStar =itemView.findViewById(R.id.star);
        }
    }
}
