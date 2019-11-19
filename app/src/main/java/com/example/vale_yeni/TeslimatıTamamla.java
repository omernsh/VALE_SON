package com.example.vale_yeni;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeslimatıTamamla extends AppCompatActivity {


    private String[] para_birimleri={"TL","Dolar","Euro"};

    private Spinner para_birimleri_spinner;
    private ArrayAdapter<String> para_birimleri_adapter;

    private int ücretli_ücretsiz=0;

    final Context context = this;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teslimati_tamamla);




        final Button ücretsiz_button=(Button)findViewById(R.id.ücretsiz_button);

        final Button teslimat_tamamla_button=(Button)findViewById(R.id.teslimat_tamamla_button);


        ücretsiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ücretli_ücretsiz==0){

                    ücretsiz_button.setBackgroundResource(R.drawable.turuncu_button_back);
                    ücretli_ücretsiz=1;
                }
                else {

                    ücretsiz_button.setBackgroundResource(R.drawable.border_button);
                    ücretli_ücretsiz=0;


                }



            }
        });

        teslimat_tamamla_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMyCustomAlertDialog();




            }
        });










        para_birimleri_spinner = (Spinner) findViewById(R.id.para_birimi);

        para_birimleri_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, para_birimleri);

        para_birimleri_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        para_birimleri_spinner.setAdapter(para_birimleri_adapter);



        para_birimleri_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                ((TextView)parentView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });











    }


    public void showMyCustomAlertDialog() {

        // dialog nesnesi oluştur ve layout dosyasına bağlan
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.alert_dialog);

        // custom dialog elemanlarını tanımla - text, image ve button
        Button btnKaydet = (Button) dialog.findViewById(R.id.button_kaydet);
        TextView tvBaslik = (TextView) dialog.findViewById(R.id.textview_baslik);
        ImageView ivResim = (ImageView) dialog.findViewById(R.id.imageview_resim);

        // custom dialog elemanlarına değer ataması yap - text, image
        tvBaslik.setText("Teslimat tamamlandı!");

        // tamam butonunun tıklanma olayları
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TeslimatıTamamla.this, AnaSayfa.class);
                startActivity(intent);



            }
        });

        dialog.show();
    }

}
