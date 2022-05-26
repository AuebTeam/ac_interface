package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageView;
    ImageButton btnGreek, btnEnglish;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencing the text and button views
        messageView = (TextView) findViewById(R.id.headtext);
        btnGreek = findViewById(R.id.btnGreek);
        btnEnglish = findViewById(R.id.btnEnglish);

        // setting up on click listener event over the button
        // in order to change the language with the help of
        // LocaleHelper class
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "en");
                resources = context.getResources();

                messageView.setText(resources.getString(R.string.header));


                startActivity(new Intent(MainActivity.this, User_proficiency.class));
            }
        });

        btnGreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "el");
                resources = context.getResources();

                startActivity(new Intent(MainActivity.this, User_proficiency.class));
            }
        });

    }
}