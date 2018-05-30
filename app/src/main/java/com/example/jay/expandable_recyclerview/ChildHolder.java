package com.example.jay.expandable_recyclerview;

import android.support.v7.widget.RecyclerView;

import com.example.jay.expandable_recyclerview.databinding.ChildCardBinding;
import com.example.jay.expandable_recyclerview.databinding.ParentCardBinding;

/**
 * Created by jay on 30/5/18.
 */

public class ChildHolder extends RecyclerView.ViewHolder {
  ChildCardBinding binding;
  public ChildHolder(ChildCardBinding  binding) {
    super(binding.getRoot());
    this.binding=binding;
  }
}
