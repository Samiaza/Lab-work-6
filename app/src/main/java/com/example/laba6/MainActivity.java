package com.example.laba6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String buffer = "undefined";
    final static String nameVariableKey = "NAME_VAR";
    final static String textViewTextKey = "TEXT_VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(nameVariableKey, buffer);
        TextView textView = (TextView) findViewById(R.id.savedTextView);
        outState.putString(textViewTextKey,textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buffer = savedInstanceState.getString(nameVariableKey);
        String textViewText = savedInstanceState.getString(textViewTextKey);
        TextView textView = (TextView) findViewById(R.id.savedTextView);
        textView.setText(textViewText);
    }

    public void saveField(View view) {
        TextView textBox = (TextView) findViewById(R.id.editTextTextMultiLine);
        buffer = textBox.getText().toString();
    }

    public void restoreField(View view) {
        TextView textView = (TextView) findViewById(R.id.savedTextView);
        textView.setText(buffer);
    }
}