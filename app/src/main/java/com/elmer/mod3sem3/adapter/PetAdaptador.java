package com.elmer.mod3sem3.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elmer.mod3sem3.model.Pet;
import com.elmer.mod3sem3.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHolder> {

    List<Pet> pets;
    Activity activity;

    public PetAdaptador(List<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, final int position) {
        final Pet pet = pets.get(position);
        final int rating = pet.getRating();
        holder.imgFoto.setImageResource(pet.getFoto());
        holder.tvNombre.setText(pet.getNombre());
        holder.tvRating.setText(String.valueOf(rating));

        holder.boneblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pet.setRating(rating+1);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private MaterialTextView tvNombre;
        private MaterialTextView tvRating;
        private ImageButton boneblack;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRating = itemView.findViewById(R.id.tvRating);
            boneblack = itemView.findViewById(R.id.boneblack);
        }
    }
}
