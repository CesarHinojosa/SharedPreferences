package edu.fvtc.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();
    }

    @Override
    public void onResume()
    {
        // Read the shared preferences
        SharedPreferences preferences = getApplication().getSharedPreferences("myprefs", MODE_PRIVATE);
        Boolean isDarkMode = preferences.getBoolean("darkmode", false);
        Log.d(TAG, "onResume: " + isDarkMode);

        CheckBox chkDarkMode = findViewById(R.id.chkDarkMode);
        chkDarkMode.setChecked(isDarkMode);
        super.onResume();
    }
    private void initButton() {
        Button btnNavigate = findViewById(R.id.btnNavigate);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to the other screen
                startActivity(new Intent(v.getContext(),EditDarkMode.class));
            }
        });

    }
}