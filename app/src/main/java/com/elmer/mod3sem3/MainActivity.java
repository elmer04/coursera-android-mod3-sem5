package com.elmer.mod3sem3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pet> pets;
    private RecyclerView listPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        FloatingActionButton fltBtn = findViewById(R.id.fltBtn);
        fltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.camera, Toast.LENGTH_SHORT).show();
            }
        });

        inicializarListaPets();

        listPets = findViewById(R.id.rvPets);

        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listPets.setLayoutManager(llm);

        inicializarAdaptador();

    }

    public void inicializarAdaptador() {
        PetAdaptador adaptador = new PetAdaptador(pets, this);
        listPets.setAdapter(adaptador);
    }

    public void inicializarListaPets() {
        pets = new ArrayList<>();

        pets.add(new Pet(R.drawable.pet1, "mascota 1", 2));
        pets.add(new Pet(R.drawable.pet1, "mascota 2", 2));
        pets.add(new Pet(R.drawable.pet1, "mascota 3", 2));
        pets.add(new Pet(R.drawable.pet1, "mascota 4", 2));
        pets.add(new Pet(R.drawable.pet1, "mascota 5", 2));
        pets.add(new Pet(R.drawable.pet1, "mascota 6", 2));
        pets.add(new Pet(R.drawable.pet1, "mascota 7", 2));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_favorite:
                Intent intent =new Intent(this, FavoritePet.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar, menu);

        MenuItem item = menu.findItem(R.id.action_favorite);
        SearchView searchView = (SearchView) item.getActionView();

        return super.onCreateOptionsMenu(menu);
    }
}