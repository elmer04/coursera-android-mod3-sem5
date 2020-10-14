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
import com.elmer.mod3sem3.pojo.Pet;
import com.elmer.mod3sem3.presentador.IRecyclerViewFragmentPresenter;
import com.elmer.mod3sem3.presentador.RecyclerViewFragmentPresenter;

import java.util.List;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private RecyclerView listPets;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listPets = v.findViewById(R.id.rvPets);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertivcal() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listPets.setLayoutManager(llm);
    }

    @Override
    public PetAdaptador crearAdaptador(List<Pet> pets) {
        return new PetAdaptador(pets, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(PetAdaptador adaptador) {
        listPets.setAdapter(adaptador);
    }
}