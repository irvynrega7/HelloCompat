package com.example.asus.hellocompat;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Text view for Hello World
    private TextView mhelloTextView;
    //array of color names, these match the color resources in color.xml
    private String[] mColorArray  = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhelloTextView = findViewById(R.id.hello_textview);
        // restore saved instance state ( the text color)
        if (savedInstanceState != null){
            mhelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color",mhelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        // Get a random color name from the color array (20 colors).
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];

        // Get the color identifier that matches the color name.
        int colorResourceName = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());

        // Get the color ID from the resources.
        int colorRes = ContextCompat.getColor(this,colorResourceName);

        // Set the text color
        mhelloTextView.setTextColor(colorRes);
    }
}
