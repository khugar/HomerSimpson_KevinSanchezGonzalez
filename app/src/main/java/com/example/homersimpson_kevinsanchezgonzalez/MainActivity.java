package com.example.homersimpson_kevinsanchezgonzalez;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable simpsonsTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView titol =(ImageView)findViewById(R.id.theSimpsonsTitle);
        titol.setBackgroundResource(R.drawable.title_animation);
        simpsonsTitle = (AnimationDrawable) titol.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        simpsonsTitle.start();
    }
}
