package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class FirstPage extends AppCompatActivity {

  public  static final String Title_Name = "Title";
   public  static final String Title_ID = "TitleID";
    public  static final String Title_Description= "Description";
    public LinearLayout linearLayout;
    private FirebaseAuth mAuth;
    private RecyclerView mEntryList;

    private GoogleApiClient mGoogleApiClient;

    private FloatingActionButton mFloatingActionButton;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference databaseData ;
    List <data> dataList;
    private Query mQueryCurrentUser;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        mAuth = FirebaseAuth.getInstance();

        String currentUserId = mAuth.getCurrentUser().getUid();
        databaseData = FirebaseDatabase.getInstance().getReference("data");
        databaseData.keepSynced(true);
        mCurrentUser = mAuth.getCurrentUser();

        mQueryCurrentUser = databaseData.orderByChild("uid").equalTo(currentUserId);

        mEntryList = (RecyclerView) findViewById( R.id.entry_list );
        mEntryList.setHasFixedSize(true);
        mEntryList.setLayoutManager(new LinearLayoutManager(this));

        mFloatingActionButton  = (FloatingActionButton) findViewById(R.id.floatActionBtn);


       mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
               Intent intent = new Intent( FirstPage.this, SecondPage.class);
                startActivity(intent);
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            if (firebaseAuth.getCurrentUser() == null){

                startActivity(new Intent(FirstPage.this, MainActivity.class));
            }
            }
        };

            }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

        FirebaseRecyclerAdapter<data, EntryViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<data, EntryViewHolder>(
                data.class,
                R.layout.row,
                EntryViewHolder.class,
                databaseData

                ){
            @Override
            protected void populateViewHolder(EntryViewHolder viewHolder, data model, int position) {

                viewHolder.setTitleName(model.getTitleName());
                viewHolder.setDescriptionName(model.getDescriptionName());
                //viewHolder.setdate(model.getdate());

                viewHolder.mView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent( FirstPage.this, editor.class);
                        startActivity(intent);

                        Toast.makeText( FirstPage.this, "You clicked and item", Toast.LENGTH_SHORT ).show();
                    }
                } );

            }
                };

        mEntryList.setAdapter( firebaseRecyclerAdapter );
    }

    private void logout() {

        mAuth.signOut();
    }

      private  void showUpdateDialog(final String title_ID, final String title_Name) {
          AlertDialog.Builder dialogBuilder = new AlertDialog.Builder( this );

          LayoutInflater inflater = getLayoutInflater();

          final View dialogView = inflater.inflate( R.layout.activity_editor, null );

          dialogBuilder.setView( dialogView );

          final EditText editTextTitle = (EditText) dialogView.findViewById( R.id.edit_title );
          final EditText editTextDescript = (EditText) dialogView.findViewById( R.id.edit_descript );
          final Button editUpdate = (Button) dialogView.findViewById( R.id.Button_Update );
          final Button editDelete = (Button) dialogView.findViewById( R.id.Button_Delete );

          dialogBuilder.setTitle( "Updating Data" + title_ID );

          final AlertDialog alertDialog = dialogBuilder.create();
          alertDialog.show();
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_Log_Out:

                int id = item.getItemId();

                if (id == R.id.action_Log_Out){

                    logout();
                    return true;
                }

                return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }


    public static class EntryViewHolder extends RecyclerView.ViewHolder{

        View mView;



        public EntryViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setTitleName(String title){

            TextView e_title = (TextView) mView.findViewById(R.id.entry_title);
            e_title.setText(title);

        }

        public void setDescriptionName(String content){

            TextView e_content = (TextView) mView.findViewById(R.id.entry_content);
            e_content.setText(content);
        }


    }


    }

