package com.elmer.mod3sem3.presentador;

import android.content.Context;

import com.elmer.mod3sem3.bd.ConstructorMascotas;
import com.elmer.mod3sem3.fragment.IRecyclerViewFragmentView;
import com.elmer.mod3sem3.pojo.Pet;

import java.util.List;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private List<Pet> pets;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        pets = constructorMascotas.obtenerMascotas();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(pets));
        iRecyclerViewFragmentView.generarLinearLayoutVertivcal();
    }
}
