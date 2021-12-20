package com.example.recibos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText correo, nombre, telefono, contrasena, confircontrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        correo = findViewById(R.id.correo);
        nombre = findViewById(R.id.nombre);
        telefono = findViewById(R.id.telefono);
        contrasena = findViewById(R.id.contrasena);
        confircontrasena = findViewById(R.id.confircontrasena);
    }

    public void registrarusuario(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String email = correo.getText().toString();
        String name = nombre.getText().toString();
        String phone = telefono.getText().toString();
        String password = contrasena.getText().toString();
        String confirpassword = confircontrasena.getText().toString();
        if (email.isEmpty() && password.isEmpty() && name.isEmpty() && phone.isEmpty() && confirpassword.isEmpty()){
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.equals(confirpassword)){
            Toast.makeText(this, "Las contraseñas son diferentes", Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues registro = new ContentValues();
        registro.put("email", email);
        registro.put("name", name);
        registro.put("phone", phone);
        registro.put("password", password);
        registro.put("confirpassword", confirpassword);
        bd.insert("facturas", null, registro);
        bd.close();
        correo.setText("");
        nombre.setText("");
        telefono.setText("");
        contrasena.setText("");
        confircontrasena.setText("");
        Toast.makeText(this, "Se ha registrado satisfactoriamente", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void guardar(Integer monto, String factura, String correo, String radio){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor linea = db.rawQuery("Select count(id) from historial", null);

        if(linea.moveToFirst()){
            String p = linea.getString(0);
            Integer t = Integer.parseInt(p);

            if(t<1){
                Integer num = 1;
                ContentValues registro = new ContentValues();
                registro.put("id", num);
                registro.put("monto", monto);
                registro.put("factura", factura);
                registro.put("correo", correo);
                registro.put("radio", radio);
                db.insert("historial", null, registro);
            }else{
                Integer num = t+1;
                ContentValues registro = new ContentValues();
                registro.put("id", num);
                registro.put("monto", monto);
                registro.put("factura", factura);
                registro.put("correo", correo);
                registro.put("radio", radio);
                db.insert("historial", null, registro);
            }
        }
    }
}