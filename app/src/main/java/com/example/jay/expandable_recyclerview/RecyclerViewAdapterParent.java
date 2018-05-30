package com.example.jay.expandable_recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.expandable_recyclerview.databinding.ParentCardBinding;

/**
 * Created by jay on 30/5/18.
 */

public class RecyclerViewAdapterParent extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  String[] str = {"lollipop", "HoneyComb", "oreo", "KitKat"};

  Context context;
  public RecyclerViewAdapterParent(Context context){
    this.context=context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ParentCardBinding binding = DataBindingUtil.inflate(inflater, R.layout.parent_card, parent, false);
    ParentHolder holder = new ParentHolder(binding);
    return holder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    ParentHolder parentHolder=(ParentHolder)holder;
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    RecyclerViewAdapterChild adapter = new RecyclerViewAdapterChild(str);
    parentHolder.binding.childRecyclerView.setLayoutManager(layoutManager);
    parentHolder.binding.childRecyclerView.setAdapter(adapter);
    parentHolder.binding.titleCard.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });
  }

  @Override
  public int getItemCount() {
    return 10;
  }
}
