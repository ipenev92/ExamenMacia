package com.example.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private EditText inputText;
    private float fontSize = 20f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        inputText = view.findViewById(R.id.inputText);
        SeekBar fontSeekBar = view.findViewById(R.id.fontSeekBar);
        Button changeTextButton = view.findViewById(R.id.changeTextButton);

        fontSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSize = 12 + (progress / 4f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        changeTextButton.setOnClickListener(v -> {
            String text = inputText.getText().toString();
            if (getActivity() instanceof SecondActivity) {
                ((SecondActivity) getActivity()).updateText(text, fontSize);
            }
        });

        return view;
    }
}