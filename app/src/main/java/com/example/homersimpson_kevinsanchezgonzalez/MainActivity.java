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
    Animation engranatgeBlau,engranatgeVerd,engranatgeVermell,rotacioUll,rotacioDonut;


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
        rotacioUll = AnimationUtils.loadAnimation(this,R.anim.rotacio_ull);
        rotacioDonut = AnimationUtils.loadAnimation(this,R.anim.rotacio_donut);



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
                    Ull.startAnimation(rotacioUll);
                    Donut.startAnimation(rotacioDonut);
                    Blau.setVisibility(View.VISIBLE);
                    Verd.setVisibility(View.VISIBLE);
                    Vermell.setVisibility(View.VISIBLE);
                    Ull.setVisibility(View.VISIBLE);
                    Donut.setVisibility(View.VISIBLE);
                    visible = true;
                } else {
                    Blau.clearAnimation();
                    Verd.clearAnimation();
                    Vermell.clearAnimation();
                    Donut.clearAnimation();
                    Ull.clearAnimation();
                    Blau.animate().cancel();
                    Verd.animate().cancel();
                    Vermell.animate().cancel();
                    Donut.animate().cancel();
                    Ull.animate().cancel();

                    Blau.setVisibility(View.INVISIBLE);
                    Vermell.setVisibility(View.INVISIBLE);
                    Verd.setVisibility(View.INVISIBLE);
                    Ull.setVisibility(View.INVISIBLE);
                    Donut.setVisibility(View.INVISIBLE);

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
