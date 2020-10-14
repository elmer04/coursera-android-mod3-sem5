package com.elmer.mod3sem3.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.elmer.mod3sem3.pojo.Pet;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTablaMascota = "create table " + ConstantesBD.TABLE_MASCOTA + "(" +
                ConstantesBD.TABLE_MASCOTA_ID + " integer primary key autoincrement," +
                ConstantesBD.TABLE_MASCOTA_NOMBRE + " text," +
                ConstantesBD.TABLE_MASCOTA_FOTO + " integer" +
                ")";

        String queryTablaRating = "create table " + ConstantesBD.TABLE_RATING + "(" +
                ConstantesBD.TABLE_RATING_ID + " integer primary key autoincrement," +
                ConstantesBD.TABLE_RATING_ID_MASCOTA + " integer," +
                ConstantesBD.TABLE_RATING_FECHA + " text," +
                "foreign key (" + ConstantesBD.TABLE_RATING_ID_MASCOTA + ")" +
                "references " + ConstantesBD.TABLE_MASCOTA + "(" + ConstantesBD.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryTablaMascota);
        db.execSQL(queryTablaRating);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + ConstantesBD.TABLE_MASCOTA);
        db.execSQL("drop table if exists " + ConstantesBD.TABLE_RATING);
    }

    public List<Pet>obtenerMascotas () {
        List<Pet> pets = new ArrayList<>();

        String query = "select * from " + ConstantesBD.TABLE_MASCOTA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Pet p = new Pet();
            p.setId(cursor.getInt(0));
            p.setNombre(cursor.getString(1));
            p.setFoto(cursor.getInt(2));

            pets.add(p);
        }

        db.close();

        return pets;
    }

    public void insertarMascotas(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarRating(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_RATING, null, contentValues);
        db.close();
    }

    public List<Pet> obtenerRatingsPets() {
        List<Pet> pets = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select m.id, m.nombre, m.foto " +
                "from " + ConstantesBD.TABLE_RATING + " r, " + ConstantesBD.TABLE_MASCOTA + " m " +
                "where m." + ConstantesBD.TABLE_MASCOTA_ID + " = r." + ConstantesBD.TABLE_RATING_ID_MASCOTA + " " +
                "group by m." + ConstantesBD.TABLE_MASCOTA_ID + " " +
                "order by r." + ConstantesBD.TABLE_RATING_FECHA + " desc " +
                "limit 5";

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Pet p = new Pet();
            p.setId(cursor.getInt(0));
            p.setNombre(cursor.getString(1));
            p.setFoto(cursor.getInt(2));

            pets.add(p);
        }

        db.close();

        return pets;
    }

    public int obtenerRatingPet(Pet p) {
        int rating = 0;

        String query = "select count(" + ConstantesBD.TABLE_RATING_ID_MASCOTA + ") " +
                "from " + ConstantesBD.TABLE_RATING + " " +
                "where " + ConstantesBD.TABLE_RATING_ID_MASCOTA + " = " + p.getId();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToNext()) {
            rating = cursor.getInt(0);
        }

        db.close();

        return  rating;
    }
}
