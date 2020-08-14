package com.example.counterhomework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvCount;
    private EditText editText;
    private Button btnCount;
    private int count = 0;

    private final String EXTRA_STRING_NAME = "string edit text";
    private final String EXTRA_INT_NAME = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tv_count);
        editText = findViewById(R.id.editText);
        btnCount = findViewById(R.id.btn_count);

        tvCount.setText(count + "");

        if (savedInstanceState != null) {
            editText.setText(savedInstanceState.getString(EXTRA_STRING_NAME));
            tvCount.setText(savedInstanceState.getInt(EXTRA_INT_NAME) + "");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String text = editText.getText().toString().trim();
        int count = Integer.parseInt(tvCount.getText().toString());

        outState.putString(EXTRA_STRING_NAME, text);
        outState.putInt(EXTRA_INT_NAME, count);
    }

    public void onClick(View view) {
        tvCount.setText(++count + "");
    }
}