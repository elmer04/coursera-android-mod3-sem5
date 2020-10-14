package com.elmer.mod3sem3.fragment;

import com.elmer.mod3sem3.adapter.PetAdaptador;
import com.elmer.mod3sem3.pojo.Pet;

import java.util.List;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertivcal();

    public PetAdaptador crearAdaptador(List<Pet> pets);

    public void inicializarAdaptadorRV(PetAdaptador adaptador);
}
