package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondPage extends AppCompatActivity {

   private EditText mNameEditText;
   private  EditText mDescriptionEditText;
   private  Button mButtonSave;
   private DatabaseReference mDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        mDatabase = FirebaseDatabase.getInstance().getReference("data");

       mNameEditText = (EditText) findViewById(R.id.edit_title_name);
       mDescriptionEditText = (EditText) findViewById(R.id.edit_description);
       mButtonSave = (Button) findViewById(R.id.Button_Save);

        mButtonSave.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick (View view){

               addText();

               Intent intent = new Intent( SecondPage.this, FirstPage.class);
              startActivity(intent);
            }
        });
        }

    private void addText () {
       String text = mNameEditText.getText().toString().trim();
       String description = mDescriptionEditText.getText().toString().trim();

        if (!TextUtils.isEmpty(text) || !TextUtils.isEmpty(description)) {

            String id = mDatabase.push().getKey();

            data data = new data(id, text, description);

            mDatabase.child( id ).setValue( data );

            mNameEditText.setText( " " );
            mDescriptionEditText.setText( " " );

            Toast.makeText(this, "Content added", Toast.LENGTH_LONG).show();

            startActivity(new Intent(SecondPage.this, FirstPage.class));
        } else {
            Toast.makeText(this, "Enter Content", Toast.LENGTH_LONG).show();

        }
    }

}
