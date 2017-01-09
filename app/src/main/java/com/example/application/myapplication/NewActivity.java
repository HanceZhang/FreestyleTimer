package com.example.application.myapplication;

/**
 * Created by Hance on 2016-12-21.
 */
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.application.myapplication.databinding.NewActivityBinding;

import Util.Heap;
import ViewModels.NewActivityViewModel;

public class NewActivity extends AppCompatActivity {

    NewActivityViewModel newActivityVM = new NewActivityViewModel();

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        NewActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.new_activity);

        binding.setNewActivityViewModel(newActivityVM);

        binding.ResetButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Restart(0);
            }
        });

        binding.DeleteButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Delete(0);
            }
        });

        binding.ResetButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Restart(1);
            }
        });

        binding.DeleteButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Delete(1);
            }
        });

        binding.ResetButton3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Restart(2);
            }
        });

        binding.DeleteButton3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Delete(2);
            }
        });

        binding.ResetButton4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Restart(3);
            }
        });

        binding.DeleteButton4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivityVM.Delete(3);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        newActivityVM.setHeapHead();
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_newact, menu);
        return true;
    }

    public void actionAddClickHandler (MenuItem item)
    {
        Intent myIntent = new Intent(NewActivity.this, AddActivity.class);
        startActivity(myIntent);
    }

    public void actionEditClickHandler (MenuItem item)
    {
        Intent myIntent = new Intent(NewActivity.this, EditActivity.class);
        startActivity(myIntent);
    }
}
