package com.example.vale_yeni;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Yeni_Arac_Kayit extends AppCompatActivity {

    Button b_1,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9,b_10,b_11,kaydet_button;
    Context context=this;
    private int int_1,int_2,int_3,int_4,int_5,int_6,int_7,int_8,int_9,int_10,int_11=0;
    private TextView tarih_textview;
    private EditText kart_no_edittext,plaka_edittext,ad_soyad_edittext,telefon_edittext,park_alını_edittext;


    private DatabaseReference dbRef;
    private FirebaseDatabase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeni_arac_kayit);

        b_1=(Button)findViewById(R.id.b_1);
        b_2=(Button)findViewById(R.id.b_2);
        b_3=(Button)findViewById(R.id.b_3);
        b_4=(Button)findViewById(R.id.b_4);
        b_5=(Button)findViewById(R.id.b_5);
        b_6=(Button)findViewById(R.id.b_6);
        b_7=(Button)findViewById(R.id.b_7);
        b_8=(Button)findViewById(R.id.b_8);
        b_9=(Button)findViewById(R.id.b_9);
        b_10=(Button)findViewById(R.id.b_10);
        b_11=(Button)findViewById(R.id.b_11);

        kaydet_button=(Button)findViewById(R.id.kaydet_button);

        tarih_textview=(TextView)findViewById(R.id.tarih);
        kart_no_edittext=(EditText)findViewById(R.id.kart_no_edittext);
        plaka_edittext=(EditText)findViewById(R.id.plaka_edittext);
        ad_soyad_edittext=(EditText)findViewById(R.id.ad_soyad_edittext);
        telefon_edittext=(EditText)findViewById(R.id.telefon_edittext);
        park_alını_edittext=(EditText)findViewById(R.id.park_alanı_edittext);



        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("ARACLAR");


        kaydet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                long msTime = System.currentTimeMillis();
                Date curDateTime = new Date(msTime);
                SimpleDateFormat formatter = new SimpleDateFormat("dd'/'MM'/'y hh:mm");
                String dateTime = formatter.format(curDateTime);
                String kart_no_str= kart_no_edittext.getText().toString();
                String plaka_str= plaka_edittext.getText().toString();
                String ad_soyad_str= ad_soyad_edittext.getText().toString();
                String telefon_str= telefon_edittext.getText().toString();
                String park_alanı_str= park_alını_edittext.getText().toString();

                final Message message = new Message(kart_no_str,plaka_str,ad_soyad_str,telefon_str,park_alanı_str,dateTime);
                dbRef.push().setValue(message);

                Toast.makeText(getApplicationContext(), "KAYIT ALINDI...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Yeni_Arac_Kayit.this, AnaSayfa.class);
                startActivity(intent);





            }
        });







        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_1==0){

                    b_1.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_1=1;
                }
                else {

                    b_1.setBackgroundResource(R.drawable.saglam_check_button);
                    int_1=0;

                }
            }
        });



        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_2==0){

                    b_2.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_2=1;
                }
                else {

                    b_2.setBackgroundResource(R.drawable.saglam_check_button);
                    int_2=0;

                }
            }
        });





        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_3==0){

                    b_3.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_3=1;
                }
                else {

                    b_3.setBackgroundResource(R.drawable.saglam_check_button);
                    int_3=0;

                }
            }
        });



        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_4==0){

                    b_4.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_4=1;
                }
                else {

                    b_4.setBackgroundResource(R.drawable.saglam_check_button);
                    int_4=0;

                }
            }
        });



        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_5==0){

                    b_5.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_5=1;
                }
                else {

                    b_5.setBackgroundResource(R.drawable.saglam_check_button);
                    int_5=0;

                }
            }
        });


        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_6==0){

                    b_6.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_6=1;
                }
                else {

                    b_6.setBackgroundResource(R.drawable.saglam_check_button);
                    int_6=0;

                }
            }
        });


        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_7==0){

                    b_7.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_7=1;
                }
                else {

                    b_7.setBackgroundResource(R.drawable.saglam_check_button);
                    int_7=0;

                }
            }
        });


        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_8==0){

                    b_8.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_8=1;
                }
                else {

                    b_8.setBackgroundResource(R.drawable.saglam_check_button);
                    int_8=0;

                }
            }
        });


        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_9==0){

                    b_9.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_9=1;
                }
                else {

                    b_9.setBackgroundResource(R.drawable.saglam_check_button);
                    int_9=0;

                }
            }
        });


        b_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_10==0){

                    b_10.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_10=1;
                }
                else {

                    b_10.setBackgroundResource(R.drawable.saglam_check_button);
                    int_10=0;

                }
            }
        });


        b_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (int_11==0){

                    b_11.setBackgroundResource(R.drawable.hasarli_check_button);
                    int_11=1;
                }
                else {

                    b_11.setBackgroundResource(R.drawable.saglam_check_button);
                    int_11=0;

                }
            }
        });

    }
}
