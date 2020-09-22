package com.elmer.mod3sem3.opciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.elmer.mod3sem3.R;
import com.google.android.material.appbar.MaterialToolbar;

public class AcercaMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_menu);

        MaterialToolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}