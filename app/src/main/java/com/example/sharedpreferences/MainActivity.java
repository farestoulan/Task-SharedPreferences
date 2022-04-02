package com.example.sharedpreferences;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtuser =(EditText)findViewById(R.id.et_inputdata);
                SharedPreferences.Editor myedit = sharedPreferences.edit();
                myedit.putString("data", txtuser.getText().toString());
                myedit.commit();
               Toast.makeText(MainActivity.this , "Data Successfully Saved",Toast.LENGTH_LONG).show();

            }
        });

        binding.btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtuser = (EditText) findViewById(R.id.et_getdata);
                txtuser.setText(sharedPreferences.getString("data","emplty"));
            }
        });

    }
}