package com.elmer.mod3sem3.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elmer.mod3sem3.R;
import com.elmer.mod3sem3.model.Pet;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class PetGridAdaptador extends RecyclerView.Adapter<PetGridAdaptador.PetGridViewHolder> {

    List<Pet> pets;
    Activity activity;

    public PetGridAdaptador(List<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petgrid, parent, false);
        return new PetGridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetGridViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.imgFotoGrid.setImageResource(pet.getFoto());
        holder.tvRatingGrid.setText(String.valueOf(pet.getRating()));
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetGridViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoGrid;
        private MaterialTextView tvRatingGrid;

        public PetGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoGrid = itemView.findViewById(R.id.imgFotoGrid);
            tvRatingGrid = itemView.findViewById(R.id.tvRatingGrid);
        }
    }
}
