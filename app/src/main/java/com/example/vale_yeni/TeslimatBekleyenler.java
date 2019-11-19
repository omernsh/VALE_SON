package com.example.vale_yeni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeslimatBekleyenler extends AppCompatActivity {


    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private FirebaseUser fUser;
    private ArrayList<Message> chatLists = new ArrayList<>();
    private CustomAdapter_Tes_Bekleyen customAdapter;
    private String subject;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teslimat_bekleyenler);

        listView = (ListView)findViewById(R.id.chatListView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(TeslimatBekleyenler.this,TeslimatıTamamla.class);
                intent.putExtra("sıra_key", position);
                startActivity(intent);


            }
        });



        db = FirebaseDatabase.getInstance();
        customAdapter = new CustomAdapter_Tes_Bekleyen(getApplicationContext(),chatLists,fUser);
        listView.setAdapter(customAdapter);

        dbRef = db.getReference("TESLİMAT_BEKLEYENLER");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                chatLists.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    Message message = ds.getValue(Message.class);
                    chatLists.add(message);

                }
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
