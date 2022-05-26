package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Novice extends AppCompatActivity {


    Button plus1,minus1,activate,back;
    TextView temperature,header;

    Context context;
    Resources resources;

    int wanted_temperature = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novice);


        context = LocaleHelper.setLocale(Novice.this);
        resources = context.getResources();

        header = (TextView) findViewById(R.id.headtext);
        temperature = (TextView) findViewById(R.id.novice_temperature);
        plus1 = findViewById(R.id.plus_one);
        minus1 = findViewById(R.id.minus_one);
        activate = findViewById(R.id.activate_1);
        back = findViewById(R.id.back_2);

        activate.setText(resources.getString(R.string.activate));
        back.setText(resources.getString(R.string.back));
        header.setText(resources.getString(R.string.header));

        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainActivity.this, User_proficiency.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Novice.this, User_proficiency.class));
            }
        });

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wanted_temperature+=1;
                String temp = Integer.toString(wanted_temperature);
                temperature.setText(temp+" C");
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wanted_temperature-=1;
                String temp = Integer.toString(wanted_temperature);
                temperature.setText(temp+" C");
            }
        });


    }
}