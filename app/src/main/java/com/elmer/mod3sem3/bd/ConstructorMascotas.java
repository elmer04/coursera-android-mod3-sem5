package com.elmer.mod3sem3.bd;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.elmer.mod3sem3.R;
import com.elmer.mod3sem3.pojo.Pet;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public List<Pet>obtenerMascotas() {
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerMascotas();
    }

    public void insertarMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota1");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota2");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota3");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota4");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota5");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota6");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "mascota7");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.pet3);
        db.insertarMascotas(contentValues);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void darRatingMascota(Pet p) {
        BaseDatos db = new BaseDatos(context);
        LocalDateTime now = LocalDateTime.now();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_RATING_ID_MASCOTA, p.getId());
        contentValues.put(ConstantesBD.TABLE_RATING_FECHA, now.toString());

        db.insertarRating(contentValues);
    }

    public int obtenerRatingPet(Pet p) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingPet(p);
    }

    public List<Pet> obtenerMascotasFavoritas() {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingsPets();
    }
}
