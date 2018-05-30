package com.example.jay.expandable_recyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.jay.expandable_recyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    RecyclerViewAdapterParent adapter = new RecyclerViewAdapterParent(this);
    binding.parentRecyclerView.setLayoutManager(layoutManager);
    binding.parentRecyclerView.setAdapter(adapter);
  }
}
