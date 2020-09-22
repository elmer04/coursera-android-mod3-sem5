package com.elmer.mod3sem3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elmer.mod3sem3.R;
import com.elmer.mod3sem3.adapter.PetAdaptador;
import com.elmer.mod3sem3.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    List<Pet> pets;
    private RecyclerView listPets;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listPets = v.findViewById(R.id.rvPets);

        LinearLayoutManager llm =new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listPets.setLayoutManager(llm);

        inicializarListaPets();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador() {
        PetAdaptador adaptador = new PetAdaptador(pets, getActivity());
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
}