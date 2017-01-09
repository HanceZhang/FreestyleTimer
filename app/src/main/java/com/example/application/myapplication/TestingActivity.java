package com.example.application.myapplication;

/**
 * Created by Hance on 2017-01-04.
 */

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.application.myapplication.databinding.NewActivityBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.Artifact;
import Util.Heap;
import ViewModels.NewActivityViewModel;
import adapters.ArtifactAdapter;

public class TestingActivity extends AppCompatActivity{
    private ArtifactAdapter artifactAdapter;
    NewActivityViewModel newActivityVM = new NewActivityViewModel();
    private RecyclerView recyclerView;
    private List<Artifact> artifactList;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_activity);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        artifactList = Arrays.asList(newActivityVM.getHeapHead());
        artifactAdapter = new ArtifactAdapter(artifactList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(artifactAdapter);
    }
}
