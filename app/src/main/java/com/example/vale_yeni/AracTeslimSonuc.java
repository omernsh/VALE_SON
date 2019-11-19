package com.example.vale_yeni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AracTeslimSonuc extends AppCompatActivity {


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
        setContentView(R.layout.arac_teslim_sonuc);


        Button button=(Button)findViewById(R.id.button);
        TextView text_view=(TextView)findViewById(R.id.text_view);
        ImageView image=(ImageView)findViewById(R.id.image);



        Bundle extras = getIntent().getExtras();
        int değer = extras.getInt("key");

        if (değer==1){


            text_view.setText("Kart eşleşiyor, araç teslim edilebilir!");
            image.setBackgroundResource(R.drawable.saglam_check_button);
            button.setText("Teslim ediliyor olarak işaretle");












        }

        else {

            text_view.setText("Kart eşleşmiyor, tekrar dene!");
            image.setBackgroundResource(R.drawable.hasarli_check_button);
            button.setText("Tekrar dene");



        }















        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Teslim ediliyor olarak işaretlendi...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AracTeslimSonuc.this, TeslimatBekleyenler.class);
                startActivity(intent);



                db = FirebaseDatabase.getInstance();
                dbRef = db.getReference("TESLİMAT_BEKLEYENLER");


                long msTime = System.currentTimeMillis();
                Date curDateTime = new Date(msTime);
                SimpleDateFormat formatter = new SimpleDateFormat("dd'/'MM'/'y hh:mm");
                String dateTime = formatter.format(curDateTime);
                String kart_no_str= "12";
                String plaka_str= "34 AF 56";
                String ad_soyad_str= "Ömer Nasuhi Aydemir";
                String telefon_str= "531 836 77 81";
                String park_alanı_str= "Loca";

                final Message message = new Message(kart_no_str,plaka_str,ad_soyad_str,telefon_str,park_alanı_str,dateTime);
                dbRef.push().setValue(message);


            }
        });

    }



}
