package com.example.recibos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Map;

public class PagosActivity extends AppCompatActivity {
    private ArrayList<String> datos;
    private ArrayAdapter<String> adaptador;
    private EditText factura,monto;
    private ListView lv1;
    private SharedPreferences prefe;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        datos =new ArrayList<String>();
        leerSharedPreferences();
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        lv1=(ListView)findViewById(R.id.list1);
        lv1.setAdapter(adaptador);

        //factura=(EditText)findViewById(R.id.factura);
        //monto=(EditText)findViewById(R.id.monto);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Bundle bundle = getIntent().getExtras();
        //correo = bundle.getString("usuario");
    }

    private void leerSharedPreferences() {
        prefe = getSharedPreferences("datospagos", Context.MODE_PRIVATE);
        Map<String, ?> claves = prefe.getAll();
        for (Map.Entry<String, ?> ele : claves.entrySet()) {
            datos.add(ele.getKey() + " : " + ele.getValue().toString());
        }
    }
    public void agregar(View v) {
        datos.add(factura.getText().toString()+" : "+monto.getText().toString());
        adaptador.notifyDataSetChanged();
        SharedPreferences.Editor elemento=prefe.edit();
        elemento.putString(factura.getText().toString(),monto.getText().toString());
        elemento.commit();
    }

    public void agua(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(PagosActivity.this);
        View v = this.getLayoutInflater().inflate(R.layout.alert_pagos, null);
        final RadioButton rb1 = (RadioButton)v.findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton)v.findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton)v.findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton)v.findViewById(R.id.rb4);
        final RadioButton rb5 = (RadioButton)v.findViewById(R.id.rb5);
        final EditText factura = (EditText)v.findViewById(R.id.factura);
        final EditText monto = (EditText)v.findViewById(R.id.monto);

        rb1.setText("EMSERPA");
        rb2.setText("Imsaguas Ltda");
        rb3.setText("Aguas Cool");
        rb4.setText("ESPO S.A");
        rb5.setText("ADAMIUAIN");

        alert.setView(v);
        alert.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder alert1 = new AlertDialog.Builder(PagosActivity.this);
                alert1.setTitle("Confirmación de Pago");
                alert1.setMessage("¿Estas seguro que desea continuar con el pago?");
                alert1.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String em = "";

                        if(rb1.isChecked() == true){
                            em = "EMSERPA";
                        }
                        if(rb2.isChecked() == true){
                            em = "Imsaguas Ltda";
                        }
                        if(rb3.isChecked() == true){
                            em = "Aguas Cool";
                        }
                        if(rb4.isChecked() == true){
                            em = "ESPO S.A";
                        }
                        if(rb5.isChecked() == true){
                            em = "ADAMIUAIN";
                        }
                        Intent i = new Intent(getApplicationContext(), PagosActivity.class);
                        i.putExtra("dato",em);
                        i.putExtra("fac",factura.getText().toString());
                        i.putExtra("mon",monto.getText().toString());
                        //i.putExtra("correo",correo);
                        startActivity(i);
                    }
                });
                alert1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert1.show();
            }
        });
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    public void luz(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(PagosActivity.this);
        View v = this.getLayoutInflater().inflate(R.layout.alert_pagos, null);
        final RadioButton rb1 = (RadioButton)v.findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton)v.findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton)v.findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton)v.findViewById(R.id.rb4);
        final RadioButton rb5 = (RadioButton)v.findViewById(R.id.rb5);
        final EditText factura = (EditText)v.findViewById(R.id.factura);
        final EditText monto = (EditText)v.findViewById(R.id.monto);
        rb1.setText("CENS");
        rb2.setText("Electrificadora de Santander");
        rb3.setText("Electricos Super Luz");
        rb4.setText("TotalEnergies");
        rb5.setText("Lersa Energia");

        alert.setView(v);
        alert.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder alert1 = new AlertDialog.Builder(PagosActivity.this);
                alert1.setTitle("Confirmación de Pago");
                alert1.setMessage("¿Estas seguro que desea continuar con el pago?");
                alert1.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String em = "";

                        if(rb1.isChecked() == true){
                            em = "CENS";
                        }
                        if(rb2.isChecked() == true){
                            em = "Electrificadora de Santander";
                        }
                        if(rb3.isChecked() == true){
                            em = "Electricos Super Luz";
                        }
                        if(rb4.isChecked() == true){
                            em = "TotalEnergies";
                        }
                        if(rb5.isChecked() == true){
                            em = "Lersa Energia";
                        }
                    }
                });
                alert1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert1.show();
            }
        });
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
    public void internet(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(PagosActivity.this);
        View v = this.getLayoutInflater().inflate(R.layout.alert_pagos, null);
        final RadioButton rb1 = (RadioButton)v.findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton)v.findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton)v.findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton)v.findViewById(R.id.rb4);
        final RadioButton rb5 = (RadioButton)v.findViewById(R.id.rb5);
        final EditText factura = (EditText)v.findViewById(R.id.factura);
        final EditText monto = (EditText)v.findViewById(R.id.monto);
        rb1.setText("Movistar");
        rb2.setText("Tigo");
        rb3.setText("DirecTV");
        rb4.setText("TV Norte");
        rb5.setText("Flash Mobile");

        alert.setView(v);
        alert.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder alert1 = new AlertDialog.Builder(PagosActivity.this);
                alert1.setTitle("Confirmación de Pago");
                alert1.setMessage("¿Estas seguro que desea continuar con el pago?");
                alert1.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String em = "";

                        if(rb1.isChecked() == true){
                            em = "Movistar";
                        }
                        if(rb2.isChecked() == true){
                            em = "Tigo";
                        }
                        if(rb3.isChecked() == true){
                            em = "DirecTV";
                        }
                        if(rb4.isChecked() == true){
                            em = "TV Norte";
                        }
                        if(rb5.isChecked() == true){
                            em = "Flash Mobile";
                        }
                    }
                });
                alert1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert1.show();
            }
        });
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
    public void gas(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(PagosActivity.this);
        View v = this.getLayoutInflater().inflate(R.layout.alert_pagos, null);
        final RadioButton rb1 = (RadioButton)v.findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton)v.findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton)v.findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton)v.findViewById(R.id.rb4);
        final RadioButton rb5 = (RadioButton)v.findViewById(R.id.rb5);
        final EditText factura = (EditText)v.findViewById(R.id.factura);
        final EditText monto = (EditText)v.findViewById(R.id.monto);
        rb1.setText("Norgas");
        rb2.setText("Ensagas");
        rb3.setText("Proviservicios S.A. E.S.P.");
        rb4.setText("Industrial de Gases S.A.S");
        rb5.setText("OIL");

        alert.setView(v);
        alert.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder alert1 = new AlertDialog.Builder(PagosActivity.this);
                alert1.setTitle("Confirmación de Pago");
                alert1.setMessage("¿Estas seguro que desea continuar con el pago?");
                alert1.setPositiveButton("Pagar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String em = "";

                        if(rb1.isChecked() == true){
                            em = "Norgas";
                        }
                        if(rb2.isChecked() == true){
                            em = "Ensagas";
                        }
                        if(rb3.isChecked() == true){
                            em = "Proviservicios S.A. E.S.P.";
                        }
                        if(rb4.isChecked() == true){
                            em = "Industrial de Gases S.A.S";
                        }
                        if(rb5.isChecked() == true){
                            em = "OIL";
                        }
                    }
                });
                alert1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert1.show();
            }
        });
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
}