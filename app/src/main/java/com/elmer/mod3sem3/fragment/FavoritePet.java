package com.elmer.mod3sem3.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.elmer.mod3sem3.R;
import com.elmer.mod3sem3.adapter.PetAdaptador;
import com.elmer.mod3sem3.pojo.Pet;
import com.elmer.mod3sem3.presentador.FavoritePetPresenter;
import com.elmer.mod3sem3.presentador.IRecyclerViewFragmentPresenter;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.List;

public class FavoritePet extends AppCompatActivity implements IRecyclerViewFragmentView {

    private RecyclerView listPets;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pet);

        MaterialToolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listPets = findViewById(R.id.rvPets);
        presenter = new FavoritePetPresenter(this, this);

    }

    @Override
    public void generarLinearLayoutVertivcal() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listPets.setLayoutManager(llm);
    }

    @Override
    public PetAdaptador crearAdaptador(List<Pet> pets) {
        return new PetAdaptador(pets, this);
    }

    @Override
    public void inicializarAdaptadorRV(PetAdaptador adaptador) {
        listPets.setAdapter(adaptador);
    }
}