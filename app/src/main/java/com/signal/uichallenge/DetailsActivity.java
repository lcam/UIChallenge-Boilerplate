package com.signal.uichallenge;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    TextView textView;
    String text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.artist_name_detail);

        text = getIntent().getStringExtra("artist");
        textView.setText(text);
        Log.e(TAG, "onCreate: " + text);
    }
}
