package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Timer extends AppCompatActivity {


    Button ok;

    RadioButton turn_on, turn_off, no_timer;

    TextView header, settings,turn_on_input,turn_off_input;

    FloatingActionButton help;

    Context context;
    Resources resources;

    int to,tf,nt=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        context = LocaleHelper.setLocale(Timer.this);
        resources = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        ok = findViewById(R.id.ok);
        turn_on = findViewById(R.id.turn_on_timer);
        turn_off = findViewById(R.id.turn_off_timer);
        no_timer = findViewById(R.id.no_timer);

        header = findViewById(R.id.header);
        settings = findViewById(R.id.timer_header);
        turn_on_input = findViewById(R.id.timer_text_on);
        turn_off_input = findViewById(R.id.timer_text_off);

        help = findViewById(R.id.help_timer);



        ok.setText(resources.getString(R.string.ok));
        turn_on.setText(resources.getString(R.string.turn_on_timer));
        turn_off.setText(resources.getString(R.string.turn_off_timer));
        no_timer.setText(resources.getString(R.string.no_timer));

        header.setText(resources.getString(R.string.header));
        settings.setText(resources.getString(R.string.timer_settings));
        turn_on_input.setText(resources.getString(R.string.timer_message));
        turn_off_input.setText(resources.getString(R.string.timer_message));

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Timer.this, Average.class));

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help_timer));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });


    }

    public void turn_on_timer(View view){
        to++;
        if(to%2==0) {
            turn_on.setChecked(false);
        }
        else {
            no_timer.setChecked(false);
        }
    }

    public void turn_off_timer(View view){
        tf++;
        if(tf%2==0) {
            turn_on.setChecked(false);
        }
        else {
            no_timer.setChecked(false);
        }

    }

    public void no_timer(View view){
        nt++;
        if(nt%2==0) {
            no_timer.setChecked(false);
        }
        else{
            turn_on.setChecked(false);
            turn_off.setChecked(false);
        }

    }
}