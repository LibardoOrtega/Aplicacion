package com.example.recibos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class HistorialActivity extends AppCompatActivity {
    private ListView lv1;
    private TextView tv1,tv2,tv3;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        tv1 = (TextView) findViewById(R.id.tv1his);
        tv2 = (TextView) findViewById(R.id.tv2his);
        tv3 = (TextView) findViewById(R.id.tv3his);

        String dato = getIntent().getStringExtra("dato");
        tv1.setText(dato);
        String fac = getIntent().getStringExtra("fac");
        tv2.setText(fac);
        String mon = getIntent().getStringExtra("mon");
        tv3.setText(mon);
        correo = getIntent().getStringExtra("correo");
    }

    public void imprimir(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor linea = db.rawQuery("Select * from historial where correo="+correo, null);
        if(linea.moveToFirst()){

        }
    }

    public void  regresar(View view){
        Intent i = new Intent(this, PagosActivity.class);
        startActivity(i);
    }
}