package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        callFragments();
    }

    private void callFragments() {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.firstFragmentContainer, new FirstFragment())
            .commit();

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.secondFragmentContainer, new SecondFragment())
            .commit();

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.thirdFragmentContainer, new ThirdFragment())
            .commit();
    }

    public void updateText(String text, float fontSize) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.secondFragmentContainer);
        if (secondFragment != null) {
            secondFragment.updateText(text, fontSize);
        }
    }

    public void updateTextColor(int color) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.secondFragmentContainer);
        if (secondFragment != null) {
            secondFragment.updateTextColor(color);
        }
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