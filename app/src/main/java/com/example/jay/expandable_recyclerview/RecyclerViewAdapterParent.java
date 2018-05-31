package com.example.jay.expandable_recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

import com.example.jay.expandable_recyclerview.databinding.ParentCardBinding;

/**
 * Created by jay on 30/5/18.
 */

public class RecyclerViewAdapterParent extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  String[] str = {"lollipop", "HoneyComb", "oreo", "KitKat"};
  int currentPosition = 0;
  RecyclerView recyclerView;
  Context context;

  public RecyclerViewAdapterParent(Context context, RecyclerView recyclerView) {
    this.context = context;
    this.recyclerView = recyclerView;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ParentCardBinding binding = DataBindingUtil.inflate(inflater, R.layout.parent_card, parent, false);
    ParentHolder holder = new ParentHolder(binding);
    return holder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    final ParentHolder parentHolder = (ParentHolder) holder;
    parentHolder.binding.text.setText(String.valueOf(position) +" - "+ String.valueOf(currentPosition));
    if(currentPosition==position){
      parentHolder.binding.childRecyclerView.setVisibility(View.VISIBLE);
      parentHolder.binding.text.setTextColor(context.getResources().getColor(R.color.colorPrimary));
    }
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    RecyclerViewAdapterChild adapter = new RecyclerViewAdapterChild(str);
    parentHolder.binding.childRecyclerView.setLayoutManager(layoutManager);
    parentHolder.binding.childRecyclerView.setAdapter(adapter);
    parentHolder.binding.titleCard.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (currentPosition != position) {
          ParentHolder parentHolder1 = (ParentHolder) recyclerView.findViewHolderForAdapterPosition(currentPosition);
          if (parentHolder1 != null) {
//            TranslateAnimation animate = new TranslateAnimation(
//                    0,                 // fromXDelta
//                    0,                 // toXDelta
//                    0,  // fromYDelta
//                    parentHolder1.binding.childRecyclerView.getHeight());                // toYDelta
//            animate.setDuration(500);
//            animate.setFillAfter(true);
//            Animation animation= AnimationUtils.loadAnimation(context, R.anim.slide_up);
//            animation.setFillAfter(true);
//            parentHolder1.binding.childRecyclerView.startAnimation(animate);
            parentHolder1.binding.text.setTextColor(context.getResources().getColor(R.color.border_gray));
//          RecyclerViewAdapterParent.collapse(parentHolder1.binding.childRecyclerView);
//            parentHolder1.binding.childRecyclerView.setVisibility(View.GONE);
          }
//          TranslateAnimation animate = new TranslateAnimation(
//                  0,                 // fromXDelta
//                  0,                 // toXDelta
//                  parentHolder.binding.childRecyclerView.getHeight(),  // fromYDelta
//                  0);                // toYDelta
//          animate.setDuration(500);
//          animate.setFillAfter(true);
//          Animation animation= AnimationUtils.loadAnimation(context, R.anim.slide_down);
//          parentHolder.binding.childRecyclerView.setVisibility(View.VISIBLE);
//          parentHolder.binding.childRecyclerView.startAnimation(animate);
          parentHolder.binding.text.setTextColor(context.getResources().getColor(R.color.colorPrimary));
          RecyclerViewAdapterParent.expand(parentHolder.binding.childRecyclerView);
          currentPosition=position;
        }
//        ((LinearLayoutManager)(recyclerView.getLayoutManager())).scrollToPositionWithOffset(position,0);
      }
    });
  }

  @Override
  public int getItemCount() {
    return 50;
  }

  public static void expand(final View v) {
    v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    final int targetHeight = v.getMeasuredHeight();

    // Older versions of android (pre API 21) cancel animations for views with a height of 0.
    v.getLayoutParams().height = 1;
    v.setVisibility(View.VISIBLE);
    Animation a = new Animation()
    {
      @Override
      protected void applyTransformation(float interpolatedTime, Transformation t) {
        v.getLayoutParams().height = interpolatedTime == 1
                ? ViewGroup.LayoutParams.WRAP_CONTENT
                : (int)(targetHeight * interpolatedTime);
        v.requestLayout();
      }

      @Override
      public boolean willChangeBounds() {
        return true;
      }
    };

    // 1dp/ms
    a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
    v.startAnimation(a);
  }

  public static void collapse(final View v) {
    final int initialHeight = v.getMeasuredHeight();

    Animation a = new Animation()
    {
      @Override
      protected void applyTransformation(float interpolatedTime, Transformation t) {
        if(interpolatedTime == 1){
          v.setVisibility(View.GONE);
        }else{
          v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
          v.requestLayout();
        }
      }

      @Override
      public boolean willChangeBounds() {
        return true;
      }
    };

    // 1dp/ms
    a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
    v.startAnimation(a);
  }


}
