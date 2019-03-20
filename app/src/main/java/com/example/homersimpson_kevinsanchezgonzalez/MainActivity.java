package com.example.homersimpson_kevinsanchezgonzalez;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    boolean visible, sonando;
    ImageView Blau, Verd, Vermell, Ull, Donut;
    AnimationDrawable simpsonsTitle;
    Animation engranatgeBlau,engranatgeVerd,engranatgeVermell;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView titol = (ImageView) findViewById(R.id.theSimpsonsTitle);
        titol.setBackgroundResource(R.drawable.title_animation);
        simpsonsTitle = (AnimationDrawable) titol.getBackground();
        final ImageView Blau = (ImageView) findViewById(R.id.ivBlau);
        final ImageView Vermell = (ImageView) findViewById(R.id.ivVermell);
        final ImageView Verd = (ImageView) findViewById(R.id.ivVerd);
        final ImageView Ull = (ImageView) findViewById(R.id.ivUll);
        final ImageView Donut = (ImageView) findViewById(R.id.ivDonut);


        player = MediaPlayer.create(this, R.raw.the_simpsons);

        Blau.setVisibility(View.INVISIBLE);
        Vermell.setVisibility(View.INVISIBLE);
        Verd.setVisibility(View.INVISIBLE);
        Ull.setVisibility(View.INVISIBLE);
        Donut.setVisibility(View.INVISIBLE);
        visible = false;
        sonando = false;

        engranatgeBlau = AnimationUtils.loadAnimation(this,R.anim.engranatge_blau);
        engranatgeVerd = AnimationUtils.loadAnimation(this,R.anim.engranatge_verd);
        engranatgeVermell = AnimationUtils.loadAnimation(this,R.anim.engranatge_vermell);

        Donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    player.stop();
                } else {
                    player.start();
                }
            }
        });

        titol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (visible == false) {
                    Blau.startAnimation(engranatgeBlau);
                    Verd.startAnimation(engranatgeVerd);
                    Vermell.startAnimation(engranatgeVermell);
                    Blau.setVisibility(View.VISIBLE);
                    Verd.setVisibility(View.VISIBLE);
                    Vermell.setVisibility(View.VISIBLE);
                    Ull.setVisibility(View.VISIBLE);
                    Donut.setVisibility(View.VISIBLE);
                    visible = true;
                } else {

                    Blau.setVisibility(View.INVISIBLE);
                    Vermell.setVisibility(View.INVISIBLE);
                    Verd.setVisibility(View.INVISIBLE);
                    Ull.setVisibility(View.INVISIBLE);
                    Donut.setVisibility(View.INVISIBLE);
                    Blau.animate().cancel();

                    visible = false;

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
