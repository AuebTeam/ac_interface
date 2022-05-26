package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class User_proficiency extends AppCompatActivity {

    TextView messageView;

    Button experience,novice,back;
    FloatingActionButton help;

    Context context;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_proficiency);

        context = LocaleHelper.setLocale(User_proficiency.this);
        resources = context.getResources();


        messageView = (TextView) findViewById(R.id.headtext);
        experience = findViewById(R.id.experienced);
        novice = findViewById(R.id.novice);
        back = findViewById(R.id.back_1);


        experience.setText(resources.getString(R.string.experienced));
        novice.setText(resources.getString(R.string.novice));
        back.setText(resources.getString(R.string.back));

        messageView.setText(resources.getString(R.string.header));

        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainActivity.this, User_proficiency.class));
            }
        });

        novice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_proficiency.this, Novice.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_proficiency.this, MainActivity.class));
            }
        });


    }


}