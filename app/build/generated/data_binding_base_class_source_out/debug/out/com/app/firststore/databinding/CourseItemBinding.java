// Generated by view binder compiler. Do not edit!
package com.app.firststore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.firststore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CourseItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final LinearLayout courseBg;

  @NonNull
  public final TextView courseData;

  @NonNull
  public final TextView courseLevel;

  @NonNull
  public final TextView courseSale;

  @NonNull
  public final TextView courseTitle;

  private CourseItemBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView,
      @NonNull LinearLayout courseBg, @NonNull TextView courseData, @NonNull TextView courseLevel,
      @NonNull TextView courseSale, @NonNull TextView courseTitle) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.courseBg = courseBg;
    this.courseData = courseData;
    this.courseLevel = courseLevel;
    this.courseSale = courseSale;
    this.courseTitle = courseTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CourseItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CourseItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.course_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CourseItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.courseBg;
      LinearLayout courseBg = ViewBindings.findChildViewById(rootView, id);
      if (courseBg == null) {
        break missingId;
      }

      id = R.id.courseData;
      TextView courseData = ViewBindings.findChildViewById(rootView, id);
      if (courseData == null) {
        break missingId;
      }

      id = R.id.courseLevel;
      TextView courseLevel = ViewBindings.findChildViewById(rootView, id);
      if (courseLevel == null) {
        break missingId;
      }

      id = R.id.courseSale;
      TextView courseSale = ViewBindings.findChildViewById(rootView, id);
      if (courseSale == null) {
        break missingId;
      }

      id = R.id.courseTitle;
      TextView courseTitle = ViewBindings.findChildViewById(rootView, id);
      if (courseTitle == null) {
        break missingId;
      }

      return new CourseItemBinding((ConstraintLayout) rootView, cardView, courseBg, courseData,
          courseLevel, courseSale, courseTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
