package com.example.jay.expandable_recyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.jay.expandable_recyclerview.databinding.ChildCardBinding;

/**
 * Created by jay on 30/5/18.
 */

public class RecyclerViewAdapterChild extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  String[] str;
  public RecyclerViewAdapterChild(String[] str){
    this.str=str;
  }
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ChildCardBinding binding = DataBindingUtil.inflate(inflater, R.layout.child_card, parent, false);
    ChildHolder holder = new ChildHolder(binding);
    return holder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ChildHolder childHolder=(ChildHolder)holder;
    childHolder.binding.name.setText(str[position]);
  }

  @Override
  public int getItemCount() {
    return str.length;
  }
}
