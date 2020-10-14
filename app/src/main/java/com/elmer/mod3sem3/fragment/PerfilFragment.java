package com.elmer.mod3sem3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elmer.mod3sem3.R;
import com.elmer.mod3sem3.adapter.PetGridAdaptador;
import com.elmer.mod3sem3.pojo.Pet;
import com.google.android.material.textview.MaterialTextView;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

public class PerfilFragment extends Fragment {

    List<Pet> pets;
    private RecyclerView listPets;

    CircularImageView imgPerfilCircular;
    MaterialTextView tvNombrePerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        imgPerfilCircular = v.findViewById(R.id.imgPerfilCircular);
        tvNombrePerfil = v.findViewById(R.id.tvNombrePerfil);

        imgPerfilCircular.setImageResource(R.drawable.pet3);
        tvNombrePerfil.setText("Mascota1");

        listPets = v.findViewById(R.id.rvPetsGrid);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listPets.setLayoutManager(glm);

        inicializarListaPets();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador() {
        PetGridAdaptador adaptador = new PetGridAdaptador(pets, getActivity());
        listPets.setAdapter(adaptador);
    }

    public void inicializarListaPets() {
        pets = new ArrayList<>();

        pets.add(new Pet(R.drawable.pet3, "mascota 1", 2));
        pets.add(new Pet(R.drawable.pet3, "mascota 2", 2));
        pets.add(new Pet(R.drawable.pet3, "mascota 3", 2));
        pets.add(new Pet(R.drawable.pet3, "mascota 4", 2));
        pets.add(new Pet(R.drawable.pet3, "mascota 5", 2));
        pets.add(new Pet(R.drawable.pet3, "mascota 6", 2));
        pets.add(new Pet(R.drawable.pet3, "mascota 7", 2));
    }
}