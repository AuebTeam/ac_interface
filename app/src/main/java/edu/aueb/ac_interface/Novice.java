package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

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
    private PopupWindow popup_window;

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
                //onButtonShowPopupWindowClick(view);
            }
        });



    }

   /* public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }*/
}