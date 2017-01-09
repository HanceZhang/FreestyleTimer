package com.example.application.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RelativeLayout;

import Models.Artifact;
import Util.Heap;

/**
 * Created by Hance on 2016-12-21.
 */

public class AddActivity extends Activity{
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_activity);
    }

    //set name
    //set loop time
    //post form
    public void submitButtonHandler (View v){
        EditText nameField = (EditText)findViewById(R.id.artifactName);
        EditText loopTimeField = (EditText)findViewById(R.id.loopTime);

        String name = nameField.getText().toString();
        int loopTime = Integer.parseInt(loopTimeField.getText().toString());

        Heap.getInstance().TheHeap.Enqueue(new Artifact(name, loopTime));
        ((EditText)findViewById(R.id.loopTime)).setText("");
        ((EditText)findViewById(R.id.loopTime)).setText("");

    }
}
