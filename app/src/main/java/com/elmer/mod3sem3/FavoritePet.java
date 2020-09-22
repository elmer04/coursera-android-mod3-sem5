package com.elmer.mod3sem3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.elmer.mod3sem3.adapter.PetAdaptador;
import com.elmer.mod3sem3.model.Pet;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.List;

public class FavoritePet extends AppCompatActivity {

    List<Pet> pets;
    private RecyclerView listPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pet);

        MaterialToolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializarListaPets();

        listPets = findViewById(R.id.rvPets);
        listPets.setLayoutManager(new LinearLayoutManager(this));

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
    }
}