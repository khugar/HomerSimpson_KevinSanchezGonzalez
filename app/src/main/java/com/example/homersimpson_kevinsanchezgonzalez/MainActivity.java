package com.example.homersimpson_kevinsanchezgonzalez;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean visible;
    ImageView Blau, Verd, Vermell, Ull, Donut;
    AnimationDrawable simpsonsTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView titol =(ImageView)findViewById(R.id.theSimpsonsTitle);
        titol.setBackgroundResource(R.drawable.title_animation);
        simpsonsTitle = (AnimationDrawable) titol.getBackground();
        final ImageView Blau = (ImageView)findViewById(R.id.ivBlau);
        final ImageView Vermell = (ImageView)findViewById(R.id.ivVermell);
        final ImageView Verd = (ImageView)findViewById(R.id.ivVerd);
        final ImageView Ull = (ImageView)findViewById(R.id.ivUll);
        final ImageView Donut = (ImageView)findViewById(R.id.ivDonut);

        Blau.setVisibility(View.INVISIBLE);
        Vermell.setVisibility(View.INVISIBLE);
        Verd.setVisibility(View.INVISIBLE);
        Ull.setVisibility(View.INVISIBLE);
        Donut.setVisibility(View.INVISIBLE);
        visible = false;

        titol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visible==false){
                Blau.setVisibility(View.VISIBLE);
                Verd.setVisibility(View.VISIBLE);
                Vermell.setVisibility(View.VISIBLE);
                Ull.setVisibility(View.VISIBLE);
                Donut.setVisibility(View.VISIBLE);
                visible=true;}
                else{
                    Blau.setVisibility(View.INVISIBLE);
                    Vermell.setVisibility(View.INVISIBLE);
                    Verd.setVisibility(View.INVISIBLE);
                    Ull.setVisibility(View.INVISIBLE);
                    Donut.setVisibility(View.INVISIBLE);
                    visible=false;

                }
                }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        simpsonsTitle.start();
    }

}
