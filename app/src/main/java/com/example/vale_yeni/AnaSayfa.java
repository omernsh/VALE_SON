package com.example.vale_yeni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnaSayfa extends AppCompatActivity {


    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private FirebaseUser fUser;
    private ArrayList<Message> chatLists = new ArrayList<>();
    private CustomAdapter customAdapter;
    private String subject;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_sayfa);

        ImageView yeni_arac_kayit_button=(ImageView) findViewById(R.id.yeni_arac_kayit_button);

        ImageView teslimat_bekleyen=(ImageView) findViewById(R.id.teslimat_bekleyen);


        yeni_arac_kayit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaSayfa.this,Yeni_Arac_Kayit.class);
                startActivity(intent);
            }
        });


        teslimat_bekleyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaSayfa.this,TeslimatBekleyenler.class);
                startActivity(intent);
            }
        });

        listView = (ListView)findViewById(R.id.chatListView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(AnaSayfa.this,AracAyrinti.class);
                intent.putExtra("sıra_key", position);
                startActivity(intent);






            }
        });



        db = FirebaseDatabase.getInstance();
        customAdapter = new CustomAdapter(getApplicationContext(),chatLists,fUser);
        listView.setAdapter(customAdapter);

        dbRef = db.getReference("ARACLAR");
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
