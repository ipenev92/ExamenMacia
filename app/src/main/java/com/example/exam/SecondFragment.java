package com.example.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private TextView displayTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        displayTextView = view.findViewById(R.id.displayTextView);
        return view;
    }

    public void updateText(String text, float fontSize) {
        if (displayTextView != null) {
            displayTextView.setText(text);
            displayTextView.setTextSize(fontSize);
        }
    }

    public void updateTextColor(int color) {
        if (displayTextView != null) {
            displayTextView.setTextColor(color);
        }
    }
}