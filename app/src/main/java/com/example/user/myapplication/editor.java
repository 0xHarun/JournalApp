package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class editor extends AppCompatActivity {


    EditText edit_title;
    EditText edit_descript;
    Button mUpdateButton;
    DatabaseReference  databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_editor );

        edit_title = (EditText) findViewById( R.id.edit_title );
        edit_descript = (EditText) findViewById( R.id.edit_descript );
        mUpdateButton = (Button) findViewById( R.id.Button_Update );

        Intent intent = getIntent();

     //   String id = intent.getStringExtra( FirstPage.Title_ID );
       // String name = intent.getStringExtra( FirstPage.Title_Name );

        //edit_title.setText( name );
        //databaseReference = FirebaseDatabase.getInstance().getReference("Title").child( id );
    }
}
