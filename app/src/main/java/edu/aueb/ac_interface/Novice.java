package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Novice extends AppCompatActivity {

    String mode;
    Spinner spinner;
    Button plus1,minus1,activate,back;
    TextView temperature,header;

    FloatingActionButton help;

    Context context;
    Resources resources;

    int wanted_temperature = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novice);


        context = LocaleHelper.setLocale(Novice.this);
        resources = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mode = resources.getString(R.string.hot);
        spinner = findViewById(R.id.spinner);
        header = (TextView) findViewById(R.id.headtext);
        temperature = (TextView) findViewById(R.id.novice_temperature);
        plus1 = findViewById(R.id.plus_one);
        minus1 = findViewById(R.id.minus_one);
        activate = findViewById(R.id.activate_1);
        back = findViewById(R.id.back_2);
        help = findViewById(R.id.novice_help_button);

        activate.setText(resources.getString(R.string.activate));
        back.setText(resources.getString(R.string.back));
        header.setText(resources.getString(R.string.header));

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(resources.getString(R.string.hot));
        arrayList.add(resources.getString(R.string.cold));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  mode = parent.getItemAtPosition(position).toString();
              }

              @Override
              public void onNothingSelected(AdapterView<?> adapterView) {

              }
        });

        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("AC activated in novice mode");
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

                if(mode.equals(resources.getString(R.string.hot))){
                    if(wanted_temperature < 31) {
                        wanted_temperature+=1;
                        String temp = Integer.toString(wanted_temperature);
                        temperature.setText(temp+" C");
                    }
                }
                else{
                    if(wanted_temperature < 27) {
                        wanted_temperature+=1;
                        String temp = Integer.toString(wanted_temperature);
                        temperature.setText(temp+" C");
                    }
                }

            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode.equals(resources.getString(R.string.hot))){
                    if(wanted_temperature > 23) {
                        wanted_temperature-=1;
                        String temp = Integer.toString(wanted_temperature);
                        temperature.setText(temp+" C");
                    }
                }
                else{
                    if(wanted_temperature > 17) {
                        wanted_temperature-=1;
                        String temp = Integer.toString(wanted_temperature);
                        temperature.setText(temp+" C");
                    }
                }
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });



    }


}