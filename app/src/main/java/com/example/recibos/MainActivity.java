package com.example.recibos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.CacheRequest;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText correo, contrasena;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
    }
    public void iniciarsesion(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String email = correo.getText().toString();
        String password = contrasena.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()){
        Cursor fila = db.rawQuery("select correo, contrasena from facturas where correo='"+ email +"' and contrasena='" +password+ "'", null);
            if (fila.moveToFirst()){
                Intent i = new Intent(this, PagosActivity.class);
                //login.putExtra("usuario", correo.getText().toString());
                startActivity(i);
                db.close();
                Toast.makeText(this, "Ha iniciado sesion correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText( this, "Datos incorrectos", Toast.LENGTH_SHORT ).show();
               db.close();
            }
        }else{
            Toast.makeText( this, "Debes introducir un correo y una contraseña", Toast.LENGTH_SHORT).show();
        }
    }

    public void registrarse(View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }

}