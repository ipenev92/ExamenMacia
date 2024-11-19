package com.example.exam;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    final ValueAnimator valueAnimatorSky = ValueAnimator.ofArgb(
            Color.parseColor("#1E7AC7"),
            Color.parseColor("#817D67"),
            Color.parseColor("#EB8001"),
            Color.parseColor("#05192E"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView sun = findViewById(R.id.sun);
        View sky = findViewById(R.id.sky);
        sky.setOnClickListener(view -> startSunsetAnimation(sun, sky));
    }

    private void startSunsetAnimation(View sun, View sky) {
        Float speed = sky.getHeight() / 2.35f;
        ObjectAnimator objectAnimatorSun = ObjectAnimator.ofFloat(
                sun, "translationY", 0f, speed).setDuration(3000);

        valueAnimatorSky.setDuration(3000);
        valueAnimatorSky.setEvaluator(new ArgbEvaluator());
        valueAnimatorSky.addUpdateListener(animation -> {
            int animatedColor = (int) animation.getAnimatedValue();
            sky.setBackgroundColor(animatedColor);
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorSun, valueAnimatorSky);
        animatorSet.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Sunset")
                .setIcon(R.drawable.moon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add(0, 2, 1, "Second Activity")
                .setIcon(R.drawable.smile)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case 2:
                startActivity(new Intent(this, SecondActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}