// Generated by view binder compiler. Do not edit!
package com.app.firststore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.firststore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFourthLayerAccountBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView UserName;

  @NonNull
  public final ImageView imageView10;

  @NonNull
  public final ImageView imageView13;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView numCourses;

  @NonNull
  public final TextView percent;

  @NonNull
  public final TextView pochta;

  @NonNull
  public final TextView status;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView19;

  @NonNull
  public final TextView textView21;

  @NonNull
  public final TextView textView5;

  private ActivityFourthLayerAccountBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView UserName, @NonNull ImageView imageView10, @NonNull ImageView imageView13,
      @NonNull ImageView imageView4, @NonNull TextView numCourses, @NonNull TextView percent,
      @NonNull TextView pochta, @NonNull TextView status, @NonNull TextView textView12,
      @NonNull TextView textView13, @NonNull TextView textView15, @NonNull TextView textView17,
      @NonNull TextView textView19, @NonNull TextView textView21, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.UserName = UserName;
    this.imageView10 = imageView10;
    this.imageView13 = imageView13;
    this.imageView4 = imageView4;
    this.numCourses = numCourses;
    this.percent = percent;
    this.pochta = pochta;
    this.status = status;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView15 = textView15;
    this.textView17 = textView17;
    this.textView19 = textView19;
    this.textView21 = textView21;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFourthLayerAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFourthLayerAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_fourth_layer_account, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFourthLayerAccountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.UserName;
      TextView UserName = ViewBindings.findChildViewById(rootView, id);
      if (UserName == null) {
        break missingId;
      }

      id = R.id.imageView10;
      ImageView imageView10 = ViewBindings.findChildViewById(rootView, id);
      if (imageView10 == null) {
        break missingId;
      }

      id = R.id.imageView13;
      ImageView imageView13 = ViewBindings.findChildViewById(rootView, id);
      if (imageView13 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.numCourses;
      TextView numCourses = ViewBindings.findChildViewById(rootView, id);
      if (numCourses == null) {
        break missingId;
      }

      id = R.id.percent;
      TextView percent = ViewBindings.findChildViewById(rootView, id);
      if (percent == null) {
        break missingId;
      }

      id = R.id.pochta;
      TextView pochta = ViewBindings.findChildViewById(rootView, id);
      if (pochta == null) {
        break missingId;
      }

      id = R.id.status;
      TextView status = ViewBindings.findChildViewById(rootView, id);
      if (status == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView19;
      TextView textView19 = ViewBindings.findChildViewById(rootView, id);
      if (textView19 == null) {
        break missingId;
      }

      id = R.id.textView21;
      TextView textView21 = ViewBindings.findChildViewById(rootView, id);
      if (textView21 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new ActivityFourthLayerAccountBinding((ConstraintLayout) rootView, UserName,
          imageView10, imageView13, imageView4, numCourses, percent, pochta, status, textView12,
          textView13, textView15, textView17, textView19, textView21, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
