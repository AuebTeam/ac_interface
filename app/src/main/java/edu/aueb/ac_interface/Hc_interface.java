package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Hc_interface extends AppCompatActivity {

    Button btnBack, btnTurnoff, minus_1, plus_1;
    TextView mode, temperature, louver, header, temperature_text;
    Spinner spinner_mode, spinner_louver;
    FloatingActionButton help;
    Context context;
    Resources resources;
    String mode_string, louver_string;
    int wanted_temperature = 20;
    static int button_mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hc_interface);
        context = LocaleHelper.setLocale(Hc_interface.this);
        resources = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        btnBack = findViewById(R.id.back_hc);
        btnTurnoff = findViewById(R.id.turn_off_hc);
        minus_1 = findViewById(R.id.minus_1_hc);
        plus_1 = findViewById(R.id.plus_1_hc);
        mode = findViewById(R.id.mode_hc);
        temperature = findViewById(R.id.temperature_hc);
        louver = findViewById(R.id.louver_hc);
        header = findViewById(R.id.header_hc);
        spinner_mode = findViewById(R.id.spinner_mode_hc);
        spinner_louver = findViewById(R.id.spinner_louver_hc);
        help = findViewById(R.id.help_hc);
        temperature_text = findViewById(R.id.header);

        header.setText(resources.getString(R.string.header));
        mode.setText(resources.getString(R.string.mode));
        louver.setText(resources.getString(R.string.louver));
        temperature_text.setText(resources.getString(R.string.temperature));

        btnBack.setText(resources.getString(R.string.back));
        btnTurnoff.setText(resources.getString(R.string.turn_on));
        minus_1.setText("-1");
        plus_1.setText("+1");

        mode_string = resources.getString(R.string.hot);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(resources.getString(R.string.hot));
        arrayList.add(resources.getString(R.string.cold));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_mode.setAdapter(arrayAdapter);
        spinner_mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mode_string = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayListL = new ArrayList<>();
        arrayListL.add(resources.getString(R.string.low));
        arrayListL.add(resources.getString(R.string.medium));
        arrayListL.add(resources.getString(R.string.high));

        louver_string = resources.getString(R.string.low);

        ArrayAdapter<String> arrayAdapterL = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayListL);
        arrayAdapterL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_louver.setAdapter(arrayAdapterL);
        spinner_louver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                louver_string = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnTurnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTurnoff.setSelected(!btnTurnoff.isSelected());
                button_mode = (btnTurnoff.isSelected())?1:0;
                if (button_mode == 1) {
                    btnTurnoff.setText(resources.getString(R.string.turn_off));
                    Toast.makeText(context,"The AC has been turned on at " + wanted_temperature + " C, "
                            + " mode : " + mode_string + ", louver : " + louver_string , Toast.LENGTH_SHORT).show();
                } else {
                    btnTurnoff.setText(resources.getString(R.string.activate));
                    Toast.makeText(context,R.string.toast_deact, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hc_interface.this, Average.class));
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

        plus_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(mode_string.equals(resources.getString(R.string.hot))){
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

        minus_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(mode_string.equals(resources.getString(R.string.hot))){
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
    }
}