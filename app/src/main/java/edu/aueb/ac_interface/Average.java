package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Average extends AppCompatActivity {


    FloatingActionButton help;

    Context context;
    Resources resources;

    Button back,activate,timer_settings;

    TextView header,timer_header,mode_header;

    Spinner spinner;

    String mode,timer_mode;


    int minutes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);

        context = LocaleHelper.setLocale(Average.this);
        resources = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mode = resources.getString(R.string.heat_cold_mode);
        spinner = findViewById(R.id.spinner);
        header = (TextView) findViewById(R.id.headtext);
        timer_header = (TextView) findViewById((R.id.timerview));
        mode_header = (TextView) findViewById((R.id.modeview));

        timer_settings = findViewById(R.id.timer_settings_button);
        back = findViewById(R.id.back_3);
        activate = findViewById(R.id.turn_on);

        help = findViewById(R.id.experienced_help_button);



        timer_settings.setText(resources.getString(R.string.timer_settings));
        activate.setText(resources.getString(R.string.cbutton));
        back.setText(resources.getString(R.string.back));
        header.setText(resources.getString(R.string.header));
        timer_header.setText(resources.getString(R.string.choose_timer));
        mode_header.setText(resources.getString(R.string.mode));



        timer_mode = "No Timer";
        minutes = 0;

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(resources.getString(R.string.heat_cold_mode));
        arrayList.add(resources.getString(R.string.fan_mode));
        arrayList.add(resources.getString(R.string.dry_mode));


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
                System.out.println(timer_mode + " : " + minutes);
                if(mode.equals(resources.getString(R.string.heat_cold_mode))) {
                    startActivity(new Intent(Average.this, Hc_interface.class));
                }
                else if(mode.equals(resources.getString(R.string.fan_mode)))
                {
                    startActivity(new Intent(Average.this, Fan_mode.class));
                }
                else{
                    startActivity(new Intent(Average.this, Dry_mode.class));
                }
            }
        });


        timer_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Average.this, Timer.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Average.this, User_proficiency.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help_experienced));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });



    }
}