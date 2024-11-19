package com.example.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {
    private int red = 0, green = 0, blue = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment, container, false);

        SeekBar redSeekBar = view.findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = view.findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar = view.findViewById(R.id.blueSeekBar);
        Button changeColorButton = view.findViewById(R.id.changeColorButton);

        redSeekBar.setMax(255);
        greenSeekBar.setMax(255);
        blueSeekBar.setMax(255);

        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getId() == R.id.redSeekBar) {
                    red = progress;
                } else if (seekBar.getId() == R.id.greenSeekBar) {
                    green = progress;
                } else if (seekBar.getId() == R.id.blueSeekBar) {
                    blue = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        changeColorButton.setOnClickListener(v -> {
            int color = Color.rgb(red, green, blue);
            if (getActivity() instanceof SecondActivity) {
                ((SecondActivity) getActivity()).updateTextColor(color);
            }
        });

        return view;
    }
}