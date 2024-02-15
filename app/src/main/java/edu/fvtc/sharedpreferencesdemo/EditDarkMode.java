package edu.fvtc.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class EditDarkMode extends AppCompatActivity {
    public static final String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dark_mode);

        initButton();
        initCheckBox();
        getSettings();
    }

    private void getSettings() {
        //Read the shared preferences
        SharedPreferences preferences = getApplication().getSharedPreferences("myprefs", MODE_PRIVATE);

        //get the value
        Boolean isDarkMode = preferences.getBoolean("darkmode", false);
        Log.d(TAG, "onResume: " + isDarkMode);

        CheckBox chkDarkMode = findViewById(R.id.chkDarkMode);
        chkDarkMode.setChecked(isDarkMode);
    }

    private void initCheckBox() {
        CheckBox chkDarkMode = findViewById(R.id.chkDarkMode);

        chkDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //save the value of the che3eckbox to shared preferences
                SharedPreferences preferences = getApplication().getSharedPreferences("myPrefs", MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();

                editor.putBoolean("darkmode", isChecked);
                editor.putInt("age", 45);
                editor.putString("name", String.valueOf(R.string.app_name));
                editor.commit();
                Log.d(TAG, "onCheckedChanged: " + isChecked);

            }
        });
    }

    public void onResume()
    {
        //Read the shared preferences
        SharedPreferences preferences = getApplication().getSharedPreferences("myprefs", MODE_PRIVATE);
        Boolean isDarkMode = preferences.getBoolean("darkmode", false);
        Log.d(TAG, "onResume:" + isDarkMode);
        super.onResume();
    }


    private void initButton() {
        Button btnNavigate = findViewById(R.id.btnNavigate);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to the other screen
                startActivity(new Intent(v.getContext(),MainActivity.class));
            }
        });

    }
}

