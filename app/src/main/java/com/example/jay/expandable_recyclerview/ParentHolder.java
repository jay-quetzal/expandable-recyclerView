package com.example.jay.expandable_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jay.expandable_recyclerview.databinding.ParentCardBinding;

/**
 * Created by jay on 30/5/18.
 */

public class ParentHolder extends RecyclerView.ViewHolder {
  ParentCardBinding binding;
  public ParentHolder(ParentCardBinding binding) {
    super(binding.getRoot());
    this.binding=binding;
  }
}
