package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class editor extends AppCompatActivity {

    public Button btnUpdate;
    public Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_editor);


        btnUpdate = (Button) findViewById( R.id.Button_Update );
        btnDelete = (Button) findViewById( R.id.Button_Delete );
        
        btnUpdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText( editor.this, "Data Updated", Toast.LENGTH_SHORT ).show();

                Intent intent = new Intent( editor.this, FirstPage.class);
                startActivity(intent);
            }
        } );

        btnDelete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( editor.this, "Data Deleted", Toast.LENGTH_SHORT ).show();

                Intent intent = new Intent( editor.this, FirstPage.class);
                startActivity(intent);
            }
        } );

    }
}