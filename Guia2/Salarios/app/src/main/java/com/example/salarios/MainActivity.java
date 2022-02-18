package com.example.salarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Nombre;
    private EditText Horas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText) findViewById(R.id.Nombre);
        Horas = (EditText) findViewById(R.id.Horas);

    }

    public void calcular(View view){
        double horas = Double.parseDouble(Horas.getText().toString());
        double salario = horas * 8.5;
        double isss = salario * 0.02;
        double afp = salario * 0.03;
        double renta = salario * 0.04;
        double neto = salario - isss - afp - renta;

        Intent i = new Intent(this,Resultados.class);
        i.putExtra("Nombre", Nombre.getText().toString());
        i.putExtra("Salario", salario);
        i.putExtra("isss", isss);
        i.putExtra("afp", afp);
        i.putExtra("renta", renta);
        i.putExtra("neto", neto);
        startActivity(i);
    }
}