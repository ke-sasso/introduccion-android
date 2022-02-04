package com.example.operacionesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    EditText valor1;
    EditText valor2;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.valor1);
        valor2 = (EditText) findViewById(R.id.valor2);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void Sumar(View view){
        double n1 = Double.parseDouble(valor1.getText().toString());
        double n2 = Double.parseDouble(valor2.getText().toString());
        double total = n1 + n2;

        txtResultado.setText("Resultado: " + total);
    }

    public void Restar(View view){
        double n1 = Double.parseDouble(valor1.getText().toString());
        double n2 = Double.parseDouble(valor2.getText().toString());
        double total = n1 - n2;

        txtResultado.setText("Resultado: " + total);
    }

    public void Multiplicar(View view){
        double n1 = Double.parseDouble(valor1.getText().toString());
        double n2 = Double.parseDouble(valor2.getText().toString());
        double total = n1 * n2;

        txtResultado.setText("Resultado: " + total);
    }

    public void Dividir(View view){
        double n1 = Double.parseDouble(valor1.getText().toString());
        double n2 = Double.parseDouble(valor2.getText().toString());
        double total = n1 / n2;

        txtResultado.setText("Resultado: " + total);
    }
}