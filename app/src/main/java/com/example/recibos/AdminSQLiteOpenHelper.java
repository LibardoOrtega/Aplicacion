package com.example.recibos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table facturas(correo string primary key, nombre text, telefono real, contrasena text, confircontrasena text)");
        db.execSQL("create table historial(id integer primary key, factura text, monto integer, correo string, radio string)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists facturas");
        db.execSQL("create table facturas(correo string primary key, nombre text, telefono real, contrasena text, confircontrasena text)");
        db.execSQL("drop table if exists historial");
        db.execSQL("create table historial(id integer primary key, factura text, monto integer, correo string, radio string)");
    }
}
